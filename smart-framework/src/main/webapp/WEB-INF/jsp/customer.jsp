<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="BASE" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户管理</title>
</head>
<body>
	<h1>客户列表</h1>
	<table>
		<tr>
			<th>客户名称</th>
			<th>联系人</th>
			<th>电话号码</th>
			<th>邮箱地址</th>
			<th>操作</th>
		</tr>
		<c:forEach var="customer" items="${customerList }">
			<tr>
				<td>${customer.name }</td>
				<td>${customer.contact }</td>
				<td>${customer.telephone }</td>
				<td>${customer.email }</td>
				<td>编辑 删除</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>