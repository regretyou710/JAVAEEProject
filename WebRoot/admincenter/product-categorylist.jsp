<%@ page language="java" import="java.util.*,tw.com.domain.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println(session.getAttribute("admin"));
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
<title>Happy購</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首頁 <span class="c-gray en">&gt;</span>
		產品管理 <span class="c-gray en">&gt;</span> 分類列表 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="4">分類列表</th>
			</tr>
			<tr class="text-c">
				<th width="25">序號</th>
				<th width="40">分類名稱</th>
				<th width="90">數量</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>

			<%
				List<Category> list = (List) request.getAttribute("categoryList");
				int i = 0;
				for (Category g : list) {
					i++;
			%>
			<tr class="text-c">
				<td><span id="num" value="<%=i%>"><%=i%></span></td>
				<td><input type="text" id="name<%=i%>" value="<%=g.getName()%>"
					class="input-text" style="border-style:none;text-align: center;" disabled="true" /></td>
				<td><input type="text" id="goodsNum<%=i%>"
					value="<%=g.getGoodsNum()%>" style="border-style:none;text-align: center;"
					class="input-text" disabled="true" /></td>
				<td class='td-manage'><a title='編輯' href='javascript:;'
					onclick="edit(false,'<%=i%>')" class='ml-5'
					style='text-decoration:none'> <i class='Hui-iconfont'>&#xe6df;</i>
				</a> <a title='保存' href='javascript:;'
					onclick="update('<%=g.getId()%>','<%=i%>')" class='ml-5'
					style='text-decoration:none'> <i class='Hui-iconfont'>&#xe632;</i>
				</a> <a title='删除' href='javascript:;'
					onclick="admin_del(this,'<%=g.getId()%>')" class='ml-5'
					style='text-decoration:none'> <i class='Hui-iconfont'>&#xe6e2;</i>
				</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>	
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
	<script type="text/javascript"
		src="../admincenter/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="../admincenter/js/jquery-3.4.1.min.js"></script>
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
			layer.confirm('確定要刪除？', function() {
				$.ajax({
					type : 'delete',
					url : '../category/delCategory',
					dataType : 'json',
					contentType : 'application/json;charset=utf-8',
					data : '{"id":"' + id + '"}',
					success : function(data) {
						if (data) {
							$(obj).parents("tr").remove();
							layer.msg('已删除!', {
								icon : 1,
								time : 1000
							});
						}
					}
				});
			});
		}
	
		/*管理员-编辑*/
		function edit(state, num) {
			var nameid = 'name' + num;
			var goodsNumid = 'goodsNum' + num;
			var nameState = document.getElementById(nameid);
			var goodsNumState = document.getElementById(goodsNumid);
			if (nameState.disabled == true) {
				nameState.disabled = state;
				nameState.style.borderStyle = 'solid';
				goodsNumState.disabled = state;
				goodsNumState.style.borderStyle = 'solid';
			} else if (nameState.disabled == false) {
				nameState.disabled = 'false';
				nameState.style.borderStyle = 'none';
				goodsNumState.disabled = 'false';
				goodsNumState.style.borderStyle = 'none';
			}
		}
	
		function update(id, num) {
			var nameid = 'name' + num;
			var nameVal = document.getElementById(nameid).value;
			var goodsNumid = 'goodsNum' + num;
			var goodsNumVal = document.getElementById(goodsNumid).value;
			var nameState = document.getElementById(nameid);
			if (nameState.disabled == false) {
				layer.confirm('確定要保存？', function() {
					$.ajax({
						type : 'put',
						url : '../category/updateCategory',
						dataType : 'json',
						contentType : 'application/json;charset=utf-8',
						data : '{"id":"' + id + '","name":"' + nameVal + '","goodsNum":"' + goodsNumVal + '"}',
						success : function(data) {
							if (data) {
								layer.msg('已保存!', {
									icon : 1,
									time : 1000
								});
	
								var nameState = document.getElementById(nameid);
								nameState.disabled = 'false';
								nameState.style.borderStyle = 'none';
	
								var goodsNumState = document.getElementById(goodsNumid);
								goodsNumState.disabled = 'false';
								goodsNumState.style.borderStyle = 'none';
							}
						}
					});
				});
			}
		}
	</script>
</body>
</html>