<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>SIW-Swap home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/mainStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script src="/javascript/mainNavGuest.js"></script>
	</head>
	<body>
		<jsp:include page="includes/navbarGuest.jsp" />
		
		<div class="jumbotron home-jumbo text-center bg-warning text-primary">
			<h1>Benvenuto in SIW Swap</h1>
			<h5>Compra e vendi oggetti</h5>
		</div>
		<p class="text-center">Non sei Loggato, loggati per comprare e vendere prodotti e avere accesso a tutte le funzioni, oppure fai una panoramica dei prodotti</p>
		<br>
		<h3 class="text-center mb-2">Prodotti in evidenza</h3>	
		<br>
		
		<div id="prodSlide" class="carousel slide w-75 mx-auto" data-ride="carousel">		  
		  
		  <div class="carousel-inner">		  		  
		  <c:forEach items="${products}" var="item" varStatus="status">
		  	<c:if test="${status.index==0}">
		  	<div class="carousel-item text-center active">
		  	</c:if>
		  	<c:if test="${status.index!=0}">
		  	<div class="carousel-item text-center">
		  	</c:if>
		      <img src="${item.image}" height="600" alt="Immagine prodotto">
		      <div class="mt-2">
		        <h3>${item.nome} <span class="text-primary">${item.fprezzo}&euro;</span></h3>
		        <p>${item.descrizione}</p>
		      </div>   
		    </div>
		  </c:forEach>		    
		  </div>
		  
		  <a class="carousel-control-prev" href="#prodSlide" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#prodSlide" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		  
		</div>
	</body>
</html>