<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.Bean.DestiInfoBean" %>
<%@ page import="com.Dao.DestiInfoDao" %>
<html>
<head>
<meta charset="UTF-8">
<title>Show Destinations</title>
<style>
body {
    margin: 0;
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(to bottom, #4facfe, #00f2fe); /* Cool blue gradient */
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding: 20px;
    color: #333;
}

div {
    background: white;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
    max-width: 1200px;
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

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

thead {
    background-color: #4facfe; /* Cool blue */
    color: white;
}

th, td {
    text-align: left;
    padding: 12px;
    border: 1px solid #ddd;
}

th {
    font-size: 16px;
    font-weight: bold;
    text-transform: uppercase;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tbody tr:hover {
    background-color: #e0f7fa;
    transition: background-color 0.3s;
}

td {
    font-size: 14px;
}

.nothing {
    font-size: 18px;
    color: #555;
    text-align: center;
    margin-top: 20px;
}
</style>
</head>
<body>
	
	 <%
            List<DestiInfoBean> destinations = new ArrayList<>();
		DestiInfoDao ddao = new DestiInfoDao();
		destinations = ddao.allDestiInfo();


            if (destinations == null || destinations.isEmpty()) {
        %>
        nothing
        <%
            } else {
        %>
        <div>
            <table>
                <thead>
                    <tr>
                        <th >Destination ID : </th>
                        <th >Destination Name : </th>
                        <th >Destination Description : </th>
                        <th >Destination Price : </th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Loop through the bookList and display each book's details -->
                    <% 
                        for (DestiInfoBean Desti : destinations) {
                    %>
                    <tr>
                        <td><%= Desti.getDid() %></td>
                        <td><%= Desti.getDname() %></td>
                        <td><%= Desti.getDdis() %></td>
                        <td><%= Desti.getDprice() %></td>
                    </tr>
                    <% 
                        }
                    %>
                </tbody>
            </table>
        </div>
        <% 
            }
        %>
	
</body>
</html>