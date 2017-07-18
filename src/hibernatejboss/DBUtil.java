package com.chinasoft.app.hibernatejboss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	//�������ķ���
	private Connection conn = null;
	private PreparedStatement  ptsm = null;
	private ResultSet rs =null;
	//����һ����ȡ���ݿ�����
	public void getConn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://127.0.0.1:3306/test";
			String username ="root";
			String password = "1";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���������ر����ݿ����ӵķ���
	public void closeConn(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ptsm!=null){
			try {
				ptsm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//����������ɾ�ĵķ���
	public int executOther(final String strSQL,final Object[] params){
		this.getConn();
		try {
			ptsm = conn.prepareStatement(strSQL);
			for(int i=0;i<params.length;i++){
				ptsm.setObject(i+1, params[i]);
			}
			return ptsm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	//�����ģ�ר��ִ�в�ѯ�ķ���
	public ResultSet execQuery(final String strSQL,final Object[] params){
		this.getConn();
		try {
			ptsm = conn.prepareStatement(strSQL);
			for(int i=0;i<params.length;i++){
				ptsm.setObject(i+1, params[i]);
			}
			return ptsm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
