package com.example.demo.bo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bo.model.burger.BurgerVO;
import com.example.demo.bo.service.SelectBurgerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/selectBurger")
@Controller
public class SelectBurgerController {
	
	@Autowired
	private SelectBurgerService selectBurgerService;
	
	@RequestMapping(value = "/boList")
	public ModelAndView selectBurgerList(HttpServletRequest request) {
		log.info("[SelectBurgerController] selectBurgerList");
		String url = request.getHeader("referer");
		
		log.debug("referer check => {}", url);
		
		ModelAndView mav = new ModelAndView();		
		
		if(StringUtils.isEmpty(url)) {
//			mav.addObject("msg", REFERER_CHK_MSG);
			mav.addObject("msg", "");
		}else {
			mav.addObject("msg", "");			
		}

		mav.setViewName("select/burger/selectBurgerList");
		return mav;
	}
	
	@RequestMapping(value = "/getList")
	public @ResponseBody String getCustomerLoyaltyDailyInfoList() {
		return selectBurgerService.getBurgerInfoList();
	}


}

