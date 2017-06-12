<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
				<select id="blogTypeId" name="blogType.id" class="easyui-combobox" style="width:154px" editable="false" panelHeight="auto">
					<option value="">请选择博客类型...</option>
					<c:forEach items="${blogTypeList }" var="blogType">
						<option value="${blogType.id }">${blogType.typeName }</option>
					</c:forEach>
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
		var title = $("#title").val();
		var blogTypeId = $("#blogTypeId").combobox("getValue");//获取下拉框被选中的项
		var content = UE.getEditor('editor').getContent();
		var summary = UE.getEditor('editor').getContentTxt().substr(0, 155);
		var keyWord = $("#keyWord").val();
		var contentNoTag = UE.getEditor('editor').getContentTxt();
		if (title == null || title == '') {
			$.messager.alert("系统提示", "请输入标题！");
		} else if (blogTypeId == null || blogTypeId == '') {
			$.messager.alert("系统提示", "请选择博客类型！");
		} else if (content == null || content == '') {
			$.messager.alert("系统提示", "请编辑博客内容！");
		} else {
			$.post("${pageContext.request.contextPath}/admin/blog/save",
			{
				'title' : title,
				'blogType.id' : blogTypeId,
				'content' : content,
				'summary' : summary,
				'keyWord' : keyWord,
				'contentNoTag' : contentNoTag
			}, function(data) {
				if (data.result>0) {
					$.messager.alert("系统提示", "博客修改成功！");
				} else {
					$.messager.alert("系统提示", "博客修改失败！");
				}
			}, "json");
		}
	}
</script>
</body>
</html>