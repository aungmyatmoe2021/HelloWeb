/**
 * 
 */

function updateAction(id){
	window.alert(id);
	frmMemberList.method = "get";
	frmMemberList.action = "/helloweb/userroleentry?id="+id;
	frmMemberList.submit();
}

function deleteRoleRecord(id){
	if(window.confirm("Are you sure delete this record?")){
		frmMemberList.hidID.value = id;
		frmMemberList.hidStatus.value= 'D';
		
		frmMemberList.method="get";
//		frmMemberList.action = "/helloweb/userroleentry";
		frmMemberList.action = "/helloweb/testentry";
		frmMemberList.submit();
	}
}