<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
 <nav class="navbar navbar-default" style="background-color:white">
  <div class="container-fluid" style="color:black">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">HOME</a>
    </div>

    <c:choose>
		<c:when test="${sessionScope.auth eq null}">
		    <ul class="nav navbar-nav navbar-right">
		      <li><a href="/join/step01"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="/login/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    </ul>
	    </c:when>
		<c:otherwise>
		    <ul class="nav navbar-nav">
		      <li><a href="/info/info"><b>${auth_id}_INFO</b></a></li>
		      <li><a href="javascript:openChat()">CHAT</a></li>
		      <li><a href="/board/list">Q&A</a></li>
		      <li><a href="/share/list">DOWNLOAD</a></li>
		      <li><a href="/memberInfo/info">MEMBER INFO</a></li>
		      <li><a href="/login/logout">LOG OUT</a></li>
		    </ul>
		</c:otherwise>
	</c:choose>
  </div>
</nav>
	<script>
		function openChat(){
			window.open("/views/chat/main.jsp","openChat","width=400, height=500, left=600, top=150")
		}
	</script>
</body>


