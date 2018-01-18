package com.oneyuanma.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.oneyuanma.model.PageBean;
import com.oneyuanma.model.Adv;

@Repository
public class AdvPicture extends SqlSessionDaoSupport{
	String ap="adv_picture.";
	public List<Adv> findpage(PageBean<Adv> page) {
		return this.getSqlSession().selectList(ap+"findpage", page);
	}
	public int findpagecount(PageBean<Adv> page) {
		return this.getSqlSession().selectOne(ap+"findpagecount", page);
	}
	public int findmaxorderby(int parentid) {
		return this.getSqlSession().selectOne(ap+"findmaxorderby", parentid);
	}
	
	public List<Adv> find(Adv Adv) {
		return this.getSqlSession().selectList(ap+"find", Adv);
	}
	
	public List<Adv> findall() {
		List<Adv> Adv = new ArrayList<Adv>();
		return this.getSqlSession().selectList(ap+"findall",Adv);
	}

	public void insert(Adv Adv) {
		this.getSqlSession().insert(ap+"insert", Adv);
	}

	public void delete(Integer id) {
		this.getSqlSession().delete(ap+"delete", id);
	}

	public void update(Adv Adv) {
		this.getSqlSession().update(ap+"update", Adv);
	}

}