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
                    <h1 class="page-header">用户列表</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
           <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="user!toNewUser.action">新增</a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>用户编号</th>
                                            <th>用户名</th>
                                            <th>使用状态</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <s:set name = "users" value = "users" />
                                    <tbody>
                                        <s:iterator value = "users" id = "users">
                                        <tr>
                                        <td>
                                        <a href = "user!toChangeInfo.action?userid=<s:property value = "#users.uid"/>"><s:property value = "#users.uid"/></a>
                                        </td>
                                        <td>
                                        <s:property value = "#users.name"/>
                                        </td>
                                        <td>
                                         <s:if test = "#users.userState ==0">
													未激活
                                                </s:if> 
                                          <s:if test = "#users.userState ==1">
                                                	激活中 
                                                </s:if> 
                                                </select>
                                        </td>
                                        <td>
                                        <form role="form" action = "user!deleteUser.action" method = "post">
                                        	<input type="hidden" name="userid" value="<s:property value="#users.uid"/>"/>
                                           <input type="submit" value="删除"/>
                                           </form>
                                        </td>
                                        </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
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
