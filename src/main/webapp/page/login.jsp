<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
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
    <div class="message">线上商城登录</div>
    <div id="darkbannerwrap"></div>
    <form method="post" class="layui-form" >
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <br>
        <a href="http://localhost:8088/page/signup.jsp" style="margin-top: 10px">没有账户?点击注册</a>
        <hr class="hr20" >
    </form>
</div>

<script>
    layui.use(['form','jquery','layer'],function () {
        var form = layui.form;
        var $ = layui.jquery;
        var layer = layui.layer;

        //监听表单的提交事件
        form.on("submit(login)",function (data) {
            $.post("/user/Login",data.field,function(result){
                console.log(result);
                //判断是否成功
                if(result.success){
                    location.href="../page/index.html";
                }else{
                    layer.msg("用户名密码错误，登录失败");
                }
            },"json");
            //禁止页面跳转
            return false;
        })

    });
</script>

</body>
</html>