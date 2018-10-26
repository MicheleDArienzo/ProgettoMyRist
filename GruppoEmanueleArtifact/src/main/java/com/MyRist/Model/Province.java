package com.MyRist.Model;

public class Province {

	private int id_provincia;
	private int fk_id_regione;
	private String nome_provincia;
	
	
	public int getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	public int getFk_id_regione() {
		return fk_id_regione;
	}
	public void setFk_id_regione(int fk_id_regione) {
		this.fk_id_regione = fk_id_regione;
	}
	public String getNome_provincia() {
		return nome_provincia;
	}
	public void setNome_provincia(String nome_provincia) {
		this.nome_provincia = nome_provincia;
	}
	
}
