<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	
	$(function(){
		//绑定delBook的click事件
		$("#delBook").click(function(){
			//获取到点击删除的超链接 
			var url = this.href;
			//给 隐藏表单的 action 赋值  url
			$("#hiddenForm").attr("action",url);
			//给隐藏表单的 hidden的值赋值 DELETE
			$(":hidden").val("DELETE");
			//提交表单
			$("#hiddenForm").submit();
			//必须返回false
			return false;
		})
	})
	
</script>
</head>
<body>
	<h1>Rest风格的crud操作案例</h1>
	<br>
	<hr><h1>查询书籍[get]</h1>
	<a href="user/book/100">点击查询书籍</a>
	
	<br>
	<hr><h1>添加书籍[post]</h1>
	<form action="user/book" method="post">
	name:<input name="bookname" type="text"><br>
	<input type="submit" value="添加书籍">
	</form>
	
	<br>
	<hr><h1>删除书籍[delete]</h1>
	<a href="user/book/200" id="delBook">删除书籍</a>
	
	
	<!-- 为了配合将get转成delete请求，需要加一个隐藏的表单 
		 name="_method" 名字写成 _method 
	-->
	<form action="" method="post" id="hiddenForm">
		<input type="hidden" name="_method">
	</form>
	
	<br>
	<hr><h1>修改书籍[put]</h1>
	<form action="user/book" method="post">
		id:<input type="text" name="id"><br>
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="修改书籍">
	</form>
	
</body>
</html>