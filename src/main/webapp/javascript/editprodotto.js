function add() {
	$.post("/addproduct",
	{nome: $("#name").val(),
	prezzo: $("#price").val(),
	categoria: $("#category").val(),
	descrizione: $("#desc").val()},
	function(data,status){
	if (data==="OK")
		alert("Prodotto aggiunto");
	else
		alert("Qualcosa non va");
	});
}

$(document).ready(function(){
	$("#btn-add").click(add);
});
