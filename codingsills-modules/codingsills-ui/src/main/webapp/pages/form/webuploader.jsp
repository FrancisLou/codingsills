<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/webuploader/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/static/demo/webuploader-demo.min.css" />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">

                    <div class="ibox-content">

                        <h2>
                                Web Uploader
                            </h2>
                        <p>
                            WebUploader是由Baidu WebFE(FEX)团队开发的一个简单的以HTML5为主，FLASH为辅的现代文件上传组件。在现代的浏览器里面能充分发挥HTML5的优势，同时又不摒弃主流IE浏览器，沿用原来的FLASH运行时，兼容IE6+，iOS 6+, android 4+。两套运行时，同样的调用方式，可供用户任意选用。 采用大文件分片并发上传，极大的提高了文件上传效率。
                        </p>

                        <div class="alert alert-warning">
                            官方文档及更多示例请参考：
                            <a href="http://fex.baidu.com/webuploader/" target="_blank">http://fex.baidu.com/webuploader/</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>百度Web Uploader</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_file_upload.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_file_upload.html#">选项1</a>
                                </li>
                                <li><a href="form_file_upload.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="page-container">
                            <p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮，来体验此demo.</p>
                            <div id="uploader" class="wu-example">
                                <div class="queueList">
                                    <div id="dndArea" class="placeholder">
                                        <div id="filePicker"></div>
                                        <p>或将照片拖到这里，单次最多可选300张</p>
                                    </div>
                                </div>
                                <div class="statusBar" style="display:none;">
                                    <div class="progress">
                                        <span class="text">0%</span>
                                        <span class="percentage"></span>
                                    </div>
                                    <div class="info"></div>
                                    <div class="btns">
                                        <div id="filePicker2"></div>
                                        <div class="uploadBtn">开始上传</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
	<script src="${ctx}/static/plugins/webuploader/webuploader.min.js" type="text/javascript" ></script>
	<script src="${ctx}/static/demo/webuploader-demo.min.js" type="text/javascript" ></script>
    <script>
    	var BASE_URL = 'static/plugins/webuploader';
    </script>
</body>

</html>
