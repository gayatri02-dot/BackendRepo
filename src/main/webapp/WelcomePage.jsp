<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome paage</title>
<style>
	body {
    margin: 0;
    padding: 0;
    height: 100vh;
    overflow: hidden;
}

.video-bg {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    z-index: -1;
}
</style>
</head>
<body>
	<video class="video-bg" autoplay muted loop>
    <source src="AllImages/background_v2.mp4" type="video/mp4">
</video>
</body>
</html>