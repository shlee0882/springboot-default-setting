package com.example.demo.bo.common.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	
	DecimalFormat df = new DecimalFormat("00");
    public static Calendar currentCalendar = Calendar.getInstance();
	
	/**
     * 3자리 마다 comma 로 구분지어 주는 문자열 생성
     * @param string
     * @return
     */
    public String formatSeperatedByComma(String value) {
        NumberFormat format = NumberFormat.getNumberInstance();
        
        if(StringUtils.equals(value, "0") || StringUtils.isEmpty(value)) {
        	return "";
        }
        
        return format.format(Long.parseLong(value));
    }
    
    /**
     * 이번달을 리턴 한다.
     * @return
     */
    public String thisMoth() {
    	return df.format(currentCalendar.get(Calendar.MONTH) + 1);	
    }
        
    /**
     * 이번달 첫째날을 리턴 한다.
     * @return
     */
    public String thisMonthFirstDay() {    	
    	return df.format(currentCalendar.getActualMinimum(Calendar.DAY_OF_MONTH )); 
    }    
    
    /**
     * 이번달 마지막날을 리턴 한다.
     * @return
     */
    public String thisMonthLastDay() {    	
    	return df.format(currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH )); 
    }
    
    /**
     * 오늘 날짜를 리턴 한다.
     * @return
     */
    public String getToday() {
        Calendar rightNow = Calendar.getInstance(Locale.KOREA);
        String year = Integer.toString(rightNow.get(1));
        String month = Integer.toString(rightNow.get(2) + 1);
        String day = Integer.toString(rightNow.get(5));
        if (month.length() == 1) {
            month = "0" + month;
        }
        if (day.length() == 1) {
            day = "0" + day;
        }
        return String.valueOf(year) + "-" + month + "-" + day;
    }
    
    /**
     * yyyy년 mm월 dd일 (일)형태로 리턴한다.
     * @return
     */
    public String getTodayAllString() {
    	
    	DateFormat df = DateFormat.getDateInstance(1, java.util.Locale.KOREA);
        Calendar cal = Calendar.getInstance(java.util.Locale.KOREA);
        String today = df.format(cal.getTime());
        
        return today;
    }
    
    /**
     * yyyymmddhhmmss 형태로 리턴한다.
     * @return
     */
	public String getTodayYYYYMMDDHHMMSS() {
		SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(new java.util.Date());
	}
   

}
