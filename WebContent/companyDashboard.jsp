<%@page import="service.ServiceProvider"%>
<%@page import="java.util.LinkedHashSet"%>
<%
	// fetch the list of all the required data to show in the jsp page.

	LinkedHashSet<String> langs = ServiceProvider.getSubjects();

	String curr_company = String.valueOf(session.getAttribute("curr_company"));

	LinkedHashSet<String> passoutList = ServiceProvider.getPassoutList();

	LinkedHashSet<String> eduList = ServiceProvider.getEducationList();
%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Company Panel</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/metisMenu.min.css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/startmin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->







</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Company Panel</a>
			</div>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<!-- Top Navigation: Left Menu -->
			<ul class="nav navbar-nav navbar-left navbar-top-links">
				<!--<li><a href="http://localhost/project/cetpa"><i class="fa fa-home fa-fw"></i> Website</a></li>-->
			</ul>

			<!-- Top Navigation: Right Menu -->
			<ul class="nav navbar-right navbar-top-links">
				<li class="dropdown navbar-inverse">
					<!--  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-bell fa-fw"></i> <b class="caret"></b>
                </a>-->
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> New Comment <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									All Alerts</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						About Us<b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> Contact
								us</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Help</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-sign-out fa-fw"></i>
								Donate</a></li>
					</ul></li>
			</ul>

			<!-- Sidebar -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">

					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</li>
						<li><a href="" class="active"><i
								class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
						<li><a href="company.jsp" class="active"><i
								class="fa fa-lock"></i> Logout</a></li>
						<!-- <li>
                        <a href="deletequestion.jsp" class="active"><i class="fa fa-trash-o "></i> Delete_Question</a>
                    </li>
                    <li>
                        <a href="Search.html" class="active"><i class="fa fa-search"></i> Search</a>
                    </li> -->

					</ul>

				</div>
			</div>
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							{ Welcome
							<%=curr_company%>
							}
						</h1>
					</div>
				</div>

				<!-- ... Your content goes here ... -->
				<form action="SearchStudentFromCompany" method="POST">

					<!-- <div class="form-group">
						<label>Name of student(optional)</label> <input type="text"
							class="form-control" name="name">
					</div>

					<div class="form-group">
						<label>Email of student(Optional)</label> <input type="email"
							name="email" class="form-control">
					</div>
 -->
					<div class="form-group">
						<label>Gender &nbsp; &nbsp; &nbsp;</label> <input type="radio"
							name="gender" value="male"> Male &nbsp; &nbsp; <input
							type="radio" name="gender" value="female"> Female
					</div>
					<!-- <div class="form-group">
						<label>City(optional)</label> <input type="text" name="city"
							class="form-control">
					</div> -->

					<div class="form-group">
						<label>Education &nbsp&nbsp</label>


						<!-- show lang from database -->
						<%
							for (String ed : eduList) {
						%>

						<input type="checkbox" name="edu" value="<%=ed%>" />&nbsp&nbsp&nbsp<%=ed%>&nbsp&nbsp&nbsp

						<%
							}
						%>



					</div>


					<div class="form-group">
						<label>Passout &nbsp&nbsp </label>

						<!-- show lang from database -->
						<%
							for (String pas : passoutList) {
						%>

						<input type="checkbox" name="passout" value="<%=pas%>" />&nbsp&nbsp&nbsp<%=pas%>&nbsp&nbsp&nbsp

						<%
							}
						%>



					</div>

					<div class="form-group">
						<label>Programming lang &nbsp&nbsp </label>
						<!-- show lang from database -->
						<%
							for (String lang : langs) {
						%>

						<input type="checkbox" name="lang" value="<%=lang%>" />&nbsp&nbsp&nbsp<%=lang%>&nbsp&nbsp&nbsp

						<%
							}
						%>

					</div>

					<div class="form-group">
						<label>Grade&nbsp&nbsp</label> <select name="grade">
							<option value="0 - 30">0 - 30</option>
							<option value="30 - 60">30 - 60</option>
							<option value="60 - 90">60 - 90</option>
							<option value="90 - 100">90 - 100</option>
						</select>
					</div>

					<input type="submit" name="submit" value="Search"
						class="btn btn-block btn-success" style="width: 25%;">
				</form>






			</div>
		</div>

	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/startmin.js"></script>

</body>
</html>
