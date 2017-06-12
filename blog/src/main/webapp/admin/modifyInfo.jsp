<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp"%>
<%@include file="/common/ueditor.jsp"%>
<title>编辑个人信息</title>
<script type="text/javascript" src="${basePath }static/datepicker/WdatePicker.js"></script>
<script type="text/javascript">
	window.UEDITOR_HOME_URL = "${basePath }static/ueditor1_4_3_3/";
	var ue=UE.getEditor('editor');
</script>
</head>
<body style="margin:5px;font-family:'microsoft yahei'">
<div id="p" class="easyui-panel" title="编辑个人信息" style="padding:10px;" data-options="iconCls:'icon-edit',fit:true">
	<form id="fm" method="post" enctype="multipart/form-data">
		<!-- cellspacing:单元格间的间距 -->
		<table cellspacing="20px">
			<tr>
				<td width="80px;">用&nbsp;&nbsp;户&nbsp;&nbsp;名:</td>
				<td>
					<input type="hidden" id="title" name="username" value="id"/>
					<input class="easyui-textbox" id="title" name="username" value="cheny" readonly="readonly" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</td>
				<td>
					<input class="easyui-textbox" required="true" id="title" name="nickname" value="charlie" style="width:200px;"/>
				</td>
			</tr>
			<tr>
				<td>个人头像:</td>
				<td>
					<input type="file" id="img" name="img"/>
				</td>
			</tr>
			<tr>
				<td>个性签名:</td>
				<td>
					<input class="easyui-textbox" id="title" name="sign" style="width:400px;" required="true"/>
				</td> 
			</tr>
			<tr>
				<!-- valign 属性规定单元格中内容的垂直排列方式。 -->
				<td valign="top">个人简介:</td>
				<td>
					<script id="editor" name="profile" type="text/plain" style="width:100%;height:140px;"></script>
					<%-- UEditor不能作为表单的一部分提交，所以用这种隐藏域的方式 --%>
					<input type="hidden" id="pf" name="profile">
				</td>
			</tr>
			<tr>
				<td>修改日期:</td>
				<td>
					<input class="text" readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="javascript:submitBlogerInfo()" class="easyui-linkbutton" data-options="iconCls:'icon-fabu'">提交</a>
				</td>
			</tr>
		</table>
	</form>     
</div>
<script type="text/javascript">
	function submitBlogerInfo(){
		$("#fm").form("submit",{
			url: "${pageContext.request.contextPath}/admin/blogger/save",
			onSubmit: function() {
				var profile = UE.getEditor("profile").getContent();
				$("#pf").val(profile); //将UEditor编辑器中的内容放到隐藏域中提交到后台
				return $(this).form("validate");
			}, //进行验证，通过才让提交
			success: function(data) {
				if(data.result>0) {
					$.messager.alert("系统提示", "博主信息更新成功");
				} else {
					$.messager.alert("系统提示", "博主信息更新失败");
					return;
				} 
			}
		});
	}
</script>
<%-- 实例化编辑器 --%>
<script type="text/javascript">
	var ue = UE.getEditor('profile');
	ue.addListener("ready", function(){
		//通过UE自己封装的ajax请求数据
		UE.ajax.request("${pageContext.request.contextPath}/admin/blogger/findBlogger",
		{
			method: "post",
			async: false,
			/* data: {}, */
			onsuccess: function(data) {
				var result=data.blogger
				$("#nickname").val(result.nickname);
				$("#sign").val(result.sign);
				UE.getEditor('profile').setContent(result.profile);
			}
		});
	});
</script>
</body>
</html>