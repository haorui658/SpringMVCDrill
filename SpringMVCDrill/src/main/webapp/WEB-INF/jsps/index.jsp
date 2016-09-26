<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页标题</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.12.1.min.js"></script>
<script type="text/javascript" >
$(document).ready(function(){
$("#test").click(function(){
	$("#test").text("我是一个按钮！")
	return false;
});
})
</script>
</head>
<body>
<button id="test">test</button>
<h1>普通的request带参数</h1>
<a href="/hello/Request?id=123">测试</a>
<h1>测试path变量参数</h1>
<a href="/hello/Path/456">测试</a>
<h1>测试ModelAndView</h1>
<a href="/hello/TestModelAndView/456">测试</a>
<h1>测试requestScope中获取Map</h1>
<a href="/hello/TestMap">测试</a>
<h1>测试传统方式servlet</h1>
<a href="/hello/Traditional?id=123">测试</a>
<h1>测试提交表单ModelAttribute获取对象及多级跳转和必加参数</h1>
<a href="/hello/admin?add">测试</a>
</body>
</html>