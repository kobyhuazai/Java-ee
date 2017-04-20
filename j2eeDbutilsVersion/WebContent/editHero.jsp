<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="dao.HeroDAO"%>
<%@page import="bean.Hero"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改英雄信息</title>
</head>
<body>

<% 
int id = Integer.parseInt(request.getParameter("id"));
Hero hero = new HeroDAO().get(id);
%>

<form action='updateHero' method='post'>
名字 ： <input type='text' name='name' value='<%=hero.getName()%>' > <br>
血量 ： <input type='text' name='hp'  value='<%=hero.getHp()%>' > <br>
伤害 ： <input type='text' name='damage'  value='<%=hero.getDamage()%>' > <br>
<input type='hidden' name='id' value='<%=hero.getId()%>'>
<input type='submit' value='更新'>
</form>

</body>
</html>