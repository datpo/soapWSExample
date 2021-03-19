package com.cyber.bill;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cyber.object.ApiConfig;
import com.cyber.staticvar.UtilsDefind;
import com.google.gson.Gson;

@SpringBootApplication
public class CyberbillsoapwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CyberbillsoapwsApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		try {
			Resource resource = new ClassPathResource("config/configapi.json");

			InputStream input = resource.getInputStream();
			
			StringWriter writer = new StringWriter();
			IOUtils.copy(input, writer, StandardCharsets.UTF_8);
			String jsonString = writer.toString();
			System.out.println(jsonString);
			
			ApiConfig[] apiConfig = new Gson().fromJson(jsonString, ApiConfig[].class);
			UtilsDefind.apiConfigstatic = apiConfig;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
