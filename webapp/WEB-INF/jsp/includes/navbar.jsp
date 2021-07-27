<nav class="navbar navbar-dark fixed-top navbar-expand-md bg-dark">
	<div class="navbar-brand">SIW Swap</div>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"></span>
  	</button>
    <div class="dropdown ml-auto mr-lg-5 mr-md-1 mr-3 order-md-last">
    	<button class="btn btn-outline-primary mr-2 p-2 dropdown-toggle" data-toggle="dropdown">
        	<i class="fa fa-user mr-1"></i>
        	${user.nome}
        </button>
        <div class="dropdown-menu bg-dark">
          <a class="dropdown-item text-primary" href="/dashboard">Dashboard</a>
          <a class="dropdown-item text-primary" href="/profile">Dati Utente</a>
          <a class="dropdown-item text-primary" id="logoutbtn" href="#">Log out</a>
    	</div>
    </div>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav mr-4">
			<li class="nav-item">
				<a class="nav-link yellow" href="/">Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="/categorie">Categorie</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Info</a>
			</li>
		</ul>
		<form action="/search">
			<div class="form-row">
				<div class="col-lg-10 col-md-8 col-5">
		    		<input class="form-control" type="text" name="q" placeholder="Cerca">
		    	</div>
		    	<div class="col-2">
		    		<button class="btn btn-warning" type="submit">Cerca</button>
		    	</div>
	    	</div>
		</form> 
	</div>
</nav>
<div class="barSpace"></div>