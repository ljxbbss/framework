package com.zlebank.controller.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zlebank.service.DubboConsumerInterface;

/**
 * @author Donald
 * @createdate 2016年5月9日
 * @version 1.0 
 * @description :
 */
@Controller
public class TestDubbo {
	private final static Logger logger = LoggerFactory.getLogger(TestDubbo.class); 
	@Autowired
	private DubboConsumerInterface demoServiceRemote;
	
	@RequestMapping(value= "/portal-dubbo")
	public ModelAndView getRequsetValue(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		String ms = demoServiceRemote.getName("tangchuchu");
		if(ms==null){
			logger.info("test logger:"+"");

		}else{
			logger.info("test logger:"+ms);

		}
		
		Map map = new HashMap();
		
		mv.addObject("name", ms);
		mv.setViewName("hello");
		return mv;
		
	}
	
}
