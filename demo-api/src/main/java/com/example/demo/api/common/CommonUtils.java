package com.example.demo.api.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.api.model.ResultMessage;

public class CommonUtils {

	/**
	 * 현재 일자를 반환한다.
	 * 
	 * @return String : 현재 년/월/일을 반환 한다.
	 */
	public String getNowDate() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	/**
	 * 하루전 일자를 반환한다.
	 * 
	 * @return String : 현재 년/월/일을 반환 한다.
	 */
	public String getYesterDate() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
		// String d = sdf.format(c1.getTime()); // String으로 저장

		Date date = calendar.getTime();
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	/**
	 * 작업성패
	 * 
	 * @param result
	 * @return
	 */
	public static ResponseEntity<ResultMessage> getResponseEntity(int result) {
		if (result > 0) {
			return new ResponseEntity<>(new ResultMessage("Y", "정상", HttpStatus.OK), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ResultMessage("N", "오류", HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
	
	
	public static ResponseEntity<String> getResponseEntityForStingMessage(int result) {
		if (result > 0) {
			return new ResponseEntity<>("Y", HttpStatus.OK);
		}
		return new ResponseEntity<>("N", HttpStatus.BAD_REQUEST);
	}

}
