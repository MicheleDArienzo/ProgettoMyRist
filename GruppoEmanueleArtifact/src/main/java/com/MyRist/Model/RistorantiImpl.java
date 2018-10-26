package com.MyRist.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.MyRist.Dao.Dao;

public class RistorantiImpl implements RistorantiUtility {

	private Ristoranti rist = null;
	private ArrayList<Ristoranti> list = new ArrayList<Ristoranti>();
	private Connection con = null;
	private Statement st = null;
	private ResultSet rst = null;
	
	public ArrayList<Ristoranti> queryRegioneProvinciaComuneNome(String regione, String provincia, String comune,
			String nome) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND nome_regione = '"+regione+"' AND nome_provincia = '"+provincia+"' AND nome_comune ='"+comune+"' AND nome_ristorante = '"+nome+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
	}

	public ArrayList<Ristoranti> queryRegioneProvinciaComune(String regione, String provincia, String comune) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND nome_regione = '"+regione+"' AND nome_provincia = '"+provincia+"' AND nome_comune ='"+comune+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
		
	}

	public ArrayList<Ristoranti> queryRegioneProvincia(String regione, String provincia) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND nome_regione = '"+regione+"' AND nome_provincia = '"+provincia+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
		
	}

	public ArrayList<Ristoranti> queryRegione(String regione) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND nome_regione = '"+regione+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
		
	}

	public ArrayList<Ristoranti> queryNome(String nome) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND nome_ristorante = '"+nome+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
		
	}

	public ArrayList<Ristoranti> queryRegioneProvinciaComuneNomeTipo(String regione, String provincia, String comune,
			String nome, String tipo) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti, rel_ristoranti_tipi_cucina, tipi_cucina WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND ristoranti_fk_p_iva = ristoranti.p_iva AND tipi_cucina_id_fk = id_tipi_cucina AND nome_regione = '"+regione+"' AND nome_provincia = '"+provincia+"' AND nome_comune ='"+comune+"' AND nome_ristorante = '"+nome+"' AND tipi_cucina.descrizione ='"+tipo+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
	}

	public ArrayList<Ristoranti> queryTipo(String tipo) {
		
		con = Dao.getConnection();
		
		try {
			st = con.createStatement();
			
			rst = st.executeQuery("SELECT p_iva, nome_ristorante, inizio_pranzo, fine_pranzo, inizio_cena, fine_cena, indirizzo, giorno_chiusura FROM italia.ristoranti, italia.regioni, italia.province, italia.comuni, italia.utenti, rel_ristoranti_tipi_cucina, tipi_cucina WHERE fk_username = utenti.username AND ristoranti.fk_id_regione = regioni.id_regione AND ristoranti.fk_id_provincia = province.id_provincia AND ristoranti.fk_id_comune = comuni.id_comune AND ristoranti_fk_p_iva = ristoranti.p_iva AND tipi_cucina_id_fk = id_tipi_cucina AND tipi_cucina.descrizione ='"+tipo+"'");
			
			rst.first();
			int i = 0;
			while(rst.next())
			{
				list.add(new Ristoranti());
				list.get(i).setP_iva(rst.getString("p_iva"));
				list.get(i).setNome_ristorante(rst.getString("nome_ristorante"));
				list.get(i).setInizio_pranzo(rst.getString("inizio_pranzo"));
				list.get(i).setFine_pranzo(rst.getString("fine_pranzo"));
				list.get(i).setInizio_cena(rst.getString("inizio_cena"));
				list.get(i).setFine_cena(rst.getString("fine_cena"));
				list.get(i).setIndirizzo(rst.getString("indirizzo"));
				list.get(i).setGiorno_chiusura(rst.getString("giorno_chiusura"));
				i++;
			}
			
			return list;
			
		}catch(SQLException e) {e.printStackTrace();}
		
		return null;
	}

}
