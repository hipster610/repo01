<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div style="min-height: 10%;">
		<tiles:insertAttribute name="header"/>
	</div>
	<div>
		<tiles:insertAttribute name="nav"/>
	</div>
	<div style="min-height: 80%; margin-left: 50px; margin-right: 50px;">
	<div>
		<tiles:insertAttribute name="main"/>
	</div>
	</div>
	<div style="min-height: 10%;">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>