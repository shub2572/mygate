<%@page import="Bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
</head>
<body>
<jsp:include page="AdminPanel.jsp"></jsp:include>


<%
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
%>

<div class="container-fluid">
<div class="row">
<div class="col-md-1"></div>
<div class="col-md-12">
<h2 align="center">List Users</h2><br>

<!--  <div class="p-3 mb-2 bg-success text-white">-->
${successMsg}
${updateMsg}
<!-- </div> -->
${errorMsg}

<table id="users" class="table display">
<thead class="thead-dark">
	<tr>
		<th>UserId</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Gender</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<% 
		for (UserBean user : users){
	%>
	
	<tr>
		<td><%=user.getUserId() %></td>
		<td><%=user.getFirstName() %></td>
		<td><%=user.getLastName() %></td>
		<td><%=user.getEmail() %></td>
		<td><%=user.getGender() %></td>
		<td><%=user.getStatus() %></td>
		<td><a href="ApproveUserController?userid=<%=user.getUserId()%>"><i class="fas fa-edit"></i></a>&nbsp;&nbsp;&nbsp;<a href="DeclineUserController?userid=<%=user.getUserId()%>"><i class="fas fa-edit"></i></a>
		</td>
	</tr>
	
	<% } %>
</tbody>	
</table>
</div>
</div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function () {
    $('#users').DataTable();
});
</script>

</body>
</html>