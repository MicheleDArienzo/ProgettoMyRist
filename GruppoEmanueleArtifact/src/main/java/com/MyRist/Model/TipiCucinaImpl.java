package com.MyRist.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.MyRist.Dao.Dao;

public class TipiCucinaImpl implements TipiCucinaUtility {

	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	private ArrayList<TipiCucina> list = new ArrayList<TipiCucina>();
	
	public ArrayList<TipiCucina> getTipiCucina() {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT * FROM italia.tipi_cucina");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new TipiCucina());
				list.get(i).setId_tipi_cucina(Integer.parseInt(rst.getString("id_tipi_cucina")));
				list.get(i).setDescrizione(rst.getString("descrizione"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {System.out.println("errore sql");}
		
		return null;
	}

}
