package com.example.demo.bo.common;

import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.example.demo.config.ServiceConfig;

@Component
public class ApiClientUtil implements Serializable {

	@Autowired
	private ServiceConfig config;

	private final Logger log = LoggerFactory.getLogger(getClass());


	/**
	 * http 헤더정보를 가져온다.
	 *
	 * @return HttpHeaders
	 */
	public HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	/**
	 * http body param 정보를 가져온다.
	 *
	 * @param t
	 * @return
	 * @return HttpEntity<T>
	 */
	public <T> HttpEntity<T> getEntityBodyParam(T t) {
		try {
			HttpHeaders headers = getHeaders();
			return new HttpEntity<T>(t, headers);
		} catch (Exception e) {
			log.info("getEntityBodyParam 오류 => {}", e);
			return null;
		}

	}

	/**
	 * http body param 정보를 가져온다.
	 *
	 * @param t
	 * @param headers
	 * @return HttpEntity<T>
	 */
	public <T> HttpEntity<T> getEntityBodyParam(T t, HttpHeaders headers) {
		try {
			return new HttpEntity<T>(t, headers);
		} catch (Exception e) {
			log.info("getEntityBodyParam 오류 => {}", e);
			return null;
		}
	}

	/**
	 * http entity 정보를 가져온다.
	 *
	 * @return HttpEntity
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HttpEntity getEntity() {
		try {
			return new HttpEntity(getHeaders());
		} catch (Exception e) {
			log.info("getEntity 오류 => {}", e);
			return null;
		}
	}

	/**
	 * http entity 정보를 가져온다.
	 *
	 * @param headers
	 * @return HttpEntity
	 */
	public HttpEntity getEntity(HttpHeaders headers) {
		try {

			return new HttpEntity(headers);
		} catch (Exception e) {
			log.info("getEntity 오류 => {}", e);
			return null;
		}
	}

	/**
	 * RestTemplate 정보를 가져온다.
	 *
	 * @return RestTemplate
	 */
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				// log.error("handleError code :" + response.getStatusText());
			}
		});

		return restTemplate;
	}

	/**
	 * http header 정보를 demo API 기본 정보로 설정한다.
	 *
	 * @return RestTemplate
	 */
	public HttpHeaders getHeaderWithApikey() {
		HttpHeaders headers = getHeaders();
		headers.set(config.getApiDemoKeyName(), config.getApiDemoKeyValue());
		headers.set("version", config.getApiDemoVersion());
		return headers;
	}
}
