package com.oneyuanma.controller.index;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject; 

import com.oneyuanma.model.Adv;
import com.oneyuanma.model.User;
import com.oneyuanma.service.AdvService;
import com.oneyuanma.service.UserService;
import com.oneyuanma.tool.PublicStatic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/*
 * 首页
 * 
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	AdvService AdvService;

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
		List<Adv> advList = AdvService.findall();
		System.out.println(advList.size());
		request.setAttribute("advlist", advList);
		model.addAttribute("advlist", (Adv)request.getSession().getAttribute("advlist"));
		return "jsp/index/adv";
	}
	
	@RequestMapping("advPicShow.do")
	public String advPicShow(HttpServletRequest request, Model model) {
		List<Adv> advList = AdvService.findall();
		request.setAttribute("advlist", advList);
		return "";
	}
	
	@RequestMapping("advpic.do")
	@ResponseBody
    public String  advpic(HttpServletRequest request,Adv adv)
    {
		System.out.println("advpic in success");
		System.out.println(adv.getName());
		System.out.println(adv.getUrl());
		System.out.println(adv.getDescrib());
		System.out.println(adv.getGrade());
		Adv advupdate = new Adv();
		advupdate.setId(adv.getGrade());
		advupdate.setName(adv.getName());
		advupdate.setDescrib(adv.getDescrib());
		advupdate.setGrade(adv.getGrade());
		advupdate.setUrl(adv.getUrl());
		AdvService.insert(advupdate);
		return "success";
    }
	
//	@RequestMapping("advpic.do")
//	public String advpic(HttpServletRequest request, Model model) {
//		System.out.println("uploadpic in success");
//		return "jsp/index/welcome";
//		 try {  
//	            // 获取图片原始文件名  
//	            String originalFilename = pic.getOriginalFilename();  
//	            System.out.println(originalFilename);  
//	          
//	            // 文件名使用当前时间  
//	            String name = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());  
//	          
//	            // 获取上传图片的扩展名(jpg/png/...)  
//	            String extension = FilenameUtils.getExtension(originalFilename);  
//	              
//	            // 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）  
//	            String path = "/upload/" + name + "." + extension;  
//	  
//	            // 图片上传的绝对路径  
//	            String url = request.getSession().getServletContext().getRealPath("") + path;  
//	          
//	                File dir = new File(url);  
//	            if(!dir.exists()) {  
//	            dir.mkdirs();  
//	            }  
//	              
//	            // 上传图片  
//	            pic.transferTo(new File(url));  
//	          
//	            // 将相对路径写回（json格式）  
//	            JSONObject jsonObject = new JSONObject();  
//	            // 将图片上传到本地  
//	            jsonObject.put("path", path);  
//	          
////	            // 设置响应数据的类型json  
////	            response.setContentType("application/json; charset=utf-8");  
////	            // 写回  
////	            response.getWriter().write(jsonObject.toString());  
//	  
//	        } catch (Exception e) {  
//	            throw new RuntimeException("服务器繁忙，上传图片失败");  
//	        }
//	}
	
	
}
