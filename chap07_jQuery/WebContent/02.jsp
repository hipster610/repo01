<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<h2>jQuery DOM Traversing</h2>
-태그$("태그명")나, 클래스이름$(".클래스명"), 아이디명$("#아이디명")로 접근 가능
<br/>
<c:forTokens var="tk" items="가위,바위,보" delims=",">
	<button>${tk }</button>
</c:forTokens>
<hr/>
<!-- 
	태그명이나.. 클래스이름으로 서칭이 되면.. 여러개가 나옴. each 랑 연동이 됨.
 -->
<c:forEach var="i" begin="1" end="10">
	<input type="checkbox" class="chk"/>목록 .${i }<br/>
</c:forEach>
<input type="text" readonly value="아무말이나" id="t"/>
<hr/>
<button id="bt">클릭</button>
<script>
	$("button").each(function(){
		console.log(this);
		// this.innerHTML = "안녕";
		// $(this).html("음..");
		console.log($(this).html());
		this.disabled = true;		// $(this).disabled = true; (X)
		// $(this).prop("disabled", true);
	});
	$(".chk").each(function() {
		// this.checked= true;
		console.log($(this).prop("checked"));	// true를 안넣으면 true, false 확인
		$(this).prop("checked", true);			// true를 넣으면 실제 변경
	});
	$("#bt").prop("disabled", false);
	$("#bt").click(function(){
		$(".chk").each(function() {
			// 	if(($(this).prop("checked")) == false){
			// 		$(this).prop("checked", true);		
			// 	}else{
			// 		$(this).prop("checked", false);
			// 	}
			$(this).prop("checked", !$(this).prop("checked"));
		});
	});
	// $("#t").prop("readonly", false);		
	$(document.getElementById("t") ).prop("readonly", false);
	// prop 으로 제어되는 효과는 .. [checked, disabled, selected, readonly]
	
</script>








