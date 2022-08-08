<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddSecurity</title>
</head>
<body>

	<jsp:include page="AdminPanel.jsp"></jsp:include>

	<div class="container-fluid">


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2>Add New Security</h2>

				<form method="post" action="AddSecurityController">

					<div class="form-group">
						Security Name : <input type="text" name="firstName"
							class="form-control" />
					</div>
                      <div class="form-group">
						LastName : <input type="text" name="lastName"
							class="form-control" />
					</div>
					<div class="form-group">
						Contact Number : <input type="number" name="contact"
							class="form-control" />
					</div>
					<div class="form-group">
						Password : <input type="password" name="password"
							class="form-control" />
					</div>
					
					


					<input type="submit" class="btn btn-success" value="Add" />
					<button type="reset" class="btn btn-danger">Reset</button>

				</form>

			</div>

		</div>

	</div>
</body>
</html>