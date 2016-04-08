<%@page import="java.util.*,testpack.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <center>
    
    </table>
	
	<jsp:useBean id="user" class="testpack.User" scope="session"></jsp:useBean>
	<h2>Edit User Info Form</h2>
	<div style="color:red;font-weight:600;">${param.error}</div>
	<form method="post">
	<tr><td align="right">Name:</td><td><input type="text" name="uname" required></td></tr>
	<tr><td align="right">Full Name:</td><td><input type="text" name="fullname" required></td></tr>
	<tr><td align="right">Password:</td><td><input type="password" name="upass" required></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="Update" required></td></tr>
	<input type='hidden' name='userId' value=<jsp:getProperty property="uid" name="user"/>>
	</form>

	</td></tr></table>
    
    </center>
