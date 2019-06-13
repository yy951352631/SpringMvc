<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录页面</h1>
	<form action="user/login" method="post">
	u:<input type="text" name="username"><br>
	p:<input type="password" name="password"><br>
	<input type="submit" value="登录">
	</form>
	<br><h1>购买商品</h1>
	<form action="user/buy" method="post">
	u:<input type="text" name="username"><br>
	p:<input type="password" name="password"><br>
	<input type="submit" value="购买">
	</form>
	
	<hr><h1>演示params的使用</h1>
	<a href="user/test?bookid=100">查询一本书1</a>
	<a href="user/test?book=200">查询一本书1</a>
	
	<hr><h1>演示Ant风格的请求资源方式 </h1>
	<a href="user/message/aa">发送消息1</a><br>
	<a href="user/message/bb/cc/dd">发送消息2</a><br>
	
	<hr><h1>占位符的演示</h1>
	<a href="user/reg/zhangsan/300">占位符的演示</a>
</body>
</html>