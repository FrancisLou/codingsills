<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
    <link href="${ctx}/static/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Fancybox <small>http://fancybox.net/</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="basic_gallery.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="basic_gallery.html#">选项1</a>
                                </li>
                                <li><a href="basic_gallery.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">

                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片1">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片2">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p3.jpg" title="图片3">
                            <img alt="image" src="${ctx}/static/images/p_big3.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片4">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片5">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p3.jpg" title="图片6">
                            <img alt="image" src="${ctx}/static/images/p_big3.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片7">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片8">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片9">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片10">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p3.jpg" title="图片11">
                            <img alt="image" src="${ctx}/static/images/p_big3.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片12">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片13">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p3.jpg" title="图片14">
                            <img alt="image" src="${ctx}/static/images/p_big3.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p1.jpg" title="图片15">
                            <img alt="image" src="${ctx}/static/images/p_big1.jpg" />
                        </a>
                        <a class="fancybox" href="${ctx}/static/images/p2.jpg" title="图片16">
                            <img alt="image" src="${ctx}/static/images/p_big2.jpg" />
                        </a>


                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
    <script src="${ctx}/static/plugins/peity/jquery.peity.min.js"></script>
    <script src="${ctx}/static/plugins/fancybox/jquery.fancybox.js"></script>
    <script>
        $(document).ready(function(){$(".fancybox").fancybox({openEffect:"none",closeEffect:"none"})});
    </script>
</body>

</html>
