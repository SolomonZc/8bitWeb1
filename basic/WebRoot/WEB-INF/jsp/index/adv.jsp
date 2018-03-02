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
    <script src="${path}/public/js/jquery.validate.js"></script>
    <script src="${path}/public/js/pintuer.js"></script>  
     <script type="text/javascript">  
     $(function(){  
     //让当前表单调用validate方法，实现表单验证功能  
     $("#ff").validate({  
     debug:true, 
     //调试模式，即使验证成功也不会跳转到目标页面  
     rules:{ 
     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)   
     sort:{   
	     required:true, 
	     //必填。如果验证方法不需要参数，则配置为true   
	     range:[1,3]   
	     },    
     },  
     messages:{   
	     sort:{   
		     required:"请输入用户名",   
		     range:$.validator.format("轮播图排序必须为：{1}-{3}之间")  
	      },
     }  
     });  
     });  
     </script> 
</head>
<body>
<div class="panel admin-panel" >
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">ID</th>
      <th width="20%">图片</th>
      <th width="15%">名称</th>
      <th width="20%">描述</th>
      <th width="10%">排序</th>
      <th width="15%">操作</th>
    </tr>
    <c:forEach items="${advlists}" var="advlists">
	    <tr>
	      <td id="advlistsId">${advlists.id }</td>
   	      <td><img  id="showImage" src="${advlists.url }" alt="" width="120" height="50" /></td>     
		  <td>${advlists.name }</td> 
	      <td>${advlists.describ }</td>
	      <td>${advlists.grade }</td>
	      <td><div class="button-group">
	      <a class="button border-main" href="#add"><span class="icon-edit"></span> 修改</a>
	      <a class="button border-red" href="javascript:void(0)" onclick="return del(${advlists.id },1)"><span class="icon-trash-o"></span> 删除</a>
	      </div></td>
	    </tr>
    </c:forEach>
  </table>
</div>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" id="ff">    
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" id="title" name="title" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>URL：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="url" name="url" value=""  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="field">
          <input type="file" class="button bg-blue margin-left" id="uploadImg" name="uploadImg" onChange="submitImg()" style="float:left;">
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" id="note" name="note" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>排序：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="sort" name="sort"  data-validate="required:,number:排序必须为数字" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o"  onclick="uploadPic()"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
	function uploadPic(){
		 var name=$.trim($("#title").val());
		 var describ=$.trim($("#note").val());
		 var url=$.trim($("#url").val());
		 var grade=$.trim($("#sort").val());
		 var file = document.getElementById("uploadImg").files[0];
		 //var yanzhengma=$.trim($("#yanzhengma").val());
		 var formFile = new FormData();
		 formFile.append("name", name);
		 formFile.append("describ", describ);
		 formFile.append("grade", grade);
		 formFile.append("uploadImg", file);
	//	 var formData={};
		// formData.name=name;
		 //formData.describ=describ;
		 //formData.url=url;
		 //formData.grade=grade;
		$.ajax({
		   type: "POST",
		   url: "${path}/index/advpic.do",
		   data: formFile,
		   dataType: "json", 
		   async: false,
           cache: false,  
           contentType: false,  
           processData: false, 
		   success: function(data){
			   alert(data);
			   advPicShow();
			   location.reload();
		   }
		 });
	 }
	 function del(id,mid){
		 var formFile = new FormData();
		 formFile.append("picId", id);
		if(confirm("您确定要删除吗?")){
			$.ajax({
			   type: "POST",
			   url: "${path}/index/advPicDelete.do",
			   data:  formFile,
			   dataType: "json", 
			   async: false,
	           cache: false, 
	           contentType:false,  
	           processData: false, 
			   success: function(data){
			   	 alert("sdfasdf");
			   	 advPicShow();
				 location.reload();
			   }
		 	});
		}
	}
	 
 	function advPicShow(){
		$.ajax({
		   type: "POST",
		   url: "${path}/index/advPicShow.do",
		   async: false,
		 });
	 }
	 
 </script>
</body>
</html>
