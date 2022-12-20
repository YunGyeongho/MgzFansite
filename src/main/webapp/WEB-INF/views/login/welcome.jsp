<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/login2.css">
</head>
<body>
<table id="indexLoginTable">
	<tr>
		<td align="center">
			<img src="resources/profilePhoto/${sessionScope.loginMember.m_photo }">
		</td>
		<td align="center">
			${sessionScope.loginMember.m_nickname }(${sessionScope.loginMember.m_id })님<br>
			환영합니다.
		</td>
		<td align="center">
			<div onclick="goMyInfo();">MyInfo</div>
		</td>
		<td align="center">
			<div onclick="goLogout();">Logout</div>
		</td>
	</tr>
</table>
</body>
</html>