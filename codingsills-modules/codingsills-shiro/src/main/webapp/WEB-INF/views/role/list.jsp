<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/tag.jsp"%>
<html>
<head>
<title>角色管理</title>
<%@ include file="../common/common.jsp" %>
<script src="${ctx}/static/bootstrap/table/bootstrap-table.min.js" type="text/javascript" ></script>
<script src="${ctx}/static/bootstrap/table/bootstrap-table-zh-CN.min.js" type="text/javascript" ></script>
</head>
	
<body class="white-bg">
	<div height="100%">
		<div id="toolbar">
			<button id="b_add" class="btn btn-primary">
	            <i class="glyphicon glyphicon-plus"></i>新增
	        </button>
			<button id="b_remove" class="btn btn-danger" disabled>
	            <i class="glyphicon glyphicon-remove"></i>删除
	        </button>
		</div>
		<table id="table" data-url="${ctx}/role/query.json"></table>
	</div>
		
<script type="text/javascript">
	var $table,selections;
	function initBtn(){
		$('#b_add').on('click',function(){
			window.location.href='${ctx}/role/addRole.t';
		});
		$('#b_remove').on('click',function(){
			//window.location.href='${ctx}/user/addView.action';
			console.log('Ids', selections);
		});		
	}
	//checkbox选中激活delete按钮，未选中时禁用
	function checkboxInit(){
		$table.on('check.bs.table uncheck.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function () {
			$('#b_remove').prop('disabled', !$table.bootstrapTable('getSelections').length);
            selections = getIdSelections();
        });
	}
	//获取当前页选中记录IDs
	function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.roleId
        });
    }
	$(function(){
		$table = $('#table').bootstrapTable({
			//height:getHeight(),
			columns:[
	         	{field:'state',checkbox:true,align:'center',valign:'middle'},
	         	{field:'id',title:'ID'},
	         	{field:'roleCn',title:'角色名称'},
	         	{field:'role',title:'角色代码'},
	         	{field:'description',title:'角色描述'},
	         	{field:'opt',title:'操作',
	         		formatter:function(value,row,index){
	         			var str = '';
	         			str += formatStr('<a href="${ctx}/role/editRole.t?id={0}" title="修改"><i class="glyphicon glyphicon-edit"></i></a>',row.id);
	         			str += '&emsp;'+formatStr('<a href="${ctx}/role/deleteRole.t?id={0}" title="删除"><i class="glyphicon glyphicon-remove"></i></a>',row.id);
						return str;		
	         		}
	         	}
	        ],
	        search:true,
 	        toolbar:'#toolbar',
	        pagination:true,
	        idField:'id',
	        sidePagination:'server',
	        pageList:[10, 15, 25, 100]
		});

		initBtn();
		checkboxInit();
	});
</script>
</body>
</html>
