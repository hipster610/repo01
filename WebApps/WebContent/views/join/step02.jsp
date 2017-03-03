<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div align="center" class="well" style="background-color: white">
	<h3>STEP 02. 추가정보 입력</h3>
	<form action="/join/check" method="post" style="background-color:white">
		<p>
			<b>NAME</b><br/>
			<input type="text" class="form-control" name="name"/>
		</p>
		<p>
			<b>AGE</b><br/>
			<select class="form-control" name="age">
				<%for(int i=19; i<=80; i++){ %>
					<option value="<%=i%>"><%=i %>세</option>
				<%} %>
			</select>
		</p>
		<p>
			<b>GENDER</b><br/>
			<select class="form-control" name="gender">
				<option value="male">남</option>
				<option value="female">여</option>
			</select> 
		</p>
		<p>
			<b>E-MAIL</b><br/>
			<input type="email" class="form-control" name="email"/>
		</p>
		<p>
			<button type="submit" class="btn">등록하기</button>
		</p>
	</form>
</div>
