<%@page pageEncoding="utf-8"%>
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
			}
			a{
				padding:5px 8px;
				text-decoration:none;
				color:blue;
			}
		</style>
	</head>
	<body>
		<form action="modify.do" method="post">
			<p>
				编号:<input type="text" value="${param.id}" name="eid" readonly/>
			</p>
			<p>
				姓名:<input type="text" value="${param.name}" name="name"/>
			</p>
			<p>
				性别:<input type="text" value="${param.gender}" name="gender"/>
			</p>
			<p>
				生日:<input type="text" value="${param.birthday}" name="birthday"/>
			</p>
			<p>
				工作:<input type="text" value="${param.job}" name="job"/>
			</p>
			<p>
				工资:<input type="text" value="${param.sal}" name="sal"/>
			</p>
			<p>
				<input type="submit" value="保存"/>
			</p>
		</form>
	</body>
</html>