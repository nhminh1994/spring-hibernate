<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="CustomTagLib" uri="CustomTagLib"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/error.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/sort.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/myjs.js" />"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet prefetch"
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>

<%-- <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet"> --%>

<title>Customer List</title>
</head>
<body>
	<div class="container">
		<form:form id="searchForm" method="POST" action="customers"
			modelAttribute="customersearchdata">
			<div class="table-responsive">
				<table>
					<tr>
						<td><div class="form-group">
								<div>Name</div>
							</div></td>

						<td><div class="form-group">
								<form:input class="form-control" path="name" />
								<form:errors path="name" cssClass="error" />
							</div></td>
						<td><div class="form-group">
								<div>Phone</div>
							</div></td>
						<td><div class="form-group">
								<form:input class="form-control" path="phone"
									onkeypress="return AllowOnlyNumbers(event);" />
								<form:errors path="phone" cssClass="error" />
							</div></td>
					</tr>
					<tr>
						<td><div class="form-group">
								<div>Date of Birth</div>
							</div></td>
						<td><div class="form-group">
								<%-- <form:input class="form-control" type="date" path="dateOfBirth"
									min="1970-01-01" /> --%>
								<div class="input-group date" data-provide="datepicker"
									data-date-format="dd/mm/yyyy">
									<form:input path="dateOfBirth" type="text" class="form-control" />
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-th"></span>
									</div>
								</div>
								<form:errors path="dateOfBirth" cssClass="error" />
							</div></td>
						<td><div class="form-group">
								<div>Gender</div>
							</div></td>
						<td><div class="form-group">
								<form:radiobutton path="gender" value="true" />
								Male
								<form:radiobutton path="gender" value="false" />
								Female
							</div></td>
					</tr>
					<tr>
						<td><div class="form-group">
								<div>Email</div>
							</div></td>
						<td><div class="form-group">
								<form:input class="form-control" path="email" />
								<form:errors path="email" cssClass="error" />
							</div></td>
						<td><div class="form-group"></div></td>
						<td><div class="form-group">
								<input type="button" id="resetBtn" value="Reset"
									onclick="resetProcess()" class="btn btn-default"> <input
									type="button" id="searchBtn" value="Search"
									class="btn btn-default">
							</div></td>
					</tr>
				</table>
			</div>
			<form:hidden path="currentPage" />
			<form:hidden path="numOfPage" />
			<form:hidden path="sortName" class="sort" />
			<form:hidden path="sortDob" class="sort" />
			<form:hidden path="sortPhone" class="sort" />
			<form:hidden path="sortEmail" class="sort" />
		</form:form>
		<table>
			<tr>


				<td><div class="form-group">
						<form:form id="createForm" method="POST" action="customer">
							<input type="button" id="newBtn" value="New"
								class="btn btn-default">
						</form:form>
					</div></td>
				<td><div class="form-group">
						<input type="button" id="updateBtn" value="Update"
							class="btn btn-default"> <input type="hidden"
							id="customerId" name="customerId">
					</div></td>
				<td><div class="form-group">
						<form:form id="deleteForm" method="GET" action="delete">
							<input type="hidden" id="customerIds" name="customerIds">
							<input type="button" id="deleteBtn" value="Delete"
								class="btn btn-default">
						</form:form>
					</div></td>
				<td><div class="form-group">
						<form:form id="exportForm" method="GET" action="report">
							<input type="submit" id="exportBtn" value="Export"
								class="btn btn-default">
						</form:form>
					</div></td>
			</tr>
		</table>
		<div class="table-responsive">
			<table class="table" id="listTable">
				<thead>
					<tr>
						<th></th>
						<th>Name <span
							onclick="sortClick('Name','${customersearchdata.sortName}')"
							class="sort-arrow">${customersearchdata.sortName}</span></th>
						<th>Date of Birth <span
							onclick="sortClick('Dob','${customersearchdata.sortDob}')"
							class="sort-arrow">${customersearchdata.sortDob}</span></th>
						<th>Phone <span
							onclick="sortClick('Phone','${customersearchdata.sortPhone}')"
							class="sort-arrow">${customersearchdata.sortPhone}</span></th>
						<th>Email <span
							onclick="sortClick('Email','${customersearchdata.sortEmail}')"
							class="sort-arrow">${customersearchdata.sortEmail}</span></th>
					</tr>
				</thead>
				<c:forEach var="customer" items="${lstcustomer}">
					<tr>
						<td><div class="form-group">
								<input type="checkbox" name="${customer.id}"
									value="${customer.id}" onclick="fetchId(${customer.id})">
							</div></td>
						<td><div class="form-group">${customer.name}</div></td>
						<td><div class="form-group">${customer.dateOfBirth}</div></td>
						<td><div class="form-group">${customer.phone}</div></td>
						<td><div class="form-group">${customer.email}</div></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pull-right">
				<CustomTagLib:pagenavigation
					current="${customersearchdata.currentPage}"
					max="${customersearchdata.numOfPage}" />
			</div>
		</div>


		<form action="<c:url value="/j_spring_security_logout" />"
			method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit" value="Logout"
				class="btn btn-default" />
		</form>
	</div>
</body>
<script>
	function resetProcess() {
		$(':input','#searchForm')
		  .not(':button, :submit, :reset, :hidden')
		  .val('')
		  .removeAttr('checked')
		  .removeAttr('selected');
	}
	function fetchId(id) {
		document.getElementById("customerId").value=id;
	}
	function newClick(){
		$('#createForm').submit();
	}
	function pageNavClick(o){
		$('#currentPage').val(o.value);
		$('#searchForm').submit();
	}
	function searchClick(){
		var validator = $('#searchForm')[0].reportValidity();
		if (!validator)
			return;
		$('.sort').val("");
		$('#currentPage').val("");
		$('#numOfPages').val("");
		$('#searchForm').submit();
	}
	function updateClick(){
		var id = document.getElementById( "customerId" ).value;
		var updateForm = $('#updateForm');
		var url = "${pageContext.request.contextPath}/customer/"+id;
		window.location=url;
	}
	function deleteClick(){
		
		var ids = "";
		$('input[type=checkbox]','#listTable').each(function (){
			if (this.checked)
				ids += $(this).val() + "/";
		})
		document.getElementById("customerIds").value=ids;
		if (ids != ""){
			var r = confirm("Do you want to delete?");
			if (r == false){
				return;
			}
			$('#deleteForm').submit();
		}	
	}
	function sortClick(name, method){
		$('.sort').val("");
		var id = "sort"+name;
		document.getElementById(id).value=method;
		$('#searchForm').submit();
	}
	$('.pageNav').attr("onclick","pageNavClick(this)");
	$('#newBtn').attr("onclick","newClick()");
	$('#searchBtn').attr("onclick","searchClick()");
	$('#updateBtn').attr("onclick","updateClick()");
	$('#deleteBtn').attr("onclick","deleteClick()");
</script>
</html>