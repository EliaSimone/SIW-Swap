<nav class="navbar navbar-dark fixed-top navbar-expand-md bg-dark">
	<div class="navbar-brand">SIW Swap</div>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"></span>
  	</button>
    <div class="d-flex ml-auto mr-lg-5 mr-md-0 mr-3 order-md-last">
    	<button class="btn btn-outline-warning mr-2 p-2" data-toggle="modal" data-target="#login">Accedi</button>
    	<button class="btn btn-outline-primary p-2" data-toggle="modal" data-target="#signin">Registrati</button>
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

<div class="modal fade" id="login">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
      
          <div class="modal-header">
            <h4 class="modal-title">Log In</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
        
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="user">Nome Utente:</label>
                <input type="text" class="form-control" placeholder="Utente" id="user">
              </div>
              <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" placeholder="Enter password" id="pwd">
              </div>
              <button type="button" id="loginbtn" class="btn btn-primary">Accedi</button>
            </form>
            <br>
            <div id="alertSuccess" class="alert alert-success">
				<strong>Success!</strong> Accesso effettuato.
            </div>
            <div id="alertWrong" class="alert alert-danger">
            	<strong>Danger!</strong> Credenziali errate.
            </div>
          </div>
        
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        
		</div>
	</div>
</div>

<div class="modal fade" id="signin">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
      
          <div class="modal-header">
            <h4 class="modal-title">Sign In</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
        
          <div class="modal-body">
            <form>
              <div class="form-group">
                <label for="user2">Nome Utente:</label>
                <input type="text" class="form-control" placeholder="Utente" id="user2">
              </div>
              <div class="form-group">
                <label for="pwd2">Password:</label>
                <input type="password" class="form-control" placeholder="Enter password" id="pwd2">
              </div>
              <button type="button" id="signinbtn" class="btn btn-primary">Registrati</button>
            </form>
            <br>
            <div id="alertSuccess2" class="alert alert-success">
				<strong>Success!</strong> Registrazione effettuata.
            </div>
            <div id="alertWrong2" class="alert alert-danger">
            	<strong>Danger!</strong> Dati errati.
            </div>
          </div>
        
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        
		</div>
	</div>
</div>