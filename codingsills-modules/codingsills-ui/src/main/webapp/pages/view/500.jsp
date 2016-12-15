<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
</head>


<body class="gray-bg">
    <div class="middle-box text-center animated fadeInDown">
        <h1>500</h1>
        <h3 class="font-bold">服务器内部错误</h3>

        <div class="error-desc">
            服务器好像出错了...
            <br/>您可以返回主页看看
            <br/><a href="index.html" class="btn btn-primary m-t">主页</a>
        </div>
    </div>
    <script src="${ctx}/static/js/jquery.min.js?v=2.1.4" type="text/javascript" ></script>
    <script src="${ctx}/static/plugins/bootstrap/js/bootstrap.min.js?v=3.3.7" type="text/javascript" ></script>
</body>

</html>
