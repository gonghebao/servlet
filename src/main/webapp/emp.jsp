<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>jsp</title>
		<style>
			table{
				border:1px solid #ddd;
				border-collapse:collapse;
			}
			td{
				border:1px solid #ddd;
				text-align:center;
			}
			a{
				padding:5px 8px;
				text-decoration:none;
				color:blue;
			}
		</style>
	</head>
	<body>
		<a href="add.jsp">增加</a>
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>工作</td>
				<td>工资</td>
				<td></td>
			</tr>
			<c:forEach items="${emps}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.name }</td>
					<td>${e.gender}</td>
					<td>${e.birthday }</td>
					<td>${e.job }</td>
					<td>${e.sal}</td>
					<td><a href="modify.jsp?id=${e.id}&
					name=${e.name}&gender=${e.gender}&
					birthday=${e.birthday}&job=${e.job}&
					sal=${e.sal}">修改</a><a href="delete.do?id=${e.id}">删除</a></td>
				</tr>
			</c:forEach>		
		</table>
	</body>
</html>