<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type='text/javascript' src='<%=path%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/util.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/interface/jCategory.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/interface/jNews.js'></script>
		<script type='text/javascript' src='scripts/categoryLogic.js'></script>
	</head>

	<body onload="display()">
		<table id="c" border="1" algin="center"></table>
		<form action="#">
		title:<input type="text" id="title" name="title" value="" /><br/>
		content:<input type="text" id="content" name="content" value="" /><br/>
		<input type="button"  name="submit" value="add" onclick="addNews()"/>
		</form>
	</body>
</html>
