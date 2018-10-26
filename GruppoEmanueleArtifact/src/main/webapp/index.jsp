<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%String currReg; %>


<script type="text/javascript" src="jscript/ricercaRist.js"></script>
<link rel="stylesheet" type="text/css" href="stylecss/stilicss.css">
<%/*
Ricerca ristorante con menù a tendina o con nome.

*/ %>

</head>
<body>
<%@ page import = "com.MyRist.Model.RegioniImpl" %>
<%@ page import = "com.MyRist.Model.Ristoranti" %>
<%@ page import = "com.MyRist.Model.TipiCucina" %>
<%@ page import = "com.MyRist.Model.TipiCucinaImpl" %>
<%@ page import = "java.util.ArrayList" %>
<%

String login = "";
String logout = "";
String registrati = "";
String gestioneUtente = "";
String gestioneRistorante = "";
RegioniImpl reg = new RegioniImpl();
ArrayList<String> regioni = reg.getRegioni();
TipiCucinaImpl tipimp = new TipiCucinaImpl();
ArrayList<TipiCucina> tipi = tipimp.getTipiCucina();

if(session.getAttribute("Login") == null)
	{
	
		registrati = "<form method = 'post' action = 'Registrati'><input class = 'head' type = 'submit' value = 'Registrati'></form>";
		
		login = "<form method = 'post' action = 'CheckLogin'><input class = 'head' type = 'submit' value = 'Login' ></form>";
	
	}
	else
	{
		logout = "<form method = 'post' action = 'LogOut'><input class = 'head' type = 'submit' value = 'Logout'></form>";
		
		gestioneUtente = "<form method = 'post' action = 'GestioneUtente'><input type class = 'head' = 'submit' value = 'Gestione utente'></form>";
		
		if((Integer)session.getAttribute("Login") == 1)
		{
		
			gestioneRistorante = "<form method = 'post' action = 'GestioneRistorante'><input type class = 'head' = 'submit' value = 'Gestione Ristorante'></form>";
		
		}
	
	}%>
<div class = "rosso">
<br>
<b>Benvunuto su MyRestaurant!</b>



<br><br><br>
<p><%out.println(registrati); out.println(login); out.println(gestioneUtente); out.println(logout); %></p>
<br>

</div>
<hr>
<div class = "ricerca">
<form method = "post" action = "prendiProvince" name = "formregioni" style = "display:inline;">

<%
out.println("<select id = 'regioni' name = 'regioni' onchange='document.formregioni.submit()'><option value = 'blank'>Regione</option>");
for(int i = 0; i < regioni.size(); i++)
{
	out.println("<option value='"+regioni.get(i)+"'>"+regioni.get(i)+"</option>");
	}
out.println("</select>");
%>
</form>


<form method = "post" action = "prendiComuni" name = "formcomuni" style = "display:inline;">

<select id = "province" name = 'province' onchange='document.formcomuni.submit()'>

<option value = 'blank'>Provincia</option>

<%
	if(session.getAttribute("province") != null)
	{
		
		ArrayList<String> list =(ArrayList<String>) session.getAttribute("province");
		int i  = 0;
		
		for(String item: list)
		{
			out.println("<option value='"+list.get(i)+"'>"+list.get(i)+"</option>");
			i++;
		}
		
	}
%>
</select>

</form>

<form method = "post" action = "stampaRistoranti">
<select id = "comuni" name = 'comuni'><option value = 'blank'>Comuni</option>

<%
	if(session.getAttribute("comuni") != null)
	{
		
		ArrayList<String> list =(ArrayList<String>) session.getAttribute("comuni");
		int i  = 0;
		
		for(String item: list)
		{
			out.println("<option value='"+list.get(i)+"'>"+list.get(i)+"</option>");
			i++;
		}
		
	}
%>

</select>

<select id = "tipicucina" name = "tipicucina">
<option value = 'blank'>Tipo cucina</option>
<%
	for(TipiCucina item: tipi)
	{
		out.println("<option value = '"+item.getDescrizione()+"'>"+item.getDescrizione()+"</option>");
	}
%>
</select>
<input type = "text" name = "nome" id = "nome" placeholder = "Cerca per nome...">
<input type = submit value = "Cerca">
</form>
</div>
<div class = "ricerca">
<%
	ArrayList<Ristoranti> list = new ArrayList<Ristoranti>();
	list = (ArrayList<Ristoranti>)session.getAttribute("ricercaCompleta");
	if(list != null && !list.isEmpty())
	{
		
		
		out.println("<form method = 'post' action = 'Prenota'>");
		
		for(Ristoranti item : list)
		{
			out.println("Nome "+item.getNome_ristorante()+" Indirizzo "+item.getIndirizzo()+" Apertura pranzo "+item.getInizio_pranzo()+" Chiusura pranzo "+item.getFine_pranzo()+" Apertura cena "+item.getInizio_cena()+" Chiusura cena "+item.getFine_cena()+" <button type='submit' name='buttonPrenota' value='"+item.getP_iva()+"'>Prenota</button>");
			
		}
		out.println("</form>");
		
	}
	else if(session.getAttribute("ricercaFatta") != null)
	{
		out.println("<b>Non ho trovato nulla :/</b>");
	}
%>
</div>
</body>
</html>
