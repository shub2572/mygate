<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>

<header>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white">
    <div class="container-fluid">
      <button
        class="navbar-toggler"
        type="button"
        data-mdb-toggle="collapse"
        data-mdb-target="#navbarExample01"
        aria-controls="navbarExample01"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
            <a class="nav-link" aria-current="page" href="Page.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListUserController">ListMember</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="AddSecurity.jsp">Add Security</a>
          </li>       
          
       <li class="nav-item">
            <a class="nav-link" href="PendingRequestController">Pending Requests</a>
          </li>         
          <li class="nav-item">
            <a class="nav-link" href="LogoutController">Logout</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
 
</header>


</body>
</html>