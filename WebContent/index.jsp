<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="<c:url value="/resources/styles/main.css" />" rel="stylesheet">
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   	<script src="<c:url value="/resources/js/main.js" />"></script>
   	
</head>
<body>
	<br>
	<div class = "container">
		<div class = "centered">
			<h2>
				Search a relation to our beloved KB!
			</h2>
			<input class = "search-query" id = "searchQuery"/>
			<button id = "btn" >find</button>
			<div id = "response"></div>
		</div>
	</div>
</body>
</html>