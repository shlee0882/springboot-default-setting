package com.example.demo.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.annotation.UseDemoDatasource;
import com.example.demo.api.exception.DemoException;
import com.example.demo.api.model.burger.BurgerVO;

@Mapper
@Repository
@UseDemoDatasource
public interface BurgerDAO {

	List<BurgerVO> selectBurgerInfoList(BurgerVO burgerVO) throws DemoException;


}
