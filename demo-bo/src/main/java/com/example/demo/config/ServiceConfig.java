package com.example.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


import lombok.Data;

@Configuration
@Data
public class ServiceConfig {
	
	@Value("${api.demo.server}")
	private String apiDemoServer;
		
	@Value("${api.demo.keyName}")
	private String apiDemoKeyName;

	@Value("${api.demo.keyValue}")
	private String apiDemoKeyValue;
	
	@Value("${api.demo.version}")
	private String apiDemoVersion;
		
	@Value("${file.downLoadPath}")
	private String fileDownLoadPath;
}
