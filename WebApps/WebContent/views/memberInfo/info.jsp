<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<form aiign="center">
	<div align="center"><h3>회원 통계</h3><br/>	 </div>
		<div class="col-md-8" align="right" id="3dView" style="width: 750px; height: 400px; margin: 0 auto"></div>
			<script type="text/javascript">
		   		google.charts.load('current', {packages: ['corechart']});     

					function drawChart() {
					   var data = new google.visualization.DataTable();
					   data.addColumn('string', 'Age');
					   data.addColumn('number', 'Count');
				       data.addRows([
				        	<c:forEach var="obj" items="${ageList }" varStatus="status">
					        	[ 
					        		'${obj.AGE_GROUP}', ${obj.COUNT}
					        	]<c:if test="${status.last == false }">,</c:if>
				      		</c:forEach>
				      		]
				        );
					   var options = {
							   'title':'회원분석(연령)',
						  	   'width':750,
						       'height':400,
						       is3D:true
					   };
					   var chart = new google.visualization.PieChart(document.getElementById("3dView"));
					   chart.draw(data, options);
					}
					google.charts.setOnLoadCallback(drawChart);
			</script>
			
		<div class="col-md-8" align="left" id="columnchart_material" style="width: 700px; height: 400px; margin: 0 auto"></div>
			<script type="text/javascript">
 			  google.charts.load('current', {packages: ['corechart']});     
			</script>
		   <script>   
		   google.charts.setOnLoadCallback(drawChart2);
		      function drawChart2() {
		    var data = new google.visualization.DataTable();
				       data.addColumn('string', '성별');
				       data.addColumn('number', '회원수');
		         data.addRows([  
			        	<c:forEach var="obj" items="${genderList }" varStatus="status">
			        	[ 
			        		'${obj.GENDER}', ${obj.COUNT}
			   	     	]<c:if test="${status.last == false }">,</c:if>
			  			</c:forEach>
		           ]);
		          var chart = new google.visualization.BarChart(
		                   document.getElementById('columnchart_material'));
		          chart.draw(data,
		             {width: 700, height: 400, title: '회원 분석(성별)', backgroundColor: 'transparent'}); 
		             
		      }  
		      </script>   
</form>
<form align="center" action="/board/write" method="post">
<div class="col-md-12">
<h3>가입자 연령대</h3> 
<br/>
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>age</td>
			<td>count</td>
		</tr>
		<c:forEach var="all" items="${ageList}">
			<tr style="text-align:center; height: 30px; " >
				<td>${all.AGE_GROUP}대</td>
				<td>${all.COUNT}</td> 
			</tr>
		</c:forEach> 
	</table>
<h3>가입자 성별 빈도</h3> 
<br/>
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>gender</td>
			<td>count</td>
		</tr>
		<c:forEach var="all" items="${genderList}">
			<tr style="text-align:center; height: 30px; " >
				<td>${all.GENDER}</td>
				<td>${all.COUNT}</td> 
			</tr>
		</c:forEach> 
	</table>
<h3>연령대별 로그인 회수</h3> 
<br/>
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>age</td>
			<td>count</td>
		</tr>
		<c:forEach var="all" items="${ageLogin}">
			<tr style="text-align:center; height: 30px; " >
				<td>${all.AGE}대</td>
				<td>${all.COUNT}</td> 
			</tr>
		</c:forEach> 
	</table>
<h3>성별 로그인 회수</h3> 
<br/>
	<table width="100%">
		<tr style="text-align:center; height: 30px; " >
			<td>gender</td>
			<td>count</td>
		</tr>
		<c:forEach var="all" items="${genderLogin}">
			<tr style="text-align:center; height: 30px; " >
				<td>${all.GENDER}</td>
				<td>${all.COUNT}</td> 
			</tr>
		</c:forEach> 
	</table>
</div>
</form>
<br/><br/>
<%-- ${obj.GENDER eq null ? '-' : obj.GENDER } (${obj.CNT }) --%>
