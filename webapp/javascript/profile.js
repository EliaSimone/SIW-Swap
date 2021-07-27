function save() {
	$.post("/saveprofile",
	{cognome: $("#surname").val(),
	citta: $("#city").val(),
	indirizzo: $("#address").val(),
	tel: $("#telnumber").val(),
	descrizione: $("#desc").val()},
	function(data,status){
	if (data==="OK")
		alert("Dati salvati");
	else
		alert("Qualcosa non va");
	});
}

$(document).ready(function(){
	$("#btn-save").click(save);
	setInterval(function() {
		if ($("#city").val()==="") {
			$.get("https://api.ipify.org/",function(data,status){
				var url="http://ip-api.com/json/"+data;
				$.get(url,function(data,status){
					$("#city").val(data["city"]);
				});
			});
		}
	}, 500);
});
