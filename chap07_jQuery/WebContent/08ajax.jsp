<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"	 
    pageEncoding="UTF-8"%>  
<%@ page import="java.util.*"  %>
<%
	// contentType="application/json : jQuery에서 인식

	String q = request.getParameter("q");
	String v = request.getParameter("v");
	System.out.println("Q : "+q+" / V : "+v);
	Map map = new HashMap();
		map.put("name", "박성환");
		map.put("age", 19);
		map.put("role", true);
		map.put("hobby", new String[]{"독서", "공부"});
		
	ObjectMapper om = new ObjectMapper();
	String str = om.writeValueAsString(map);
	out.println(str);
%>