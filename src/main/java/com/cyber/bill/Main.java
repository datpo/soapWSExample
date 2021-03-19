package com.cyber.bill;


import org.springframework.core.io.Resource;

import com.cyber.object.ApiConfig;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// chuyen data to json
		Resource resource = new ClassPathResource("config/configapi.json");
		
		InputStream inputStream = resource.getInputStream();
		StringWriter stringWriter = new StringWriter();
		
		//
		IOUtils.copy(inputStream, stringWriter, StandardCharsets.UTF_8);
		
		// write to obj
		System.out.println(stringWriter.toString());
		
		// read data to object
		ApiConfig apiConfig[] = new Gson().fromJson(stringWriter.toString(), ApiConfig[].class);
		
		for (ApiConfig apiConfig2 : apiConfig) {
			System.out.println(apiConfig2.toString());
		}
	}
}
