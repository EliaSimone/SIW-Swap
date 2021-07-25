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
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		
		<div class="container-fluid px-5">
  			<h4 class="text-center my-5">Dashboard di ${user.nome}</h4>
		</div>
		
		<div class="container px-5">
			<div class="mx-auto text-center mb-5">
				<a class="btn btn-success" href="/prodotto/aggiungi">Aggiungi nuovo prodotto</a>
			</div>
		
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-primary dropdown-toggle w-100" data-toggle="collapse" data-target="#mexs">Messaggi</button>
	  			<div id="mexs" class="collapse m-3">
	  				<ul class="list-group">
					  <li class="list-group-item">First item</li>
					  <li class="list-group-item">Second item</li>
					  <li class="list-group-item">Third item</li>
					</ul>
				</div>
			</div>
			<hr>
		
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-warning dropdown-toggle w-100" data-toggle="collapse" data-target="#prods">I miei prodotti</button>
	  			<div id="prods" class="collapse m-3">
	  				<ul class="list-group">
					  <li class="list-group-item">First item<a href="/prodotto/modifica/id=id" class="text-danger pull-right"><strong>modifica</strong></a></li>
					  <li class="list-group-item">Second item</li>
					  <li class="list-group-item">Third item</li>
					</ul>
				</div>
			</div>
			<hr>
			
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-danger dropdown-toggle w-100" data-toggle="collapse" data-target="#sales">Le mie vendite</button>
	  			<div id="sales" class="collapse m-3">
	  				<ul class="list-group">
					  <li class="list-group-item">First item</li>
					  <li class="list-group-item">Second item</li>
					  <li class="list-group-item">Third item</li>
					</ul>
				</div>
			</div>
			<hr>
			
			<div class="w-75 mx-auto my-2">
	  			<button type="button" class="btn btn-success dropdown-toggle w-100" data-toggle="collapse" data-target="#buys">I miei acquisti</button>
	  			<div id="buys" class="collapse m-3">
	  				<ul class="list-group">
					  <li class="list-group-item">First item</li>
					  <li class="list-group-item">Second item</li>
					  <li class="list-group-item">Third item</li>
					</ul>
				</div>
			</div>
			
		</div>
		<br>		

	</body>
</html>