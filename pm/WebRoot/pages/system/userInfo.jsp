<%@ page contentType = "text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
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

    <!-- Custom Fonts -->
    <link href="/pm/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
  <jsp:include page = "../head.jsp"></jsp:include>
    <div id="wrapper">
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">用户信息</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           填写信息
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>用户名</label>
                                            <s:property value = "#user.name"></s:property>
                                        </div>   
                                        <div class="form-group">
                                            <label>旧密码</label>
                                             <s:property value = "#user.password"></s:property>
                                        </div>
                                         <form  action = "user!updateUser.action" method = "post" name = "login">  
                                        <div class="form-group">
                                            <label>新密码</label>
                                            <input id="newpassword" class="form-control" name = "user.password"/>
                                        </div>                                                          
                                       <button type="submit" class="btn btn-default">确定</button>
                                        <button type="reset" class="btn btn-default">取消</button>
                                    </form>
                                </div>
                              
                               
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


    <!-- Metis Menu Plugin JavaScript -->
    <script src="/pm/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/pm/vendor/dist/js/pm.js"></script>

</body>

</html>
