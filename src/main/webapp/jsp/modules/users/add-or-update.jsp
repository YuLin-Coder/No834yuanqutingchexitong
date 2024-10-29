<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<%@ include file="../../static/head.jsp"%>
	<link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
	</script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
	.error{
		color:red;
	}

</style>
<body>
<!-- Pre Loader -->
<div class="loading">
	<div class="spinner">
		<div class="double-bounce1"></div>
		<div class="double-bounce2"></div>
	</div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
	<!-- Page Content -->
	<div id="content">
		<!-- Top Navigation -->
		<%@ include file="../../static/topNav.jsp"%>
		<!-- Menu -->
		<div class="container menu-nav">
			<nav class="navbar navbar-expand-lg lochana-bg text-white">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="ti-menu text-white"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul id="navUl" class="navbar-nav mr-auto">

					</ul>
				</div>
			</nav>
		</div>
		<!-- /Menu -->
		<!-- Breadcrumb -->
		<!-- Page Title -->
		<div class="container mt-0">
			<div class="row breadcrumb-bar">
				<div class="col-md-6">
					<h3 class="block-title">编辑区域</h3>
				</div>
				<div class="col-md-6">
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
							<a href="${pageContext.request.contextPath}/index.jsp">
								<span class="ti-home"></span>
							</a>
						</li>
						<li class="breadcrumb-item">管理员信息管理</li>
						<li class="breadcrumb-item active">编辑区域</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /Page Title -->

		<!-- /Breadcrumb -->
		<!-- Main Content -->
		<div class="container">

			<div class="row">
				<!-- Widget Item -->
				<div class="col-md-12">
					<div class="widget-area-2 lochana-box-shadow">
						<h3 class="widget-title">管理员信息</h3>
						<form id="addOrUpdateForm">
							<div class="form-row">
								<input id="updateId" name="id" type="hidden" v-model="ruleForm.id">
								<div class="form-group col-md-6">
									<label>用户名</label>
									<input class="form-control"  name="username" id="username" class="form-control" v-model="ruleForm.username">
								</div>

								<div class="form-group col-md-6">
									<label>角色</label>
									<select id="role" name="role" class="form-control">
										<option id="管理员"  value="管理员" >管理员</option>
										<option id="舍管管理员"  value="舍管管理员" >舍管管理员</option>
									</select>
								</div>
								<div class="form-group col-md-6 mb-3">
									<button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
									<button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- /Widget Item -->
			</div>
		</div>
		<!-- /Main Content -->
	</div>
	<!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
	<span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "users";
    var pageType = "add-or-update";
    var updateId = "";

    var ruleForm = {};
    var vm = new Vue({
        el: '#addOrUpdateForm',
        data:{
            ruleForm : {},
        },
        beforeCreate: function(){

            var addUser =  window.sessionStorage.getItem("addUser");
            if (addUser != null && addUser != "" && addUser != "null") {
                window.sessionStorage.removeItem('addUser');
                //注册表单验证
                $(validform());

            } else {
                var userId = window.sessionStorage.getItem('userId');
                updateId = userId;//先赋值登录用户id
                var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
                if (uId != null && uId != "" && uId != "null") {
                    //如果修改id不为空就赋值修改id
                    updateId = uId;
                }
                httpJson("users/info/" + updateId, "GET", null, (res) => {
                    window.sessionStorage.removeItem("updateId");
					if(res.code == 0){
					    debugger
						vm.ruleForm = res.data;
						var role = vm.ruleForm.role;
						//设置权限下拉框
						var roles = document.getElementById('role');
						for (var i = 0; i < roles.length; i++) {
							var v = roles[i].value;
							if(role ==v){
								document.getElementById('role').options[i].selected = true;
							}
						}
                        var thisRole = window.sessionStorage.getItem('role');
						//设置非管理员不可选择
						if(thisRole !="管理员"){
							$('#role').attr('style', 'pointer-events: none;');
							$('#submitBtn').remove();
						}
					}else if(res.code == 401) {
						<%@ include file="../../static/toLogin.jsp"%>
					}else{ alert(res.msg)
					}
            	});
            }
        },
        methods: { }
    });

    // 表单提交
    function submit() {
        if(validform() ==true){
            let data = {};

            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            debugger
            let json = JSON.stringify(data);
            //console.log('json : ',json);
            var urlParam;
            var successMes = '';
            if(updateId!=null && updateId!="null" && updateId!=''){
                urlParam = 'update';
                successMes = '修改成功';
            }else{

                urlParam = 'save';
                successMes = '添加成功';
            }
            $.ajax({
                type: "POST",
                url: baseUrl + "users/"+urlParam,
                contentType: "application/json",
                data:json,
                beforeSend: function(xhr) {xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));},
                success: function(res){
                    if(res.code == 0){
                        window.sessionStorage.removeItem('id');
                        alert(successMes);
                        window.location.href="list.jsp";
                    }else if(res.code == 401){
                        <%@ include file="../../static/toLogin.jsp"%>
                    }else{
                        alert(res.msg)
                    }
                },
            });
        }else{
            alert("表单未填完整或有错误");
        }
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                username: "required",
            },
            messages: {
                username: "请输入用户名",
            }
        }).form();
    }

    $(document).ready(function() {
        setMenu();
        //注册表单验证
        $(validform());
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            window.sessionStorage.removeItem("updateId");
            window.location.href = "../home/home.jsp";

        });
        $('#submitBtn').on('click', function(e) {
            e.preventDefault();
            //console.log("点击了...提交按钮");
            submit();
        });
    });
    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>