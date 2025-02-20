<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome paage</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	body {
    margin: 0;
    padding: 0;
    height: 100vh;
    overflow: hidden;
    background-size:100%;
    text-align: center;
}
h1{
padding-top: 100px;
font-family: 'Lucida Handwriting';
}

.video-bg {
    position: fixed;
    top: 0;
    left: 0;
    video-size: cover;
    width:100%;
    transform: translate(0%, 0%);
    display: block;
    object-fit: cover;
    z-index: -1;
}

        .buttons {
       
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 5px; /* Small gap between buttons */
}

input {
    width: 150px;
    height: 75px;
    border: none;
    font-size: 16px;
    color: white;
    cursor: pointer;
    text-align: center;
}

/* Upper Button (Top Half-Circle) */
#admin-btn {
color:black;
    background-color: rgb(241, 218, 211);
    border-top-left-radius: 75px;
    border-top-right-radius: 75px;
}

/* Lower Button (Bottom Half-Circle) */
#customer-btn {
color: black;
    background-color: rgb(241, 218, 211);
    border-bottom-left-radius: 75px;
    border-bottom-right-radius: 75px;
}
</style>
 <script>
        $(document).ready(function() {
            $("#toggle-text").click(function() {
                $(".buttons").slideToggle(); // Slide down on mouse enter
                
            })
            $("#toggle-text").css("cursor","pointer");
        });
        
    </script>
</head>
<body>
	<video class="video-bg" autoplay muted loop>
    <source src="AllImages/background v3.mp4" type="video/mp4">
</video>
<div>
	<h1>Welcome To Savvy Sunset Travel</h1>
	<h3 id="toggle-text">Enter</h3>
    <div class="buttons">
        <a href="Index.html"><input type="button" value="Login as Admin" align="center" id ="admin-btn"></a>
        <a href="Index1.jsp"><input type="button" value="Login as Customer" align="center" id="customer-btn"></a>
    </div>
</div>
</body>
</html>