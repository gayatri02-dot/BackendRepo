<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Destination</title>
<style>
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(to bottom, #ff7e5f, #feb47b); /* Vibrant gradient */
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    color: #333;
}

form {
    background: #fff;
    padding: 30px 50px;
    border-radius: 15px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
    max-width: 450px;
    width: 100%;
    text-align: center;
    animation: fadeIn 0.8s ease;
}

@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(10px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

form h1 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
    font-weight: 600;
}

label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
    color: #555;
    text-align: left;
}

input[type="number"],
input[type="text"] {
    width: 100%;
    padding: 12px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 16px;
    box-sizing: border-box;
    transition: border-color 0.3s;
}

input[type="number"]:focus,
input[type="text"]:focus {
    border-color: #ff7e5f;
    outline: none;
}

input[type="submit"] {
    background-color: #ff7e5f; /* Vibrant button */
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 8px;
    font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    width: 100%;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

input[type="submit"]:hover {
    background-color: #feb47b;
    transform: scale(1.02);
}

input[type="submit"]:active {
    transform: scale(0.98);
}

footer {
    margin-top: 20px;
    text-align: center;
    color: #fff;
    font-size: 14px;
}

footer a {
    color: #fff;
    text-decoration: underline;
}

footer a:hover {
    color: #ff7e5f;
}

</style>
</head>
<body>

	<form name=fm1 action="./UpdateInfoServlet" method="post">
	
		<label for="did">Destination Id : </label>
		<input type="number" name="did" id="did" required/>
		
		<label for="dname">Destination Name : </label>
		<input type="text" name="dname" id="dname" required/>
		
		<label for="ddis">Destination Decription : </label>
		<input type="text" name="ddis" id="ddis" required/>
	
		<label for="dprice">Destination Price : </label>
		<input type="number" name="dprice" id="dprice" required/>
		
		<input type="submit" value="Update Destination" />
	
	</form>

</body>
</html>