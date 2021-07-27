function login() {
	$.post("/login",
	{
		user: $("#user").val(),
		password: $("#pwd").val()
	},
	function(data,status){
		if (data==="OK") {
	  		$("#alertWrong").hide();
	  		$("#alertSuccess").show(200);
			setTimeout(function(){location.reload();}, 1000);
		}
		else {
			$("#alertWrong").hide();
			$("#alertWrong").show(500);
		}
	});
}
		
function signin() {
	$.post("/signin",
		{
			user: $("#user2").val(),
			password: $("#pwd2").val()
		},
		function(data,status){
			if (data==="OK") {
				$("#alertWrong2").hide();
			  	$("#alertSuccess2").show(200);
		    	setTimeout(function(){location.reload();}, 500);
		    }
		    else {
		    	$("#alertWrong2").hide();
		    	$("#alertWrong2").show(500);
		    }
		});
}

$(document).ready(function(){
	$("#alertSuccess").hide();
	$("#alertWrong").hide();
	$("#alertSuccess2").hide();
	$("#alertWrong2").hide();
			
	$("#loginbtn").click(login);
	$("#signinbtn").click(signin);
});