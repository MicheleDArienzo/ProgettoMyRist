package com.MyRist.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.MyRist.Dao.Dao;

public class ComuniImpl implements ComuniUtility {

	private ArrayList<String> list = new ArrayList<String>();
	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	
	public ArrayList<String> getComuni(String regione, String provincia) {
		con = Dao.getConnection();
		
		
		try {
			
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT nome_comune FROM province, regioni, comuni WHERE id_regione = fk_id_regione AND id_provincia = fk_id_provincia AND nome_provincia = '"+provincia+"'");
			
			rst.first();
			
			while(rst.next())
			{
				/*prov = new Province();
				
				prov.setNome_provincia(rst.getString("nome_provincia"));*/
				
				list.add(rst.getString("nome_comune"));
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
	}

}
