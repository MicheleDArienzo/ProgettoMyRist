<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<%@ page import = "java.util.ArrayList" %>
<%

String login = "";
String logout = "";
String registrati = "";
String areaPrivata = "";
RegioniImpl reg = new RegioniImpl();
ArrayList<String> regioni = reg.getRegioni();

if(session.getAttribute("Login") == null)
	{
		registrati = "<form method = 'post' action = 'Registrati'><input class = 'head' type = 'submit' value = 'Registrati'></form>";
		login = "<form method = 'post' action = 'CheckLogin'><input class = 'head' type = 'submit' value = 'Login' ></form>";
	}
	else
	{
		logout = "<form method = 'post' action = 'LogOut'><input class = 'head' type = 'submit' value = 'Logout'></form>";
		areaPrivata = "<form method = 'post' action = 'AreaPrivata'><input type class = 'head' = 'submit' value = 'Area Privata'></form>";
	}%>
<div class = "rosso">
<br>
<b>Benvunuto su MyRestaurant!</b>



<br><br><br>
<p><%out.println(registrati); out.println(login); out.println(areaPrivata); out.println(logout); %></p>
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

<form method = "post" action = "stampaRistoranti">
<input type = "text" name = "nome" id = "nome" placeholder = "Cerca per nome...">
<input type = submit value = "Cerca">
</form>
</div>
<div class = "ricerca">

</div>
</body>
</html>
