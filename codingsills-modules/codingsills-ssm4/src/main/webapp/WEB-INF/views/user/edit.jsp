<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/tag.jsp"%>
<html>
<head>
<%@ include file="../common/common.jsp" %>
	<title>修改用户</title>
</head>
	
<body class="white-bg">
	<div class="panel panel-default">
		<div class="panel-heading">修改用户</div>
		<div class="panel-body">
			<form id="editForm" method="post" action="${ctx}/user/editUser.t" class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-3 control-label">用户名</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="userName" value="${user.userName}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">姓名</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="realName" value="${user.realName}"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">原始密码</label>
					<div class="col-lg-5">
						<input class="form-control" type="password" name="oldPwd" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">新密码</label>
					<div class="col-lg-5">
						<input class="form-control" type="password" name="password" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">确认新密码</label>
					<div class="col-lg-5">
						<input class="form-control" type="password" name="confirmPassword" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-3 control-label">Email</label>
					<div class="col-lg-5">
						<input class="form-control" type="text" name="email" value="${user.email}"/>
					</div>
				</div>
				<div class="form-group">
				    <label class="col-lg-3 control-label">角色</label>
					<div class="col-lg-5">
						<c:forEach var="role" items="${roles}">
							<input type="checkbox" name="roleAry"  value="${role.id}" <c:if test="${fn:contains(userRole,role.id)}">checked</c:if>>${role.roleCn}
						</c:forEach>
					</div>
				</div>
				<input type="hidden" name="id" value="${user.id}" />
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
		function initBtn(){
			$('#toBack').unbind().bind('click',function(){
				window.location.href='${ctx}/user/list.t';
			});
		}
		$(function(){
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
