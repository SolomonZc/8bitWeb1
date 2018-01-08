<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${path}/public/css/pintuer.css">
<link rel="stylesheet" href="${path}/public/css/admin.css">
<script src="${path}/public/js/jquery.js"></script>
<script src="${path}/public/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form action="" class="form-x">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           ${user.name }
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="mpass" size="50" />
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="newpass" name="newpass" size="50"  />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="renewpass" name="renewpass" size="50"/>          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <a href="javaScript:;" class="button bg-main icon-check-square-o" onclick="updatePwd()"> 提交</a>
        </div>
      </div>      
    </form>
  </div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
	});
	
	function updatePwd(){
		var pwd = $("#mpass").val();
		var newpwd = $("#newpass").val();
		var newpwd2 = $("#renewpass").val();
		
		if(pwd==""){
			//$("#chk_oldpassword").html("请输入原始密码");
			alert("请输入原始密码");
			return;
		}
		else if(newpwd==""){
			//$("#chk_oldpassword").html("请输入原始密码");
			alert("请输入新密码");
			return;
		}
		else if(newpwd2==""){
			//$("#chk_oldpassword").html("请输入原始密码");
			alert("请输入确认密码");
			return;
		}
		else if(newpwd.length<6){
			//$("#chk_newpassword").html("新密码长度不能小于6位");
			alert("新密码长度不能小于6位");
			return;
		}
		else if(newpwd!=newpwd2){
			//$("#chk_newpassword2").html("两次密码不一致");
			alert("两次密码不一致");
			return;
		}
		
		 var param={};
		 param.pwd=pwd;
		 param.newpwd=newpwd;
		 $.ajax({
			   type: "POST",
			   url: "${path}/user/pwd.do",
			   data: param,
			   async: false,
			   dataType: "json", 
			   success: function(data){
				   if(data==1){
					   alert("密码修改成功");
					   $("#mpass").val("");
					   $("#newpass").val("");
					   $("#renewpass").val("");
				   }else if(data==0){
					   $("#chk_oldpassword").html("原密码错误");
				   }else{
					   alert("系统错误");
				   }
			   }
		 });
	}
</script>

</body></html>