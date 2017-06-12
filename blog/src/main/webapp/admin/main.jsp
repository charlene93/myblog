<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp"%>
<%@include file="/common/ueditor.jsp"%>
<title>SSM个人博客系统后台</title>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="margin: 0px; height: 78px; background-color: #E0ECFF;">
		<table style="padding:5px;width:100%">
			<tr>
				<td><h2>SSM个人博客系统</h2></td>
				<td valign="bottom" align="right">
					<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>您登录</font>
				</td>
				<td valign="bottom" align="right">
					<div>
						<a href="#" class="easyui-menubutton"
							data-options="menu:'#mm1',iconCls:'icon-help'">控制面板</a>
					</div>
					<div id="mm1">
						<div data-options="iconCls:'icon-tip'">个人信息</div>
						<div data-options="iconCls:'icon-edit'">
							<span>更换皮肤</span>
							<div>
								<div onclick="javascript:changeTheme('default')">default</div>
								<div onclick="javascript:changeTheme('bootstrap')">bootstrap</div>
								<div onclick="javascript:changeTheme('gray')">gray</div>
								<div onclick="javascript:changeTheme('black')">black</div>
								<div onclick="javascript:changeTheme('material')">material</div>
								<div onclick="javascript:changeTheme('metro')">metro</div>
								<div onclick="javascript:changeTheme('metro-blue')">metro-blue</div>
								<div onclick="javascript:changeTheme('metro-gray')">metro-gray</div>
								<div onclick="javascript:changeTheme('metro-green')">metro-green</div>
								<div onclick="javascript:changeTheme('metro-orange')">metro-orange</div>
								<div onclick="javascript:changeTheme('metro-red')">metro-red</div>
								<div onclick="javascript:changeTheme('ui-sunny')">sunny</div>
								<div onclick="javascript:changeTheme('ui-dark-hive')">dark-hive</div>
								<div onclick="javascript:changeTheme('ui-pepper-grinder')">pepper-grinder</div>
								<div onclick="javascript:changeTheme('ui-cupertino')">cupertino</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<!--南边-->
	<div region="south" style="height: 25px;padding: 5px" align="center">
		Copyright © xxxx cheny的SSM博客系统 版权所有
	</div>
	<!--西边-->
	<!-- disabled:true不可调节宽度-->
	<div
		data-options="region:'west',split:true,title:'导航菜单',iconCls:'icon-nav',disabled:true"
		style="width: 150px;">
		<div id="accordionId" class="easyui-accordion"
			data-options="fit:true,border:false,animate:true,multiple:false,selected:-1">
			<div title="常用操作" data-options="iconCls:'icon-comop'"
				style="padding: 10px;">
				<a
					href="javascript:openTab('写博客','icon-writeBlog','writeBlog.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-writeBlog',plain:true">写博客</a>
				<p>
				<a
					href="javascript:openTab('评论审核','icon-shenhe','commentReview.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-shenhe',plain:true">评论审核</a>
				</p>
				
			</div>
			<div title="博客管理" data-options="iconCls:'icon-blog'" style="padding: 10px;">
				<a
					href="javascript:openTab('写博客','icon-writeBlog','writeBlog.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-writeBlog',plain:true">写博客</a>
				<p>
				<a
					href="javascript:openTab('博客信息管理','icon-blogMsgMag','blogMag.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-blogMsgMag',plain:true">博客信息管理</a>
				</p>
			</div>
			<div title="博客类别管理" data-options="iconCls:'icon-blogType',collapsible:true"
				style="padding: 10px;">
				<a href="javascript:openTab('博客类别管理','icon-blogType','blogType.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-blogType',plain:true">博客类别管理</a>
				<p>
			</div>
			<div title="评论管理" data-options="iconCls:'icon-comment',collapsible:true"
				style="padding: 10px;">
				<a
					href="javascript:openTab('评论审核','icon-shenhe','commentReview.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-shenhe',plain:true">评论审核</a>
				<p>
					<!--disabled:是否禁用-->
					<a
						href="javascript:openTab('评论信息管理 ','icon-msgmag','commentMag.jsp')"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-msgmag',plain:true">评论信息管理 </a>
				<p>
			</div>
			<div title="个人信息管理"
				data-options="iconCls:'icon-userInfo',collapsible:true"
				style="padding: 10px;">
				<a
					href="javascript:openTab('个人信息','icon-userInfo','modifyInfo.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-userInfo',plain:true">修改个人信息</a>
				<p>
			</div>
			<div title="系统管理"
				data-options="iconCls:'icon-userInfo',collapsible:true"
				style="padding: 10px;">
				<a
					href="javascript:openTab('友情链接管理','icon-linkAddress','linksMag.jsp')"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-linkAddress',plain:true">友情链接管理</a>
				<p>
					<!--disabled:是否禁用-->
					<a href="javascript:openModifyPwdDialog()"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-pwd',plain:true">修改密码</a>
				<p>
					<a href="javascript:refreshSysCache()"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-reloadCache',plain:true">刷新系统缓存</a>
				<p>
					<a href="javascript:logOut()"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-out',plain:true">安全退出</a>
				<p>
			</div>
		</div>
	</div>
	<!--中间-->
	<div data-options="region:'center'">
		<!--fit自适应父容器
            border布局边框
        	-->
		<div id="tabsID" class="easyui-tabs"
			data-options="border:false,selected:-1,fit:true">
			<div title="首页"
				data-options="iconCls:'icon-home',selected:1,fit:true"
				style="padding: 20px;"></div>
		</div>
	</div>
	<div id="dd" class="easyui-dialog" title="修改密码" style="width:400px;padding:30px 60px;" data-options="closed:true,iconCls:'icon-pwd'">
		<form id="ff" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="username" style="width:100%" value="chencharlie" data-options="label:'用户名'" readonly="readonly"/>
			</div>
			<div style="margin-bottom:20px">
				<input id="pwd" class="easyui-textbox" name="password" style="width:100%" data-options="label:'新密码',required:true"/>
			</div>
			<div style="margin-bottom:20px">
				<input id="confirmPwd" class="easyui-textbox" name="password" style="width:100%" data-options="label:'确认密码',required:true"/>
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:modifyPassword()" class="easyui-linkbutton" iconCls="icon-ok" style="width:80px">保存</a>
			<a href="javascript:closeModifyPwdDialog()" class="easyui-linkbutton" iconCls="icon-cancel" style="width:80px">取消</a>
		</div>
	</div>
	<script type="application/javascript">
		function modifyPassword(){
			
			var $pwd=$("#pwd").val();
			var $confirmPwd=$("#confirmPwd").val();
			if($pwd==null||$pwd==""||$confirmPwd==null||$confirmPwd==""){
				$.messager.alert("系统提示","不能为空!,请输入数据");
			}else{
				if($pwd==$confirmPwd){
					/* $.ajax({
					
					}); */
					$.messager.alert("系统提示","修改成功！下次登录生效");
					closeModifyPwdDialog();
				}else{
					$.messager.alert("系统提示","两次密码不一致!");
				}
			}
		}
		
		// 关闭修改密码的对话框
		function closeModifyPwdDialog(){
			$("#pwd").val(""); //保存成功后将内容置空
			$("#confirmPwd").val("");
			$("#dd").dialog({
				closed:true
			});
		}
		// 打开修改密码的对话框
		function openModifyPwdDialog(){
			$("#dd").dialog({
				closed:false,
				modal: true
			});
		}
	
    	function directContent(url) {
            var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
            return content;
        }
    	
    	function openTab(text,icon,url){
    		if($("#tabsID").tabs("exists",text)){
    			$("#tabsID").tabs("select",text);
    		}else{
    			$("#tabsID").tabs("add", {
                    "title": text,
                    "closable": true,
                    "content": directContent(url),
                    "iconCls": icon
                });
    		}
    	}
	</script>
</body>
</html>