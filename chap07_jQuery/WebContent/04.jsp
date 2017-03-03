<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<h3>append / prepend (vs HTML)</h3>
<div id="result" >
	글씨를 적어두자.
</div>
<c:forEach var="i" begin="1" end="5">
	<button id="bt_${i }">${i }번버튼</button>
</c:forEach>
<script>
	$("#bt_4").click(function(){
		$("#result").css("color", "red");	
	});
	$("#bt_5").click(function(){
		console.log($("#result").css("font-size"));
		$("#result").css({"background": "gray", "text-align":"center" });
	});
	$("#bt_1").click(function(){
		// $("#result").html($("#result").html()+ ???);
		$("#result").append("<b>어펜드!!</b><br/>");	
	});
	$("#bt_2").click(function(){
		// $("#result").html( ??? ++ $("#result").html() );
		$("#result").prepend("<b>프리펜드!!</b><br/>");
	});
	$("#bt_3").click(function(){
		$("#result").html("<b>에이치티엠엘</b><br/>");
	});
</script>
