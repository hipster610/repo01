<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
<h1>jQuery</h1>
자바스크립트 프로그래밍을 쉽게 구현할수 있게 만들어둔 자바 스크립트 라이브러리
<br />
자바스크립트의 역활을 알면 쉽게 배울수 있다.
<br />
<hr />
jQuery 를 사용하기 위해선 라이브러리 연동이 필요한데,
<br />
실제로 다운을 받아서 프로젝트에 넣어두고 쓰는 방식 vs CDN(Content Delivery Network) 방식이 있음.
<br/>
브라우저에서 CDN방식으로 연동시키게 하면, 최신 jQuery가 적용되고, 대부분의 웹 어플리케이션들이
거의 CDN 연동을 해서 브라우저에 받아져있을 가능성이 큼. 로딩 시간도 줄어들고
<hr/>
jQuery 의 특징 #
document traversal and manipulation,  (돔탐색, 돔제어)
event handling, animation, (이벤트 처리, 에니메이션 효과)
and Ajax much simpler with an easy-to-use API (Ajax 처리가 단순해짐)
<hr/>
<input type="text" id="view"/>
<button id="bt">버튼</button>
<script>
	// $("p") : document.getElementsByTagName("p")  ==> jQuery용 객체 
	// $(".btn") : document.getElementsByClassName("btn")  ==> jQuery용 객체 
	// $("#view") : document.getElementById("view")  ==> jQuery용 객체 
	console.log($("#view"));	
	console.log(document.getElementById("view"));
	console.log($(document.getElementById("view")) );
	
	$("#bt").click(function(){
		window.alert("~~");
		$.ajax({
			url : "/01ajax.jsp"
		}).done(function(txt){
			$("#bt").html(txt);
		});
	});
	
	$("#view").val("아아아");
	$("#view").fadeOut(5000);
	$("#view").fadeIn(1000);
	
	//=====================================
	
	
</script>




 


