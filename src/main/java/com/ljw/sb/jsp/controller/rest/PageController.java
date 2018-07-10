package com.ljw.sb.jsp.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.sb.jsp.mq.MqProducer;
import com.ljw.sb.jsp.vo.Response;

@RestController
public class PageController {
	
	@Autowired
	public MqProducer mqProducer;

	@RequestMapping("/test500")
	public Response test500(){
		Response res = new Response();
		res.setResultCode("500");
		System.out.println(res.getResultDesc().toString());
		return res;
		
	}
	
	
	@RequestMapping("/mq")
	public Response mqSendMessage(@RequestParam(required=false,defaultValue="msg is null") String msg){
		String result = mqProducer.sendMessage(msg);
		Response res = new Response();
		res.setResultCode("200");
		res.setResultDesc("message="+msg+",result="+result);
		return res;
		
	}
	
	
}
