<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddMember</title>
</head>
<body>

 <jsp:include page="Header.jsp"></jsp:include>
 
  <div class="container-fluid">


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2> Add New Member</h2>

				<form method="post" action="AddMemberController">

					<div class="form-group">
						 Member Name : <input type="text" name="Member name" class="form-control" />
					</div>

					<div class="form-group">
						Contact Number  : <input type="text" name="price" class="form-control" />
					</div>
					<div class="form-group">
						Age : <input type="text" name="qty" class="form-control" />
					</div>
					<div class="form-group">
									Gender :- Male : <input type="radio" name="gender" value="male">
									Female : <input type="radio" name="gender" value="female">
								</div>


					<input type="submit" class="btn btn-success" value="Add" />
					<button type="reset" class="btn btn-danger">Reset</button>

				</form>

			</div>

		</div>

	</div>
</body>
</html>