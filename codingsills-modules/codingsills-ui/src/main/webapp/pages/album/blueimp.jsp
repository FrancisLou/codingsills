<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
    <link href="${ctx}/static/plugins/blueimp/css/blueimp-gallery.min.css" rel="stylesheet">
    <style>
        .lightBoxGallery img {
            margin: 5px;
            width: 160px;
        }
    </style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">

                    <div class="ibox-content">

                        <h2>相册插件</h2>
                        <p>
                            <strong>blueimp Gallery</strong>主要为移动设备而设计，同时也支持桌面浏览器。可定制视频和相片，支持触摸操作，支持全屏播放等。项目地址： <a href="https://github.com/blueimp/Gallery" target="_blank">https://github.com/blueimp/Gallery</a>
                        </p>

                        <div class="lightBoxGallery">
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>
                            <a href="${ctx}/static/images/p_big1.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p1.jpg"></a>
                            <a href="${ctx}/static/images/p_big2.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p2.jpg"></a>
                            <a href="${ctx}/static/images/p_big3.jpg" title="图片" data-gallery=""><img src="${ctx}/static/images/p3.jpg"></a>

                            <div id="blueimp-gallery" class="blueimp-gallery">
                                <div class="slides"></div>
                                <h3 class="title"></h3>
                                <a class="prev">‹</a>
                                <a class="next">›</a>
                                <a class="close">×</a>
                                <a class="play-pause"></a>
                                <ol class="indicator"></ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
    <script src="${ctx}/static/plugins/blueimp/jquery.blueimp-gallery.min.js"></script>
</body>

</html>
