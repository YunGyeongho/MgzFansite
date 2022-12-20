<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/dataroomMain.css">
</head>
<body>
<table>
	<tr>
		<td>
			<div class="data">
			<table>
				<tr>
					<th>
						A
					</th>
				</tr>
				<c:forEach var="dA" items="${ddA }">
				<tr>
					<td align="center">
						${dA.md_title }
					</td>
				</tr>
				<tr>
					<td align="center">
						작성자 : ${dA.md_uploader }&nbsp;&nbsp;&nbsp;&nbsp;
						<fmt:formatDate value="${dA.md_date }" pattern="yyyy년  MM월  dd일"/> 
					</td>
				</tr>
				<tr>
					<td align="center" class="dRLastTd">
						<a href="dataroom.download?md_no=${dA.md_no }">
						<img src="resources/css/img/fileImg.png">
						</a><br>
						${dA.md_fileName }
					</td>
				</tr>
				<c:if test="${dA.md_uploader == sessionScope.loginMember.m_id }">
				<tr>
					<td>
						<a href="dataroom.delete?md_no=${dA.md_no }">삭제</a>
					</td>
				</tr>
				</c:if>
				</c:forEach>
			</table>
			</div>
		</td>
		<td>
			<div class="data">
			<table>
				<tr>
					<th>
						B
					</th>
				</tr>
				<c:forEach var="dB" items="${ddB }">
				<tr>
					<td align="center">
						${dB.md_title }
					</td>
				</tr>
				<tr>
					<td align="center">
						작성자 : ${dB.md_uploader }&nbsp;&nbsp;&nbsp;&nbsp;
						<fmt:formatDate value="${dB.md_date }" pattern="yyyy년  MM월  dd일"/>
					</td>
				</tr>
				<tr>
					<td align="center" class="dRLastTd">
						<a href="dataroom.download?md_no=${dB.md_no }">
						<img src="resources/css/img/fileImg.png">
						</a><br>
						${dB.md_fileName }
					</td>
				</tr>
				<c:if test="${dB.md_uploader == sessionScope.loginMember.m_id }">
				<tr>
					<td>
						<a href="dataroom.delete?md_no=${dB.md_no }">삭제</a>
					</td>
				</tr>
				</c:if>		
				</c:forEach>		
			</table>
			</div>
		</td>
		<td>
			<div class="data">
			<table>
				<tr>
					<th>
						C
					</th>
				</tr>
				<c:forEach var="dC" items="${ddC }">
				<tr>
					<td align="center">
						${dC.md_title }
					</td>
				</tr>
				<tr>
					<td align="center">
						작성자 : ${dC.md_uploader }&nbsp;&nbsp;&nbsp;&nbsp;
						<fmt:formatDate value="${dC.md_date }" pattern="yyyy년  MM월  dd일"/>
					</td>
				</tr>
				<tr>
					<td align="center" class="dRLastTd">
						<a href="dataroom.download?md_no=${dC.md_no }">
						<img src="resources/css/img/fileImg.png">
						</a><br>
						${dC.md_fileName }
					</td>
				</tr>
				<c:if test="${dC.md_uploader == sessionScope.loginMember.m_id }">
				<tr>
					<td>
						<a href="dataroom.delete?md_no=${dC.md_no }">삭제</a>
					</td>
				</tr>
				</c:if>		
				</c:forEach>		
			</table>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="3" align="center">
			<form action="uploadData" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>
							<input name="md_title" placeholder="자료이름 최대 20자">
							<input name="token" type="hidden" value="${token }">
						</td>
						<td>
							<select name="md_category">
								<option>a</option>
								<option>b</option>
								<option>c</option>
							</select>
						</td>
						<td>
							<input name="md_file" type="file">
						</td>
						<td>
							<button>Upload</button>
						</td>
					</tr>
				</table>		
			</form>
		</td>
	</tr>
</table>
		
</body>
</html>