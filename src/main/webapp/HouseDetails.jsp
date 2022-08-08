<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddMember</title>
</head>
<body>

 
 
  <div class="container-fluid">


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2> Add House number</h2>

				<form method="post" action="HouseDetailController">

					
					<div class="form-group">
						House no.  : <input type="text" name="houseDetail" class="form-control" />
					</div>
					

					<input type="submit" class="btn btn-success" value="Add" />
					

				</form>

			</div>

		</div>

	</div>
</body>
</html>