function add() {
	$.post("/addproduct",
	{nome: $("#name").val(),
	prezzo: $("#price").val(),
	categoria: $("#category").val(),
	descrizione: $("#desc").val()},
	function(data,status){
	if (data==="OK") {
		alert("Prodotto aggiunto");
		location.href="/dashboard";
	}
	else
		alert("Qualcosa non va");
	});
}

function save() {
	$.post("/saveproduct",
	{id: productid,
	nome: $("#name").val(),
	prezzo: $("#price").val(),
	categoria: $("#category").val(),
	descrizione: $("#desc").val()},
	function(data,status){
	if (data==="OK") {
		alert("Prodotto salvato");
		location.href="/prodotto?id="+productid;

	}
	else
		alert("Qualcosa non va");
	});
}

function deleteprod() {
	$.post("/deleteproduct",
	{id: productid},
	function(data,status){
	if (data==="OK") {
		alert("Prodotto eliminato");
		location.href="/dashboard";
	}
	else
		alert("Qualcosa non va");
	});
}

function test() {
	var utente = {nome: "Mario"};
	$.post("/ciao",
	{u: utente},
	function(data,status){
		alert(data);
	});
	alert("bu");
}



$(document).ready(function(){
	$("#btn-add").click(add);
	$("#btn-save").click(save);
	$("#btn-delete").click(deleteprod);
});
