<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/hoValidChecker.js"></script>
<script type="text/javascript" src="resources/js/joinChecker.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/mgzJQuery.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body id="joinBody">
<h1 id="joinH1">WELCOME TO JOIN</h1>
<form action="welcome" method="post" name="joinF" onsubmit="return joinCheck();" enctype="multipart/form-data">
		<table id="joinTable">
			<tr>
				<td align="center" colspan="3" class="generalInput">
					<input name="m_photo" type="file">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					프로필 사진(img, jpg, png만 가능)
				</td>
			</tr>
			<tr >
				<td colspan="3" id="joinIdTd">
					아이디(최소 5자)
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3" class="generalInput">
					<input name="m_id" autocomplete="off" maxlength="15" autofocus="autofocus" placeholder="한글, 특수문자 제외" id="joinIdInput">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					비밀번호
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3" class="generalInput"> 
					<input name="m_pw" type="password" autocomplete="off" maxlength="15" placeholder="한글 제외 특수문자는 !@#$%^만 가능">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					비밀번호 재확인
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3" class="generalInput">
					<input name="pw2" type="password" autocomplete="off" maxlength="15">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					닉네임
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3" class="generalInput">
					<input name="m_nickname" autocomplete="off" maxlength="10">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					생년월일
				</td>
			</tr>
			<tr>
				<td align="center">
					<select name="y">
						<c:forEach var="yy" begin="${curYear - 60 }" end="${curYear }">
							<option>${yy }</option>
						</c:forEach>
					</select>년
				</td>
				<td align="center">
					<select name="m">
						<c:forEach var="mm" begin="1" end="12">
							<option>${mm }</option>
						</c:forEach>
					</select>월
				</td>
				<td align="center">
					<select name="d">
						<c:forEach var="dd" begin="1" end="31">
							<option>${dd }</option>
						</c:forEach>
					</select>일
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Block
				</td>
			</tr> 
			<tr>
				<td align="center" colspan="3" class="generalInput">
					<input style="border:red solid 3px; cursor:pointer; font-size:8pt;" id="joinBcnoInput" name="m_block" readonly="readonly" value=${latestBlockHash } autocomplete="off">
				</td>
			</tr>
			<tr>
				<td colspan="3">
					주소
				</td>
			</tr>
			<tr>
				<td align="center" class="addrInput" colspan="3">
					<input name="addr1" autocomplete="off" placeholder="우편번호" id="joinAddr1" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="center" class="addrInput" colspan="3">
					<input name="addr2" autocomplete="off" placeholder="주소" id="joinAddr2" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td align="center" class="addrInput" colspan="3">
					<input name="addr3" autocomplete="off" placeholder="상세주소">
				</td>
			</tr>
		</table>
			<button>JOIN</button>
	</form>
</body>
</html>