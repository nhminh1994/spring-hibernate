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
<form:form method="POST" action="addEmployee" modelAttribute="employee">
	<table>
		<tr>
			<td>
				<div>Name</div>
			</td>
			<td><input type="text" id="searchName"></td>
			<td>
				<div>Phone</div>
			</td>
			<td><input type="text" id="searchPhone"></td>
		</tr>
		<tr>
			<td>
				<div>Date of Birth</div>
			</td>
			<td><input type="date" id="searchDob"></td>
			<td>
				<div>Gender</div>
			</td>
			<td><input type="radio" id="searchGender" name="searchGender"
				value="male"> <input type="radio" id="searchGender"
				name="searchGender" value="female"></td>
		</tr>
		<tr>
			<td>
				<div>Email</div>
			</td>
			<td><input type="text" id="searchEmail"></td>
			<td></td>
			<td><input type="button" id="resetBtn" value="Reset"> 
				<input type="button" id="searchBtn" value="Search"></td>

		</tr>
	</table>
</form:form>
</body>
</html>