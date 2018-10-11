<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>Customer Information</h3>
		<br>
		<form:form id="detailForm" method="POST" action="processupdate"
			modelAttribute="customerdetaildata">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>
						<div>Name</div>
					</td>
					<td><form:input path="name" /> <form:errors path="name"
							cssClass="error" /></td>
				</tr>
				<tr>
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
					<td><form:input path="email" /> <form:errors path="email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Address</div>
					</td>
					<td><form:textarea path="addressLine" /> <form:errors
							path="addressLine" cssClass="error" /></td>
				</tr>
				<tr>
					<td>
						<div>Title</div>
					</td>
					<td><form:select path="title">
							<form:options items="${titlemap}" />
						</form:select> <form:errors path="title" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="button" id="resetBtn" value="Reset"
						onclick="reset()"> <input type="submit" id="saveBtn"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>