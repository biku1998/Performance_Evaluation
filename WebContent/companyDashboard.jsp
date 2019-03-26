<!DOCTYPE html>
<html lang="en">
<head>


<style >
.select-style {
    padding: 0;
    margin: 0;
    border: 1px solid #ccc;
    width: 200px;
    border-radius: 3px;
    overflow: hidden;
    background-color: #fff;

    background: #fff url("http://www.scottgood.com/jsg/blog.nsf/images/arrowdown.gif") no-repeat 90% 50%;
}

.select-style select {
    padding: 5px 8px;
    width: 130%;
    border: none;
    box-shadow: none;
    background-color: transparent;
    background-image: none;
    -webkit-appearance: none;
       -moz-appearance: none;
            appearance: none;
}

.select-style select:focus {
    outline-style: ;
    outline-color: black;
}

.button {
    background-color: #f44336; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
Try it Yourself »



</style>
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
                        <a href="" class="active"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
		  			 <li>
                        <a href="compandest.jsp" class="active"><i class="fa fa-lock"></i> Logout</a>
                    </li>
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
                    <h1 class="page-header">* Welcome  *</h1>
                </div>
            </div>

            <!-- ... Your content goes here ... -->
            <form action="searchresult.jsp" method="post">
            <div style="height: 90px; width: 50%; background-color: #DCDCDC; float: left;">
             <br><h3 style="font-family: cooper; color: 	#6495ED ">Course</h3>       
				            <br><div class="select-style" style="position: fixed; text-align: center; ">
				  <select name="course">
				    <option value="bca">BCA</option>
				    <option value="mca">MCA</option>
				    <option value="btech">Btech</option>
				    <option value="mtech">Mtech</option>
				    <option value="others">Others</option>
				  </select>
				</div>
            
            
            </div>
            <div style="height: 90px; width: 50%; background-color: #DCDCDC; float: left; ">
            <br><h3 style="font-family: cooper; color: 	#6495ED ">Technology</h3>       
				            <br><div class="select-style" style="position: absolute; text-align: center;">
				  <select name="tech">
				    <option value="c">C</option>
				    <option value="c++">C++</option>
				    <option value="java">Java</option>
				    <option value="c#">c#</option>
				    <option value="python">Python</option>
				     <option value="php">Php</option>
				  </select>
				</div>
            
            </div>
            <div style="height: 90px; width: 50%; background-color: #DCDCDC; float: left;">
            <br><h3 style="font-family: cooper; color: 	#6495ED ">Grade(low)</h3>       
				            <br><div class="select-style" style="position: absolute;float:left; text-align: center;">
				  <select name="lgrade">
				    <option value="40">40</option>
				    <option value="50">50</option>
				    <option value="60">60</option>
				    <option value="70">70</option>
				    <option value="80">80</option>
				    <option value="90">90</option>
				  </select>
				</div>
                       
            
            
            
            
            
            </div>
            <div style="height: 90px; width: 50%; background-color: #DCDCDC; float: left; ">
             <br><h3 style="font-family: cooper; color: 	#6495ED ">Grade(high)</h3>       
				            <br><div class="select-style" style="position: absolute;float:left; text-align: center;">
				  <select name="hgrade">
				    <option value="50">50</option>
				    <option value="60">60</option>
				    <option value="70">70</option>
				    <option value="80">80</option>
				    <option value="90">90</option>
				    <option value="100">100</option>
				  </select>
				</div>
            
            
            </div>
            <div style="height: 100px; width: 50%; background-color: #DCDCDC; float: left;">
             <br><h3 style="font-family: cooper; color: 	#6495ED ">Passing Year</h3>       
				            <br><div class="select-style" style="position: absolute;float:left; text-align: center;">
				  <select name="passyear">
				   <option value="2014-2015">2014-2015</option>
                    <option value="2015-2016">2015-2016</option>
                    <option value="2016-2017">2016-2017</option>
				  </select>
				</div>
            
            </div>
            <div style="height: 100px; width: 50%; background-color: #DCDCDC; float: left; ">
            
             <br><h3 style="font-family: cooper; color: 	#6495ED ">Gender</h3>    
            <input type="radio" name="gen" value="male">Male&nbsp;<input type="radio" name="gen" value="female">Female&nbsp;
            <input type="radio" name="gen" value="others">Others
            
            
            </div>
            <div style="height: 150px; width: 50%; background-color: #DCDCDC; float: left;">
            
           
            
            </div>
            <div style="height: 150px; width: 50%; background-color: #DCDCDC; float: left; ">
            <br><br><input type="submit"  name="submit" value="Get-It" class="button"></div>
            
            
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
