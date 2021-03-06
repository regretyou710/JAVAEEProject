﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session == null || session.getAttribute("admin") == null)
		response.sendRedirect("../adminlogin/html/index.jsp");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="../admincenter/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../admincenter/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../admincenter/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../admincenter/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="../admincenter/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>管理员列表</title>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"
	src="../admincenter/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="../admincenter/lib/layer/2.4/layer.js"></script>
<script type="text/javascript"
	src="../admincenter/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript"
	src="../admincenter/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
	src="../admincenter/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
	src="../admincenter/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#categoryid').val('${goods.category.id}');
	});
</script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首頁 <span class="c-gray en">&gt;</span>
		商品管理 <span class="c-gray en">&gt;</span> 商品列表 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<form action="../goods/getGoods" method="post">
				<span class="select-box inline"> <select name="category.id"
					id="categoryid" class="select">
						<option value="">分類選擇</option>
						<c:forEach items="${categoryList}" var="items">
							<option value="${items.id}">${items.name}</option>
						</c:forEach>
				</select>
				</span> 商品名稱：<input type="text" class="input-text" style="width:250px"
					placeholder="" name="name" value="${goods.name}">
				<button type="submit" class="btn btn-success">
					<i class="Hui-iconfont">&#xe665;</i> 篩選
				</button>
			</form>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()"
				class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
					批量删除</a></span>
		</div>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr class="text-c">
					<th width="50"><input type="checkbox" name="" value=""></th>
					<th width="300">商品名稱</th>
					<th width="150">分類</th>
					<th width="50">銷售價格</th>
					<th width="50">庫存</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goodsList}" var="items">
					<tr class="text-c">
						<td><input type="checkbox" value="2" name=""></td>
						<td>${items[0]}</td>
						<td>${items[1].name}</td>
						<td>${items[2]}</td>
						<td>${items[3]}</td>
						<td><a title="编辑" href="javascript:;"
							onclick="admin_edit('管理员编辑','admin-add.html','2','800','500')"
							class="ml-5" style="text-decoration:none"><i
								class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
							href="javascript:;" onclick="admin_del(this,'1')" class="ml-5"
							style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript"
		src="../admincenter/lib/laypage/1.2/laypage.js"></script>

	<script type="text/javascript">
	
		/*
			参数解释：
			title	标题
			url		请求的url
			id		需要操作的数据id
			w		弹出层宽度（缺省调默认值）
			h		弹出层高度（缺省调默认值）
		*/
		/*管理员-增加*/
		function admin_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-删除*/
		function admin_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '',
					dataType : 'json',
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
	
		/*管理员-编辑*/
		function admin_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-停用*/
		function admin_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {
				//此处请求后台程序，下方是成功后的前台处理……
	
				$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
				$(obj).remove();
				layer.msg('已停用!', {
					icon : 5,
					time : 1000
				});
			});
		}
	
		/*管理员-启用*/
		function admin_start(obj, id) {
			layer.confirm('确认要启用吗？', function(index) {
				//此处请求后台程序，下方是成功后的前台处理……
	
	
				$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!', {
					icon : 6,
					time : 1000
				});
			});
		}
	</script>
</body>
</html>