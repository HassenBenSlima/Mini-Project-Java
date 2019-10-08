<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>ColorTesting</TITLE>

<%
	String bgColor = request.getParameter("bgColor");
	boolean hasExplicitColor;
	if (bgColor != null) {
		hasExplicitColor = true;

	} else {
		hasExplicitColor = false;
		bgColor = "WHITE";
	}
%>

</head>

<BODY BGCOLOR="<%=bgColor%>">
	<H2 ALIGN="CENTER">ColorTesting</H2>
	<%
		if (hasExplicitColor) {
			out.println("vous avez choisi la couleur" + bgColor);
		}

		else {
			out.println(" la couleur blanche est choisie par défaut ");
		}
	%>


</body>
</html>