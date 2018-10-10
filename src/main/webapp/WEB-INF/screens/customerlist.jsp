<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="searchForm" method="POST" action="customers" modelAttribute="customer">
	<table>
		<tr>
			<td>
				<div>Name</div>
			</td>
			<td><input type="text" name="name"></td>
			<td>
				<div>Phone</div>
			</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>
				<div>Date of Birth</div>
			</td>
			<td><form:input type="date" path="dateOfBirth" /></td>
			<td>
				<div>Gender</div>
			</td>
			<td><input type="radio" name="gender" value="male"> 
				<input type="radio" name="gender" value="female"></td>
		</tr>
		<tr>
			<td>
				<div>Email</div>
			</td>
			<td><input type="text" id="email"></td>
			<td></td>
			<td><input type="button" id="resetBtn" value="Reset" onclick="reset()"> 
				<input type="submit" id="searchBtn" value="Search"></td>

		</tr>
	</table>
	<div>
		<table border="1" style="border-collapse: collapse">
			<thead><tr><th></th><th>Name</th><th>Date of Birth</th><th>Phone</th><th>Email</th></tr></thead>
			<c:forEach var="customer" items="${lstcustomer}">
			<tr><td><input type="checkbox" name="id" value="${customer.id}"> </td><td>${customer.name}</td><td> ${customer.dateOfBirth}</td> <td>${customer.phone}</td><td>${customer.email}</td></tr>
			</c:forEach>
		</table>
	</div>
</form:form>
</body>
<script>
	function reset() {
	    document.getElementById("searchForm").reset();
	}
</script>
</html>