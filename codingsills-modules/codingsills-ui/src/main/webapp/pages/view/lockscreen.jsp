<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>


<body class="gray-bg">

    <div class="lock-word animated fadeInDown">
    </div>
    <div class="middle-box text-center lockscreen animated fadeInDown">
        <div>
            <div class="m-b-md">
                <img alt="image" class="img-circle circle-border" src="${ctx}/static/images/a1.jpg">
            </div>
            <h3>Beaut-zihan</h3>
            <p>您需要再次输入密码</p>
            <form class="m-t" role="form" action="index.html">
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="******" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width">登录到H+</button>
            </form>
        </div>
    </div
    <script src="${ctx}/static/js/jquery.min.js?v=2.1.4" type="text/javascript" ></script>
    <script src="${ctx}/static/plugins/bootstrap/js/bootstrap.min.js?v=3.3.7" type="text/javascript" ></script>
</body>

</html>
