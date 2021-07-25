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
		<br>
		
		<div class="container justify-content-center mt-4">
  			<h4>Risultati per "${param.q}":</h4>
		</div>
		<br>
		
		<div class="row col-10 offset-1">
			<c:forEach items="${results}" var="item" varStatus="status">
			<div class="col-xl-3 col-lg-4 col-md-6 p-4">
				<div class="card shadow p-2">
					<img class="card-img-top" src="https://www.w3schools.com/bootstrap4/img_avatar1.png" alt="Immagine prodotto">
					<div class="card-body">
						<h4 class="card-title">${item.nome}</h4>
						<p class="card-text">${item.descrizione}</p>
						<a href="/prodotto?id=${item.identifier}" class="btn btn-primary stretched-link">Vai al prodotto</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>

	</body>
</html>