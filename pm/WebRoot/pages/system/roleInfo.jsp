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
                    <h1 class="page-header">角色信息</h1>
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
                                            <label>先前角色</label>
                                             <s:if test = "#user.role.roleId ==1">
                                                		项目经理
                                                </s:if>
                                                <s:if test = "#user.role.roleId ==2">
														需求人员       
                                                </s:if> 
                                                 <s:if test = "#user.role.roleId ==3">
														开发人员 
                                                </s:if>
                                                 <s:if test = "#user.role.roleId ==4"> 
														测试人员
                                                </s:if>   
                                                <s:if test = "#user.role.roleId ==5"> 
														数据库管理人员
                                                </s:if>    
                                        </div>
                                   <form  action = "user!updateRole.action" method = "post" name = "login">
                                        <div class="form-group">            
                                            <label>新角色</label>
                                            <select class="form-control" name = "roleid">
                                                <option value ="1">项目经理</option>
                                                <option value ="2">需求人员</option>
                                                <option value ="3">开发人员</option>
                                                <option value ="4">测试人员</option>                                          
                                            </select>
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
