<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Admin Dashboard</title>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body background="${pageContext.request.contextPath}/static/image/bg2.jpg">
        <table border="1" width="80%" align="center">
            <tr>
                <td height="100px">
                    <!-- header -->	
                    <jsp:include page="include/header.jsp"/>
                </td>

            </tr>

            <tr>
                <td height="25px">
                    <!-- Menu -->		
                    <jsp:include page="include/menu.jsp"/>
                </td>

            </tr>
            <tr>
                <td height="350px" valign="top">
                    <!-- Page Content -->	
                    <h1>Admin Dashboard</h1>
                    TODO - html form
                </td>

            </tr>
            <tr>
                <td height="25px">
                    <!-- Footer -->	
                    <jsp:include page="include/footer.jsp"/>
                </td>

            </tr>
        </table>
    </body>
</html>