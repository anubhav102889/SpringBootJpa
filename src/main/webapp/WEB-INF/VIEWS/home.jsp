<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/home.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.2/css/ui.jqgrid.min.css"/>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/grid.locale-en.js" type="text/javascript"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home.js"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>home</h4>
<div id="grid">
	<table id="homegrid"></table>
	<div id="navgrid"><div id="#pager"></div></div>
</div>
</body>
</html>