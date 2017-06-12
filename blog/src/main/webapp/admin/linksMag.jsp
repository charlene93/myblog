<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp" %>
<title>友情链接管理</title>
</head>
<body style="margin:1px;font-family:'microsoft yahei'">
	<table id="dg" class="easyui-datagrid" toolbar="#tb" title="博客类别管理"
		iconCls="icon-linkAddress" width="100%" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="10%" align="center">编号</th>
				<th field="linkname" width="30%" align="center">友情链接名称</th>
				<th field="linkurl" width="48%" align="center">友情链接地址</th>
				<th field="order" width="10%%" align="center">友情链接序号</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="javascript:openAddDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
		<a href="javascript:openEditDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		<a href="javascript:deleteLink()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a href="javascript:printToExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">打印</a> 
	</div>
	<!-- resizable:是否可以调整大小
		closed:true---关闭的
	 -->
	<div id="dlg" class="easyui-dialog" style="width:600px;height:274px;"   
        data-options="closed:true,buttons:'#dlg-buttons'" > 
        <form id="fm" method="post">  
	   		<table cellspacing="20px" style="margin:20px 22px;">
	   			<tr width="80px;">
	   				<td>友情链接名称:</td>
	   				<td><input class="easyui-textbox" required="true" id="linkname" name="linkname" style="width:400px;"/></td>
	   			</tr>
	   			<tr>
	   				<td>友情链接地址:</td>
	   				<td><input class="easyui-textbox" validType="url" required="true" id="linkurl" name="linkurl" style="width:400px"/></td>
	   			</tr>
	   			<tr>
	   				<td>友情链接排序:</td>
	   				<!-- <br/>(友情链接会根据序号从小到大排列) -->
	   				<td><input class="easyui-textbox" required="true" id="order" name="order" style="width:200px"/>(友情链接会根据序号从小到大排列)</td>
	   			</tr>
	   		</table>
   		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton" iconCls="icon-confirm">保存</a>
		<a href="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
	</div>
	<script>
	function save(){
		var $linkname=$("#linkname").val();
		var $linkurl=$("#linkurl").val();
		var $order=$("#order").val();
		if($linkname!=""&&$linkurl!=""&&$order!=""){
			/* var json=$.toJson(blogTypeData);
			// ajax提交数据如果添加成功就有提示对话框，提示添加成功，否则添加失败
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/admin/addLink"
				data:json,
				contentType:"application/json",
				async:true,
				success:function(data){
					
				}
			}); */
		}else{
			$.messager.alert("系统提示","不能有空数据");
		}
	}
	
	
	function deleteLink(){
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert('系统提示','至少选择一个需要被删除的数据');
			return;
		}
		
		$.messager.confirm('确认',"<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>",function(result){    
		    if (result){    
		        alert('确认删除');    
		    }    
		});  

	}
	// 打开修改操作的对话框
	function openEditDialog(){
		//var selectedRow==$("#dg").datagrid("getSelected") //取得选中行数据：
		// 取得所有选中行的 itemid
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert('系统提示','请选择一个修改的数据');
			return;
		}
		$("#dlg").dialog({
			title:"修改友情链接信息",
			iconCls:"icon-edit",
			closed:false
		});
		var row=selectedRows[0];
		$("#fm").form('load',row);
	}
	
	
	//打开添加操作的对话框
	function openAddDialog(){
		$("#dlg").dialog({
			title:'添加友情链接信息',
			iconCls:"icon-add",
			closed:false
		});
	}
	</script>
</body>
</html>