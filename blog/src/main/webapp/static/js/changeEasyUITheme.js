/**
 * 更換easyui的主题
 */

function changeTheme(themeName){
	var $theme=$('#easyuiTheme');
	var $url=$theme.attr('href');
	console.info($url);
	var $href=$url.substring(0,$url.indexOf('themes'))+'themes/'+themeName+'/easyui.css';
	$theme.attr('href',$href);
	//如果使用了iframe 则要添加下面这段代码、否则的话iframe中的内容不会出现样式的改变
	var $iframe=$('iframe');
	if ($iframe.length > 0) {
	    for ( var i = 0; i < $iframe.length; i++) {
	        var ifr = $iframe[i];
	        $(ifr).contents().find('#easyuiTheme').attr('href', $href);
	    }
	}	 
		
    $.cookie('easyuiThemeName', themeName, {
        expires : 7
    });
}

/*};

if ($.cookie('easyuiThemeName')) {

    changeThemeFun($.cookie('easyuiThemeName'));

}*/