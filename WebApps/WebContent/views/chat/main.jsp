<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>CHAT - Wep Apps</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="well" id="result" style="height: 80%; overflow: auto; background-color: white"></div>
	<div class="row">
		<input type="text" class="form-control" id="msg" placeholder="남길내용" />
	</div>
</body>
</html>

<script>
	document.getElementById("msg").onkeyup=function(e) {
		if(e.key=='Enter') {
			var xhr = new XMLHttpRequest();
				
				xhr.open("get", "/chat/chatAjax?msg="+this.value,true);
				xhr.send();
			this.value ="";
		}
	}
	
	function getChatLog() {
		var xhr =new XMLHttpRequest();
			xhr.open("get", "/chat/logAjax", true);
			xhr.send();
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4&&xhr.status==200) {
					var obj = JSON.parse(xhr.responseText);
					var html = "";
					for(var i=0; i<obj.length; i++) {
						html += "<b>["+obj[i].id+"]</b> ";
						html += obj[i].msg+"<br/>";
					}
					document.getElementById("result").innerHTML = html;
					document.getElementById("result").scrollTop = document.getElementById("result").scrollHeight;
				}
			}
	}
	setInterval(getChatLog, 200 );
	
</script>