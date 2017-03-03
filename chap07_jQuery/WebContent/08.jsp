<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 변경 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<div id="result" style="height: 150;">
</div>
<button id="go">검색!</button>
<script>
	$("#go").click(function(){
		$.ajax({
			"url" : "/08ajax.jsp",
			"method" : "post",
			"data" : {
				"q" : "query",
				"v" : "value"
			}
		}).done(function(a){
			$("#result").append("이름:"+a.name+"<br/>");
			$("#result").append("나이:"+a.age+"<br/>");
			$("#result").append("역할:"+a.role+"<br/>");
			$("#result").append("취미:"+a.hobby[0]+","+a.hobby[1] +"<br/>");
		});
	});
	// jquery ajax는 contentType에 따라서 자동으로 바뀜.
</script>