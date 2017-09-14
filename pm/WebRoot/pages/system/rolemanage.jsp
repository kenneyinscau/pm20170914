<%@ page contentType = "text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
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
       <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">角色管理</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
           <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            用户列表
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       <!--  <form role="form" action = "right!updateRole.action" method = "post">  -->
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>用户编号</th>
                                            <th>用户名</th>
                                            <th>角色</th>
                                        </tr>
                                    </thead>
                                    <s:set name = "users" value = "users" />
                                    <tbody>
                                        <s:iterator value = "users" id = "users">
                                        <tr>
                                        <td>
                                        <a href = "user!toRoleInfo.action?userid=<s:property value = "#users.uid"/>"><s:property value = "#users.uid"/></a>
                                        </td>
                                        <td>
                                        <s:property value = "#users.name"/>
                                        </td>
                                        <td>
                                            	<s:if test = "#users.role.roleId ==1">
                                                		项目经理
                                                </s:if>
                                                <s:if test = "#users.role.roleId ==2">
														需求人员       
                                                </s:if> 
                                                 <s:if test = "#users.role.roleId ==3">
														开发人员 
                                                </s:if>
                                                 <s:if test = "#users.role.roleId ==4"> 
														测试人员
                                                </s:if>   
                                                <s:if test = "#users.role.roleId ==5"> 
														数据库管理人员
                                                </s:if>                     
                                          
                                        </td>     
                                        </tr>
                                        </s:iterator>
                                    </tbody>
                                 </table>  
                            </div>
                            
                       <!-- 	 </form> -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
                </div>
                
         
                </div>
        <!-- /#page-wrapper -->
        
  

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/pm/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/pm/vendor/dist/js/pm.js"></script>
  </body>
</html>
