package com.MyRist.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Dao {

	private static DataSource ds = null;
	private static Connection conn = null;
	private static Dao dao = null;
	
	private Dao()
	{
		Context initCtx;
		Context envCtx;
		try {
			initCtx = new InitialContext();
			envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource)envCtx.lookup("jdbc/italia");
		}catch(NamingException e) {}
	}
	
	
	public static Connection getConnection()
	{
		if(ds == null)
		{
			dao = new Dao();
			
			try {
				conn = ds.getConnection();
			}catch(SQLException e) {}
			
			
		}
		
		return conn;
	}
	
}
