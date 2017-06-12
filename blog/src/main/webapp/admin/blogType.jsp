<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/header.jsp" %>
<title>博客类别管理</title>
</head>
<body style="margin:1px;font-family:'microsoft yahei'">
	<table id="dg" class="easyui-datagrid" toolbar="#tb" title="博客类别管理"
		iconCls="icon-blogType" width="100%" fitColumns="true" rownumbers="true" pagination="true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" width="28%" align="center">编号</th>
				<th field="typeName" width="35%" align="center">博客类别名称</th>
				<th field="orderNum" width="35%" align="center">类别排序</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="javascript:openAddDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
		<a href="javascript:openEditDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
		<a href="javascript:deleteBlogType()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		<a href="javascript:printExcel()" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">打印</a> 
	</div>
	<!-- resizable:是否可以调整大小
		closed:true---关闭的
	 -->
	<div id="dlg" class="easyui-dialog" style="width:350px;height:190px;"   
        data-options="closed:true,buttons:'#dlg-buttons'" > 
        <form id="fm" method="post">  
	   		<table cellspacing="20px">
	   			<tr>
	   				<td>博客类别名称:</td>
	   				<td><input class="easyui-textbox" required="true" type="text" id="typeName" name="typeName" style="width:100%"/></td>
	   			</tr>
	   			<tr>
	   				<td>类&nbsp;&nbsp;别&nbsp;&nbsp;排&nbsp;&nbsp;序:</td>
	   				<td><input class="easyui-numberbox" required="true" type="text" id="orderNum" name="orderNum" placeholder="博客类别会根据序号从小到大排列" style="width:100%"/></td>
	   			</tr>
	   		</table>
   		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:save()" class="easyui-linkbutton" iconCls="icon-confirm">保存</a>
		<a href="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel" class="easyui-linkbutton">取消</a>
	</div>
</body>
<script type="application/javascript">
	function save(){
		$("#fm").form("submit",{
			url: url,
			onSubmit: function() {
				return $(this).form("validate");
			}, //进行验证，通过才让提交
			success: function(result) {
				var result = eval("(" + result + ")"); //将json格式的result转换成js对象
				if(result.success) {
					$.messager.alert("系统提示", "博客类别保存成功");
					$("#typeName").val(""); //保存成功后将内容置空
					$("#orderNum").val("");
					$("#dlg").dialog("close"); //关闭对话框
					$("#dg").datagrid("reload"); //刷新一下
				} else {
					$.messager.alert("系统提示", "博客类别保存失败");
					return;
				} 
			}
		});
	}
	
	
	function deleteBlogType(){
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

	function openEditDialog(){
		//var selectedRow==$("#dg").datagrid("getSelected") //取得选中行数据：
		// 取得所有选中行的 itemid
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert('系统提示','请选择一个修改的数据');
			return;
		}
		$("#dlg").dialog({
			title:"编辑博客类别信息",
			iconCls:"icon-edit",
			closed:false
		});
		var row=selectedRows[0];
		
	}
	
	
	
	function openAddDialog(){
		$("#dlg").dialog({
			title:'添加博客类别信息',
			iconCls:"icon-add",
			closed:false
		});
	}
	
	// page:当前的页码
	// rows:每页显示的条数
	function paging(page, rows, userName) {
		var index = (page - 1) * rows;
		var uri="operationlog/"+index+"/"+page+"/"+rows;
		$.ajax({
			type : 'GET',
			url : 	uri,
			data : {"userName":userName},
			contentType : "application/json",
			async : true,
			success : function(data) {
				$('#dg').datagrid({
					data : data.datas,
					pageList : [ 5, 10 ],
				});

				var p = $("#dg").datagrid("getPager");
				$(p).pagination({
					total : data.totalRows,
					pageNumber : data.page,
					pageSize : data.rows,
					onSelectPage : function(pageNumber, pageSize) {
						$(this).pagination('loading');
						paging(pageNumber, pageSize, userName);
						$(this).pagination('loaded');
					}
				});
			}
		});
	}
	
	paging(1, 5, '');
	
</script>
</html>