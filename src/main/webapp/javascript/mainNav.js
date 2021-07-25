function logout() {
			$.post("/logout",
		    {},
		    function(data,status){
		    	if (data==="OK")
			  		location.reload();
		    	else
		    		alert("Qualcosa non va");
		    });
		}

$(document).ready(function(){
	$("#logoutbtn").click(logout);
});