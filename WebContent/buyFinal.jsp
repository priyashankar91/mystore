<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Model.Transaction" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<% Transaction t = (Transaction)request.getAttribute("trans");
	%>
<p align="center">Thank you for shopping at the MyStore.</p>
<p align="center">You BillID is: <%=t.getTranid() %></p>
<p align="center"><a href="index">Go to Homepage.</a></p>	

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>