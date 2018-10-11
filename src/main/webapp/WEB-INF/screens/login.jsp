<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>CodePen - Random Login Form</title>

<script src="<c:url value="/resources/js/prefixfree.min.js" />"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Minh<span>Site</span>
		</div>
	</div>
	<br>
	<form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
	<!-- <form name='loginForm' action="/customers" method='POST'> -->
		<div class="login">
			<input type="text" placeholder="username" name="username"><br>
			<input type="password" placeholder="password" name="password"><br>
			<input name="submit" type="submit" value="login" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div>${message}</div>
		</div>
	</form>

</body>

</html>