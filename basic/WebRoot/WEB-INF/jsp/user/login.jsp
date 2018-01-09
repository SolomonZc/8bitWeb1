<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${path}/public/css/pintuer.css">
    <link rel="stylesheet" href="${path}/public/css/admin.css">
    <script src="${path}/public/js/jquery.js"></script>
    <script src="${path}/public/js/pintuer.js"></script>  
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="" method="post" id="form">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" id="name" name="name" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" id="pwd" name="pwd" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <!-- <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">  
                                                   
                        </div>
                    </div> -->
                </div>
                <div style="padding:30px;"><input type="button" class="button button-block bg-main text-big input-big" value="登录" onclick="submitlogin();"></div>
            </div>
            </form>          
        </div>
    </div>
</div>
 <script type="text/javascript">
function submitlogin(){
		 /* if(isusername()&&ispwd()&&isyanzhengma()){ */
			 var name=$.trim($("#name").val());
			 var pwd=$.trim($("#pwd").val());
			 //var yanzhengma=$.trim($("#yanzhengma").val());
			 var param={};
			 param.loginname=name;
			 param.pwd=pwd;
			// param.yanzhengma=yanzhengma;
			 param.pathlocation='${pathlocation}';
			 $.ajax({
				   type: "POST",
				   url: "${path}/login/login.do",
				   data: param,
				   dataType: "json", 
				   async: false,
				   success: function(data){
					   var flag=data.flag;
					   var pathlocation=data.pathlocation;
					   if(flag==99){
						  /*  $("#namespan").html("用户名错误");
							$("#namespan").show(); */
							alert("用户名错误");
					   }else if(flag==88){
						   /* $("#pwdspan").html("密码错误");
							$("#pwdspan").show();
							$("#namespan").hide(); */
						   alert("密码错误");
					   }else if(flag==77){
						  /*  $("#yanzhengmaspan").html("验证码错误");
							$("#yanzhengmaspan").show();
							$("#namespan").hide();
							$("#pwdspan").hide(); */
						   alert("验证码错误");
					   }else if(flag==0){
						  /*  $("#namespan").html("用户名限制登录");
							$("#namespan").show();
							$("#pwdspan").hide(); */
						   alert("用户名限制登录");
					   }else if(flag==1){
						   window.location.href=pathlocation;
					   }else{
						   alert("系统错误");
					   }
				   }
			 });
		/*  } */
	 }
 </script>
 
</body>
</html>