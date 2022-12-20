<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="margin-left: auto; margin-right: auto;" id="mainTable">
		<tr>
			<td align="center">
				<input id="locationInput" placeholder="지역 입력">
			</td>
			<td align="center">
				<input id="kewordInput" placeholder="키워드 입력">
			</td>
		</tr>	
		<tr>
			<td align="center">
				<div id="map" style="width:500px;height:400px;"></div>
			</td>
			<td align="center">
				<div id="rv" style="width:500px; height:400px;"></div>
			</td>
		</tr>	
		<tr>
			<td colspan="2" align="center">
				<div id="scrollDiv">
					<table id="shopInfoTable">
					</table>
				</div>
			</td>
		</tr>	
	</table>
</body>
</html>