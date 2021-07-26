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
		<script type="text/javascript">
			var productid=null;
		</script>
		<script src="/javascript/editprodotto.js"></script>
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		
		<div class="container-fluid px-5">
  			<h4 class="text-center my-5">Aggiungi un nuovo prodotto</h4>
  			<div class="row">
				<div class="col-12 col-sm-5 col-xl-4 ml-xl-5">
		  			<img src="https://www.w3schools.com/bootstrap/cinqueterre.jpg" class="img-thumbnail shadow w-75 mx-auto d-block" alt="Immagine Prodotto">
		  			<button class="btn btn-success mt-4 mb-5 mx-auto d-block w-75">Cambia immagine</button>
				</div>
				<div class="col-12 col-sm-6 col-xl-7">
		  			<form class="mr-xl-5">
					    <div class="row my-2">
					      <div class="my-auto col-xl-2 col-lg-3 col-sm-4 col-3">
					        Nome:
					      </div>
					      <div class="col">
					        <input type="text" class="form-control" placeholder="Nome" id="name">
					      </div>
					    </div>
					    
					    <div class="row my-2">
					      <div class="my-auto col-xl-2 col-lg-3 col-sm-4 col-3">
					        Prezzo:
					      </div>
					      <div class="col">
					        <input type="number" class="form-control" placeholder="Prezzo in &euro;" id="price">
					      </div>
						</div>
					      
					    <div class="row my-2">
					      <div class="my-auto col-xl-2 col-lg-3 col-sm-4 col-3">
					        Categoria:
					      </div>
					      <div class="col">
					      	<select class="form-control" id="category">
					        	<option>elettronica</option>
					        	<option>sport</option>
					        	<option>indumenti</option>
					        	<option>casa e arredamenti</option>
					        	<option>utilità</option>
					      	</select>
					      </div>
					    </div>
					    				    
					    <div class="mt-3 mb-2">Descrizione:</div>
					    <textarea class="form-control" placeholder="Descrizione" rows="3" id="desc"></textarea>
					    
					    <button id="btn-add" type="button" class="btn btn-primary mt-3">Aggiungi</button>
					</form>
				</div>
			</div>
		</div>
		<br>		

	</body>
</html>