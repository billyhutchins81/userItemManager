<%@ page language="java" import="java.util.*,testpack.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewItem</title>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</head>
<body>
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>
	
	<div style="text-align:center;">

	<jsp:useBean id="i" class="testpack.Item" scope="request"></jsp:useBean>
	
				<h2>Item Details</h2>
				<ul>
				<li>Item Name: <jsp:getProperty property="itemName" name="i"/></li>
				<li>Item Quantity: <jsp:getProperty property="qty" name="i"/></li>
				</ul>
				
	</div>
	
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>