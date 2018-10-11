<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<form:form id="searchForm" method="POST" action="customers"
		modelAttribute="customer">
		<table>
			<tr>
				<td>
					<div>Name</div>
				</td>
				<td><form:input path="name" /> <form:errors path="name"
						cssClass="error" /></td>
				<td>
					<div>Phone</div>
				</td>
				<td><form:input path="phone" /> <form:errors path="phone"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>
					<div>Date of Birth</div>
				</td>
				<td><form:input type="date" path="dateOfBirth" /> <form:errors
						path="dateOfBirth" cssClass="error" /></td>
				<td>
					<div>Gender</div>
				</td>
				<td><form:radiobutton path="gender" value="true" />Male <form:radiobutton
						path="gender" value="false" />Female</td>
			</tr>
			<tr>
				<td>
					<div>Email</div>
				</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="error" /></td>
				<td></td>
				<td><input type="button" id="resetBtn" value="Reset"
					onclick="reset()"> <input type="submit" id="searchBtn"
					value="Search"></td>

			</tr>
		</table>
	</form:form>
	<table border="1" style="border-collapse: collapse">
		<tr>
			<td><form:form id="newForm" method="POST" action="create">
					<input type="submit" id="newBtn" value="New">
				</form:form></td>
			<td><form:form id="updateForm" method="POST" action="update">
					<input type="hidden" id="customerId" name="customerId">
					<input type="submit" id="updateBtn" value="Update">
				</form:form></td>
			<td><input type="submit" id="deleteBtn" value="Delete"></td>
			<td><form:form id="exportForm" method="GET" action="report">
					<input type="submit" id="exportBtn" value="Export">
				</form:form></td>
		</tr>
	</table>
	<div>
		<table border="1" style="border-collapse: collapse">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Date of Birth</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
			</thead>
			<c:forEach var="customer" items="${lstcustomer}">
				<tr>
					<td><input type="checkbox" name="${customer.id}"
						value="${customer.id}" onclick="fetchId(${customer.id})">
					</td>
					<td>${customer.name}</td>
					<td>${customer.dateOfBirth}</td>
					<td>${customer.phone}</td>
					<td>${customer.email}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	function reset() {
		document.getElementById("searchForm").reset();
	}
	function fetchId(id) {
		document.getElementById("customerId").value=id;
	}
</script>
</html>