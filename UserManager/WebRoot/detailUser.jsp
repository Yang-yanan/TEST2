<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <s:form action="userToDetail" method="post">
   		<table width="300" border="1" bordercolor="#99CCFF">
   			<s:textfield name="user.id" label="ID号" />
   			<s:textfield name="user.name" label="姓名" />
    		<s:select list="sexs" name="user.sex" label="性别" />
    		<s:textfield name="user.age" label="年龄" />
    		<s:textfield name="user.telephone" label="电话" />
    		<s:textfield name="user.email" label="邮箱" />
    		<s:textfield name="user.specialty" label="专业" />
    		<s:textfield name="user.school" label="学校" />
    		<s:textarea name="user.address" label="地址" />
   		</table>
   	</s:form>
   
  </body>
</html>
