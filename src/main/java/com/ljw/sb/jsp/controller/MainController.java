package com.ljw.sb.jsp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController extends BaseController{

	
	
	
	@RequestMapping("/")
	public ModelAndView main(){
		System.out.println("welcome");
		
		return new ModelAndView("welcome");
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelAndView showForm(){
		System.out.println("表格");
		return new ModelAndView("form");
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public ModelAndView getFormData(@RequestParam(value="name") String name){
		System.out.println(name);
		return new ModelAndView("welcome");
		
	}
	

}
