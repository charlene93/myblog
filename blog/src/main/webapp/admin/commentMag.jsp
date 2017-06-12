<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp" %>
<title>评论管理</title>
<script type="text/javascript">
function formatTitle(val,row){
	if(val==null){
		return "<font color='red'>该博客已删除</font>"
	} else{
		return "<a href='${pageContext.request.contextPath}/admin/....'></a>"//跳转
	}
}

function formatState(val,row){
	if(val==null){
		return "待审核";
	}else if(val==2){
		return "审核通过";
	} else{
		return "审核未通过";
	}
	
}
</script>
</head>
<body style="margin:1px;font-family:'microsoft yahei'">
<table id="dg" class="easyui-datagrid" toolbar="#tb" title="评论管理"
		iconCls="icon-msgmag" width="100%" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="5%" align="center">编号ID</th>
				<th field="blog" width="25%" align="center">博客标题</th>
				<th field="userIp" width="14%" align="center">用户的IP</th>
				<th field="comment" width="30%" align="center">评论内容</th>
				<th field="commentDate" width="15%" align="center">评论日期</th>
				<th field="state" width="10%" align="center">评论状态</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td></td>
				<td>编号test01</td>
				<td><!-- 博客标题test01 --></td>
				<td>用户的IPtest01</td>
				<td>评论内容test01</td>
				<td>评论日期test01</td>
				<td><!-- 评论状态test01 --></td>
			</tr>
		</tbody>
	</table>
	<div id="tb">
		<a href="javascript:deleteComments()" class="easyui-linkbutton" data-options="iconCls:'icon-delete',plain:true">删除</a>
		<a href="javascript:refreshComments()" class="easyui-linkbutton" data-options="iconCls:'icon-refresh',plain:true">刷新</a> 
		<a href="javascript:printToExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">打印</a> 
	</div>
	<script type="text/javascript">
		function deleteComments(){
			var selectedRows=$("#dg").datagrid("getSelections");
			if(selectedRows.length==0){
				$.messager.alert('系统提示','至少选择一个需要被删除的数据');
				return;
			}
			
			/* var ids=[];
			for (var i = 0; i < selectedRows.length; i++) {
				ids.push(selectedRows[i].id);
			}
			var id=$.toJson(ids); */
			$.messager.confirm('确认',"<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>",function(result){    
			    if (result){    
			        alert('确认删除');    
			    }    
			});
		}
		
		function refreshComments(){
			$("#dg").datagrid('reload');
		}
	</script>
</body>
</html>