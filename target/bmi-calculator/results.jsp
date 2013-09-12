<%@page import="cse.maven.sample.exception.InvalidBmiPropException"%>
<%@page import="cse.maven.sample.NicProp"%>
<%@page import="cse.maven.sample.NicInterpreter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h1>Bmi interpretation resutls</h1>

<h3>Result of bmi calculation is</h3>
<%
	String idNumberV = request.getParameter("nicNumber");
	
	
	NicInterpreter nicInterpreter = new NicInterpreter();
	
	try {
		NicProp nicProp = nicInterpreter.createNicProp(idNumberV);
		String birthDay = nicInterpreter.calculate(nicProp);
		out.println(birthDay);
	} catch (InvalidBmiPropException ex) {
		out.println(ex.getMessage());
	}	
%>
</head>
<body>

</body>
</html>