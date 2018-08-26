<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>User Dashboard</title>
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
                    <c:if test="${not empty err}">
                        <p class="error">${err}</p>
                    </c:if>
                    <h1>Add contact</h1>
                    <f:form action="saveContactProcess" modelAttribute="command" method="post">
                        <table border="1">
                            <tr>
                                <td>Name</td>
                                <td><f:input path="name"/>
                                    <f:errors path="name" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><f:input path="phone"/>
                                    <f:errors path="phone" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><f:input path="email"/>
                                    <f:errors path="email" cssClass="error"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Address</td>
                                <td><f:input path="address"/></td>
                            </tr>
                            <tr>
                                <td>Remark</td>
                                <td><f:input path="remark"/></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <input type="submit" value="Save" />
                                    <input type="reset" value="Reset" />
                                </td>
                            </tr>
                        </table>

                    </f:form> 
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