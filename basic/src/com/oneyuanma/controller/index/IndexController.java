package com.oneyuanma.controller.index;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oneyuanma.model.Adv;
import com.oneyuanma.service.AdvService;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping("adv.do")
	public String adv(HttpServletRequest request, Model model) {
		model.addAttribute("advlists", (List<Adv>)request.getSession().getAttribute("advlists"));
		return "jsp/index/adv";
	}
	
	@RequestMapping("advPicShow.do")
	public Object advPicShow(HttpServletRequest request, Model model) {
		System.out.println("advPicShow in success");
		List<Adv> advList = AdvService.findall();
		System.out.println(advList.size());
		System.out.println(advList.get(0).getId());
		request.getSession().setAttribute("advlists", advList);
		request.getSession().setAttribute("advlisto", advList.get(0));
		return advList;
	}
	
	@RequestMapping("advpic.do")
	@ResponseBody
    public String  advpic(HttpServletRequest request,Adv adv,@RequestParam("uploadImg") MultipartFile multipartFile)
    {
		System.out.println("uploadImage in success");
		//处理上传文件  
		String oldFileName = multipartFile.getOriginalFilename();
		System.out.println(oldFileName);
		//文件后缀  
		String suffix = oldFileName.substring(oldFileName.lastIndexOf("."));
		System.out.println(suffix);
		//获取文件提交路径(服务器)  
		//request.getServletContext() --> application  
		StringBuffer buffer = new StringBuffer();
		buffer.append("http://localhost:8080");
		buffer.append(request.getServletContext().getContextPath());
		buffer.append("/upload");
		System.out.println(buffer.toString());
		
		//文件重命名  
		//时间(毫秒数)+随机数+_blog+suffix  
		//1970-1-1~今天   System.currentTimeMillis();  
		String newFileName = System.currentTimeMillis()+new Random().nextInt(1000000)+"_blog"+suffix;  
		System.out.println(newFileName);
		//上传文件 java.io.File  
		File targetFile = new File(buffer.toString(),newFileName);  
		try {  
		multipartFile.transferTo(targetFile);  
		} catch (IllegalStateException e){  
		e.printStackTrace();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}
		
		String uploadPath1 = request.getServletContext().getRealPath("/upload/"+newFileName);
		System.out.println(uploadPath1);
		
		String uploadPath2 = "WebRoot/upload/"+newFileName;
		System.out.println(uploadPath2);
		
		System.out.println("advpic in success");
		System.out.println(adv.getName());
		System.out.println(adv.getDescrib());
		System.out.println(adv.getGrade());
		Adv advupdate = new Adv();
		advupdate.setId(adv.getGrade());
		advupdate.setName(adv.getName());
		advupdate.setDescrib(adv.getDescrib());
		advupdate.setGrade(adv.getGrade());
		advupdate.setUrl(uploadPath2);
		AdvService.insert(advupdate);
		return uploadPath2;
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
