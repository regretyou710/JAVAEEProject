<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		產品管理 <span class="c-gray en">&gt;</span> 添加分類 <a
			class="btn btn-success radius r"
			style="line-height:1.6em;margin-top:3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20" style="width: 75%">
			<form action="../category/addCategory" method="get">
				<table class="table table-border table-bordered table-bg">
					<tr class="text-c">
						<td>分類名稱:</td>
						<td><input type="text" name="name" class="input-text"
							style="width: 75%"> <input type="submit" value="確定"
							class="btn btn-primary radius"></td>
					</tr>
					</tbody>
				</table>
			</form>
		</div>

	</div>
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
	<script type="text/javascript">
		$(document).ready(
			function() {
				var msg = '${requestScope.msg}';
				if (msg.length != 0)
					alert(msg);
			}
		);
	</script>
</body>
</html>