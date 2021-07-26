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
    		var username = "${user.nome}";
    		var productid = ${product.identifier};
    		var productSeller = "${product.venditore.nome}";
		</script>
		<script src="/javascript/prodotto.js"></script>
	</head>
	<body>
		<jsp:include page="includes/navbar.jsp" />
		<br>
		
		<div class="row my-5 mx-5 pl-xl-5 pl-lg-4 pl-3">
			<div class="col-6 col-md-3">
	  			<img src="https://www.w3schools.com/bootstrap/cinqueterre.jpg" class="img-thumbnail shadow w-100" alt="Immagine Prodotto">
	  			<br>
	  			<br>
	  			<div class="d-inline-flex thumbs ml-2">
	  				<div class="text-center">
	  					<a href="#"><i class="fa fa-thumbs-up"></i></a>
	  					<br>
	  					<strong>100</strong>
	  				</div>
	  				<div class="text-center ml-4">
	  					<a href="#"><i class="fa fa-thumbs-down"></i></a>
	  					<br>
	  					<strong>9</strong>
	  				</div>
	  			</div>
			</div>
			<div class="col-6 pl-4">
	  			<h4>${product.nome}</h4>
	  			<h4 class="text-primary">${product.fprezzo}&euro;</h4>
	  			Categoria: ${product.categoria.nome}<br>
	  			<br>
	  			Descrizione:<br>
	  			${product.descrizione}
			</div>
			<div class="col-3">
	  			Venditore: ${product.venditore.nome} ${product.venditore.cognome}<br>
	  			Città: ${product.venditore.citta}<br>
	  			Indirizzo: ${product.venditore.indirizzo}<br>
	  			Numero tel.: ${product.venditore.tel}<br>
	  			<button id="btn-contact" class="btn btn-primary w-75 m-2">Contatta</button>
	  			<br>
	  			<c:if test="${product.compratore!=null}">
	  			<h5 class="text-danger text-center w-75 m-2"><strong>VENDUTO</strong></h5>
	  			</c:if>
	  			<c:if test="${product.compratore==null}">
		  			<c:if test="${user.nome==product.venditore.nome}">
		  			<button id="btn-buy" class="btn btn-danger w-75 m-2" disabled>Compra</button>
		  			</c:if>
		  			<c:if test="${user.nome!=product.venditore.nome}">
		  			<button id="btn-buy" class="btn btn-danger w-75 m-2">Compra</button>
		  			</c:if>
	  			</c:if>
			</div>
		</div>
		
		<div class="container-fluid bg-warning col-10 offset-1">
			<h4>Lascia un commento:</h4>
	    	<form role="form">
	    		<div class="form-group">
	        		<textarea class="form-control" rows="3" required></textarea>
	        	</div>
	        	<button type="submit" class="btn btn-success">Pubblica</button>
	        </form>
	    	<br><br>
	    
	    	<h5>Commenti:</h5><br>      
	      	<div class="row">
	        	<div class="col-sm-2 text-center">
	        		<img src="https://www.w3schools.com/bootstrap4/img_avatar1.png" class="rounded-circle w-75" alt="Immagine Profilo">
	        	</div>
	        	<div class="col-sm-10">
		        	<h4>Utente</h4>
		        	<p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		        	<br>
	        	</div>
	        </div>
        
	    </div>

	</body>
</html>