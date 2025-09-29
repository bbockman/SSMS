<!DOCTYPE HTML PUBLIC "-//W3C//DTD	HTML	4.01	Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252" %>
    <%@ page import="java.util.Date" %>
        <% String strDynIncPage="BisError.jsp" ; strDynIncPage=request.getParameter("prmDynInclPage") + ".jsp" ; %>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html;	charset=windows-1252" />
                <title>Baig International School</title>
                <link rel="stylesheet" type="text/css" href="resources/css/BISStyle.css">
                </link>
                <script src="resources/js/BISScript.js"></script>
            </head>

            <body>
                <table border="0" cellpadding="0" cellspacing="0" width="100%" height="99%">
                    <tr bgcolor="White">
                        <td>
                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                <tr height="70">
                                    <td align="left" valign="bottom" width="15%">
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <%= new Date() %>
                                    </td>
                                    <td align="center" valign="middle" width="*">
                                        Baig International School
                                    </td>
                                    <td align="right" valign="bottom" width="15%">
                                        <% out.println(request.getRemoteUser()); %>
                                            &nbsp;&nbsp;|&nbsp;&nbsp;
                                            <a href="bissecurityservlet"> Logout </a>
                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td>
                            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                <tr>
                                    <td rowspan="3" align="left">
                                        <div id="cssmenu">
                                            <ul>
                                                <li class=‘has-sub’>
                                                    <a href=‘BisControllerServlet?ParameterActionCommand=BisDashboard’>
                                                        <span>Home</span>
                                                    </a>
                                                </li>
                                                <li class=‘has-sub’>
                                                    <a href=’#’>
                                                        <span>Students</span>
                                                    </a>
                                                    <ul>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentDetails">
                                                                <span>Details</span></a>
                                                        </li>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentAcademics&sem=1">
                                                                <span>Sem-I Results</span></a>
                                                        </li>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentAcademics&sem=2">
                                                                <span>Sem-II Results</span></a>
                                                        </li>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentAttendance&sem=1">
                                                                <span>Sem-I Attendance</span></a>
                                                        </li>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentAttendance&sem=2">
                                                                <span>Sem-II Attendance</span></a>
                                                        </li>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetStudentFees">
                                                                <span>Fees</span></a>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li class=‘has-sub’>
                                                    <a href=’#’>
                                                        <span>Admin</span></a>
                                                    <ul>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=AddStudent">
                                                                <span>Add Student</span></a>
                                                        </li>
                                                        <li class=‘last’>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=EditStudent">
                                                                <span>Edit Student</span></a>
                                                        </li>
                                                        <li class=‘last’>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=ManageResult">
                                                                <span>Manage Result</span></a>
                                                        </li>
                                                        <li class=‘last’>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=ManageAttendance">
                                                                <span>Manage Attendance</span></a>
                                                        </li>
                                                        <li class=‘last’>
                                                            <a href=’\bis\jsp\ManageStudentFees.html’>
                                                                <span>Manage Fees</span></a>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li class=‘has-sub’>
                                                    <a href=’#’>
                                                        <span>Reports</span></a>
                                                    <ul>
                                                        <li>
                                                            <a
                                                                href="BisControllerServlet?ParameterActionCommand=GetReportByClass">
                                                                <span>Class</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’\bis\jsp\ReportsBus.html’>
                                                                <span>Bus</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’\bis\jsp\ReportsFees.html’>
                                                                <span>Fees</span></a>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li class=‘has-sub’>
                                                    <a href=’#’>
                                                        <span>Help</span></a>
                                                    <ul>
                                                        <li>
                                                            <a href=’\bis\jsp\ResultsLegend.html’>
                                                                <span>Legend</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’#’>
                                                                <span>FAQs</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’#’>
                                                                <span>Holiday Calender</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’#’>
                                                                <span>Escalation Matrix</span></a>
                                                        </li>
                                                        <li>
                                                            <a href=’#’>
                                                                <span>Fee Structure</span></a>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="<%=	strDynIncPage	%>" flush="true" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            &nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                    <tr id="trbgred">
                        <td align="center" colspan="2">©copyright: 2015, Mirza Yousuf Ahmed Baig, Build Web Applications
                            with Java</td>
                    </tr>
                </table>
            </body>

            </html>