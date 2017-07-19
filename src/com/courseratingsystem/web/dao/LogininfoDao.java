package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;

public interface LogininfoDao {
	public void add(Logininfo logininfo);
	public void update(Logininfo logininfo);
	public void delete(Logininfo logininfo);
	public List<Logininfo> findLogininfoByuserid(int userid);
	public Logininfo findLogininfoByusername(String username);
	public Logininfo findLogininfoByusernameandpassword(String username,String password);
}
