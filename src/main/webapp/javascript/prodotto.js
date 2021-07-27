function buy() {
	$.post("/buy",
	{productid: productid},
	function(data,status){
	if (data==="OK") {
		alert("Prodotto acquistato");
		$("#btn-buy").prop('disabled', true);
	}
	else
		alert("Qualcosa non va");
	});
}

function mex() {
	$.post("/mex",
	{from: username,
	to: productSeller,
	text: $("#mextext").val()}, 
	function(data,status){
		if (data==="OK") {		
			$("#alertWrong").hide();
			$("#alertSuccess").show(200);
		    	setTimeout(function(){
				$("#mexmodal").modal('hide');
				$("#alertSuccess").hide();
				$("#mextext").val("");
			}, 1000);
		}
		else {
			$("#alertWrong").hide();
		    	$("#alertWrong").show(500);
		}
	});
}

function comment() {
	$.post("/comment",
	{productid: productid,
	text: $("#txt-comment").val()},
	function(data,status){
	if (data==="OK") {
		alert("Commento aggiunto");
		$("#txt-comment").val("");
		loadComments();
	}
	else
		alert("Qualcosa non va");
	});
}

function loadComments() {
	$.post("/getcomments",
	{productid: productid},
	function(data,status){
	if (status==="success") {
		var inHtml="";
		for (var i=0; i<data.length; i++) {
			inHtml+="<div class=\"row\">"+
		        	"<div class=\"col-sm-2 text-center\">"+
		        		"<img src=\"https://www.w3schools.com/bootstrap4/img_avatar1.png\" class=\"rounded-circle w-75\" alt=\"Immagine Profilo\">"+
		        	"</div>"+
		        	"<div class=\"col-sm-10\">"+
			        	"<h4>"+data[i].utente.nome+"</h4>"+
			        	"<p>"+data[i].testo+"</p>"+
			        	"<br>"+
		        	"</div>"+
		        "</div>"+
		        "<br>";
		}
		$("#comments").html(inHtml);
	}
	else
		alert("Qualcosa non va");
	});
}

function setlikeUp() {
	$.post("/setlike",
	{productid: productid,
	up: true},
	function(data,status) {
		if (data==="OK")
			loadlikes();
	});
}

function setlikeDown() {
	$.post("/setlike",
	{productid: productid,
	up: false},
	function(data,status) {
		if (data==="OK")
			loadlikes();
	});
}

function loadlikes() {
	$.post("/getlike",
	{productid: productid},
	function(data,status) {
		if (data==="UP") {
			$("#thumb-up i").addClass("set");
			$("#thumb-down i").removeClass("set");
		}
		else if (data==="DOWN") {
			$("#thumb-down i").addClass("set");
			$("#thumb-up i").removeClass("set");
		}
		else if (data==="NO") {
			$("#thumb-down i").removeClass("set");
			$("#thumb-up i").removeClass("set");
		}
	});

	$.post("/getnlikes",
	{productid: productid},
	function(data,status) {
		if (data!==null) {
			$("#nthumbs-up").html("<strong>"+data["up"]+"</strong>");
			$("#nthumbs-down").html("<strong>"+data["down"]+"</strong>");
		}
	});

}


$(document).ready(function(){
	$("#alertSuccess").hide();
	$("#alertWrong").hide();

	$("#btn-buy").click(buy);
	$("#btn-send").click(mex);
	$("#btn-comment").click(comment);
	$("#thumb-up").click(setlikeUp);
	$("#thumb-down").click(setlikeDown);
	loadlikes();
});
