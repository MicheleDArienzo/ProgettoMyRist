<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	input.head{
	
	border: none;
	background: none;
	background-color: brick;
	float: right;
	}
	
	div.rosso{
	
	padding: 10px;
	}
	
	div.ricerca{
		text-align: center;
		margin-top: 100px;
	}
	
	
</style>
<%/*
Ricerca ristorante con menù a tendina o con nome.

*/ %>
</head>
<body>
<%

String login = "";
String logout = "";
String registrati = "";
String areaPrivata = "";

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
<input type = "button" id = "BRicerca" value = "Cerca il Ristorante">
</div>
</body>
</html>
