<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h3>Q&A</h3> 
<br/>
<form align="center" action="/share/form" method="post">
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>No.</td>
			<td>title</td>
			<td>file name</td>
			<td>down count</td>
		</tr>
	<c:forEach var="list" items="${list}">
		<tr style="text-align:center; height: 30px; " >
			<td>${list.NUM}</td> 
			<td>${list.TITLE}</td>
			<td><a href="/share/down?num=${list.NUM}" >${list.FILENAME}</a> (<fmt:formatNumber value="${list.FILESIZE/1024 }" pattern="#,###.0" />KB)</td> 
			<td>${list.COUNT}</td>
		</tr>
	</c:forEach>
	</table>
<hr/>
<div align="right" >
	<button type="submit" class="btn">WRITE</button>
</div>
</form>

