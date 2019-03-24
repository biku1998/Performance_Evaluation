<!-- here we will fetch the user details and show the marks. -->






<!DOCTYPE html>
<html lang="en">
<head>
<style >
.button {
    background-color: #0B8;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.maxl{
  margin:25px ;
}
.inline{
  display: inline-block;
}
.inline + .inline{
  margin-left:10px;
}
.radio{
  color:#999;
  font-size:15px;
  position:relative;
}
.radio span{
  position:relative;
   padding-left:20px;
}
.radio span:after{
  content:'';
  width:15px;
  height:15px;
  border:3px solid;
  position:absolute;
  left:0;
  top:1px;
  border-radius:100%;
  -ms-border-radius:100%;
  -moz-border-radius:100%;
  -webkit-border-radius:100%;
  box-sizing:border-box;
  -ms-box-sizing:border-box;
  -moz-box-sizing:border-box;
  -webkit-box-sizing:border-box;
}
.radio input[type="radio"]{
   cursor: pointer; 
  position:absolute;
  width:100%;
  height:100%;
  z-index: 1;
  opacity: 0;
  filter: alpha(opacity=0);
  -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"
}
.radio input[type="radio"]:checked + span{
  color:#0B8;  
}
.radio input[type="radio"]:checked + span:before{
    content:'';
  width:5px;
  height:5px;
  position:absolute;
  background:#0B8;
  left:5px;
  top:6px;
  border-radius:100%;
  -ms-border-radius:100%;
  -moz-border-radius:100%;
  -webkit-border-radius:100%;
}





</style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
    <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="csstable/style.css">

    <title>Student Report</title>

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
            <a class="navbar-brand" href="#">..Result..</a>
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
                    <i class="fa fa-user fa-fw"></i> <%=email %><b class="caret"></b>
                </a>
                <ul class="dropdown-menu dropdown-user">
                
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> Contact us</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Help</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Donate</a>
                    </li>
                    <li><a href="student.html"><i class="fa fa-user fa-fw"></i> Logout</a>
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
                   <!--  <li>
                        <a href="index.html" class="active"><i class="fa fa-dashboard fa-fw"></i>  Next Question</a>
                    </li>
                     <li>
                        <a href="admin.html" class="active"><i class="fa fa-lock fa-fw"></i>  Previous Question</a>
                    </li>
                    <li>  -->
                       <%-- <a href="company.html" class="active" >  <h4><i class="fa fa-ban" aria-hidden="true"></i> End Exam</h4></a>
                    </li>--%> 
                  <!--   <li>
                        <a href="student.html"><i class="fa fa-graduation-cap fa-fw"></i> Student<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                           <li>
                                <a href="stusignup.html">SignUp</a>
                            </li>
                            <li>
                                <a href="">SignIn <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="student.html">Login</a>
                                    </li>
                                     <li>
                                        <a href="stufpass.html">Forgot-Password</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
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
                    <h1 class="page-header" style="color: steelblue;">..Report..</h1>
                </div>
            </div>

            <!-- ... Your content goes here ... -->
            <div style="height: 800px; width: 1000px; background-color:white; border: solid 2px #999;">
            
             
								            
					            <h1>Report <span>of</span> <span><%=email %></span></h1>
					
					<% out.println("<table class=responstable>");
					
					  
					  out.println("<tr>");
					    
					    out.println("<th data-th=Driver details><span>Sr No </span></th>");
					    out.println("<th>Your answer</th>");
					    out.println("<th>Correct answer</th>");
					    
					  out.println("</tr>");
					while(rs.next()){
						sno=rs.getInt("sno");
						a = rs.getString("cans");
						ua= rs.getString("uans");
						
						
						
						
					
					
					  
					 out.println(" <tr>");
					    
					    out.println("<td>");
					    out.println(sno);
					    out.println("</td>");
					    out.println("<td>");
					    out.println(a);
					    out.println("</td>");
					    out.println("<td>");
					    out.println(ua);
					    out.println("</td>");
					    
					  out.println("</tr>");
					  if(a.equalsIgnoreCase(ua)){
						  g++;
					  }
					  
					}
					//out.println(g);
					out.println("</table>");
					  out.println("<script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script><hr>");
					  out.println("<ul>");
					  out.println("<li><h4>Each Question carry 20 marks *</h4></li>");
					  //out.println("<li><h4>No Of question Attempted:-</h4></li>");
					  out.print("<li><h4>Correct: ");
					  out.println(g);
					  out.println("</h4></li>");
					  out.print("<li><h4>InCorrect: ");
					  out.println(4-g);
					  out.println("</h4></li>"); 
					  
					  out.println("</h4></li>");
					  out.print("<li><h4>Grade: ");
					  out.println(20*g);
					  out.println("</h4></li>"); 
					  
					  out.println("</ul> ");  
					  //out.println(top);
					  PreparedStatement sp = conn.prepareStatement("update studentinfo set grade =? , exam = ? where email = ? ");
                      int  gr=20*g;


					  sp.setInt(1, gr);
					  sp.setString(2, top);
					  sp.setString(3, email);
					  
					  int rq = sp.executeUpdate();       
					            
					         
					            
       
					   %>
            
            
            
            
            </div>
                         


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
