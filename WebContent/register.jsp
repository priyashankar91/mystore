<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript">
function validate()
{	var uid=document.Regform.userid.value;
	var password=document.Regform.password.value;
	var name=document.Regform.name.value;
	var email=document.Regform.email.value;
	var phone=document.Regform.phone.value;
	if(v_uid(uid))
	{	
		if(v_password(password))
		{
			if(v_name(name))
			{
				if(v_email(email))
				{
					if(v_phone(phone))
					{
						return true;
					}
				}
			}
		}
		
	}
	return false;
}

function v_uid(uid)
{
	if(uid==null || uid=="")
		{	alert("username cannot be null or empty"); return false;} return true;
		
}
function v_password(password)
{	if(password==""||password==null ||password.length<4)
	{ alert("password cannot be empty / enter password more than 3 charaters "); return false;
	}return true;
}
function v_name(name)
{	var alpha = /^[A-Za-z]+$/; 
	if(name==null || name=="" )
	{	alert("Enter name");return false;}
	if(name.match(alpha))
		{	return true;}
	else
		{	alert("Enter only characters for name");return false;}
	
}
function v_email(email)
{	if(email=="" || email==null)
	{	alert("Enter email");return false;
	
	}
	var atpos = email.indexOf("@");
	var dotpos =email.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
	{
    	alert("Not a valid e-mail address");
    	return false;
	}
	return true;
}
function v_phone(phone)
{
	if(phone==""||phone==null)
		{	alert("enter phone number or must be number");return false;
		}
	return true;
}
</script>

</head>
<jsp:include page="header.jsp"></jsp:include>

<body style="font-family:verdana; font-size:12px; background-image:url('img/halftone.png');">
	<h2 align="center">Register</h2>
	<form name="Regform" onsubmit="return validate();" action="Register" method="post">
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
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>	
				<td>Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="text" name="phone"></td>		
			<tr>
				<td align="left"><input type="submit" value="Register"></td>
				<td align="right"><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>