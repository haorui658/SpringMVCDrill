<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	测试文字
	<form:form action="/add" method="POST" modelAttribute="addemp">
		<c:if test="${addemp.id !=null}">
			<form:hidden path="id" /><br>
			<input type="hidden" name="_method" value="PUT" />			
		</c:if>
		name<form:input path="name" /><br>
		<c:if test="${addemp.id ==null}">
		lastname<form:input path="lastName" /><br>
		</c:if>
	gender<form:input path="gender" /><br>
		<input type="submit" value="submit" />
	</form:form>



</body>
</html>