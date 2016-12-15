<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>徽章 (Badges)</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="badges_labels.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="badges_labels.html#">选项1</a>
                                </li>
                                <li><a href="badges_labels.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <p>
                            要添加徽章，只需要在元素上添加<code>.badge</code>即可，改变徽章的颜色可使用如下class，如<code>.badge-primary</code>。
                        </p>
                        <p><span class="badge">空</span>
                        </p>
                        <p><span class="badge badge-primary">badge-primary</span>
                        </p>
                        <p><span class="badge badge-info">badge-info</span>
                        </p>
                        <p><span class="badge badge-success">badge-success</span>
                        </p>
                        <p><span class="badge badge-warning">badge-warning</span>
                        </p>
                        <p><span class="badge badge-danger">badge-danger</span>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>标签 (Labels)</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="badges_labels.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="badges_labels.html#">选项1</a>
                                </li>
                                <li><a href="badges_labels.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <p>
                            要添加徽章，只需要在元素上添加class<code>.label</code>即可，如果需要修改颜色，添加如下class，如<code>.label-primary</code>
                        </p>
                        <p><span class="label">空</span>
                        </p>
                        <p><span class="label label-primary">label-primary</span>
                        </p>
                        <p><span class="label label-info">label-info</span>
                        </p>
                        <p><span class="label label-success">label-success</span>
                        </p>
                        <p><span class="label label-warning">label-warning</span>
                        </p>
                        <p><span class="label label-danger">label-danger</span>
                        </p>
                    </div>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>进度条 (Progress Bars)</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="badges_labels.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="badges_labels.html#">选项1</a>
                                </li>
                                <li><a href="badges_labels.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <h5>基本</h5>
                        <div class="progress">
                            <div style="width: 35%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="35" role="progressbar" class="progress-bar progress-bar-success">
                                <span class="sr-only">35% Complete (success)</span>
                            </div>
                        </div>

                        <div class="progress progress-bar-default">
                            <div style="width: 43%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="43" role="progressbar" class="progress-bar">
                                <span class="sr-only">43% Complete (success)</span>
                            </div>
                        </div>

                        <h5>条纹</h5>

                        <div class="progress progress-striped">
                            <div style="width: 50%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="50" role="progressbar" class="progress-bar progress-bar-warning">
                                <span class="sr-only">40% Complete (success)</span>
                            </div>
                        </div>

                        <h5>动画</h5>

                        <div class="progress progress-striped active">
                            <div style="width: 75%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75" role="progressbar" class="progress-bar progress-bar-danger">
                                <span class="sr-only">40% Complete (success)</span>
                            </div>
                        </div>

                        <h5>堆叠</h5>

                        <div class="progress progress-striped active">
                            <div style="width: 30%" class="progress-bar progress-bar-success">
                                <span class="sr-only">30% Complete (success)</span>
                            </div>
                            <div style="width: 20%" class="progress-bar progress-bar-warning">
                                <span class="sr-only">15% Complete (warning)</span>
                            </div>
                            <div style="width: 40%" class="progress-bar progress-bar-danger">
                                <span class="sr-only">40% Complete (danger)</span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
</body>

</html>
