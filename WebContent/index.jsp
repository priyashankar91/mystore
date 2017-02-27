<%@page import="java.util.*"%>
<%@page import="Model.Product"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Product> ProdList = (List<Product>) request.getAttribute("ProdList");
%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyStore</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body style="font-family:verdana; font-size:12px; background-image:url('img/halftone.png');">

<% 
  
	for(int i=0;i<ProdList.size();i+=3)
   {	 
   	%>
<table align="center" >
		<tr>
			<%try {
				if(ProdList.get(i)!= null) {  %>
				<td  align="center" style="border-collapse:collapse;border:1px solid #000000; border-radius:10px;padding-bottom:0px;" bgcolor="white" width="200" height="200">	
				<%	out.print("<img src=\"img/"+ProdList.get(i).getImgpath()+"\"><br>");
			 		out.print(ProdList.get(i).getPname()+"<br>");
			 	%>
				<form name ="productForm" action="ShowProductPage" method="post">
				<%	out.print("<input type=\"hidden\" name=\"ProdName\" value=\""+ProdList.get(i).getPid()+"\">");
					out.print("Rs. "+ProdList.get(i).getPcost()+"<br>"); 
				%>
					<input type="submit" name="Product Page" value="View"/>
				<% 	
			}
			}catch(IndexOutOfBoundsException e)
			{
			}
			%>
				</form>
				</td>
			<%try {
				if(ProdList.get(i+1)!= null) {  %>
				<td  align="center" style="border-collapse:collapse;border:1px solid #000000; border-radius:10px; padding-bottom:0px;" bgcolor="white" width="200" height="200" >	
				<%	out.print("<img src=\"img/"+ProdList.get(i+1).getImgpath()+"\"><br>");
			 		out.print(ProdList.get(i+1).getPname()+"<br>");
			 	%>
				<form name ="productForm" action="ShowProductPage" method="post">
				<%	out.print("<input type=\"hidden\" name=\"ProdName\" value=\""+ProdList.get(i+1).getPid()+"\" readonly>");
					out.print("Rs. "+ProdList.get(i+1).getPcost()+"<br>"); 
				%>
					<input type="submit" name="Product Page" value="View" style="padding-bottom:0px;"/>
				<% 	
			}
			}catch(IndexOutOfBoundsException e)
			{
			}
			%>
				</form>
				</td>
			
			<%try {
				if(ProdList.get(i+2)!= null) {  %>
				<td  align="center" style="border-collapse:collapse;border:1px solid #000000; border-radius:10px;padding-bottom:0px;" bgcolor="white" width="200" height="200" >	
				<%	out.print("<img src=\"img/"+ProdList.get(i+2).getImgpath()+"\"><br>");
			 		out.print(ProdList.get(i+2).getPname()+"<br>");
			 	%>
				<form name ="productForm" action="ShowProductPage" method="post">
				<%	out.print("<input type=\"hidden\" name=\"ProdName\" value=\""+ProdList.get(i+2).getPid()+"\" readonly>");
					out.print("Rs. "+ProdList.get(i+2).getPcost()+"<br>"); 
				%>
					<input type="submit" name="Product Page" value="View"/>
				<% 	
			}
			}catch(IndexOutOfBoundsException e)
			{
			}
			%>
				</form>
				</td>
			
	</tr>
</table> 
<% } %> 
  </body>
  <jsp:include page="footer.jsp"></jsp:include>
</html>
