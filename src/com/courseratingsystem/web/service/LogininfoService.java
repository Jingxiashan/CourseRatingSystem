package com.courseratingsystem.web.service;

import com.courseratingsystem.web.domain.Logininfo;

public interface LogininfoService {
	public void add(Logininfo logininfo);
	public void update(Logininfo logininfo);
	public void delete(Logininfo logininfo);
	public Logininfo findLogininfoBycredentialsid(int credentialsid);
	public Logininfo findLogininfoByusername(String username,String password);
}
