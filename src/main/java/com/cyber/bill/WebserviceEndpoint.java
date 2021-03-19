package com.cyber.bill;



import javax.xml.bind.DatatypeConverter;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cyber.business.Utils;
import com.cyber.object.DesConfigApi;
import com.cyber.reponse.ApiErrorReponse;
import com.cyber.ws.GetInfoCyberBillRequest;
import com.cyber.ws.GetInfoCyberBillResponse;



@Endpoint
public class WebserviceEndpoint {
private static final String NAMESPACE_URI = "http://www.cyber.com/ws/";
	
	//localPart must be xsd request element name.
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getInfoCyberBillRequest")
	@ResponsePayload
	public GetInfoCyberBillResponse getInfoCyberBillRequest(@RequestPayload GetInfoCyberBillRequest request,MessageContext messageContext) {
		GetInfoCyberBillResponse res = new GetInfoCyberBillResponse();
		try {
			int id = request.getId();
			String bodybase64 = request.getBase64Body();
			String auth = request.getAuth();
			
			//test 
			System.out.println("auth: " + auth);
			
			
			if(id <= 0) {
				res.setResult(new ApiErrorReponse(1, "id invalid").toJsonString());
				return res;
			}
			//set contents body
			String body = "";
			if(bodybase64 != null && !bodybase64.trim().equals("")) {
				body = new String(DatatypeConverter.parseBase64Binary(bodybase64),"UTF-8");
			}
			
//			// test
//			String body = bodybase64;
			System.out.println("base64: " + bodybase64);
			System.out.println("body: " + body);
			
			// get config
			DesConfigApi desConfigApi = Utils.getInfoApiById(id);
			
			// send request and receive response			
			String resfromrestapi = Utils.connectServer(desConfigApi, body, auth);
			
			//test
			System.out.println("res: " + resfromrestapi);
			
			if(resfromrestapi.length() == 1) {
				res.setResult(new ApiErrorReponse(3, "Connect api bill error:"+resfromrestapi).toJsonString());
				return res;
			}
			res.setResult(resfromrestapi);
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res.setResult(new ApiErrorReponse(2, "Exception:"+e.getMessage()).toJsonString());
			return res;
		}
	}
	
	
}
