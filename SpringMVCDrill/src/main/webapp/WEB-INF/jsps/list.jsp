<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<form action="" Method="POST">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<a href="/input">新增</a>
	<c:if test="${!empty emp}">
		<table border="1" cellpadding="10">
			<c:forEach items="${emp}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.name}</td>
					<td>${e.lastName}</td>
					<td>${e.gender}</td>
					<td><a class="edit" href="/input/${e.id}">Edit</a></td>
					<td><a class="delete" href="/list/${e.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>