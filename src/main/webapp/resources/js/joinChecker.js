function joinCheck(){
	var photo = document.joinF.m_photo;
	var id = document.joinF.m_id;
	var pw = document.joinF.m_pw;
	var pw2 = document.joinF.pw2;
	var nickname = document.joinF.m_nickname;
	var addr1 = document.joinF.addr1;
	var addr2 = document.joinF.addr2;
	var addr3 = document.joinF.addr3;
	
	
	
	if(reqCk(photo) || (fileType(photo, "img") && fileType(photo, "png") && fileType(photo, "jpg"))){
		alert("파일 유형을 확인해주세요.");
		photo.value = "";
		photo.focus();
		
		return false;
	}
	
	if(reqCk(id) || korCk(id) || $("#joinIdTd").css("color") == "rgb(255, 0, 0)"){
		alert("아이디를 정확히 입력해주세요.");
		id.value = "";
		id.focus();
		
		return false;
	}
	
	var pattern = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^";
	if(reqCk(pw) || pwPattern(pw, pattern)){
		alert("비밀번호를 정확히 입력해주세요.");
		pw.value = "";
		pw2.value = "";
		pw.focus();
		
		return false;
	}
	
	if(pwCrossCk(pw, pw2)){
		alert("비밀번호가 일치하지 않습니다.");
		pw.value = "";
		pw2.value = "";
		pw.focus();
		
		return false;
	}
	
	if(reqCk(nickname)){
		alert("닉네을 입력해주세요.");
		nickname.value="";
		nickname.focus();
		
		return false;	
	}
	
	if($("#joinBcnoInput").css("border") == "3px solid rgb(255, 0, 0)"){
		alert("블록체인 번호를 확인 해주세요");
		
		return false;
	}
	
	if(reqCk(addr1) || reqCk(addr2) || reqCk(addr3)){
		alert("주소를 정확히 입력해주세요.");
		addr1.value="";
		addr2.value="";
		addr3.value="";
		addr1.focus="";
		
		return false;
	}
	
	
	return true;
}

function loginInputCheck(f){
	var id = f.m_id;
	var pw = f.m_pw;
	
	if(reqCk(id)) {
		alert("id를 입력해주세요");
		id.value="";
		id.focus();
		
		return false;
	}
	
	if(reqCk(pw)) {
		alert("pw를 입력해주세요");
		pw.value="";
		pw.focus();
		
		return false;
	}
	
	return true;
}

function updateMyInfoCheck(f) {
	var photo = f.m_photo;
	var id = f.m_id;
	var nickname = f.m_nickname;
	var addr1 = f.addr1;
	var addr2 = f.addr2;
	var addr3 = f.addr3;
	var pw = f.m_pw;
	var pw2 = f.m_pw2;
	
	if(!reqCk(photo) && fileType(photo, "img") && fileType(photo, "png") && fileType(photo, "jpg")){
		alert("파일 유형을 확인해주세요.");
		photo.value = "";
		photo.focus();
			
		return false;
	}
	
	if(reqCk(id) || korCk(id)){
		alert("아이디를 정확히 입력해주세요.");
		id.value = "";
		id.focus();
		
		return false;
	}
	
	if(reqCk(nickname)){
		alert("닉네을 입력해주세요.");
		nickname.value="";
		nickname.focus();
		
		return false;	
	}
	
	if(reqCk(addr1) || reqCk(addr2) || reqCk(addr3)){
		alert("주소를 정확히 입력해주세요.");
		addr1.value="";
		addr2.value="";
		addr3.value="";
		addr1.focus="";
		
		return false;
	}
	
	var pattern = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^";
	if(reqCk(pw) || pwPattern(pw, pattern)){
		alert("비밀번호를 정확히 입력해주세요.");
		pw.value = "";
		pw2.value = "";
		pw.focus();
		
		return false;
	}
	
	if(pwCrossCk(pw, pw2)){
		alert("비밀번호가 일치하지 않습니다.");
		pw.value = "";
		pw2.value = "";
		pw.focus();
		
		return false;
	}
	
	return true;
}

function galleryCheck(f) {
	var title = f.ms_title;
	var txt = f.ms_txt;
	
	if(reqCk(title)){
		alert("제목을 입력해주세요");
		title.focus();
		
		return false;
	}
	
	if(reqCk(txt)){
		alert("내용을 입력해주세요");
		txt.focus();
		
		return false;
	}
	
	return true;
}