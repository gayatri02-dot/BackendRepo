<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Servlet</title>
</head>
<style>
	body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(to bottom, #42e695, #3bb2b8); /* Refreshing green-blue gradient */
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding: 20px;
    color: #333;
}

form {
    background: white;
    padding: 30px 40px;
    border-radius: 15px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
    max-width: 500px;
    width: 100%;
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
    text-align: center;
}

label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
    color: #555;
    text-align: left;
}

input[type="number"] {
    width: 100%;
    padding: 12px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 8px;
    font-size: 16px;
    box-sizing: border-box;
    transition: border-color 0.3s;
}

input[type="number"]:focus {
    border-color: #42e695;
    outline: none;
}

input[type="submit"] {
    background-color: #3bb2b8; /* Vibrant button */
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
    background-color: #42e695;
    transform: scale(1.02);
}

input[type="submit"]:active {
    transform: scale(0.98);
}
</style>
<body>
	
	<form action="./DeleteInfoServlet" method="post">
	
		<label for="did">Enter Destination id to delete : </label>
		<input type="number" name="did" id="did" />
		<input type="submit" value="Delete Destination">
	
	</form>
	
	
</body>
</html>