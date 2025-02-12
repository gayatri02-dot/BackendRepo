<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.Bean.DestiInfoBean" %>
<html>
<head>
<meta charset="UTF-8">
<title>Search Destination</title>
<style>
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(to bottom, #f7797d, #fbd786); /* Sunset gradient */
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

input[type="text"]:focus {
    border-color: #f7797d;
    outline: none;
}

input[type="submit"] {
    background-color: #fbd786; /* Warm button */
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
    background-color: #f7797d;
    transform: scale(1.02);
}

input[type="submit"]:active {
    transform: scale(0.98);
}

.result {
    background: white;
    padding: 20px;
    margin-top: 20px;
    border-radius: 15px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
}

.result h2 {
    font-size: 20px;
    color: #333;
    margin-bottom: 15px;
    text-align: center;
}

.result ul {
    list-style: none;
    padding: 0;
}

.result li {
    background: #f9f9f9;
    margin: 10px 0;
    padding: 15px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.result li strong {
    font-weight: bold;
}

</style>
</head>
<body>

	<form action="./SearchInfoServlet" method="post">
    <label for="dname">Enter Destination Name :</label>
    <input type="text" name="dname" required>
    <input type="submit" value="Search">
	</form>

<%
    List<DestiInfoBean> Destinations = (List<DestiInfoBean>) request.getAttribute("alldestinations");
    if (Destinations != null && !Destinations.isEmpty()) {
%>
    <div class="result">
        <h2>Search Results:</h2>
        <ul>
            <% for (DestiInfoBean Desti : Destinations) { %>
                <li>
                    <strong>Destination ID :</strong> <%=Desti.getDid() %> | 
                    <strong>Destination Name :</strong> <%=Desti.getDname() %> | 
                    <strong>Destination Description :</strong> <%=Desti.getDdis() %> | 
                    <strong>Destination Price :</strong> <%=Desti.getDprice() %> | 
                </li>
            <% } %>
        </ul>
    </div>
<%
    } else if (Destinations != null) {
%>
    <div class="result">
        <h2>No results found.</h2>
    </div>
<%
    }
%>
	

</body>
</html>