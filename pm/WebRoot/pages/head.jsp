<%@ page contentType = "text/html;charset=gb2312"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

    <!-- Morris Charts CSS -->
    <link href="/pm/vendor/morrisjs/morris.css" rel="stylesheet">

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
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/pm/pages/menu.jsp">IT项目任务管理系统</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
            
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="user!toUserInfo.action"><i class="fa fa-user fa-fw"></i>用户信息</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i>配置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="user!logout.action"><i class="fa fa-sign-out fa-fw"></i>注销</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
			
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="输入用户名搜索人员编号" id ="name"></input>
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button" id ="nameclick">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                    
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i>
                          	常用菜单
                           </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>工作流<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="work!toCreate.action">发起工作</a>
                                </li>
                                <li>
                                    <a href="work!findWaitWork.action">查看工作</a>
                                </li>
                                <li>
                                    <a href="work!findMyWork.action">完成结果</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                            
                            
                 
                        </li>
                        <li>
                            <a href="task!findWorkCount.action"><i class="fa fa-table fa-fw"></i>项目进度</a>
                        </li>
                        <li>
                        
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>邮箱<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                                <li>
                                    <a href="mail!getAllMail.action">收件箱</a>
                                </li>
                                <li>
                                    <a href="mail!toSend.action">发件箱</a>
                                </li>
                                <li>
                                    <a href="mail!getReadMail.action">垃圾箱</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                            
                   
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>公告<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="affiche!toTeamMail.action">发起公告</a>
                                </li>
                                <li>
                                    <a href="affiche!findAfficheList.action">公告管理</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                            
                      
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i>系统管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="user!findUserList.action">用户管理</a>
                                </li>
                                <li>
                                    <a href="right!findRoleList.action">角色管理</a>
                                </li>      
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        
      
        </nav>
     
     
     <!-- jQuery -->
    <script src="/pm/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/pm/vendor/bootstrap/js/bootstrap.min.js"></script>
        
    <!-- Metis Menu Plugin JavaScript -->
    <script src="/pm/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/pm/vendor/raphael/raphael.min.js"></script>
    <script src="/pm/vendor/morrisjs/morris.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="/pm/vendor/dist/js/pm.js"></script>
    
    <script type="text/javascript">
   $(document).ready(function(){ 
$("#nameclick").click(function(){
var name =$("#name").val();
   $.ajax({ 
        //这里的需要Struts.xml的<action/>的name属性一致。
       url:'user!findNo.action',
       //提交数据给Action传入数据 
       data:{'name':name}, 
       //返回的数据类型
       dataType:'json', 
       //成功是调用的方法
       success:function(data){ 
	/*    var obj = $.parseJSON(data);  //使用这个方法解析json
       	var message = obj.validate;  */
       //获取Action返回的数据用  data.Action中的属性名 获取
       alert(data);
      /*   $("#msg").append(data.msg); */
          },
	error:function(e) {
	alert(e);
}  
     });
  });
  });
    </script>
  </body>
</html>
