<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>账单管理系统-后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="../js/css/font.css">
    <link rel="stylesheet" href="../js/css/login_v2.css">
    <link rel="stylesheet" href="../js/css/xadmin.css">
    <script src="../layui.js"></script>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">线上商城账号注册</div>
    <div id="darkbannerwrap"></div>
    <form method="post" class="layui-form" >
        <input name="username" type="text" lay-verify="required" class="layui-input" placeholder="请输入用户名" autocomplete="off">
        <hr class="hr15">
        <input name="password" lay-verify="required" type="password" class="layui-input" placeholder="请输入密码" autocomplete='new-password'>
        <hr class="hr15">
        <input value="注册" lay-submit lay-filter="signup" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

<script>
    layui.use(['form','jquery','layer'],function () {
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;

        //监听表单的提交事件
        form.on("submit(signup)",function (data) {
            $.post("/user/Signup",data.field,function(resMsg){
                console.log(resMsg);
                //判断是否成功
                if(resMsg.code==0){
                    location.href="../page/login.jsp";
                }else{
                    layer.alert(resMsg.msg,{icon:2});
                }
            },"json");
            //禁止页面跳转
            return false;
        })
    });
</script>

</body>
</html>