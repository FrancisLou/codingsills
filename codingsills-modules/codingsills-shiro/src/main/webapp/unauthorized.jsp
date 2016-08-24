<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./WEB-INF/views/common/tag.jsp"%>
<html>
<head>
	<%@ include file="./WEB-INF/views/common/common.jsp" %> 
    <title>没有权限</title>
    <style>.error{color:red;}</style>
</head>
<body>
<div>权限异常</div>
<div class="error">您没有权限[${exception.message}]</div>
</body>
</html>