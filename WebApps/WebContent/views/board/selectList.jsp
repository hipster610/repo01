<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--<div class="row">	 12등분  -->
<c:forEach var="list" items="${list}" >
<div class="well" style="background-color: white">
	<h3>글 작성</h3>
	<br/>
	<form action="/board/updateAjax" method="post">
			<select name="category">
			  	<option value="t000" ${list.CATEGORY eq 't000'? 'selected' :''}>==선택하세요==</option>
				<option value="제품관련문의" ${list.CATEGORY eq '제품 관련 문의'? 'selected' :''}>제품 관련 문의</option>
				<option value="사이즈문의" ${list.CATEGORY eq '사이즈 문의'? 'selected' :''}>사이즈 문의</option>
				<option value="교환및반품문의" ${list.CATEGORY eq '교환 및 반품 문의'? 'selected' :''}>교환 및 반품 문의</option>
				<option value="재입고문의" ${list.CATEGORY eq '재입고 문의'? 'selected' :''}>재입고 문의</option>
				<option value="기타문의" ${list.CATEGORY eq '기타 문의'? 'selected' :''}>기타 문의</option>
			</select><br/><br/>
			
		<b>작성자</b> <input type="text" class="form-control" name="writer" value="${list.WRITER}"/>
		<b>글 제목</b> <input type="text" class="form-control" name="title" value="${list.TITLE}"/>
		<br/><br/>
		<b>글 내용</b><br/>
		<input type="text" name="content" rows="10" cols="60" name="content" class="form-control" value="${list.CONTENT}"/>
		<br/>
		<p>
			<button type="submit" class="btn">변경하기</button>
		</p>
	</form>
		<span id="hitcount"></span>
		<p>
			<button type="submit" class="btn" id="like">추천하기</button>
		</p>
</div>
</c:forEach>
<script>
	document.getElementById("like").onclick = function() {
		 var xhr = new XMLHttpRequest();
		 	var uri = "/board/like.jsp"
			xhr.open("get", uri, true);
			xhr.send();
		 	xhr.onreadystatechange = function(){
		 		if(xhr.readyState==4 && xhr.status==200){
		 			var like = xhr.responseText;
		 			console.log(like);
		 			if(txt == 'YYYYY') {
						document.getElementById("hitcount").innerHTML = 1;
					}
		 		}
		 	}
	}
</script>

    