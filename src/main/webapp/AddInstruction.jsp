<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Instruction</title>
</head>
<body>

 <jsp:include page="Header.jsp"></jsp:include>
 
  <div class="container-fluid">


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2> Add Instruction</h2>

				<form method="post" action="AddInstructionController">

					<div class="form-group">
						  Instruction Name : <input type="text" name="instruction name" class="form-control" />
					</div>

					<div class="form-group">
						Instruction Type  : <input type="text" name="type" class="form-control" />
					</div>
					<div class="form-group">
				      Description : <input type="text" name="description" class="form-control" />
					</div>
					<div class="form-group">
						Time  : <input type="time" name="time" class="form-control" />
					</div>

					<input type="submit" class="btn btn-success" value="Add" />
					<button type="reset" class="btn btn-danger">Reset</button>

				</form>

			</div>

		</div>

	</div>
</body>
</html>
