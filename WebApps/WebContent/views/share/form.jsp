<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>자료 등록</h2>
<hr />
<div class="well" style="background-color:white">
	<form action="/share/proc" method="post" enctype="multipart/form-data" style="background-color:white">
		파일 : <input type="file" name="item" class="" /><br /> 
		설명 : <input type="text" name="info" class="form-control" />
		<button type="submit" style="width: 100px; background-color: silver;"
			class="form-control">등록</button>
	</form> 
</div>