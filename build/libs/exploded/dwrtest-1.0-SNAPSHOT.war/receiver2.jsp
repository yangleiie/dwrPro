<%@ page language= "java" import ="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head >
    <title>dwr接收</title >
    <script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src= "dwr/util.js"></script >
    <script type="text/javascript" src= "dwr/engine.js"></script >
    <script type="text/javascript" src= "dwr/interface/messagePush.js" ></script>
</head >

<body onload="onPageLoad();">dwr接收<br/>
<div id="content" style=" width: 200px ;height: 30px;border : 1px solid ; text-align: center ; padding: 5px;"></div>
<script type="text/javascript" >
    //这个方法用来启动该页面的ReverseAjax功能
    dwr.engine.setActiveReverseAjax(true);
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageUnload(true);
    //这个函数是提供给后台推送的时候 调用的
    /*function show(content){
        $( "#content" ).text(content);
    }*/
    onPageLoad();

    function onPageLoad(){
        var userId = 2;
        messagePush.onPageLoad(userId);
    }

    //推送信息
    function showMessage(autoMessage){

//        alert(autoMessage);
        $( "#content" ).text(autoMessage);
    }
</script>
</body >
</html>