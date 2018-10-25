package com.MyRist.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.MyRist.Dao.*;



public class RegioniImpl implements RegioniUtility {

	private Regioni reg = null;
	private ArrayList<String> list = new ArrayList<String>();
	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	
	public ArrayList<String> getRegioni() {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT nome_regione FROM italia.regioni");
			
			rst.first();
			
			while(rst.next())
			{
				reg = new Regioni();
				reg.setNome_regione(rst.getString("nome_regione"));
				list.add(reg.getNome_regione());
			}
			
			return list;
			
		}catch(SQLException e) {System.out.println("errore sql");}
		
		return null;
	}

}
