<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<!-- 引入css文件，不限顺序 -->
<link rel="stylesheet" href="${basePath }static/easyui/themes/ui-cupertino/easyui.css" type="text/css" id="easyuiTheme"/>
<link rel="stylesheet" href="${basePath }static/easyui/themes/icon.css" type="text/css"/>

<!-- 引入js文件，有顺序限制 -->
<script type="text/javascript" src="${basePath }static/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="${basePath }static/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${basePath }static/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath }static/easyui/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${basePath }static/js/jquery.json-2.4.js"></script>
<script type="text/javascript" src="${basePath }static/js/changeEasyUITheme.js"></script>