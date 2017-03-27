package com.wangpan.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter{
	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final String MONTH_PATTERN = "yyyy-MM";

	@Override
	public Object convertFromString(Map map, String[] value, Class classType) {
		// TODO Auto-generated method stub
		Date result = null;
		String val=value[0];
		System.out.println(val.toString());
		DateFormat dateformat=DateFormat.getDateInstance();
		try {
			result=dateformat.parse(val);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String convertToString(Map map, Object value) {
		// TODO Auto-generated method stub
		String result = null;
		SimpleDateFormat sdf=new SimpleDateFormat(DATETIME_PATTERN);
		if(value instanceof Date){
			result=sdf.format(value);
		}
		return result;
	}

//	public static void main(String[] args) throws Exception{
//		Date date=new Date();
//		String d=null;
//		SimpleDateFormat sdf=new SimpleDateFormat(DATETIME_PATTERN);
//		if(date instanceof Date){
//			d=sdf.format(date);
//		}
//		convertFromString(null,new String[]{d},Date.class);
//	}
}
