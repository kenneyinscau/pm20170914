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
                    <h1 class="page-header">注册新的用户</h1>
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
                                    <form  action = "user!addUser.action" method = "post" name = "login">
                                        <div class="form-group">
                                            <label>用户名</label>
                                            <input id="name1" class="form-control" name = "user.name">
                                        </div>   
                                        <div class="form-group">
                                            <label>用户密码</label>
                                            <input id="text1" class="form-control">
                                        </div>  
                                        <div class="form-group">
                                            <label>再次输入密码</label>
                                            <input id="text2" class="form-control" name = "user.password">
                                        </div>                                                          
                                       <button type="submit" class="btn btn-default">注册</button>
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
   <script type="text/javascript" charset="utf-8">
$(document).ready(function(){ 

$("#name1").blur(function(){
var name1 =$("#name1").val();
   $.ajax({ 
        //这里的需要Struts.xml的<action/>的name属性一致。
       url:'user!checkName.action',
       //提交数据给Action传入数据 
       data:{'name':name1}, 
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





$("#text2").blur(function(){
var test1 =$("#text1").val();
var test2 =$("#text2").val();
   $.ajax({ 
        //这里的需要Struts.xml的<action/>的name属性一致。
       url:'user!checkRename.action',
       //提交数据给Action传入数据 
       data:{'nameFirst':test1,'nameSecond':test2}, 
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

    <!-- Custom Theme JavaScript -->
    <script src="/pm/vendor/dist/js/pm.js"></script>

</body>

</html>
