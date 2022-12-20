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
	<form action="updateMyInfo" method="post" onsubmit="return updateMyInfoCheck(this);" enctype="multipart/form-data">
			<table id="myInfoTable">
				<tr>
					<td colspan="2" align="center">
						<input name="m_photo" type="file"><br>
						img, png, jpg만 가능
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						사진 미선택 시 기존 이미지 등록 <br>
						<img src="resources/profilePhoto/${sessionScope.loginMember.m_photo }">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						아이디 <input name="m_id" value=${sessionScope.loginMember.m_id } readonly="readonly">
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="2">
						닉네임 <input name="m_nickname" value="${sessionScope.loginMember.m_nickname }">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						생년월일(변경 불가) <fmt:formatDate value="${sessionScope.loginMember.m_birthday }" type="date" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						주소(우편번호, 주소, 상세주소)
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input name="addr1" value="${addr1 }" placeholder="우편번호">
						<input name="addr2" value="${addr2 }" placeholder="주소">
					 	<input name="addr3" value="${addr3 }" placeholder="상세주소">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						블록체인
					</td>
				</tr>
				<tr>
					<td align="center" id="blockTd" colspan="2">
						${sessionScope.loginMember.m_block }
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						비밀번호 변경(한글 제외 특수문자는 !@#$%^만 가능)<br>
						미입력시 기존 비밀번호 등록
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input name="m_pw" type="password" value="${sessionScope.loginMember.m_pw }">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						변경 비밀번호 재확인
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input name="m_pw2" type="password" value="${sessionScope.loginMember.m_pw }">
					</td>
				</tr>
				<tr>
					<td align="center">
						<button>수정</button>
					</td>
					<td align="center">
						<div onclick="closeMyInfo();">취소</div>
					</td>
				</tr>
			</table>
	</form>
</body>
</html>