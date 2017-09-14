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
                    <h1 class="page-header">任务结果</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                          	完结明细
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                   
                                        <div class="form-group">
                                            <label >任务名</label>
                                            <!--   <s:property value = "#workRecord.title"/> -->
                                            ${session.workRecord.title} 
                                        </div>                               
                                        <div class="form-group">
                                            <label>任务类型</label>
                                            <!-- <s:property value = "#workRecord.worktype.wtid"/>-->
                                          <%--     ${session.workRecord.worktype.wtid}  --%>
                                              
                                              <s:if test = "#session.workRecord.worktype.wtid ==1">
                                                		需求分析
                                                </s:if>
                                                <s:if test = "#session.workRecord.worktype.wtid ==2">
														概要设计
                                                </s:if> 
                                                 <s:if test = "#session.workRecord.worktype.wtid==3">
														详细设计
                                                </s:if>
                                                 <s:if test = "#session.workRecord.worktype.wtid==4">
														系统开发
                                                </s:if>
                                                <s:if test = "#session.workRecord.worktype.wtid==5">
														拒绝流程
                                                </s:if>
                                        </div>
                                        <div class="form-group">
                                            <label>发起者</label>
                                           <!--   <s:property value = "#workRecord.userByUserByAuthorid.uid"/>-->
                                             ${session.workRecord.userByUserByAuthorid.uid} 
                                        </div>
                                         <div class="form-group">
                                         <label>接收人</label>
                                          <!--    <s:property value = "#workRecord.userByUserByTransactorId.uid"/> -->
                                          ${session.workRecord.userByUserByTransactorId.uid} 
                                        </div>
                                         <div class="form-group">
                                            <label>创建时间</label>
                                          <!--    <s:property value = "#workRecord.createDates"/> -->
                                           ${session.workRecord.createDates} 
                                        </div>                                                    
                                        <div class="form-group">
                                            <label>内容</label>
                                          <!--    <s:property value = "#workRecord.content"/> -->
                                           ${session.workRecord.content} 
                                        </div>
                                        <div class="form-group">
                                            <label>结果内容</label>
                                        
                                       <%-- <s:property value = "workResult.transactContent"/>  --%>
                                           ${session.workResult.transactContent}  
                                        </div>
                                        <div class="form-group">
                                            <label>结束时间</label>
                                         
                                           <%--  <s:property value = "workResult.transactDate"/>  --%>
                                        ${session.workResult.transactDate}
                                        </div> <div class="form-group">
                                            <label>结束状态</label>
                                          <!--    <s:property value = "#workRecord.content"/> -->
                                         <%--  <s:property value = "workResult.status"/> --%>
                                        
                                        <s:if test = "#session.workResult.status  ==0">
                                                		同意
                                                </s:if>
                                                <s:if test = "#session.workResult.status ==1">
														不同意
                                                </s:if> 
                                                 
                                        </div>
                                       
                                   
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
