<%@page import="java.util.*"%>
<%@page import="Model.Product"%>
<%@page import="Model.Comment" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<% 	Product prod = (Product)request.getAttribute("prod");

%>
<title>My Store</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body  style="font-family:verdana; font-size:12px; background-image:url('img/halftone.png');">
	<div align="center">
	<p>Product Page</p>
	
	<% 	String pname = prod.getPname();
		int pcost = prod.getPcost();
		String pspec = prod.getPspec();
		//String pspec = ReadTxt.readText(pspecf);
		String imgpath = prod.getImgpath(); 
	%>
		<table>
		<tr>
			<td style="background:white; width:200px;height:200px;"><img src="img/<%=imgpath%>"></td>
		</tr>
		<tr>
			<td><div style="background:white;border-radius:0px;padding:5px;"><h2><%= pname %></h2></div></td>
		</tr>
		<tr>
			<td><div style="background:white;border-radius:0px;padding:5px;"><b>Rs. <%= pcost %></b></div></td>
		</tr>
		<tr>
			<td><div style="background:white;border-radius:0px;padding:5px;"> Specification <br> 
			<%= pspec %></div>
			</td>
		</tr>
		</table>
	
	<form name="buy" action="addToCart" method="post">
	<%	out.print("<input type=\"hidden\" name=\"pid\" value=\""+prod.getPid()+"\">");
	%>	
	<input type="submit" name="addtocart" value="Add To Cart">
	</form>
	<br><br>
	</div>
	
	
	
</body>
</html>