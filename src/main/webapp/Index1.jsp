<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#signform{
display: none;
}
</style>
<script type="text/javascript">
function shows(){
	var x = document.getElementById("signform");
	var y = document.getElementById("loginform");
	if(x.style.display === "none"){
		x.style.display = "block";
		y.style.display = "none"
	}
	else{
		x.style.display = "none"
		y.style.display = "block";
	}
	
}

	function validate(){
		var name = document.f1.username.value;
		var pass = document.f1.password.value;
		if(name==null || name==""){
			alert("Username cannot be Blank!!");
			return false;
		}
		else if(pass==null || pass==""){
			alert("Password cannot be Blank!!");
			return false;
		}
		return true;
	}
	function validate2(){
		var name = document.f2.susername.value;
		var pass = document.f2.spassword.value;
		var cpass = document.f2.cpassword.value;
		if(name==null || name==""){
			alert("Username cannot be Blank!!");
			return false;
		}
		else if(pass==null || pass==""){
			alert("Password cannot be Blank!!");
			return false;
		}
		else if(cpass==null || cpass==""){
			alert("Password cannot be Blank!!");
			return false;
		}
		if(spass!=cpass){
			alert("Password must be same!!");
			return false;
		}
		return true;
	}
</script>
</head>
<body align="center">
	<div class="container" id="loginform">
        <h2>Customer Login</h2>
        <br>
        <form name="f1" action="./CustomerLoginServlet" method="post" onsubmit="return validate()">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" required>
            
            <br><br>
            
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required>
            
            <br><br>
            
            <input type="submit" value="Login">
            <br>
            <input type="button" value="Register Here" onclick="shows()">
            <br>
        </form>
    </div>
    <div class="container" id="signform">
        <h2>Customer Register</h2>
        <br>
        <form name="f2" action="./CustomerSigninServlet" method="post" onsubmit="return validate2()">
            <label for="susername">Enter Username</label>
            <input type="text" name="susername" id="susername" required>
            
            <br><br>
            
            <label for="spassword">Enter Password</label>
            <input type="password" name="spassword" id="spassword" required>
            
            <br><br>
            
            <label for="cpassword">Enter Confirm Password</label>
            <input type="password" name="cpassword" id="cpassword" required>
            
            <br><br>
            
            <label for="name">Enter Name</label>
            <input type="text" name="name" id="name" required>
            
            <br><br>
            
            <label for="lname">Enter Last Name</label>
            <input type="text" name="lname" id="lname" required>
            
            <br><br>
            
            <label for="mail">Enter Email</label>
            <input type="text" name="mail" id="mail" required>
            
            <br><br>
            
            <label for="number">Enter Phone Number</label>
            <input type="number" name="number" id="number" required>
            
            <br><br>
            
            <input type="submit" value="Register">
            <br>
            <input type="button" value="Login Here" onclick="shows()">
            <br>
        </form>
    </div>
</body>
</html>
