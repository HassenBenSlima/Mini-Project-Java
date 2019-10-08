<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<p>this is my fist view on servlet   </p>
<p><br/> ${5*6} </p>${name}
<p>بسم الله الرحمان الرحيم</p>
<%
//recuperer une varible avec URL
	String name=(String)request.getAttribute("name");
	out.println(name);
%>


<p>
<%
	String variable=(String)request.getAttribute("variable");
	out.println(variable+"<br/>");

	String heure=(String)request.getAttribute("heure");
	if(heure.equals("jour"))
	{
		out.println("<br/> Bonjour Hassen <br/>");
	}else{
		out.println("<br/> Bonsoir Hassen <br/>");
	}
%>

	<%
		for(int i =0;i<20;i++){
			out.println("<br/> Une nouvelle ligne "+i);
		}
	%>
</p>
</body>
</html>