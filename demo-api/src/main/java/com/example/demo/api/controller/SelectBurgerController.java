package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.example.demo.api.exception.DemoException;
import com.example.demo.api.model.burger.BurgerVO;
import com.example.demo.api.service.SelectBurgerService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/selectBurger")
@Api(description="버거 조회 API")
public class SelectBurgerController {
		
	@Autowired
	private SelectBurgerService statisticsService;
	
	@ApiOperation(value="버거리스트 조회")
    @ApiImplicitParams({
//		@ApiImplicitParam(name="searchYear", value="조회년도", required=true, dataType="string", paramType="query"),
//		@ApiImplicitParam(name="searchMonth", value="조회월", required=true, dataType="string", paramType="query"),                
    })    
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<BurgerVO>> selectCustomerLoyaltyDailyInfoList(BurgerVO burgerVO) throws DemoException {
		log.info("[StatisticsController] Burger 리스트 조회");
        return new ResponseEntity<>(statisticsService.selectBurgerInfoList(burgerVO), HttpStatus.OK);
    } 

	
}
