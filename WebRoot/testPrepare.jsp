<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>测试prepare的使用</h1>
	<a href="vote/vote08">请求updateMessage</a>
	<br><br>
	<a href="vote/vote01">请求方法test01</a>
	
	<h1>修改Person的信息</h1>
	<!-- 
		当我们需要修改某个javabean信息时,需要保证表单的字段名字
		和javaben的属性名保持一致.
	 -->
	<form action="person/update" method="post">
		<!-- 为了让handler获取到id,将id值放入隐藏域 -->
		<input type="hidden" name="id" value="100"><br>
		<!-- 指定我们的请求方式，让HiddenHttpMethodFilter转换 -->
		<input type="hidden" name="_method" value="PUT">
		编号:<input type="text" disabled="disabled" name="id" value="100"><br>
		名字:<input type="text" name="name" value="jerry"><br>
		<input type="submit" value="点击修改" />
	</form>
	
</body>
</html>