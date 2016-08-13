<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/tag.jsp"%>
<html>
<head>
	<%@ include file="../common/common.jsp" %>
	<link href="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.js" type="text/javascript" ></script>
	<title>新增角色</title>
</head>
	
<body class="white-bg">
	<div class="panel panel-default">
		<div class="panel-heading">新增角色</div>
		<div class="panel-body">
			<form id="addForm" method="post" action="${ctx}/role/addRole.t" class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-3 control-label">角色名</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="roleCn"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色代码</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="role"  />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色描述</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="description" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色权限</label>
					<input type="hidden" name="resIds" id="role_res"/>
					<div class="col-lg-5">
						<div id="tree"></div>
					</div>
				</div>
				<div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button type="submit" class="btn btn-primary">新&emsp;增</button>
                        <button id="toBack" type="button" class="btn btn-default">返&emsp;回</button>
                    </div>
                </div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var $tree = $('#tree');
		var selectNodeIds = new Array(0);
		function initBtn(){
			$('#toBack').on('click',function(){
				window.location.href='${ctx}/role/list.t';
			});
		}
		function getTree(){
			var menuJson;
			$.ajax({
				url:'${ctx}/role/showRoleMenu.json',
				data:{'roleId':0},
				async:false,
				success:function(data){
					menuJson = data;
				}
			});
			return menuJson;
		}
		$(function(){
			$('#addForm').bootstrapValidator({
				message: '参数无效',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        submitHandler:function(validator, form, submitButton){
		        	//TODO to do something before submit
		        	validator.defaultSubmit();
		        },
		        fields:{
					name:{
						message:'角色名无效',
						validators:{
							notEmpty:{
								message:'角色名不能为空'
							}
						}
					},
					code:{
						message:'角色编号无效',
						validators:{
							notEmpty:{
								message:'角色编号不能为空'
							}
						}
					}
				}
			});
			initBtn();

			$tree.treeview({
				data: getTree(),
				showCheckbox:true,
				onNodeChecked:function(event,data){
					iterationCheck(data);
					console.log(selectNodeIds.join(','));
					$('#role_res').val(selectNodeIds.join(','));
				},
				onNodeUnchecked:function(event,data){
					iterationUnCheck(data);
					console.log(selectNodeIds.join(','));
					$('#role_res').val(selectNodeIds.join(','));
				}
			});
			//展开菜单树
			$('#tree').treeview('expandAll', { levels: 2, silent: true });
		});
		
		/* boostrap-treeview checkbox迭代选中  */
		function iterationCheck(data){
			var childNodes = data.nodes;
			if(childNodes == undefined){
				if($.inArray(data.id,selectNodeIds)== -1){
					selectNodeIds.push(data.id);
				}
				return;
			}
			if(childNodes.length>0){
				$.each(childNodes,function(i,childNode){
					$tree.treeview('checkNode',[childNode.nodeId,{silent: true }]);
					if($.inArray(childNode.id,selectNodeIds)== -1){
						selectNodeIds.push(childNode.id);
					}
					iterationCheck(childNode);
				});
			}
		}
		/* boostrap-treeview checkbox迭代未选中  */
		function iterationUnCheck(data){
			var childNodes = data.nodes;
			if(childNodes == undefined){
				//判断父节点是否存于被全选状态
				var parentNode = $tree.treeview('getParent', data);
				$tree.treeview('uncheckNode',[data.parentId,{silent: true }]);
				if(parentNode != undefined){
					$tree.treeview('uncheckNode',[parentNode.parentId,{silent: true }]);
				}
				selectNodeIds.splice($.inArray(data.id,selectNodeIds),1);
				return;
			} 
			if(childNodes.length>0){
				$.each(childNodes,function(i,childNode){
					$tree.treeview('uncheckNode',[childNode.nodeId,{silent: true }]);
					selectNodeIds.splice($.inArray(childNode.id,selectNodeIds),1);
					iterationUnCheck(childNode);
				});
			}
		}
		
	</script>
</body>
</html>
