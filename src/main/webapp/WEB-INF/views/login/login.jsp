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
<form action="login" method="post" onsubmit="return loginInputCheck(this);">
	<table id="indexLoginTable">
		<tr>
			<td align="center">
				<input name="m_id" placeholder="id" autocomplete="off">
			</td>
			<td align="center">
				<input name="m_pw" placeholder="pw" autocomplete="off" type="password">
			</td>
			<td>
				<button>Login</button>
			</td>
			<td align="center">
				<div onclick="goJoin();">Join</div>
			</td>
		</tr>
	</table>
</form>
</body>
</html>