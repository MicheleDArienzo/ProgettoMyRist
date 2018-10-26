package com.MyRist.Model;

import java.util.ArrayList;

public interface RistorantiUtility {

	public ArrayList<Ristoranti> queryRegioneProvinciaComuneNomeTipo(String regione, String provincia, String comune, String nome, String tipo);
	
	public ArrayList<Ristoranti> queryRegioneProvinciaComuneNome(String regione, String provincia, String comune, String nome);

	public ArrayList<Ristoranti> queryRegioneProvinciaComune(String regione, String provincia, String comune);
	
	public ArrayList<Ristoranti> queryRegioneProvincia(String regione, String provincia);
	
	public ArrayList<Ristoranti> queryRegione(String regione);
	
	public ArrayList<Ristoranti> queryNome(String nome);
	
	public ArrayList<Ristoranti> queryTipo(String tipo);

}
