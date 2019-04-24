package com.example.demo.bo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bo.common.ApiClientUtil;
import com.example.demo.bo.common.ApiPath;
import com.example.demo.bo.exception.DemoException;
import com.example.demo.bo.model.burger.BurgerVO;
import com.example.demo.config.ServiceConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SelectBurgerServiceImpl implements SelectBurgerService{
	
	@Autowired
	private ServiceConfig config;
	
	@Autowired
	private ApiClientUtil apiClientUtil;

	@Override
	public String getBurgerInfoList() throws DemoException {
		log.debug("[SelectBurgerServiceImpl] getBurgerInfoList (PAR)=> {}");
		
		StringBuilder url = new StringBuilder();
		url.append(config.getApiDemoServer() + ApiPath.API_SELECTBURGER + "/list");
//		url.append("?searchYear={searchYear}");
//		url.append("&searchMonth={searchMonth}");

		Map<String, Object> info = new HashMap<String, Object>();
//		info.put("searchYear", searchYear);
//		info.put("searchMonth", searchMonth);

		log.debug("[SelectBurgerServiceImpl] getBurgerInfoList => api url: {} ", url);

		HttpEntity httpEntity = new HttpEntity(apiClientUtil.getHeaderWithApikey());
		ResponseEntity<String> responseEntity = apiClientUtil.getRestTemplate().exchange(url.toString(), HttpMethod.GET,
				httpEntity, String.class, info);
		String jsonList = "";
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			jsonList = responseEntity.getBody();
			log.debug("response=> {}", responseEntity.getBody());
			return jsonList;
		}else {
			return null;
		}
	}
	
}
