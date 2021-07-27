<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SIW-Swap search</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="/css/mainStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script src="/javascript/mainNav.js"></script>
		<script>
			$(document).ready(function(){
				$('[data-toggle="tooltip"]').tooltip();
			});
		</script>
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		
		<div class="container-fluid px-5">
  			<h4 class="text-center my-5">Dashboard di ${user.nome}</h4>
		</div>
		
		<div class="container px-5">
		
			<div class="w-75 row mx-auto mb-4">
				<div class="col-6">
					<strong>prodotti totali: ${nprods}</strong><br>
					<strong>vendite totali: ${nsales}</strong><br>
					<strong>acquisti totali: ${nbuys}</strong>
				</div>
				<div class="col-6">
					<strong>totale guadagnato: ${ntotgain}&euro;</strong><br>
					<strong>totale speso: ${ntotspent}&euro;</strong><br>
				</div>
			</div>
			
			<div class="mx-auto text-center mb-5">
				<a class="btn btn-success" href="/prodotto/aggiungi">Aggiungi nuovo prodotto</a>
			</div>
		
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-primary dropdown-toggle w-100" data-toggle="collapse" data-target="#mexs">Messaggi</button>
	  			<div id="mexs" class="collapse m-3">
	  				<ul class="list-group">
	  					<c:forEach items="${listmex}" var="item" varStatus="status">
	  					<li class="list-group-item">Da: ${item.utente1.nome}<span class="pull-right"><small>${item.dataGiorno} ${item.dataMeseNome} ${item.dataAnno}</small></span><br> ${item.testo}<br></li>
	  					</c:forEach>
					</ul>
				</div>
			</div>
			<hr>
		
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-warning dropdown-toggle w-100" data-toggle="collapse" data-target="#prods">I miei prodotti</button>
	  			<div id="prods" class="collapse m-3">
	  				<ul class="list-group">
					 	<c:forEach items="${listprods}" var="item" varStatus="status">
	  					<li class="list-group-item">${item.nome}<span class="text-primary ml-2">${item.fprezzo}&euro;</span><a href="/prodotto/modifica?id=${item.identifier}" class="text-danger pull-right"><strong>modifica</strong></a></li>
	  					</c:forEach>
					</ul>
				</div>
			</div>
			<hr>
			
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-danger dropdown-toggle w-100" data-toggle="collapse" data-target="#sales">Le mie vendite</button>
	  			<div id="sales" class="collapse m-3">
	  				<ul class="list-group">
						<c:forEach items="${listsales}" var="item" varStatus="status">
						<li class="list-group-item">${item.nome}<span class="text-primary ml-2">${item.fprezzo}&euro;</span> <a href="#" data-toggle="tooltip" data-html="true" title="${item.compratore.nome} ${item.compratore.cognome} <br>città: ${item.compratore.citta} <br>indirizzo: ${item.compratore.indirizzo} <br>tel: ${item.compratore.tel}" data-placement="left" class="text-primary pull-right"><strong>a ${item.compratore.nome}</strong></a> </li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<hr>
			
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-success dropdown-toggle w-100" data-toggle="collapse" data-target="#buys">I miei acquisti</button>
	  			<div id="buys" class="collapse m-3">
	  				<ul class="list-group">
						<c:forEach items="${listbuys}" var="item" varStatus="status">
						<li class="list-group-item">${item.nome}<span class="text-primary ml-2">${item.fprezzo}&euro;</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
		</div>
		<br>		

	</body>
</html>