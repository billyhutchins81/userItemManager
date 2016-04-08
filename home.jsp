<%@ page language="java" import="java.util.*,testpack.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="myjsp" uri="/WEB-INF/tlds/OurTags.tld" %> 
    <%@ taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</head>
<body>
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>

		
	<div align="center">
	
	</div>
	
	<div style="color:red;font-weight:600;"><my:jsp name="${param.msg}"></my:jsp></div>
	<div>
		<div style="width:100%;display:block"></div>
			
			<div style="float:left;">Welcome:<myjsp:JavaTag name="${user.userName}"></myjsp:JavaTag></div>
			<div style="float:right;">
				<a href="EditAccount">Edit Account</a>&nbsp;&nbsp;
				<a href="LogOut">LogOut</a>
			</div>
	
	<div style="width:100%;text-align:center;display:block;clear:left;">
		<h2>List of items</h2>
	
		
		<table align="center">
	
			<c:forEach var="item" items="${items}">
			<tr>
				<td><a href="ViewItem?id=${item.itemId}">View</a></td>				
				<td><a href="EditItem?id=${item.itemId}">Edit</a></td>
				<td><a href="DeleteItem?id=${item.itemId}">Delete</a></td>
				<td>${item.itemName}</td>
				<td>${item.qty}</td>
			</tr>
	
		</c:forEach>
		
		</table>
		
		here is a list of items(table)
		<h3><a href="AddItem">Add new item</a></h3>
		</div>
	</div>
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>