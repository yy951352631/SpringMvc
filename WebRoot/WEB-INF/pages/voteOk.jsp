<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>获取的的数据显示页面 voteok!</h1>
	<hr>取出 request域的数据
	<br>
	address: ${address}<br>
	主人名字 ${requestScope.master.masterName }<br>
	主人信息 ${requestScope.master }
	<br>
	主人名字[session] ${sessionScope.myMaster.masterName }
	主人信息[session] ${sessionScope.myMaster }
	
	<br>
	主人名字2[session] ${sessionScope.myMaster2.masterName }
	主人信息2[session] ${sessionScope.myMaster2 }
</body>
</html>