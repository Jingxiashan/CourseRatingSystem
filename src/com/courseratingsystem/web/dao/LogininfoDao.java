package com.courseratingsystem.web.dao;

import com.courseratingsystem.web.domain.Logininfo;

public interface LogininfoDao {
	public void add(Logininfo logininfo);
	public void update(Logininfo logininfo);
	public void delete(Logininfo logininfo);
	public Logininfo findUserById(int credentialsid);
}
