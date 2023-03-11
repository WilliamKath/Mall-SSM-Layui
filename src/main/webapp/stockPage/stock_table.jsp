<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>查看库存表</title>
    <link rel="stylesheet" href="../css/layui.css">
    <script src="../js/jquery/jquery-3.6.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous">
    </script>
    <style>
        layui-table-cell{
            height:32px;
            line-height: 32px;
        }
    </style>
</head>
<body>

<!-- 查询条件开始 -->
<div style="width: 80%;margin-left: 100px;text-align: center">
    <form class="layui-form layui-form-pane" method="post">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">查询类型</label>
                <div class="layui-input-inline">
                    <select name="typeId" class="layui-input" lay-filter="test">
                        <option value="">请选择查询类型</option>
                        <option value="stockName" id="searchName">库存名</option>
                        <option value="stockId" id="searchId">库存编号</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">关键字</label>
                <div class="layui-input-block">
                    <input type="text" id="searchKey" onkeyup="" name="" lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入查询关键字">
                </div>
            </div>
            <div class="layui-inline">
                <button type="submit" class="layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="doSearch" >搜索</button>
                <button type="reset" class="layui-btn layui-btn-radius layui-btn-warm">重置</button>
            </div>
        </div>
    </form>
</div>

<!-- 此处为表格 -->
<table id="stock_table" lay-filter="stock_table" class="layui-table-cell"></table>

<!-- 添加和修改账单的弹出层开始 -->
<div id="addOrUpdateDiv" style="display: none;margin: 10px">
    <form id="dataForm" method="post" class="layui-form  layui-form-pane" lay-filter="dataForm">
        <!-- 隐藏域，保存当前账单的ID -->
        <input type="hidden" name="stockId">
        <div class="layui-form-item">
            <label class="layui-form-label">库存名</label>
            <div class="layui-input-block">
                <input type="text" name="stockName" placeholder="请输入库存名" lay-verify="required" lay-reqText="请输入库存名"  autocomplete="off" class="layui-input" style="width: 100px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">成本价</label>
            <div class="layui-input-block">
                <input type="text" name="costprice" placeholder="请输入成本价" lay-verify="number" lay-reqText="请输入成本价"  autocomplete="off" class="layui-input" style="width: 100px">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">商品规格</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入商品规格" name="stockStandard" class="layui-textarea" ></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">库存数</label>
            <div class="layui-input-inline">
                <input type="text" name="stockQty"   lay-verify="number" placeholder="请输入库存数"  lay-reqText="请输入库存数"   autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</div>
<!-- 添加和修改账单的弹出层结束-->


<script type="text/html" id="stock_bar">
    <button class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="stock_toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="batchDel">批量删除</button>
    </div>
</script>

<script src="../layui.js"></script>
<script>
    layui.use(['form','jquery','table','laydate','layer'], function(){
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        var laydate = layui.laydate;
        var layer = layui.layer;
        var stock_table = table.render({
            elem: '#stock_table'
            ,height: 360
            ,url: '/stock/findAll' //数据接口
            ,page: true
            ,limit:5
            ,limits:[5,10,15]
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'stockId', title: '编号', width:80, sort: true}
                ,{field: 'stockName', title: '库存名', width:150}
                ,{field: 'costprice', title: '成本价', width:100, sort: true}
                ,{field: 'stockStandard',title: '商品规格',width:250}
                ,{field: 'stockQty', title: '库存数', width: 150}
                ,{title:"操作",width:200,align:"center",toolbar: '#stock_bar',templet:function(d){
                        var str="<button type='button' class='layui-btn layui-btn-xs layui-btn-warm' lay-event='edit'>编辑</button>";
                        str+="<button type='button' class='layui-btn layui-btn-xs layui-btn-danger' lay-event='del'>删除</button>";
                        return str;
                    }}
            ]],
            //表格容器的ID
            id:'stock_table',
            toolbar: '#stock_toolbar'
        });

        //监听表格头部工具栏
        table.on('toolbar(stock_table)',function (obj) {
            var data = obj.data;
            var event = obj.event;
            switch (event) {
                case 'add' :
                    openAddWindow(obj.data);
                    break;
                case 'batchDel' :
                    batchDel();
                    break;
            }
        });

        //监听表格中的编辑、删除控件
        table.on('tool(stock_table)',function (obj) {
            var data = obj.data;
            var event = obj.event;
            switch (event) {
                case 'del':
                    delById(data);
                    break;
                case 'edit':
                    openUpdateWindow(obj.data);
                    break;
            }
        });

        //监听搜索按钮提交事件
        form.on("submit(doSearch)",function (data) {
            var f = data.field;
            stock_table.reload({
                where: data.field,
                page:{
                    curr:1
                }
            });
            //禁止页面刷新
            return false;
        });

        //监听表单提交事件
        form.on("submit(doSubmit)",function (data) {
            $.post(url,data.field,function(resMsg){
                if(resMsg.code == 0){
                    layer.alert(resMsg.msg,{icon:1});
                    //关闭窗口
                    layer.close(mainIndex);
                    //刷新数据表格
                    table.reload('stock_table');
                }else{
                    layer.alert(resMsg.msg,{icon:2});
                }
            },"json");
            return false;
        });

        //监听select选择框以完成查询条件（stockId / stockName）选择
        form.on('select(test)',function (data) {
            var key = data.value;
            $('#searchKey').attr('name',key);
            switch (key) {
                case 'stockId':
                    $('#searchKey').attr('lay-verify',"required|number");
                    break;
                case 'stockName':
                    /*
                    测试用的数据包含数字，正式启用时需要验证仅有中英文
                    $('#searchKey').attr('lay-verify',"required|CheckName");
                    */
                    $('#searchKey').attr('lay-verify',"required");
                    break;
            }
        });

        /**
         * 批量删除
         */
        function batchDel() {
            //获取表格对象
            var checkStatus = table.checkStatus('stock_table'); //billTable 即为基础参数 id 对应的值
            //判断是否有选中行
            if(checkStatus.data.length>0){
                //定义数组，保存选中行的ID
                var idArr = [];
                //循环遍历获取选中行(目的是获取选中的每一行的ID值)
                for (let i = 0; i < checkStatus.data.length; i++) {
                    //将选中的ID值添加到数组的末尾
                    idArr.push(checkStatus.data[i].stockId);
                }
                //将数组转成字符串
                var ids = idArr.join(",");
                console.log(ids);
                //提示用户是否删除
                layer.confirm("确定要删除这<font color='red'>"+checkStatus.data.length+"</font>条数据吗？",{icon:3,title:"提示"},function (index) {
                    //发送ajax请求
                    $.post("/stock/batchDel",{"ids":ids},function(resMsg){
                        if(resMsg.code == 0){
                            layer.alert(resMsg.msg,{icon:1});
                            //刷新数据表格
                            stock_table.reload();
                        }else{
                            layer.alert(resMsg.msg,{icon:2});
                        }
                    },"json");
                    //关闭提示框
                    layer.close(index);
                });
            }else{
                layer.msg("请选择要删除的数据");
            }
        }

        /**
         * 根据ID删除一条数据
         */
        function delById(data) {
            layer.confirm('确认删除该库存吗？',{icon:3,title:"提示"},function (index) {
                //发送ajax请求
                $.post("/stock/delOne", {"id":data.stockId}, function (resMsg) {
                    if (resMsg.code == 0) {
                        layer.alert(resMsg.msg, {icon: 1});
                        table.reload('stock_table');
                    } else {
                        layer.alert(resMsg.msg, {icon: 2});
                    }
                },"json");
                layer.close(index);
            });
        }

        var url;//提交地址
        var mainIndex;//窗口索引
        /**
         * 打开编辑弹出层
         * @param data
         */
        function openUpdateWindow(data) {
            mainIndex =layer.open({
                type:1,//弹出层类型
                title:"修改库存信息",
                resize:false,
                area: ['400px', '445px'],
                content:$("#addOrUpdateDiv"),//引用的窗口代码
                success:function () {
                    //表单数据回显
                    form.val("dataForm",data);
                    //修改请求
                    url = "/stock/updateOne";
                }

            });
        }

        /**
         * 打开添加弹出层
         * @param data
         */
        function openAddWindow(data) {
            mainIndex =layer.open({
                type:1,//弹出层类型
                title:"添加库存",
                resize:false,
                area: ['400px', '445px'],
                content:$("#addOrUpdateDiv"),//引用的窗口代码
                success:function () {
                    //添加请求请求
                    url = "/stock/addOne";
                },
            });
        }

        //验证用的正则表达式，在lay-verify 属性中赋key值即可调用
        form.verify({
            CheckName: [    //key值
                //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
                /^[a-zA-Z_\u4e00-\u9fa5\\s·]+$/    //匹配中英文
                ,'请输入正确的姓名'
            ]
        });
    });
</script>
</body>
</html>
