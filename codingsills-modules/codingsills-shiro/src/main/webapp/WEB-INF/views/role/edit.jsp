<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/tag.jsp"%>
<html>
<head>
<%@ include file="../common/common.jsp" %>
<link href="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/static/bootstrap/treeview/bootstrap-treeview.min.js" type="text/javascript" ></script>
<title>修改角色</title>
</head>
	
<body class="white-bg">
	<div class="panel panel-default">
		<div class="panel-heading">修改角色</div>
		<div class="panel-body">
			<form id="editForm" method="post" action="${ctx}/role/editRole.t" class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-3 control-label">角色名</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="roleCn" value="${role.roleCn}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色代码</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="role" value="${role.role}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色状态</label>
					<div class="col-lg-5">
						<select class="form-control" name="available">
							<option value="0" <c:if test="${role.available==false}">selected</c:if>>禁用</option>
  							<option value="1" <c:if test="${role.available==true}">selected</c:if>>启用</option>
						</select>
						<%-- <input class="form-control" type="text" name="available" value="${role.available}"/> --%>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色描述</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="description" value="${role.description}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">角色权限</label>
					<div class="col-lg-5">
						<input class="form-control" type="hidden" name="resIds" id="permissions" value="${role.resIds}"/>
						<div id="tree"></div>
					</div>
				</div>
				<input type="hidden" name="id" id="role_id" value="${role.id}"/>
				<div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button type="submit" class="btn btn-primary">保&emsp;存</button>
                        <button id="toBack" type="button" class="btn btn-default">返&emsp;回</button>
                    </div>
                </div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var $tree = $('#tree');
		var selectNodeIds = new Array(0);
		var pmsIds = $('#permissions').val();

		/* 获取菜单树 */
		function getTree(){
			var menuJson;
			$.ajax({
				url:'${ctx}/role/showRoleMenu.json',
				data:{'roleId':$('#role_id').val()},
				async:false,
				success:function(data){
					menuJson = data;
				}
			});
			return menuJson;
		}
		function initBtn(){
			$('#toBack').unbind().bind('click',function(){
				window.location.href='${ctx}/role/list.t';
			});
		}
		/* boostrap-treeview checkbox迭代选中  */
		function iterationCheck(data){
			var childNodes = data.nodes;
			if(childNodes == undefined){
				if($.inArray((data.id).toString(),selectNodeIds)== -1){
					selectNodeIds.push((data.id).toString());
				}
				return;
			}
			if(childNodes.length>0){
				$.each(childNodes,function(i,childNode){
					$tree.treeview('checkNode',[childNode.nodeId,{silent: true }]);
					if($.inArray((childNode.id).toString(),selectNodeIds)== -1){
						selectNodeIds.push((childNode.id).toString());
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
				selectNodeIds.splice($.inArray((data.id).toString(),selectNodeIds),1);
				return;
			} 
			if(childNodes.length>0){
				$.each(childNodes,function(i,childNode){
					$tree.treeview('uncheckNode',[childNode.nodeId,{silent: true }]);
					selectNodeIds.splice($.inArray((childNode.id).toString(),selectNodeIds),1);
					iterationUnCheck(childNode);
				});
			}
		}
		$(function(){
			if(pmsIds != ''){
				selectNodeIds = pmsIds.split(',');
			}
			$('#editForm').bootstrapValidator({
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
			$tree.treeview({
				showCheckbox:true,
				data: getTree(),
				onNodeChecked:function(event,data){ //声明checkbox选中
					iterationCheck(data);
					console.log(selectNodeIds.join(','));
					$('#permissions').val(selectNodeIds.join(','));
				},
				onNodeUnchecked:function(event,data){ //声明checkbox反选
					iterationUnCheck(data);
					console.log(selectNodeIds.join(','));
					$('#permissions').val(selectNodeIds.join(','));
				} 
			});
			
			$('#editForm').bootstrapValidator({
				message: '参数无效',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields:{
					userName:{
						message:'用户名无效',
						validators:{
							notEmpty:{
								message:'用户名不能为空'
							},
							stringLength: {
		                        min: 6,
		                        max: 30,
		                        message: '用户名必须大于6个字符小于30个字符'
		                    },
		                    regexp: {
		                        regexp: /^[a-zA-Z0-9_\.]+$/,
		                        message: '用户名必须由字母和数字组成'
		                    }
						}
					},
					plainPwd: {
		                validators: {
		                    notEmpty: {
		                        message: '密码不能为空'
		                    }
		                }
		            },
		            confirmPassword: {
		                validators: {
		                    notEmpty: {
		                        message: '确认密码不能为空'
		                    },
		                    identical: {
		                        field: 'plainPwd',
		                        message: '确认密码与密码不一致'
		                    }
		                }
		            },
		            email: {
		                validators: {
		                    notEmpty: {
		                        message: '邮箱地址不能为空'
		                    },
		                    emailAddress: {
		                        message: '无效的邮箱地址'
		                    }
		                }
		            },
				}
			});
			initBtn();
		});
	</script>
</body>
</html>
