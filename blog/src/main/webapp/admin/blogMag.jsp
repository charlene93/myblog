<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp" %>
<title>博客管理</title>
</head>
<body style="margin:1px;font-family:'microsoft yahei'">
<table id="dg" class="easyui-datagrid" toolbar="#tb" title="博客管理"
		iconCls="icon-blogMsgMag" width="100%" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="18%" align="center">编号</th>
				<th field="title" width="30%" align="center">标题</th>
				<th field="releaseDate" width="30%" align="center">发布日期</th>
				<th field="blogType" width="20%" align="center">博客类型</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		&nbsp;标题&nbsp;<input class="easyui-textbox" size="20" name="s_text" id="s_title" onkeydown="if(event.keyCode==13) searchBlog()"/>
		<a href="javascript:searchBlog()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
		<a href="javascript:openEditBlogTab()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a href="javascript:deleteBlog()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a href="javascript:printExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">打印</a> 
		<a href="javascript:refresh()" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a> 
	</div>
</body>
<script type="text/javascript">
//page:当前的页码
// rows:每页显示的条数
function paging(page, rows) {
	var uri="admin/blog/listBlog/"+page+"/"+rows;
	$.ajax({
		type : 'GET',
		url : 	uri,
		contentType : "application/json",
		async : true,
		success : function(data) {
			$('#dg').datagrid({
				data : data.datas,
				pageList : [ 5, 10 ],
			});
			var p = $("#dg").datagrid("getPager");
			$(p).pagination({
				total : data.total,
				pageNumber : data.page,
				pageSize : data.pageSize,
				onSelectPage : function(pageNumber, pageSize) {
					$(this).pagination('loading');
					paging(pageNumber, pageSize);
					$(this).pagination('loaded');
				}
			});
		}
	});
}

paging(1, 5);


function deleteBlog(){
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length==0){
		$.messager.alert('系统提示','至少选择一个需要被删除的数据');
		return;
	}
	var ids=[];
	for (var i = 0; i < selectedRows.length; i++) {
		ids.push(selectedRows[id].id);
	}
	var json=$.toJson(ids);
	$.messager.confirm('确认',"<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>",function(result){    
	    if (result){    
	    	$.ajax({
				type : "post",
				url : "admin/link/deleteBlog",
				data : json,
				contentType : "application/json",
				asyn : true,
				success : function(data) {
					if(data.result>0) {
						$.messager.alert("系统提示", "评论删除成功！");
						$("#dg").datagrid("reload");
					} else {
						$.messager.alert("系统提示", "评论删除失败！");
					}
				}
			});    
	    }    
	});  

}

function openEditBlogTab(){
	//var selectedRow==$("#dg").datagrid("getSelected") //取得选中行数据：
	// 取得所有选中行的 itemid
	var selectedRows=$("#dg").datagrid("getSelections");
	if(selectedRows.length!=1){
		$.messager.alert('系统提示','请选择一个修改的数据');
		return;
	}
	var row=selectedRows[0];
	window.parent.openTab('修改博客','icon-modify','modifyBlog.jsp?id='+row.id);
}

function searchBlog(){
	$("#dg").datagrid("load",{
		"title":$("#s_title").vaul()
	})
}
</script>
</html>