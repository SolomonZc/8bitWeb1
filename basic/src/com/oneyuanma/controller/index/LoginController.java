package com.oneyuanma.controller.index;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oneyuanma.model.User;
import com.oneyuanma.service.UserService;
import com.oneyuanma.tool.PublicStatic;
/*
 * 登陆
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	private static Logger log = Logger.getLogger(LoginController.class);
	
	//修改或者新增
	/*@RequestMapping("index.do")
	public String toindex(Model model,String pathlocation) {
		model.addAttribute("pathlocation", pathlocation);
		return "jsp/index/login";
	}*/
	
	@RequestMapping("index.do")
	public String index(HttpServletRequest request, Model model) {
		log.info("进入到登录界面！");
		return "jsp/user/login";
	}
	
	
	//登录
	@ResponseBody
	@RequestMapping("login.do")
	public Map<String, String> login(HttpServletRequest request,User user,String pathlocation,String yanzhengma) {
		Map<String, String> map=new HashMap<String, String>();
		HttpSession session = request.getSession(true); 
		//String yanzhengmasession=(String)session.getAttribute("yanzhengma");
		String flag="0";
		String msg="0";
		/*if(!yanzhengma.equalsIgnoreCase(yanzhengmasession)){
			flag="77";
			msg="验证码错误！";
		}else{*/
			flag=userService.login(user,request);
			if(pathlocation!=null&&!"".equals(pathlocation)){
				map.put("pathlocation", pathlocation);
			}else{
				map.put("pathlocation", request.getContextPath()+"/index/index.do");
			}
			if(flag.equals("1")){
				user=(User)request.getSession().getAttribute(PublicStatic.USER);
				/*Jifen jifen=new Jifen();
				jifen.setFenshu(PublicStatic.JIFEN_LOGIN);
				jifen.setUserid(user.getId());
				jifen.setType("104");
				jifen.setContent("每天第一次登录您获得"+PublicStatic.JIFEN_LOGIN+"积分");
				int findnowcount = jifenService.findnowcount(jifen);
				if(findnowcount==0){
					jifenService.insert(jifen);
				}*/
			}
		/*}*/
		
		map.put("flag", flag);
		map.put("msg", msg);
		return map;
	}
	
	
	
}
