<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Dekho Case Study MVC</title>
<style type="text/css">
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}

nav {
	text-align: right;
}

li {
	display: inline-block;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
	color: white;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<div align="center">
		<nav>
			<ul>
				<li><a href="./home">Home</a></li>
				<li><a href="./add">AddCar</a></li>
				<li><a href="./search">SearchCar</a></li>
				<li><a href="./update">UpdateCar</a></li>
				<li><a href="./remove">RemoveCar</a></li>
				<li><a href="./logout">Logout</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>