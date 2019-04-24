package com.example.demo.api.service;

import java.util.List;

import com.example.demo.api.exception.DemoException;
import com.example.demo.api.model.burger.BurgerVO;

public interface SelectBurgerService {
	
	public List<BurgerVO> selectBurgerInfoList(BurgerVO burgerVO) throws DemoException;
}
