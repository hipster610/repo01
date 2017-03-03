<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<h3>INFO</h3>
</div>
<div class="well row" style="background-color: white">	<!-- 12등분  -->
	<div class="col-md-3" align="center" style="background-color: white">
		<form action="/info/pictureAjax.jsp" method="post" enctype="multipart/form-data">
				<b>PICTURE</b><br />
				
				<img src="${val.URL}" width="200" height="200"/>
				<hr/>
				<input type="file" class="form-control"	name="pic" />
				<br/>
				<button type="submit" class="btn">사진변경</button>
		</form>
	</div>
	<div class="col-md-9" style="background-color: white">
		<form action="/info/infoAjax.jsp" method="post">
		<p>
			<b>NAME</b><br/>
			<input type="text" class="form-control" name="name" value="${val.NAME}"/>
		</p>
		<p>
			<b>AGE</b><br/>
			<select class="form-control" name="age" >

			</select>
		</p>
		<p>
			<b>GENDER</b><br/>
			<select name="gender" class="form-control">
				<option value="male" ${val.GENDER eq 'male' ? 'selected' : ''}>남</option>
				<option value="female" ${val.GENDER eq 'female' ? 'selected' : ''}>여</option>
			</select> 
		</p>
		<p>
			<b>E-MAIL</b><br/>
			<input type="email" class="form-control" name="email" value="${val.EMAIL} }"/>
		</p>
		<br/>
		<p>
			<button type="submit" class="btn">변경하기</button>
			<a href="/info/infoAjax.jsp"><button type="button" class="btn">탈퇴하기</button></a>
		</p>
	</form>
	</div>
</div>



    