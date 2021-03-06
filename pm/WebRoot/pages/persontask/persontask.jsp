﻿<%@ page contentType = "text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>IT项目任务管理系统</title>

<!-- Bootstrap Core CSS -->
<link href="/pm/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/pm/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/pm/vendor/dist/css/pm.css" rel="stylesheet">

<!-- Morris Charts CSS -->
 <link href="/pm/vendor/morrisjs/morris.css" rel="stylesheet"> 

<!-- Custom Fonts -->
<link href="/pm/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<div id="wrapper">
		<div id="page-wrapper">
			<!-- /.col-lg-6 -->
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">项目进度</div>
					<!-- /.panel-heading -->
					 <div class="panel-body">
						<div id="morris-donut-chart"></div>
					</div> 
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->




	<!-- Metis Menu Plugin JavaScript -->
	<script src="/pm/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	 <script src="/pm/vendor/raphael/raphael.js" charset ="utf-8"></script> 
	 <script src="/pm/vendor/morrisjs/morris.min.js" charset ="utf-8"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/pm/vendor/dist/js/pm.js"></script>
	<script type="text/javascript" charset="utf-8">
	$(function() {
	var finishCount=${finishCount};
	var nonfinishCount=${nonfinishCount};
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "任务完结",
            value: finishCount
        }, {
            label: "任务进行中",
            value: nonfinishCount
        }],
        resize: true
    }); 
  
});
</script>

	
</body>
</html>