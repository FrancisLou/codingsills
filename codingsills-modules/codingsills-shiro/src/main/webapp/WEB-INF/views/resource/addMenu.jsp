<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/common.jsp" %>
<title>新增菜单</title>
</head>
<body class="white-bg">
	<form class="form-horizontal" action="${ctx}/resource/addMenu.ac
	tion" method="post">
		<div class="form-group" hidden>
	    <label for="menu_parentId" class="col-sm-2 control-label">父节点ID</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="parentId" value="${parentId}" id="menu_parentId" placeholder="父节点ID">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_name" class="col-sm-2 control-label">菜单名称</label>
	    <div class="col-sm-10">
	      <input type="text" name="name" class="form-control" id="menu_name" placeholder="菜单名称">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_link" class="col-sm-2 control-label">菜单路径</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="url" id="menu_link" placeholder="菜单路径">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_icon" class="col-sm-2 control-label">菜单图标</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" name="icon" id="menu_icon" placeholder="菜单图标">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="menu_weight" class="col-sm-2 control-label">菜单权重</label>
	    <div class="col-sm-10">
	      <input type="number" class="form-control" name="weight" id="menu_weight" placeholder="菜单权重">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button type="submit" class="btn btn-primary">新增</button>
	      <button id="toBack" type="button" class="btn btn-default">返回</button>
	    </div>
	  </div>
	</form>
<script type="text/javascript">
	function toBack(){
		$('#toBack').on('click',function(){
			window.location.href='${ctx}/resource/list.t';
		});
	}
	$(function(){
		toBack();
	});
</script>
</body>
</html>