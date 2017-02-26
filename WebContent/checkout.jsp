 <%@page import="Model.ShoppingCart"%>
<%@page import="java.util.*"%>
<%@page import="Model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<h2 align="center" style="margin-bottom:-40px;">Cart List</h2> 
<% ArrayList<Product> p = ShoppingCart.getList(); 
	int totalCost = 0;%>
	<% 
		String user = null;
		if(session.getAttribute("user")==null) {
		}
		else {
			user = (String)session.getAttribute("user");
		}
	%>

	<br>
	<br>
	<br>
	<br>
	<br>
	
	<%if(totalCost<=0) { %>
		<p align="center"> Cart is empty.</p>
	<% }else if(user!=null) { %>
	<form action="BuyCart" method="post">
		<div align="center" style="padding-top:20px;">
			<input type="hidden" name="totalCost" value="<%=totalCost %>">
			<input type="hidden" name="user" value="<%=user %>">
			<input type="submit" name="Buy" value="Buy">
		</div>
	</form>
	<% } else { %>
	<p align="center">Please login to proceed</p>		
	<% } %>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>