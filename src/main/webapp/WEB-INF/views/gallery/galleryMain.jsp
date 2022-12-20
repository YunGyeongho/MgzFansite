<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="galleryReplyTable">
	<tr>
		<td>
			<table id="galleryReplyContentTable">
				<c:forEach var="gr" items="${gReply }">
				<tr>
					<td align="center">
						<img src="resources/profilePhoto/${gr.msr_m_photo }"><br>
						${gr.msr_writer }
					</td>
					<td align="center">
						${gr.msr_txt }
					</td>
					<td align="center">
						${gr.msr_date }
					</td>
					<td align="center">
						수정
					</td>
					<td align="center">
						삭제
					</td>
				</tr>
				</c:forEach>
				<form action="writeGalleryReply?page=${param.page }" method="post">
				<tr>
					<td colspan="4" align="center">
						<textarea name="msr_txt"></textarea>
						<input name="msr_ms_no" value="${param.no }" type="hidden">
						<input name="token" value="${token }" type="hidden">
					</td>
					<td align="center">
						<button>작성</button>
					</td>
				</tr>
				</form>
			</table>
		</td>
	</tr>
</table>
<table id="galleryMainTable">
	<tr>
		<td align="center">
		<c:choose>
			<c:when test="${uGInfo == null }">
				<form action="galleryWrite" method="post" onsubmit="return galleryCheck(this);">
			</c:when>
			<c:otherwise>
				<form action="updateGallery" method="post" onsubmit="return galleryCheck(this);">
			</c:otherwise>
		</c:choose>
				<table id="galleryInputTable">
					<tr>
						<td colspan="2" align="center" id="gIFirstTable">
							<input name="ms_title" value="${uGInfo.ms_title }" maxlength="20" autofocus="autofocus" placeholder="최대 20자">
							<input name="reWrite" value="${reWrite }" type="hidden">
						</td>
					</tr>
					<tr>
						<td align="center">
							<input name="page" value="${param.page }" type="hidden">
							<input name="no" value="${uGInfo.ms_no }" type="hidden">
							<input name="token" value="${token }" type="hidden">
							<input id="galleryColorInput" class="galleryColor" name="ms_color" value="${boardColor }" placeholder="원하는 색상 코드 입력 가능">
						</td>
					</tr>
					<tr>
						<td align="center">
							<textarea name="ms_txt" >(최대 500자) ${uGInfo.ms_txt }</textarea>
						</td>
					</tr>
					<tr>
						<td align="center">
							<button>Write</button>
						</td>
					</tr>	
				</table>
			</form>
		</td>
	</tr>
	<tr>
		<td align="center" id="searchTd">
			<form action="galleryMain">
				<input name="page" type="hidden" value="${param.page }">
				<input name="search" placeholder="제목  & 내용 검색" autocomplete="off">&nbsp;&nbsp;<button>Search</button>
			</form>
		</td>
	</tr>
	<c:forEach var="gw" items="${GalleryInfo }">
	<tr>
		<td align="center">
			<table class="galleryBoardTable">
				<tr>
					<td colspan="4" align="center" class="galleryBoardTitleTd">
						${gw.ms_title }
					</td>
				</tr>
				<tr>
					<td class="galleryBoardSecondTd" align="left" colspan="2" style="border-bottom: solid 3px ${gw.ms_color };">
						작성자 : ${gw.ms_writer }
					</td>
					<td class="galleryBoardSecondTd" align="right" colspan="2" style="border-bottom: solid 3px ${gw.ms_color };">
						<fmt:formatDate value="${gw.ms_date }" pattern="yyyy년  MM월  dd일"/>
					</td>
				</tr>
				<tr>
					<td class="galleryImgTd" colspan="1" align="center">
						<img src="resources/profilePhoto/${gw.m_photo }">
					</td>
					<td align="center" class="galleryTextTd" colspan="3">
						${gw.ms_txt }
					</td>
				</tr>
				<c:choose>
				<c:when test="${gw.ms_writer == sessionScope.loginMember.m_id  }">
				<tr>
					<td align="center">
						<div class="galleryUpdateDiv" onclick="updateGalleryBoard(${gw.ms_no }, ${param.page });">UPDATE!</div>
					</td>
					<td align="center" colspan="2">
						<div class="galleryDeleteDiv" onclick="deleteGalleryBoard(${gw.ms_no }, ${param.page });">DELETE!</div>
					</td>
					<td align="center">
						<div class="galleryReplyDiv" onclick="showGalleryReply(${gw.ms_no }, ${param.page });">Reply</div>
					</td>
				</tr>
				</c:when>
				<c:otherwise>
				<tr>
					<td align="center" colspan="4">
						<div class="galleryReplyDiv" onclick="showGalleryReply(${gw.ms_no }, ${param.page });">Reply</div>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
			</table>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td align="center">
		<c:forEach var="i" begin="1" end="${pageCount }">
			<a href="galleryMain?page=${i }&search=${search }">${i }&nbsp;&nbsp;</a>
		</c:forEach>
		</td>
	</tr>
</table>
</body>
</html>