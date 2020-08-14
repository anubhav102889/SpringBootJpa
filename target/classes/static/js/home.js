/**
 * 
 */

console.log('home');
$(document).ready(function(){
	var grid=$("homegrid");
	
	grid.jqGrid({
		caption:'DepartmentEmployeeGrid',
		colNames:['DepartmentId','DepartmentName','EmployeeId','EmployeeName','EmployeeMail','EmployeeGender','EmployeeDoj'
			,'EmployeeTypeName'],
		colModel:[
			 {name:'deptId',index:'deptId',hidden:true},
			 {name:'deptName',index:'deptName'},
			 {name:'empId',index:'empId',hidden:true},
			 {name:'empName',index:'empName',editable:true,editrules:{ required:true}},
			 {name:'empMail',index:'empMail',editable:true,editrules:{ required:true,email:true}},
			 {name:'empGender',index:'empGender',editable:true,edittype:'select',
				 editoptions:{value:{'Male':'MALE','Female':'FEMALE'}}, editrules:{ required:true},
				 formatter:'select',search:true,stype:'select',},
		    {name:'empMail',index:'empMail',editable:true,editrules:{ required:true,email:true}},	 
				
		]
		gridview:true,
		height:'auto',
		loadonce:true,
		mtype:'GET',
		pager:'#pager',
		postData:"",
		rowList:[5,10,20],
		rownumbers:true,
		sortable:true,
		sortname:'deptName',
		sortorder:'asc',
		toolbar:[true,'top'],	
		url:'/SpringBootJpa/departmentemployeefieldsList',
		jsonReader: {
		    repeatitems: false,
		    id: "empId",
		    root: function (obj) { return obj; },
		    page: function (obj) { return 1; },
		    total: function (obj) { return 1; },
		    records: function (obj) { return obj.length; }
		}
		
	})
})