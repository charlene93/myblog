<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp"%>
<%@include file="/common/ueditor.jsp"%>
<title>编写博客</title>
<script type="text/javascript" src="${basePath }static/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
	window.UEDITOR_HOME_URL = "${basePath }static/ueditor1_4_3_3/";
	var ue=UE.getEditor('editor');
</script>
</head>
<body style="margin:5px;font-family:'microsoft yahei'">
<div id="p" class="easyui-panel" title="编写博客" style="padding:5px;" data-options="iconCls:'icon-writeBlog',fit:true">
	<!-- cellspacing:单元格间的间距 -->
	<table cellspacing="20px">
		<tr>
			<td width="80px;">博客标题:</td>
			<td>
				<input class="easyui-textbox" id="title" name="title" value="C/C++" style="width:400px;"/>
			</td>
		</tr>
		<tr>
			<td>博客类型:</td>
			<td>
				<select name="type" class="easyui-combobox" style="width:154px" editable="false" panelHeight="auto">
					<option value="">请选择博客类型</option>
					<option value="C/C++">C/C++</option>
					<option value="Java">Java</option>
					<option value="MySQL">MySQL</option>
					<option value="Android">Android</option>
					<option value="PHP">PHP</option>
					<option value="Python">Python</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>写作日期:</td>
			<td>
				<input class="easyui-datebox" required="required" editable="false"/>
			</td>
		</tr>
		<tr>
			<!-- valign 属性规定单元格中内容的垂直排列方式。 -->
			<td valign="top">博客内容:</td>
			<td><script id="editor" name="content" type="text/plain" style="width:100%;height:310px;"></script></td>
		</tr>
		<tr>
			<td>关键字:</td>
			<td>
				<!-- 如果使用 class="easyui-textbox",placeholder的属性就会失效-->
				<input class="easyui-textbox" id="keywords" name="keyWords" style="width:500px;" placeholder="多个关键字的话请用空格隔开"/><br/>(多个关键字的话请用空格隔开)
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<a href="javascript:submitBlogData()" class="easyui-linkbutton" data-options="iconCls:'icon-fabu'">发布博客</a>
			</td>
		</tr>
	</table> 
</div>
<script type="text/javascript">
	function submitBlogData(){
		
	}
</script>
</body>
</html>