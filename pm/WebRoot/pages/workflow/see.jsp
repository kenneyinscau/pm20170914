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
                    <h1 class="page-header">解决任务</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           任务详情
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
                                              <%-- ${session.workRecord.worktype.wtid}  --%>
                                       
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
                                            <label>任务发起人</label>
                                           <!--   <s:property value = "#workRecord.userByUserByAuthorid.uid"/>-->
                                             ${session.workRecord.userByUserByAuthorid.uid} 
                                        </div>
                                         <label>任务传达给</label>
                                          <!--    <s:property value = "#workRecord.userByUserByTransactorId.uid"/> -->
                                          ${session.workRecord.userByUserByTransactorId.uid} 
                                         <div class="form-group">
                                            <label>任务发起时间</label>
                                          <!--    <s:property value = "#workRecord.createDates"/> -->
                                           ${session.workRecord.createDates} 
                                        </div>                                                    
                                        <div class="form-group">
                                            <label>任务内容</label>
                                          <!--    <s:property value = "#workRecord.content"/> -->
                                           ${session.workRecord.content} 
                                        </div>
                                    <form role="form" action = "work!submit.action"> 
                                    <div class="form-group">
                                            <label >你的任务完成结果</label>
                                        	 <textarea class="form-control" rows="3" name = "workResult.transactContent"></textarea>
                                        </div> 
                                        <div class="form-group">
                                            <label>评价</label>
                                            <select class="form-control" name = "workResult.status">
                                                <option value ="0">通过</option>
                                                <option value ="1">不通过</option>                                                                           
                                            </select>
                                        </div>
                                         <label>传达给下个人</label>
                                         <div class="form-group input-group">
                                            <span class="input-group-addon">@</span>
                                            <input type="text" class="form-control" placeholder="请输入传达人编号" name = "workResult.user.uid">
                                        </div>    
                                        <button type="submit" class="btn btn-default">提交</button>
                                        <button type="reset" class="btn btn-default">重置</button>
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
