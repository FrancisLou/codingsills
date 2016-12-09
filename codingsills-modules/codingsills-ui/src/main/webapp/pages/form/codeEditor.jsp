<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <title>M+ 后台主题UI框架 - 主页示例</title>
    <%@include file="../common/commcss.jsp" %>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/codemirror/codemirror.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/static/plugins/codemirror/theme/ambiance.css" />
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>基本编辑器</h5>
                    </div>
                    <div class="ibox-content">

                        <p class="m-b-lg">
                            <strong>CodeMirror</strong> 是一个灵活的文本代码编辑器。它是专门用于编辑代码，并附带一些语言模块和插件，实现更先进的编辑功能。
                        </p>

<textarea id="code1">
<script>
    // Code goes here

    // For demo purpose - animation css script
    function animationHover(element, animation) {
        element = $(element);
        element.hover(
            function () {
                element.addClass('animated ' + animation);
            },
            function () {
                //wait for animation to finish before removing classes
                window.setTimeout(function () {
                    element.removeClass('animated ' + animation);
                }, 2000);
            });
    }
</script>
</textarea>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>主题示例</h5>
                    </div>
                    <div class="ibox-content">

                        <p class="m-b-lg">
                            <strong>CodeMirror</strong>提供丰富的API接口和CSS主题，详情请访问
                            <a href="http://codemirror.net/" target="_blank">http://codemirror.net/</a>
                        </p>
<textarea id="code2">
var SpeechApp = angular.module('SpeechApp', []);

function VoiceCtrl($scope) {

    $scope.said='...';

    $scope.helloWorld = function() {
        $scope.said = "Hello world!";
    }

    $scope.commands = {
        'hello (world)': function() {
            if (typeof console !== "undefined") console.log('hello world!')
            $scope.$apply($scope.helloWorld);
        },
        'hey': function() {
            if (typeof console !== "undefined") console.log('hey!')
            $scope.$apply($scope.helloWorld);
        }
    };

    annyang.debug();
    annyang.init($scope.commands);
    annyang.start();
}
</textarea>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="../common/commjs.jsp" %>
    <script src="${ctx}/static/plugins/peity/jquery.peity.min.js"></script>
	<script src="${ctx}/static/plugins/codemirror/codemirror.js" type="text/javascript" ></script>
    <script src="${ctx}/static/plugins/codemirror/mode/javascript/javascript.js" type="text/javascript" ></script>
	<script>
        $(document).ready(function(){var editor_one=CodeMirror.fromTextArea(document.getElementById("code1"),{lineNumbers:true,matchBrackets:true,styleActiveLine:true,theme:"ambiance"});var editor_two=CodeMirror.fromTextArea(document.getElementById("code2"),{lineNumbers:true,matchBrackets:true,styleActiveLine:true})});
    </script>
</body>

</html>
