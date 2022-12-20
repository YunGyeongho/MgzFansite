
var rc = new kakao.maps.RoadviewClient();
var map = null;
var rv = null;
var marker = null;
		
function showMapAndRv(lng, lat) {
	var there = new kakao.maps.LatLng(lat, lng);
	map.setCenter(there);
	rc.getNearestPanoId(there, 50, function(photoSpot) {
		rv.setPanoId(photoSpot, there);
	});
	marker.setPosition(there);
}		
function connectMapEvent() {
	var mapArea = document.getElementById('map');
	var rvArea = document.getElementById('rv');
		
	navigator.geolocation.getCurrentPosition(function(df) {
		var lat = df.coords.latitude;
		var lng = df.coords.longitude;
		var position = new kakao.maps.LatLng(lat, lng);
		
		map = new kakao.maps.Map(mapArea, {center:position});
		rv = new kakao.maps.Roadview(rvArea);
		marker = new kakao.maps.Marker({
			map : map, position: position
		});
		showMapAndRv(lng, lat);
	});
	
	$("#locationInput").keyup(function(e) {
		$.ajax({
			url : "https://dapi.kakao.com/v2/local/search/address.json",
			data : {query:$(this).val()},
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "KakaoAK f97c35a2dec2c919adebacba62e5bae2");
			},
			success : function(addrData) {
				showMapAndRv(addrData.documents[0].x, addrData.documents[0].y);
			}
		});
	});
	$("#kewordInput").keyup(function(e) {
		$.ajax({
			url : "https://dapi.kakao.com/v2/local/search/keyword.json",
			data : {
					query:$(this).val(), 
					x : map.getCenter().getLng(),
					y : map.getCenter().getLat(),
					radius: 5000,
					sort : "distance"
			},
					
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "KakaoAK f97c35a2dec2c919adebacba62e5bae2");
			},
			success : function(keywordData) {
				$("#shopInfoTable").empty();
				$.each(keywordData.documents, function(i, d) {
					var nameTd = $("<td></td>").text(d.place_name).attr("colspan", "2").attr("class", "placeName").attr("align", "center");
					var addrTd = $("<td></td>").text(d.road_address_name).attr("align", "center").attr("class", "infoTd").attr("onclick", "showMapAndRv("+ d.x +"," + d.y +");");
					var phoneTd = $("<td></td>").text(d.phone).attr("align", "center").attr("class", "phoneTd");
					var nameTr = $("<tr></tr>").append(nameTd);
					var descriptionTr = $("<tr></tr>").append(addrTd, phoneTd);
					$("#shopInfoTable").append(nameTr, descriptionTr);
				});
			}
		});
	});
}