<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	input{
	
	border: none;
	background: none;
	background-color: brick;
	float: right;
	}
	
	div.rosso{
	
	padding: 10px;
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

if(session.getAttribute("Login") != null)
	{
		registrati = "<form method = 'post' action = 'Registrati'><input type = 'submit' value = 'Registrati'></form>";
		login = "<form method = 'post' action = 'CheckLogin'><input type = 'submit' value = 'Login' ></form>";
	}
	else
	{
		logout = "<form method = 'post' action = 'LogOut'><input type = 'submit' value = 'Logout'></form>";
		areaPrivata = "<form method = 'post' action = 'AreaPrivata'><input type = 'submit' value = 'Area Privata'></form>";
	}%>
<div class = "rosso">
<br>
<b>Benvunuto su MyRestaurant!</b>



<br><br><br>
<p><%out.println(registrati); out.println(login); out.println(areaPrivata); out.println(logout); %></p>
<br>

</div>
<hr>
</body>
</html>
