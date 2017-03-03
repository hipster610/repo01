<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h3>Q&A</h3> 
<br/>
<form align="center" action="/board/write" method="post">
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>No.</td>
			<td>category</td>
			<td>title</td>
			<td>content</td>
			<td>writer</td>
			<td>write_date</td>
			<td>viewcount</td>
			<td>hitcount</td>
		</tr>
		<c:forEach var="all" items="${all}">
			<tr style="text-align:center; height: 30px; " >
				<td>${all.NUM}</td> 
				<td>${all.CATEGORY}</td>
				<td><a href="/board/selectList?num=${all.NUM}" >${all.TITLE}</a></td>
				<td>${fn:substring(all.CONTENT, 0, 50)}</td> 
				<td>${all.WRITER}</td>
				<td>${fn:substring(all.WRITE_DATE, 0 , 19)}</td> 
				<td>${all.VIEWCOUNT}</td>
				<td>${all.HITCOUNT}</td>
			</tr>
		</c:forEach> 
	</table>
<div align="right" >Count : ${cnt } </div>
	<hr/>
	<div align="right" >
		<button type="submit" class="btn">WRITE</button>
	</div>
</form>

<!-- 페이지 뷰 -->
<div align="center" >
	<c:if test="${page ne 1 }">
		<a href="/board/list?page=${page -1 }">이전</a>
	</c:if>
	<c:forEach var="p" begin="1" end="${size }" varStatus="vs">
		<c:choose>
			<c:when test="${p eq page }">
				<b>${p }</b>
			</c:when>
			<c:otherwise>
				<a href="/board/list?page=${p }">${p }</a>
			</c:otherwise>
		</c:choose>
		<c:if test="${vs.last eq false }">|</c:if>
	</c:forEach>
	<c:if test="${page ne size }">
		<a href="/board/list?page=${page +1 }">다음</a>
	</c:if>
</div>


