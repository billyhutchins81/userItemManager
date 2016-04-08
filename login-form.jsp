<%@page import="testpack.OurUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<center>

<form method="post">
<h3 style="color:red;">${param.msg}</h3>
<h3>Login Form</h3>
User Name: <input type="text" name="uname"><br>
Password: 	<input type="password" name="upass"><br>
<input type="submit" value="login">
</form>
<h3><a href="CreateAccount">Create New Account</a></h3>

</center>