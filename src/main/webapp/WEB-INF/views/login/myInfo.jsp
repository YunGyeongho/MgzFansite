<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="myInfoTable">
	<tr>
		<td>
			<table id="myInfoTopTable">
				<tr>
					<td align="center">
						${sessionScope.loginMember.m_nickname }(${sessionScope.loginMember.m_id })님의 정보
					</td>
				</tr>
				<tr>
					<td align="center">
						<img src="resources/profilePhoto/${sessionScope.loginMember.m_photo }">
					</td>
				</tr>
				<tr>
					<td>
						생년월일
					</td>
				</tr>
				<tr>
					<td align="center">
						<fmt:formatDate value="${sessionScope.loginMember.m_birthday }" type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td>
						주소
					</td>
				</tr>
				<tr>
					<td align="center">
						${addr }
					</td>
				</tr>
				<tr>
					<td>
						블록체인
					</td>
				</tr>
				<tr>
					<td align="center" id="blockTd">
						${sessionScope.loginMember.m_block }
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center">
			<table id="myInfoBottomTable">
				<tr>
					<td align="center">
						<div onclick="goUpdateMyInfo();">수정</div>
					</td>
					<td align="center">
						<div onclick="closeMyInfo();">닫기</div>
					</td>
					<td align="center">
						<div onclick="deleteAcount();">회원탈퇴</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>