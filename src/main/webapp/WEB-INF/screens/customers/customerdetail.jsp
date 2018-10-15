<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/sort.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/myjs.js" />"></script>
<title>Customer Detail</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Customer Information</h3>
		<br>
		<form:form id="detailForm" method="POST" action="${pageContext.request.contextPath}/processupdate"
			modelAttribute="customerdetaildata">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>
						<div>Name</div>
					</td>
					<td><form:input class="form-control" path="name" /> <form:errors path="name"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Phone</div>
					</td>
					<td><form:input class="form-control" path="phone" onkeypress="return AllowOnlyNumbers(event);" />
						<form:errors path="phone" cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Date of Birth</div>
					</td>
					<td><form:input class="form-control" type="date" path="dateOfBirth" min="2000-01-01" /> <form:errors
							path="dateOfBirth" cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Gender</div>
					</td>
					<td><form:radiobutton path="gender" value="true" />Male <form:radiobutton
							path="gender" value="false" />Female <form:errors path="gender"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Email</div>
					</td>
					<td><form:input path="email" class="form-control"/> <form:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Address</div>
					</td>
					<td><form:textarea path="addressLine" class="form-control"/> <form:errors
							path="addressLine" cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Title</div>
					</td>
					<td><form:select class="form-control" path="title">
							<form:options class="form-control" items="${titlemap}" />
						</form:select> <form:errors path="title" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="button" id="resetBtn" value="Reset"
						onclick="reset()" class="btn btn-default"> <input type="submit" id="saveBtn"
						value="Save" class="btn btn-default"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
<script>

</script>
</html>