<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</head>
<body>
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
	</div>
	<div>
	
		<jsp:include page="/WEB-INF/editaccount-form.jsp"></jsp:include>
	
	</div>
	<div style="text-align:center;background-color:lightgrey;color:blue;">
		<jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
	</div>
</body>
</html>