<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<div align="center">
	<h1>약관</h1>
	아래의 모든 약관에 동의합니다 <input type="checkbox" id="a1"/>
	<hr/>
	아래의 약관에 동의합니다.<input type="checkbox" class="sub" id="a2"/>
	<div id="eff1" style="height: 300;">
		<h2>이용약관</h2>
		asdfjpasdijfpasdifjpoasdjfiasf
		asjdfpjasdifopjasidofpjasdfop
	</div>
	<hr/>
	아래의 약관에 동의합니다.<input type="checkbox" class="sub" id="a3"/>
	<div id="eff2" style="height: 300;">
		<h2>위치정보 이용약관</h2>
		asdfjkasdjfiopasdjifopjasdiofpjiasd
		asdjfipajsdifopajsdfiopjasdfiopasd
	</div>
	<hr/>
	<button id="next" disabled>다음
	</button>
</div>
<script>
	$("#a1").on("click", function(){
		$(".sub").each(function(){
			$(this).prop("checked", $("#a1").prop("checked"));
		})		
		if(($(this).prop("checked")) == true){
			$("#eff1").slideUp(1000);
		}else{
			$("#eff1").slideDown(1000);
		}
		enableCheck();
	});
	$("#a2").click(function() {
		enableCheck();
	});
	
	$("#a3").click(enableCheck);
		
	function enableCheck() {
		var cnt=0;
		$(".sub").each(function(){
			if($(this).prop("checked"))
				cnt++;
		});
		if(cnt==2) {
			$("#a1").prop("checked", true);
			$("#next").prop("disabled", false);
		}else {
			$("#a1").prop("checked", false);
			$("#next").prop("disabled", true);
		}
	}
	
</script>