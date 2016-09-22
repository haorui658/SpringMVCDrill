<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/hello/save" method="post">
		<div>
			<span>课程介绍:</span>
			<textarea id="descrp" name="descrName" rows="5" style="width: 480px"></textarea>
		</div>
		<div>
			<input type="submit" id="btnPass" value="提交" />
		</div>
	</form>
</body>
</html>