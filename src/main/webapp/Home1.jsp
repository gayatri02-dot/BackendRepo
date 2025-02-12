<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Bean.DestiInfoBean" %>
<%@ page import="com.Dao.DestiInfoDao" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Home</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel='stylesheet' type='text/css' media='screen' href='Home1.css'>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="index.js"></script>
</head>

<body id="indexpage">
    <div id="indexface">
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar" style="color: black;"></span>
                        <span class="icon-bar" style="color: black;"></span>
                        <span class="icon-bar" style="color: black;"></span>
                    </button>
                    <a class="navbar-brand" style="color: black; font-family: 'Allura', cursive;">Savvy Sunset</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#" class="a" style="color: black;"> Home</a></li>
                        <li><a href="#footer" class="a" style="color: black;">About</a></li>
                        <li><a href="#" class="a" style="color: black;">Service</a></li>
                        <li><a href="#" class="a" style="color: black;">Contact</a></li>
                        <li><a href="#" class="a" style="color: black;">Book</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div id="mainheading">
            <h1 id="hh1">TRAVEL</h1>
            <br>
            <h3 id="hh2">Trip Of Your Dream</h3>
        </div>
    </div>

    <!-- Search Bar -->
    <div id="travel-search-container">
        <div id="search-question">Where does your next adventure begin?</div>
        <div class="travelsearch">
        <form action="Home1.jsp" method="get">
                <input type="text" id="dname" name="dname" placeholder="Search your dream destination..." required>
                <button type="submit" id="travel-search-button">Search</button>
                </form>
        </div>
    </div>

    <!-- Processing search result in JSP -->
    <%
    String dname = request.getParameter("dname");
    DestiInfoDao ddao = new DestiInfoDao();
	List<DestiInfoBean> destinations = null;
	
	try {
		if(dname != null || dname!="") {
			destinations = ddao.searchDestiByName(dname);
		}
	}
	catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
    /* List<DestiInfoBean> Destinations = (List<DestiInfoBean>) request.getAttribute("alldestinations"); */
    if (destinations != null && !destinations.isEmpty()) {
%>
    <div class="result">
        <h2>Search Results:</h2>
        
        <ul>
            <% for (DestiInfoBean Desti : destinations) { %>
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
    } else if (destinations == null) {
%>
    <div class="result">
        <h2>No results found.</h2>
    </div>
<%
    }
%>

    <div class="head" align="center">
        <h1>POPULAR PLACES</h1>
    </div>

    <div id="divtaj" class="left">
        <div class="img" id="imgtaj1">
            <img src="Images/Taj2.jpeg" id="imgtaj">
        </div>
        <div class="dis" id="tajdis">
            <h3 align="center">Taj Mahal</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Porro officiis deserunt...</p>
        </div>
    </div>

    <div id="divgoa" class="right">
        <div class="dis" id="goadis">
            <h3 align="center">Goa Beaches</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Porro officiis deserunt...</p>
        </div>
        <div class="img">
            <img src="Images/Goa1.jpeg" id="imggoa">
        </div>
    </div>

    <div id="divman" class="left">
        <div class="img" id="imgman">
            <img src="Images/manali destination 1.jpeg" id="imgman">
        </div>
        <div class="dis" id="mandis">
            <h3 align="center">Manali</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Porro officiis deserunt...</p>
        </div>
    </div>

    <div class="head" align="center">
        <h1>SERVICES</h1>
    </div>

    <div id="service">
        <div class="serv"><h5>Affordable Hotels</h5></div>
        <div class="serv"><h5>Food And Drink</h5></div>
        <div class="serv"><h5>Safety Guide</h5></div>
        <div class="serv"><h5>Adventures</h5></div>
    </div>

    <div id="footer">
        <div class="head" align="center">
            <h1>ABOUT US</h1>
        </div>
        <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Veritatis dignissimos, voluptatem nulla possimus...</p>
    </div>
</body>

</html>
