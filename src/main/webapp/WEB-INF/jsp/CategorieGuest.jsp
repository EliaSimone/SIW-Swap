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
		<script src="/javascript/mainNavGuest.js"></script>
	</head>
	<body>
		<jsp:include page="includes/navbarGuest.jsp" />
		<br>
		
		<div class="container justify-content-center mt-4">
  			<h4>Categorie:</h4>
		</div>
		<br>
		
		<c:forEach items="${products}" var="listprod" varStatus="status">
		<h4 class="text-center my-2">${listprod.key}</h4>
		<div class="row col-10 offset-1">
			<c:forEach items="${listprod.value}" var="product" varStatus="status2">
			<div class="col-xl-3 col-lg-4 col-md-6 p-4">
				<div class="card shadow p-2">
					<img class="card-img-top" src="https://www.w3schools.com/bootstrap4/img_avatar1.png" alt="Immagine prodotto">
					<div class="card-body">
						<h4 class="card-title">${product.nome} <span class="text-primary ml-2">${product.fprezzo}&euro;</span></h4>
						<p class="card-text">${product.descrizione}</p>
						<a href="#" class="btn btn-primary stretched-link" data-toggle="collapse" data-target="#error${status.index}-${status2.index}">Vai al prodotto</a>
						<p id="error${status.index}-${status2.index}" class="collapse text-danger my-2"><strong>non sei loggato</strong></p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		</c:forEach>

	</body>
</html>