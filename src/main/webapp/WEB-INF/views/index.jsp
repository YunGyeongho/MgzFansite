<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/myInfo.css">
<link rel="stylesheet" href="resources/css/gallertMain.css">
<link rel="stylesheet" href="resources/css/galleryReply.css">
<link rel="stylesheet" href="resources/css/mapmap.css">
<script type="text/javascript">
function showResult(a) {
	alert(a);
}
</script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c7a0ad70bac7f50ad8163ba7c53f1d96"></script>
<script type="text/javascript" src="resources/js/move.js"></script>
<script type="text/javascript" src="resources/js/hoValidChecker.js"></script>
<script type="text/javascript" src="resources/js/joinChecker.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/mgzJQuery.js"></script>
<script type="text/javascript" src="resources/js/map.js"></script>
</head>

<c:choose>
	<c:when test="${result !=null }">
		<body onload="showResult('${result }');"> 
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>
<table id="galleryReplyBackBoard">
</table>
<div id="mgzLogo" onclick="goHome();"><img src="resources/css/img/mgzLogo.PNG"></div>

<table>
	<tr>
		<td id="loginPage">
			<jsp:include page="${loginPage }"></jsp:include>
		</td>
	</tr>
	<tr>
		<td>
			<table id="loginButton">
				<tr>
					<td align="center">
						<c:if test="${sessionScope.loginMember != null }">My</c:if> 
						<c:if test="${sessionScope.loginMember == null }">Login</c:if>
					</td>
				</tr>
			</table>	
		</td>
	</tr>
</table>
<table  id="menuMainTable">
	<tr>
		<td>
			<table id="menuLeftTable">
				<tr>
					<td align="right">
						<table>
							<tr>
								<td>
									<a href="https://www.youtube.com/channel/UC9Yh4fKJeeOtTZxdfHkW08A">YOUTUBE</a>&nbsp;&nbsp;
								</td>
								<td>
									<a href="https://opensea.io/collection/meta-toy-gamers">OPENSEE</a>&nbsp;&nbsp;
								</td>
								<td>
									<a href="https://discord.gg/N4mq65R9">DISCORD</a>&nbsp;&nbsp;
								</td>
								<td>
									<a href="http://sbxg.gg/">SBXG</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table id="menuListTable">
							<tr>
								<td align="left">
									INTRODUCE
								</td>
							</tr>
							<tr>
								<td align="left">
									<a href="dataroomMain">DATAROOM</a>
								</td>
							</tr>
							<tr>
								<td align="left">
									<a href="galleryMain?page=1">BOARD</a>
								</td>
							</tr>
							<tr>
								<td align="left">
									<a href="mapMain">MAP(JQUERY)</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
		<td rowspan="2" align="center" id="menuRightTd">
			<table id="menuRightTable">
				<tr>
					<td id="moveText">
						LET'S PARTY AND PLAY
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<div id=backBoard></div>
<table id="contentMainPage">
	<tr>
		<td>
			<c:choose>
				<c:when test="${contentPage != null }">
					<jsp:include page="${contentPage }"></jsp:include>
				</c:when>
				<c:otherwise>
					준비중입니다.
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
<div id="mainMenu">MENU</div>
<div id="menuOpen">+</div>
<div id="menuClose">-</div>
</body>
</html>