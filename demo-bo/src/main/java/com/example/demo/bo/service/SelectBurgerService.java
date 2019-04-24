package com.example.demo.bo.service;

import java.util.List;

import com.example.demo.bo.exception.DemoException;
import com.example.demo.bo.model.burger.BurgerVO;

public interface SelectBurgerService {

	public String getBurgerInfoList() throws DemoException;
	
}
