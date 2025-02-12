<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #4facfe, #00f2fe); /* Light blue gradient */
            color: #fff;
            text-align: center;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        div {
            background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent black background */
            padding: 20px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
        }

        a {
            display: inline-block;
            margin: 10px 15px;
            padding: 10px 20px;
            color: #fff;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
            border: 2px solid #fff;
            border-radius: 5px;
            transition: all 0.3s ease;
        }

        a:hover {
            background-color: #fff;
            color: #4facfe;
            border-color: #4facfe;
        }
    </style>
</head>
<body>
        <div>
            <a href="AddInfo.html">Insert New Destination</a>
            <a href="UpdateInfo.jsp">Update Destination Info</a>
            <a href="SearchInfo.jsp">Search Destination</a>
            <a href="DeleteInfo.jsp">Delete Destination</a>
            <a href="ShowAllInfo.jsp">Show All Destination</a>
            <a href="LogoutServlet">Logout</a>
        </div>
</body>
</html>