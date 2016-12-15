<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>基本</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="timeline.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="timeline.html#">选项1</a>
                                </li>
                                <li><a href="timeline.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>

                    <div class="ibox-content timeline">

                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-briefcase"></i> 6:00
                                    <br>
                                    <small class="text-navy">2 小时前</small>
                                </div>
                                <div class="col-xs-7 content no-top-border">
                                    <p class="m-b-xs"><strong>服务器已彻底崩溃</strong>
                                    </p>

                                    <p>还未检查出错误</p>

                                    <p><span data-diameter="40" class="updating-chart" style="display: none;">3,9,6,5,9,4,7,3,2,9,8,7,4,5,1,2,9,5,4,7,2,7,7,3,5,2,3,3,2,1,6,9,8,8,3,7,4</span>
                                        <svg class="peity" height="16" width="64">
                                            <polygon fill="#1ab394" points="0 15 0 10.5 1.7777777777777777 0.5 3.5555555555555554 5.5 5.333333333333333 7.166666666666666 7.111111111111111 0.5 8.88888888888889 8.833333333333332 10.666666666666666 3.833333333333332 12.444444444444443 10.5 14.222222222222221 12.166666666666666 16 0.5 17.77777777777778 2.166666666666666 19.555555555555554 3.833333333333332 21.333333333333332 8.833333333333332 23.11111111111111 7.166666666666666 24.888888888888886 13.833333333333334 26.666666666666664 12.166666666666666 28.444444444444443 0.5 30.22222222222222 7.166666666666666 32 8.833333333333332 33.77777777777778 3.833333333333332 35.55555555555556 12.166666666666666 37.33333333333333 3.833333333333332 39.11111111111111 3.833333333333332 40.888888888888886 10.5 42.666666666666664 7.166666666666666 44.44444444444444 12.166666666666666 46.22222222222222 10.5 48 10.5 49.77777777777777 12.166666666666666 51.55555555555555 13.833333333333334 53.33333333333333 5.5 55.11111111111111 0.5 56.888888888888886 2.166666666666666 58.666666666666664 2.166666666666666 60.44444444444444 10.5 62.22222222222222 3.833333333333332 64 8.833333333333332 64 15"></polygon>
                                            <polyline fill="transparent" points="0 10.5 1.7777777777777777 0.5 3.5555555555555554 5.5 5.333333333333333 7.166666666666666 7.111111111111111 0.5 8.88888888888889 8.833333333333332 10.666666666666666 3.833333333333332 12.444444444444443 10.5 14.222222222222221 12.166666666666666 16 0.5 17.77777777777778 2.166666666666666 19.555555555555554 3.833333333333332 21.333333333333332 8.833333333333332 23.11111111111111 7.166666666666666 24.888888888888886 13.833333333333334 26.666666666666664 12.166666666666666 28.444444444444443 0.5 30.22222222222222 7.166666666666666 32 8.833333333333332 33.77777777777778 3.833333333333332 35.55555555555556 12.166666666666666 37.33333333333333 3.833333333333332 39.11111111111111 3.833333333333332 40.888888888888886 10.5 42.666666666666664 7.166666666666666 44.44444444444444 12.166666666666666 46.22222222222222 10.5 48 10.5 49.77777777777777 12.166666666666666 51.55555555555555 13.833333333333334 53.33333333333333 5.5 55.11111111111111 0.5 56.888888888888886 2.166666666666666 58.666666666666664 2.166666666666666 60.44444444444444 10.5 62.22222222222222 3.833333333333332 64 8.833333333333332" stroke="#169c81" stroke-width="1" stroke-linecap="square"></polyline>
                                        </svg>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-file-text"></i> 7:00
                                    <br>
                                    <small class="text-navy">3小时前</small>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>修复了0.5个bug</strong>
                                    </p>
                                    <p>重启服务</p>
                                </div>
                            </div>
                        </div>
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-coffee"></i> 8:00
                                    <br>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>喝水、上厕所、做测试</strong>
                                    </p>
                                    <p>
                                        喝了4杯水，上了3次厕所，控制台输出出2324个错误，神啊，带我走吧
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-phone"></i> 11:00
                                    <br>
                                    <small class="text-navy">21小时前</small>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>项目经理打电话来了</strong>
                                    </p>
                                    <p>
                                        TMD，项目经理居然还没有起床！！！
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-user-md"></i> 09:00
                                    <br>
                                    <small>21小时前</small>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>开会</strong>
                                    </p>
                                    <p>
                                        开你妹的会，老子还有897894个bug没有修复
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="fa fa-comments"></i> 12:50
                                    <br>
                                    <small class="text-navy">讨论</small>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>…………</strong>
                                    </p>
                                    <p>
                                        又是操蛋的一天
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
    <script src="${ctx}/static/plugins/peity/jquery.peity.min.js"></script>
    <script src="${ctx}/static/demo/peity-demo.min.js"></script>
</body>

</html>
