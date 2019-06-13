<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data</title>

</head>
<body>
	<h1>获取到超链接参数值</h1>
	<hr>
	<a href="vote/vote01?name=tom2">获取超链接的参数</a>
	
	<h1>获取到消息头</h1>
	<hr>
	<a href="vote/vote02">获取消息头信息</a>
	<hr>
	<h1>添加主人信息</h1>
	<!-- 为了让springmvc直接到master对象数据，
	要求这里的字段名称和对象的属性名保持一致,级联添加属性也是一样保持名字对应关系 -->
	<form action="vote/vote010" method="post">
		主人号:<input type="text" name="id"><br>
		主人名:<input type="text" name="masterName"><br>
		宠物名:<input type="text" name="pet.petName"><br>
		<input type="submit" value="添加宠物">
	</form>
	<br><hr>
	<a href="vote/vote04">获取主人和地址信息</a><br><hr>

	<a href="vote/vote07">点击提交参数</a>
</body>
</html>