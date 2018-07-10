package com.ljw.sb.jsp.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ljw.sb.jsp.vo.Response;




/**
 * 控制器异常处理
 * @author PC
 *
 */
public class BaseController {
	
	
	public static final String ERROR_UNKOWN="ERROR_UNKOWN";
	
	

	@ExceptionHandler(Exception.class)
	public Response exceptionHandler(Exception e){
		Response response = new Response();
		response.setResultCode(BaseController.ERROR_UNKOWN);
		response.setResultCode(e.getMessage());
		return response;
		
	}
}
