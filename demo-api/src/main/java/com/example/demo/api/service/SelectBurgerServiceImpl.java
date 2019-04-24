package com.example.demo.api.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.common.CommonUtils;
import com.example.demo.api.dao.BurgerDAO;
import com.example.demo.api.exception.DemoException;
import com.example.demo.api.model.burger.BurgerVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SelectBurgerServiceImpl implements SelectBurgerService{
    
    @Autowired
    private BurgerDAO burgerDAO;

	@Override
	public List<BurgerVO> selectBurgerInfoList(BurgerVO burgerVO) throws DemoException {
		log.info("[StatisticsServiceImpl] selectBurgerInfoList Service");
		List<BurgerVO> list = new ArrayList();
		list = burgerDAO.selectBurgerInfoList(burgerVO);
    	return burgerDAO.selectBurgerInfoList(burgerVO);
	}

}
