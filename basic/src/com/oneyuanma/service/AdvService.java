package com.oneyuanma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyuanma.dao.AdvPicture;
import com.oneyuanma.model.Adv;


@Service
public class AdvService {

	@Autowired
	AdvPicture AdvPicture;
	
//	public PageBean<User> findpage(User User,PageBean<User> page) {
//		page.setBean(User);
//		int count = AdvPicture.findpagecount(page);
//		page.setTotalRecords(count);
//		List<User> list = AdvPicture.findpage(page);
//		page.setList(list);
//		return page ;
//	}
	

	public void insert(Adv Adv) {
		AdvPicture.insert(Adv);
	}

	public String delete(Integer id) {
		String result="1";
		AdvPicture.delete(id);
		return result;
	}
	public void update(Adv Adv) {
		AdvPicture.update(Adv);
		
	}
	public Adv findbyid(Adv Adv) {
		List<Adv> list= AdvPicture.find(Adv);
		if(list.size()>0){
			Adv=list.get(0);
		}
		return Adv;
	}
	
	public List<Adv> findbyparentId(Adv Adv) {
		List<Adv> list= AdvPicture.find(Adv);
		return list;
	}


	public List<Adv> find(Adv Adv) {
		// TODO Auto-generated method stub
		return AdvPicture.find(Adv);
	}
	
	public List<Adv> findall() {
		// TODO Auto-generated method stub
		return AdvPicture.findall();
	}


//	public String isusername(String loginname) {
//		String flag="1";
//		Adv Adv=new Adv();
//		Adv.setLoginname(loginname);
//		List<User> list = AdvPicture.find(Adv);
//		if(list.size()>0){
//			flag="0";
//		}
//		return flag;
//	}
	
//	public String login(User user,HttpServletRequest request) {
//		String flag="99";
//		List<User> list = AdvPicture.find(user);
//		if(list.size()>0){
//			String pwd = user.getPwd();
//			pwd=Tool.MD5(pwd);
//			if(list.get(0).getPwd().equals(pwd)){
//				flag=list.get(0).getFlag();
//				if("1".equals(flag)){
//					user=list.get(0);
//					request.getSession().setAttribute(PublicStatic.USER, user);
//					user.setLastlogintime(Tool.getyyyyMMddHHmmss());
//					user.setLoginip(Tool.getIp(request));
//					AdvPicture.update(user);
//				}
//			}else{
//				flag="88";
//			}
//		}
//		return flag;
//	}
	
	public Adv findbyuserid(int id) {
		Adv adv=new Adv();
		adv.setId(id);
		List<Adv> list= AdvPicture.find(adv);
		if(list.size()>0){
			adv=list.get(0);
		}
		return adv;
	}


//	public String isfatie(String fatiegroup, User user) {
//		Map<String, Object> userjifengroup=AdvPicture.userjifengroup(user);
//		if(fatiegroup.equals("")||fatiegroup.contains("f"+userjifengroup.get("id")+",")){
//			return "1";
//		}else{
//			return "0";
//		}
//	}
	
//	public String ishuifu(String huifugroup, User user) {
//		Map<String, Object> userjifengroup=AdvPicture.userjifengroup(user);
//		if(huifugroup.equals("")||huifugroup.contains("h"+userjifengroup.get("id")+",")){
//			return "1";
//		}else{
//			return "0";
//		}
//	}
//	public Map<String, Object> findziliao( User user) {
//		Map<String, Object> ziliao=AdvPicture.findziliao(user);
//		return ziliao;
//	}


//	public void updateuseronlinetime(User user) {
//		// TODO Auto-generated method stub
//		AdvPicture.updateuseronlinetime(user);
//	}
}
