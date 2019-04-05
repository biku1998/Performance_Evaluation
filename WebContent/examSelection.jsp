<%@page import="service.ServiceProvider"%>
<%@page import="java.util.LinkedHashSet"%>
<%
// fetch all the subject that are avaliable.

LinkedHashSet<String> sub_aval = ServiceProvider.getSubjects();

String err_msg = String.valueOf(session.getAttribute("error_msg"));

if(!err_msg.equalsIgnoreCase("null"))
{
	%> <script> 
		alert('<%=err_msg%>')
		</script>
	
	<%
}
%>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
     <meta charset="UTF-8">
 
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="csstable/style.css">

    <title>Exam portal</title>

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
            <a class="navbar-brand" href="#"><i class="fa fa-clock-o" aria-hidden="true"></i>Examination Portal</a>
        </div>

        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
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
                    <li>
                        <a href="#">
                            <div>
                                <i class="fa fa-comment fa-fw"></i> New Comment
                                <span class="pull-right text-muted small">4 minutes ago</span>
                            </div>
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="text-center" href="#">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> About Us<b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> Contact us</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Help</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Donate</a>
                    </li>
                </ul>
            </li>
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
                    <li>
                        <a href="index.jsp" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <!--   <li>
                        <a href="admin.html" class="active"><i class="fa fa-lock fa-fw"></i> Admin</a>
                    </li>
                    <li>
                        <a href="company.html" class="active"><i class="fa fa-building fa-fw"></i> Company</a>
                    </li>-->
                    <li>
                        <a href="#"><i class="fa fa-graduation-cap fa-fw"></i> Student<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                           <li>
                                <a href="signup.jsp">SignUp</a>
                            </li>
                            <li>
                                <a href="">SignIn <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="login.jsp">Login</a>
                                    </li>
                                     <li>
                                        <a href="ForgotPasswordView.jsp">Forgot-Password</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">{ exams offered  by  us }</h1>
                </div>
            </div>

            <!-- ... Your content goes here ... -->
					           <h1></h1>
					<form action="getQuestions" method="post">
					<table class="responstable">
					  
					  <tr>
					    <th>Select</th>
					    <th data-th="Driver details"><span>Technology</span></th>
					    <th>Examination_Type</th>
					    <th>Duration</th>
					    <th>Description</th>
					  </tr>
					  <% 
					  for(String sub : sub_aval){
						  %>
						  <tr>
						    <td><input type="radio" name="subject" value="<%=sub%>"/></td>
						    <td><%=sub.toUpperCase()%></td>
						    <td>Mcq</td>
						    <td>1 hours</td>
						    <td>Based on <%=sub.toUpperCase()%> Basics and Frameworks.</td>
						  </tr> <%
					  }
					 %>
					  
					 
					<tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td><input   type="submit" name="submit"  value="Proceed" class="btn btn-block btn-success"style="width:75%;"></td>
					  </tr>
					  
					</table></form>
					
					  <script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>
					          
					                         


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
