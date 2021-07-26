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
	text: "testo vuoto"},
	function(data,status){
	if (data==="OK")
		location.reload();
	else
		alert("Qualcosa non va");
	});
}


$(document).ready(function(){
	$("#btn-buy").click(buy);
	$("#btn-contact").click(mex);
});
