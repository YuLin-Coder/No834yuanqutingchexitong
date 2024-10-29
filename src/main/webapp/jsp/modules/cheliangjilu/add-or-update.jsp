<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
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
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
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
                    <h3 class="block-title">编辑车辆记录</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">车辆记录管理</li>
                        <li class="breadcrumb-item active">编辑车辆记录</li>
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
                        <h3 class="widget-title">车辆记录信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6">
                                        <label>车位</label>
                                        <div>
                                            <select id="cheweiSelect" name="cheweiSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>车位名字</label>
                                        <input id="cheweiName" name="cheweiName" class="form-control"
                                               placeholder="车位名字" readonly>
                                    </div>
                                    <%--<div class="form-group col-md-6">--%>
                                        <%--<label>状态</label>--%>
                                        <%--<input id="cheweiValue" name="cheweiValue" class="form-control"--%>
                                               <%--placeholder="状态" readonly>--%>
                                    <%--</div>--%>
                                    <div class="form-group col-md-6">
                                        <label>车主</label>
                                        <input id="chezhuId" name="chezhuId" class="form-control"
                                               placeholder="车主" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>车牌号</label>
                                        <input id="chepaiNumber" name="chepaiNumber" class="form-control"
                                               placeholder="车牌号" readonly>
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>车牌号</label>
                                        <input id="chepaiNumber" name="chepaiNumber" class="form-control"
                                               placeholder="车牌号">
                                    </div>
                                <input id="cheweiId" name="cheweiId" type="hidden">
                                   <div class="form-group col-md-6">
                                       <label>状态</label>
                                       <select id="cheliangjiluTypesSelect" name="cheliangjiluTypes" class="form-control">
                                       </select>
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>泊车时间</label>
                                       <input id="insertTime-input" name="insertTime" type="text" class="form-control layui-input">
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>取车时间</label>
                                       <input id="updateTime-input" name="updateTime" type="text" class="form-control layui-input">
                                   </div>
                                <div class="form-group col-md-6">
                                    <label>停车小时</label>
                                    <input id="xiaoshi" name="xiaoshi" class="form-control"
                                           onchange="xiaoshiChickValue(this)"  placeholder="停车小时">
                                </div>

                                <div class="form-group col-md-6">
                                    <label>金额</label>
                                    <input id="monery" name="monery" class="form-control"
                                           onchange="moneryChickValue(this)"  placeholder="金额">
                                </div>

                                <div class="form-group col-md-12 mb-3">
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
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
</script><script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "cheliangjilu";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var cheliangjiluTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var cheweiOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->

    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
           if($("#cheweiId") !=null){
               var cheweiId = $("#cheweiId").val();
               if(cheweiId == null || cheweiId =='' || cheweiId == 'null'){
                   alert("车位id不能为空");
                   return;
               }
           }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                successMes = '添加成功';
            }
            httpJson("cheliangjilu/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addcheliangjilu');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function cheliangjiluTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=cheliangjilu_types", "GET", {}, (res) => {
                if(res.code == 0){
                    cheliangjiluTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function cheweiSelect() {
            //填充下拉框选项
            http("chewei/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    cheweiOptions = res.data.list;
                }
            });
        }

        function cheweiSelectOne(id) {
            http("chewei/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                cheweiShowImg();
                cheweiDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationCheliangjilutypesSelect(){
            var cheliangjiluTypesSelect = document.getElementById('cheliangjiluTypesSelect');
            if(cheliangjiluTypesSelect != null && cheliangjiluTypesOptions != null  && cheliangjiluTypesOptions.length > 0 ){
                for (var i = 0; i < cheliangjiluTypesOptions.length; i++) {
                    cheliangjiluTypesSelect.add(new Option(cheliangjiluTypesOptions[i].indexName,cheliangjiluTypesOptions[i].codeIndex));
                }
            }
        }

    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
    <!-- 初始化级联表的下拉框(要根据内容修改) -->
        function initializationcheweiSelect() {
            var cheweiSelect = document.getElementById('cheweiSelect');
            if(cheweiSelect != null && cheweiOptions != null  && cheweiOptions.length > 0 ) {
                for (var i = 0; i < cheweiOptions.length; i++) {
                        cheweiSelect.add(new Option(cheweiOptions[i].name, cheweiOptions[i].id));
                }

                $("#cheweiSelect").change(function(e) {
                        cheweiSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var cheliangjiluTypesSelect = document.getElementById("cheliangjiluTypesSelect");
        if(cheliangjiluTypesSelect != null && cheliangjiluTypesOptions != null  && cheliangjiluTypesOptions.length > 0 ) {
            for (var i = 0; i < cheliangjiluTypesOptions.length; i++) {
                if (cheliangjiluTypesOptions[i].codeIndex == ruleForm.cheliangjiluTypes) {//下拉框value对比,如果一致就赋值汉字
                        cheliangjiluTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var cheweiSelect = document.getElementById("cheweiSelect");
            if(cheweiSelect != null && cheweiOptions != null  && cheweiOptions.length > 0 ) {
                for (var i = 0; i < cheweiOptions.length; i++) {
                    if (cheweiOptions[i].id == ruleForm.cheweiId) {//下拉框value对比,如果一致就赋值汉字
                        cheweiSelect.options[i+1].selected = true;
                        $("#cheweiSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function xiaoshiChickValue(e){
            var this_val = e.value || 0;
            /*if(this_val == 0){
                e.value = "";
                alert("0不允许输入");
                return false;
            }*/
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }
        function moneryChickValue(e){
            var this_val = e.value || 0;
            /*if(this_val == 0){
                e.value = "";
                alert("0不允许输入");
                return false;
            }*/
            var reg=/^[0-9]*$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("输入不合法");
                return false;
            }
        }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addcheliangjilu');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                chepaiNumber: "required",
                cheweiId: "required",
                cheliangjiluTypes: "required",
                insertTime: "required",
                updateTime: "required",
                xiaoshi: "required",
                monery: "required",
            },
            messages: {
                chepaiNumber: "车牌号不能为空",
                cheweiId: "车位id不能为空",
                cheliangjiluTypes: "状态不能为空",
                insertTime: "泊车时间不能为空",
                updateTime: "取车时间不能为空",
                xiaoshi: "停车小时不能为空",
                monery: "金额不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addcheliangjilu = window.sessionStorage.getItem("addcheliangjilu");
        if (addcheliangjilu != null && addcheliangjilu != "" && addcheliangjilu != "null") {
            window.sessionStorage.removeItem('addcheliangjilu');
            //注册表单验证
            $(validform());
            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("cheliangjilu/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
            laydate.render({
                elem: '#insertTime-input'
                ,type: 'datetime'
            });
            laydate.render({
                elem: '#updateTime-input'
                ,type: 'datetime'
            });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        cheweiDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#chepaiNumber").val(ruleForm.chepaiNumber);
        $("#cheweiId").val(ruleForm.cheweiId);
        $("#insertTime-input").val(ruleForm.insertTime);
        $("#updateTime-input").val(ruleForm.updateTime);
        $("#xiaoshi").val(ruleForm.xiaoshi);
        $("#monery").val(ruleForm.monery);

    }
    <!--  级联表的数据回显  -->
    function cheweiDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#cheweiId").val(ruleForm.id);

        $("#cheweiName").val(ruleForm.cheweiName);
        $("#cheweiValue").val(ruleForm.cheweiValue);
        $("#chezhuId").val(ruleForm.chezhuId);
        $("#chepaiNumber").val(ruleForm.chepaiNumber);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->

        <!--  级联表的图片  -->
        cheweiShowImg();
    }


    <!--  级联表的图片  -->

    function cheweiShowImg() {
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            cheliangjiluTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            cheweiSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationCheliangjilutypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationcheweiSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>