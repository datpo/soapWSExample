package com.cyber.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.cyber.object.ApiConfig;
import com.cyber.object.DesConfigApi;
import com.cyber.staticvar.UtilsDefind;

public class Utils {
	public static DesConfigApi getInfoApiById(int id) {
		try {
			for(ApiConfig item : UtilsDefind.apiConfigstatic) {
				if(item.getId() == id) {
					return item.getDes();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static String connectServer(DesConfigApi desapi, String inputsent,String auth) {
        try {

            URL url = new URL(desapi.getUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(desapi.getMethod());
            conn.setRequestProperty("Content-Type", desapi.getContenttype());
            if(auth == null || auth.trim().equals("")) {
            	
            }else {
            	conn.addRequestProperty("Authorization", auth);
            }
            String input = inputsent;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                
            	return "1";
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String output2 = "";
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
               
                output2 += output;

            }
            
//            // tesst
//            System.out.println("output2: " + output2);
            

            conn.disconnect();
            return output2;

        } catch (MalformedURLException e) {
        	e.printStackTrace();
        	return "2";
        } catch (IOException e) {
        	e.printStackTrace();
        	return "3";
        }
       
    }
	
//	public static void main(String[] args) {
//		DesConfigApi des = Utils.getInfoApiById(3);
//		String input = null;
//	}
}
