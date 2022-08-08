<%@page import="Bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
</head>
<body>
	<jsp:include page="AdminPanel.jsp"></jsp:include>


	<%
	ArrayList<MemberBean> members = (ArrayList<MemberBean>) request.getAttribute("members");
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h2 align="center">List Members</h2>
				<br>


				<table id="users" class="table display">
					<thead class="thead-dark">
						<tr>
							<th>HouseId</th>
							<th>FirstName</th>
							<th>Gender</th>
							<th>Contact</th>
							<th>Age</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (MemberBean member : members) {
						%>

						<tr>
							<td><%=member.getHouseId()%></td>
							<td><%=member.getFirstName()%></td>
							<td><%=member.getGender()%></td>
							<td><%=member.getContact()%></td>
							<td><%=member.getAge()%></td>

							<td><a
								href="UpdateMemberFormController?userId=<%=member.getMemberId()%>"><i
									class="fas fa-edit"></i></a>&nbsp;&nbsp;&nbsp; <a
								href="DeleteMemberController?userId=<%=member.getMemberId()%>"><i
									class="fa fa-trash text text-danger"></i></a></td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>

</body>
</html>