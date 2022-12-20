function goHome() {
	location.href= "index";
}

function goJoin() {
	location.href= "join";
}

function goMyInfo() {
	if(confirm("내 정보 조회시 홈 화면으로 이동됩니다.")){
		location.href="myInfo";
	}
}

function goLogout() {
	location.href="logout";
}

function closeMyInfo() {
	location.href="closeMyInfo";
}

function deleteAcount() {
	
	var a = prompt("정말 탈퇴를 원하신다면 탈퇴하겠습니다를 입력해주세요.");
	if(a == "탈퇴하겠습니다"){
		location.href="deleteAcount";
	} else{
		alert("잘못 입력 하셨습니다.");
	}
}

function goUpdateMyInfo() {
	location.href="goUpdateMyInfo";
}

function updateGalleryBoard(no, page) {
	location.href="showUpdateGalleryInfo?no=" + no + "&page=" + page;
}

function deleteGalleryBoard(no, page) {
	location.href="galleryDelete?no=" + no + "&page=" + page;
}

function showGalleryReply(no, page) {
	location.href="showGalleryReply?no=" + no + "&page=" + page;
}