<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.Bean.DestiInfoBean"%>
<%@ page import="com.Dao.DestiInfoDao"%>
<%@ page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Home</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' media='screen' href='Home1.css'>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="index.js"></script>
</head>

<body id="indexpage">
	<div id="indexface">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar" style="color: black;"></span> <span
							class="icon-bar" style="color: black;"></span> <span
							class="icon-bar" style="color: black;"></span>
					</button>
					<a class="navbar-brand"
						style="color: black; font-family: 'Allura', cursive;">Savvy
						Sunset</a>
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
				<input type="text" id="dname" name="dname"
					placeholder="Search your dream destination..." required>
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
		if (dname != null || dname != "") {
			destinations = ddao.searchDestiByName(dname);
		}
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	/* List<DestiInfoBean> Destinations = (List<DestiInfoBean>) request.getAttribute("alldestinations"); */
	if (destinations != null && !destinations.isEmpty()) {
	%>
	<div class="result">
		<h1>Search Results:</h1>
		<%
		for (DestiInfoBean Desti : destinations) {
		%>
		<div id="res">
			<div class="desti-info">
				<h2 class="desti-name"><%=Desti.getDname()%></h2>
				<p>
					<strong>ID:</strong>
					<%=Desti.getDid()%></p>
				<p>
					<strong>Description:</strong>
					<%=Desti.getDdis()%></p>
				<p>
					<strong>Price:</strong> <span class="desti-price">$<%=Desti.getDprice()%></span>
				</p>
				<button class="book-btn">Book</button>
			</div>
			<div class="desti-img-box">
				<img src="GetImageServlet?imageId1=<%=Desti.getDid()%>"
					alt="Destination Image" class="desti-img">
			</div>
		</div>
		<%
		}
		%>

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

	<%
	List<DestiInfoBean> d1 = new ArrayList<>();
	DestiInfoDao dd = new DestiInfoDao();
	d1 = dd.allDestiInfo();

	if (d1 == null || d1.isEmpty()) {
	%>
	nothing
	<%
	} else {
	%>
	<div>

		<!-- Loop through the bookList and display each book's details -->
		<%
		for (DestiInfoBean Desti : d1) {
			if(Desti.getDid()/2 == 0){
		%>
		<div id="evendesti">
		<div class="desti-img-box">
			<img src="GetImageServlet?imageId1=<%=Desti.getDid()%>"
				alt="Destination Image" class="desti-img">
		</div>
		<div class="allinfo">
			<h2 class="alldesti-name"><%=Desti.getDname()%></h2>
			<p>
				<strong>ID:</strong>
				<%=Desti.getDid()%></p>
			<p>
				<strong>Description:</strong>
				<%=Desti.getDdis()%></p>
			<p>
				<strong>Price:</strong> <span class="desti-price">$<%=Desti.getDprice()%></span>
			</p>
			<button class="book-btn">Book</button>
		</div>
		</div>
		
		<%
		}else{
		%>
		<div id="odddesti">
		<div class="allinfo">
			<h2 class="alldesti-name"><%=Desti.getDname()%></h2>
			<p>
				<strong>ID:</strong>
				<%=Desti.getDid()%></p>
			<p>
				<strong>Description:</strong>
				<%=Desti.getDdis()%></p>
			<p>
				<strong>Price:</strong> <span class="desti-price">$<%=Desti.getDprice()%></span>
			</p>
			<button class="book-btn">Book</button>
		</div>
		<div class="desti-img-box">
			<img src="GetImageServlet?imageId1=<%=Desti.getDid()%>"
				alt="Destination Image" class="desti-img">
		</div>
		</div>
	<%
	}}
	%>
	</div>
	<%
	}
	%>

	<div class="head" align="center">
		<h1>SERVICES</h1>
	</div>

	<div id="service">
		<div class="serv">
			<h5>Affordable Hotels</h5>
		</div>
		<div class="serv">
			<h5>Food And Drink</h5>
		</div>
		<div class="serv">
			<h5>Safety Guide</h5>
		</div>
		<div class="serv">
			<h5>Adventures</h5>
		</div>
	</div>

	<div id="footer">
		<div class="head" align="center">
			<h1>ABOUT US</h1>
		</div>
		<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit.
			Veritatis dignissimos, voluptatem nulla possimus...</p>
	</div>
</body>

</html>
