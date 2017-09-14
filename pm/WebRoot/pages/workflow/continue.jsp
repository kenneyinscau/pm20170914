<%@ page contentType = "text/html;charset=gb2312"%>
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
                    <h1 class="page-header">查看工作</h1>
                </div>
                 <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            工作列表	
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                    	
                                   		<th>任务编号</th>
                                        <th>工作名称</th>
                                        <th>任务发起者</th>
                                        <th>任务接收人</th>
                                        <th>任务状态</th>
                                        <th>完成</th>
                                        
                                    </tr>
                                </thead>
                                <s:set name = "workrecords" value = "workrecords" />
                                <tbody>
                                	   <s:iterator value = "workrecords" id = "workrecords">
                                    <tr class="odd gradeX">
                                  	  <td class="center"><s:property value = "#workrecords.wrid"/></td>
                                        <td> <s:property value = "#workrecords.title"/></td>
                                        <td><s:property value = "#workrecords.userByUserByAuthorid.uid"/></td>
                                        <td><s:property value = "#workrecords.userByUserByTransactorId.uid"/></td>
                                        <td class="center"><%-- <s:property value = "#workrecords.status"/> --%>
                                         <s:if test = "#workrecords.status ==4">
                                                		被拒绝
                                                </s:if>
                                                 <s:if test = "#workrecords.status ==0">
                                                		进行中
                                                </s:if>
                                        
                                        </td>
                                        <td class="center"> 
                                        <form action = "work!doWaitWork.action" method = "post">
                                        <input type ="hidden" name = "workRecordid" value = "<s:property value = "#workrecords.wrid"/>"/>
                                        <input type = "submit" value = "进入"/>
                                        </form>
                                        </td>
                                        
                                    </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                   
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
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
