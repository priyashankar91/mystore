<%@page import="Model.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<LINK href="css/header.css" rel="stylesheet" type="text/css">
</head>
<style>
#header-nav_bar {
	background-color:#4F4F4F;
	margin-top:10px; 
	padding-top:5px; 
	padding-bottom:5px; 
	padding-right:10px; 
	font-family:verdana;
	font-size:12px;
}
</style>
<body style="font-family:verdana; font-size:12px; background-image:url('img/halftone.png');">
	<% 
		String user = null;
		if(session.getAttribute("user")==null) {
			//resource = "login.jsp";
		}
		else {
			user = (String)session.getAttribute("user");
		}
		%>
		
	<table border="0" width=100%>
		<tr>
			<td>
				<div style="background-color:white;border-radius:10px; padding:5px;">
				<img src="img/logo_mystore1.jpg" alt="My Store">&nbsp;&nbsp;
				</div>
			</td>
			<td valign="bottom" align="right" style="font-family:verdana;">
				<form name="Searchform" action="SearchProducts" method="post">
				<input type="text" name="search" size="90" style="height:30px;">
				<input type="submit" value="Search" style= "color:white ;background-color:#4F4F4F; border:hidden; height:35px;">
				</form>
			</td>
		<tr>
	</table>
	<!--<hr style="width:100%; ">-->

	<div align="center" id="header-bottom" >
		<a href="Home.jsp" style="text-decoration:none; color:white;">Home | </a>
		
		<%if(session.getAttribute("user")==null) {
		out.print("<a href=\"register.jsp\" style=\"text-decoration:none; color:white;\">Sign-Up | </a>");
		out.print("<a href=\"login.jsp\" style=\"text-decoration:none; color:white;\">Login | </a>");
		
		} //if(session.getAttribute("user")==null) 
		else
		{
			//out.print(session.getAttribute("user"));
			out.print("<a href=\"#\" style=\"text-decoration:none; color:white;\">"+user+" | </a>");
			//out.print(" | ");
			out.print("<a href=\"logout.jsp\" style=\"text-decoration:none; color:white;\">Logout | </a>");
		}
		 %>
		 
		 
		<% int size = ShoppingCart.getList().size(); %>
		<a href="checkout.jsp" style="text-decoration:none; color:white;">Cart(<%out.print(size); %>)</a>
	</div>
	
	<div align="center" id="header-nav_bar">
		<a href="ListMobiles" style="text-decoration:none; color:white; border-right:1px solid grey; border-left:1px solid grey; padding:4px 10px 4px 10px;">Electronics</a>
		<a href="ListLaptops" style="text-decoration:none; color:white; border-right:1px solid grey; padding:4px 10px 4px 5px;">Home & furniture</a>
		<a href="ListComps" style="text-decoration:none; color:white; border-right:1px solid grey; padding:4px 10px 4px 10px;">Groceries</a>
	</div>
	
</body>
</html>