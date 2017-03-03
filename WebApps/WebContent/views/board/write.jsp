<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>글 작성</h3>
<br/>
<form action="/board/writeAjax" method="post">
	<select name="category">
		<c:forTokens items="제품 관련 문의, 사이즈 문의, 교환 및 반품 문의, 재입고 문의, 기타 문의" delims=",." var="t">
			<option>${t}</option>
		</c:forTokens>
	</select><br/><br/>
작성자 <input type="text" class="form-control" name="writer"/>
글 제목 <input type="text" class="form-control" name="title"/>
<br/>
글 내용
<textarea name="content" rows="10" cols="60" name="" class="form-control" ></textarea>
<br/>
	<div align="right" >
		<button type="submit" class="btn">등록</button>
	</div>
</form>