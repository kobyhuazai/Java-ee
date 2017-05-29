<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="dao.HeroDAO"%>
<%@page import="bean.Hero"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>所有英雄信息</title>

<style type="text/css">
td {
	font-size: 12px;
}

h2 {
	margin: 0px
}
</style>

</head>
<body>

	<table align="center" width="450" border="1" height="180"
			bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
			<tr bgcolor="white">
				<td align="center" colspan="7">
					<h2>英雄信息</h2>
				</td>
			</tr>
			<tr align="center"  bgcolor="white">
				<td><b>id</b></td>
				<td><b>name</b></td>
				<td><b>hp</b></td>
				<td><b>damage</b></td>
				<td><b>edit</b></td>
				<td><b>delete</b></td>
			</tr>
			
			<%
			List<Hero> heros = new HeroDAO().list();
			for (Hero hero : heros) {
			%>
			
				<tr align="center"  bgcolor="white">
					<td><%=hero.getId()%></td>
					<td><%=hero.getName()%></td>
					<td><%=hero.getHp()%></td>
					<td><%=hero.getDamage()%></td>
					<td >
					<a href="editHero.jsp?id=<%=hero.getId()%>">edit</a>			
					</td>
				    <td>
				    <a href="HeroServlet?method=delete&id=<%=hero.getId()%>">delete</a>		  
				    </td>
				</tr>
			<%
			}
			%>
	</table>
</body>
</html>