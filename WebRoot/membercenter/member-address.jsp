<%@page import="tw.com.domain.User"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="tw.com.domain.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%
	System.out.println(session.getAttribute("user"));
	if (session == null || session.getAttribute("user") == null)
		response.sendRedirect("../login/html/login.html");
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
	href="../membercenter/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="../membercenter/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="../membercenter/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="../membercenter/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="../membercenter/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>Happy購</title>
<script type="text/javascript" src="../membercenter/js/taiwan.js"></script>
<script type="text/javascript" src="../membercenter/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		for (var i = 0; i < addressList.length; i++) {
			var option = $("<option>" + addressList[i].name + "</option>");

			option.prop('areas', addressList[i].districts); //在city的select標籤自訂一個areas屬性賦予值是用來匹配area
			$('#city').append(option); //串上option標籤

		}
		changeCity();

		$('#city').on('change', changeCity); //在city的select標籤change事件上觸發要執行的函數
	});
	function changeCity() {
		$('#area').empty(); //先將地區的select標籤清空
		var areas = $('#city').find("option:selected").prop("areas"); //在city的select標籤選擇的值的areas屬性

		for (var i = 0; i < areas.length; i++) {
			var option = $("<option>" + areas[i].name + "</option>");
			$('#area').append(option);
		}

	}
</script>
</head>
<body>

	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首頁 <span class="c-gray en">&gt;</span>
		個人設置 <span class="c-gray en">&gt;</span> 地址管理 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="7">已保存的有效地址</th>
				</tr>
				<tr class="text-c">
					<th width="100">收貨人</th>
					<th width="100">所在地區</th>
					<th width="100">街道地址</th>
					<th width="100">手機</th>
					<th width="100">郵遞區號</th>
					<th width="100">默認設置</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${addressList}" var="address">				
					<tr class="text-c">
						<td>${address.accept}</td>
						<td>${address.city}${address.area}</td>
						<td>${address.address}</td>
						<td>${address.phoneNum}</td>
						<td>${address.zip}</td>
						<c:if test="${address.isdefault eq 1}" >						
							<td class="td-status">
								<span class="label label-success radius">
									<a style="text-decoration:none;"
									 href="../address/setDefault?id=${address.id}&isdefault=1">取消默認</a>
								</span>
							</td>
						</c:if>	
						<c:if test="${address.isdefault eq 2}" >						
							<td class="td-status">
								<span class="label label-default radius">
									<a style="text-decoration:none;"
									 href="../address/setDefault?id=${address.id}&isdefault=2">設為默認</a>
								</span>
							</td>
						</c:if>					
						<td class="td-manage">
							<a title="编辑" href="javascript:;" 
								onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')" class="ml-5" style="text-decoration:none">
								<i class="Hui-iconfont">&#xe6df;</i>
							</a>							
							
							<a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5"
								style="text-decoration:none">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
						</td>
					</tr>				
					</c:forEach>				
			</tbody>
		</table>
	</div>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg"
			style="width:75%">
			<form action="../address/addAddress" method="post"
				class="form form-horizontal" id="form-member-add">
				<thead>
					<tr>
						<th scope="col" colspan="2">收貨地址</th>
					</tr>
				</thead>
				<tbody>
					<tr class="text-c">
						<th>收貨人姓名</th>
						<th>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="text" class="input-text" value="" placeholder=""
									id="accept" name="accept" style="width: 75%"  />
							</div>
						</th>

					</tr>
					<tr class="text-c">
						<td>所在地區</td>
						<td>
							<div class="formControls col-xs-8 col-sm-9">
								<select name="city" id="city" style="width: 100px"></select> <select
									name="area" id="area" style="width: 100px"></select>
							</div>
						</td>
					</tr>
					<tr class="text-c">
						<td>街道地區</td>
						<td>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="text" class="input-text" value="" placeholder=""
									id="address" name="address" style="width: 75%" />
							</div>
						</td>
					</tr>
					<tr class="text-c">
						<td>郵遞區號</td>
						<td>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="text" class="input-text" value="" placeholder=""
									id="zip" name="zip" style="width: 75%" />
							</div>
						</td>
					</tr>
					<tr class="text-c">
						<td>手機</td>
						<td>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="text" class="input-text" value="" placeholder=""
									id="phoneNum" name="phoneNum" style="width: 75%"  />
							</div>
						</td>
					</tr>
					<tr class="text-c">
						<td>設為默認</td>
						<td>
							<div class="formControls col-xs-8 col-sm-9">
								<input type="checkbox" name="isdefault" value="1" />
							</div>
						</td>
					</tr>
					<tr class="text-c">
						<th scope="col" colspan="2">
							<div class="row cl">
								<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
									<input class="btn btn-primary radius" type="submit"
										value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
								</div>
							</div>
						</th>
					</tr>
				</tbody>
			</form>
		</table>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
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
			layer.confirm('確定要刪除嗎?', function(index) {
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
		
	</script>
</body>
</html>