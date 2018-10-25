package com.MyRist.Model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.MyRist.Dao.Dao;


public class ProvinceImpl implements ProvinceUtility {

	private Province prov = null;
	private ArrayList<String> list = new ArrayList<String>();
	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	
	public ArrayList<String> getProvince(String regione) {
		con = Dao.getConnection();
		
		
		try {
			st = con.createStatement();
			
			//rst = st.executeQuery("SELECT nome_provincia FROM province, regioni WHERE fk_id_regione = id_regione AND nome_regione = '"+regione+"';");
			rst = st.executeQuery("SELECT nome_provincia FROM province, regioni WHERE id_regione = fk_id_regione AND nome_regione = '"+regione+"'");
			rst.first();
			
			while(rst.next())
			{
				/*prov = new Province();
				
				prov.setNome_provincia(rst.getString("nome_provincia"));*/
				list.add(rst.getString("nome_provincia"));
			}
			
			return list;
			
		}catch(SQLException e) {System.out.println("errore sql");}
		
		return null;
	}

}
