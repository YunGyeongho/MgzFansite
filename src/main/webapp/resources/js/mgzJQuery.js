function loginPageEvent(){
	$("#loginButton").mouseenter(function() {
		$("#loginButton").css("top", "-50px");
		$("#indexLoginTable").css("top", "20px");
		$("#myInfoTable").css("top", "30px");
		$("#indexLoginTable").mouseleave(function() {
			$("#indexLoginTable").css("top", "-100px");
			$("#loginButton").css("top", "20px");
		});
		$("#myInfoTable").mouseleave(function() {
			$("#myInfoTable").css("top", "-320px");
			$("#loginButton").css("top", "20px");
		});
	});
}

var mainMenuVisible = true;

function openAndCloseMainMenu() {
	$("#mainMenu").click(function() {
		if(mainMenuVisible){
			$("#menuOpen").css("transform", "rotate(720deg)").css("opacity", "0");
			$("#menuClose").css("transform", "rotate(0deg)").css("opacity", "0");
			$("#galleryReplyBackBoard").css("top", "700px");
			$("#menuMainTable").css("top", "0px");
			setTimeout(function() {
				$("#menuClose").css("opacity", "1");
			}, 500);
		} else{
			$("#menuMainTable").css("top", "-700px");
			$("#galleryReplyBackBoard").css("top", "-1080px");
			$("#menuClose").css("transform", "rotate(720deg)").css("opacity", "0");
			$("#menuOpen").css("transform", "rotate(0deg)").css("opacity", "0");
			setTimeout(function() {
				$("#menuOpen").css("opacity", "1");
			}, 500);
		}
		mainMenuVisible = !mainMenuVisible;
	});
}

function galleryReplyEvent() {
	$(".galleryReplyDiv").click(function() {
		$("#galleryReplyTable").css("top", "100px").css("left", "570px");
		$("#galleryReplyBackBoard").css("top", "0px");
		$("#galleryReplyBackBoard").click(function() {
			$("#galleryReplyTable").css("top", "-1080px").css("left", "570px");
			$("#galleryReplyBackBoard").css("top", "-1080px");
		});
	});
}

function connectGalleryColorChangeEvent() {
	$("#galleryColorInput").keyup(function () {
		var c = $(this).val();
		$(".galleryColor").css("color", c);
	});
}

function connectMemberJoinIdInputKeyEvent() {
	$("#joinIdInput").keyup(function(e) {
		var id = $(this).val();
		$.getJSON("getMembers?m_id=" + id, function(memberData) {
			if(id.length > 4 && memberData.member[0] == null){
				$("#joinIdTd").text("사용 가능한 아이디");
				$("#joinIdTd").css("color", "blue");
			} else{
				$("#joinIdTd").text("사용 불가한 아이디[중복 or 길이]");
				$("#joinIdTd").css("color", "red");
			}
		});
	});
}

function connectMemberJoinBcnoInputEvent() {
	var bcno = $("#joinBcnoInput").val();
	$("#joinBcnoInput").mousedown(function() {
		var u = "http://192.168.0.158:8976/block.get?no=" + bcno;
		$.getJSON(u, function(data){
			$("#joinBcnoInput").val(data.number);
		});
		$(this).css("font-size", "15pt");
	});
	$("#joinBcnoInput").mouseup(function() {
		$(this).val(bcno);
		$(this).css("font-size", "8pt");
		$(this).css("border", "none");
	});
	
}

function connectMemberJoinAddrInputEvent() {
	$("#joinAddr1, #joinAddr2").click(function() {
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#joinAddr1").val(data.zonecode);
	        	$("#joinAddr2").val(data.roadAddress);
	        }
	    }).open();
	});
}

$(function(){
	loginPageEvent();
	openAndCloseMainMenu();
	galleryReplyEvent();
	connectGalleryColorChangeEvent();
	connectMemberJoinIdInputKeyEvent();
	connectMemberJoinBcnoInputEvent();
	connectMemberJoinAddrInputEvent();
	connectMapEvent();
});