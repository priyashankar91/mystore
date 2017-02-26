<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script type="text/javascript">
	function validateForm()
	{
			var x = document.Loginform.userid.value;
			var y = document.Loginform.password.value;
			if(x==null||x==""||y==null||y=="")
			{
					alert("Invalid username and password");
					return false;
			}
	}
</script>
<jsp:include page="header.jsp"></jsp:include>

<body style="font-family:verdana; font-size:12px; background-image:url('img/halftone.png');">
	<h2 align="center">Login</h2>
	<% String msg = (String)request.getAttribute("message");
	if(msg!=null) {
	out.print(msg);
	}
	%>
	<form name="Loginform" onsubmit="return validateForm();" action="Login" method="post">
		<table align="center">
			<tr>
				<td>Username :</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>	
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td align="left"><input type="submit" value="Sign In"></td>
				<td align="right"><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>