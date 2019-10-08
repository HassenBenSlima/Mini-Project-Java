<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<BODY>
	<H2>JSP Expressions</H2>
	<UL>
		<LI>Current time: <%=new java.util.Date()%>
		<LI>Your host_name: <%=request.getRemoteHost()%>
		<LI>Your session ID: <%=session.getId()%>
		<LI>The <CODE>testParam</CODE> form parameter:<%=request.getParameter("testParam")%>
	</UL>
</BODY>

</html>