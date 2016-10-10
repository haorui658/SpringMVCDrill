<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	测试文字
<form:form method="post" action="add" modelAttribute="addemp">

	id<form:input path="id"/><br>
	name<form:input path="name"/><br>
	gender<form:input path="gender"/><br>
	<input type="submit" value="submit" />
</form:form>	



</body>
</html>