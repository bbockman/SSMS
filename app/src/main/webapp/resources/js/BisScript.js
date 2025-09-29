function submitAddStdForm() {
    document.getElementById("paramAddStdFrmSubmitted").value = "Yes";
    document.getElementById("frmAddStudent").submit();
}
function generateRptByCls() {
    document.getElementById("frmReportByCls").submit();
}
function updateAttendance(sem) {
    if (sem == '1') {
        document.getElementById("ParameterUpdateSemAttendance").value = "1";
    }
    else if (sem == '2') {
        document.getElementById("ParameterUpdateSemAttendance").value = "2";
    }
    document.getElementById("paramUpdateAttFrmSubmitted").value = "Yes";
    document.getElementById("frmManageAttendance").submit();
}
var xmlHttpReq = false;
function getStudentAJAX() {
    var stdId = document.getElementById("txtStdId").value;
    var url = "BisAjaxControllerServlet?ParameterActionCommand=LoadStudent&txtStdId=";
    url = url + stdId;
    xmlHttpReq = new XMLHttpRequest();
    xmlHttpReq.open("GET", url, true);
    xmlHttpReq.send();
    xmlHttpReq.onreadystatechange = getStudentAjaxCallBack;
}
function getStudentAjaxCallBack() {
    if (xmlHttpReq.readyState == 4 && xmlHttpReq.status == 200) {
        document.getElementById("dvStdSmry").innerHTML = xmlHttpReq.responseText;
    }
}
