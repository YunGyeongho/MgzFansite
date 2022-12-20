<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/chating.css">
<script type="text/javascript" src="http://sdgn-djvemfu.tplinkdns.com:9999/socket.io/socket.io.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
$(function() {
	var socket = io.connect("http://sdgn-djvemfu.tplinkdns.com:9999");
	$("#chatInput").keyup(function(e) {
		if(e.keyCode == 13){
			var txt = $(this).val();
			socket.emit("myData", txt);
			$(this).val("");
		}
	});
	socket.on("yourData", function(vasd) {
		var td = $("<td></td>").text(vasd).attr("class", "chatTd");
		var tr = $("<tr></tr>").append(td);
		$("#chatTable").append(tr);
	})
});
</script>
</head>
<body>
<table id="phoneCover"></table>
	<div id="phoneMain">
		<div id="chatDiv">
			<table id="chatTable">
				<tr>
					<td class="chatTd">
						와우와우
					</td>
				</tr>
			</table>
		</div>
		<div id="inputDiv">
			<input id="chatInput">
			<input type="hidden" value="${sessionScope.loginMember.m_id }">
		</div>
		<div id="typingDiv">
			<img src="resources/css/typing.PNG">
		</div>
	</div>		
</body>
</html>