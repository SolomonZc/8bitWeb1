package com.oneyuanma.controller.index;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 首页
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	private static Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping("index.do")
	public String index(HttpServletRequest request, Model model) {
		
		return "jsp/index/index";
	}
	
	@RequestMapping("welcome.do")
	public String welcome(HttpServletRequest request, Model model) {
		return "jsp/index/welcome";
	}
	
	@RequestMapping("adv.do")
	public String adv(HttpServletRequest request, Model model) {
		log.info("advis in success");
		return "jsp/index/adv";
	}
}
