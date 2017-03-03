<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<br/>
<br/>

<div align="center" class="well" style="background-color: white">
	<h3>MEMBERSHIP LOGIN</h3>
	<form action="/login/idchecker" method="post">
		<p>
			<b>ID</b><br/>
			<input type="text" class="form-control" name="id"/>
		</p>
		<p>
			<b>PASS</b><br/>

			<input type="password" class="form-control" name="pass"/>
		</p>
		<p>
			<input type="checkbox" name="keep" />로그인 유지&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn">로그인</button>
		</p>
	</form>
	<form align="center" action="/join/step01" method="post">
		회원가입 하시면 더 많은 혜택이 준비되어 있습니다.
		<button type="submit" class="btn">JOIN US</button>
	</form>
</div>

		

