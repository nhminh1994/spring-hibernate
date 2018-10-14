<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Login</title>

<script src="<c:url value="/resources/js/prefixfree.min.js" />"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	<form id='loginForm' name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
		<div class="login">
			<input type="text" placeholder="username" name="username"><br>
			<input type="password" placeholder="password" name="password"><br>
			<input name="submit" type="submit" value="login" /> 
			<input id="reset" type="button" value="reset" onclick="resetProcess()"/>
			<input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="error-login">${message}</div>
		</div>
	</form>

</body>
<script>
	function resetProcess() {
		$(':input','#loginForm')
		  .not(':button, :submit, :reset, :hidden')
		  .val('');
	}
</script>
</html>