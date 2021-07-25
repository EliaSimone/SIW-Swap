function buy() {
	$.post("/buy",
	{productid: productid},
	function(data,status){
	if (data==="OK")
		alert("Prodotto acquistato");
	else
		alert("Qualcosa non va");
	});
}

function mex() {
	$.post("/mex",
	{from: username,
	to: productSeller,
	text: "testo vuoto"},
	function(data,status){
	if (data==="OK")
		location.reload();
	else
		alert("Qualcosa non va");
	});
}


$(document).ready(function(){
	alert(username + " and " + productSeller);
	$("#btn-buy").click(buy);
	$("#btn-contact").click(mex);
});
