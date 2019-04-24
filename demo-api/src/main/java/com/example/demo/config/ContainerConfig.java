package com.example.demo.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerConfig {

	@Value("${tomcat.ajp.protocol}")
	String ajpProtocol;
	 
	@Value("${tomcat.ajp.port}")
	int ajpPort;

	@Bean
    public TomcatConnectorCustomizer containerCustomizer() {
        return container -> {
        	TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();

            Connector ajpConnector = new Connector(ajpProtocol);      
            //ajpConnector.setProtocol(ajpProtocol);
            ajpConnector.setPort(ajpPort);
            ajpConnector.setSecure(false);
            ajpConnector.setAllowTrace(false);
            ajpConnector.setScheme("http");
            tomcat.addAdditionalTomcatConnectors(ajpConnector);
        };
    }
}
