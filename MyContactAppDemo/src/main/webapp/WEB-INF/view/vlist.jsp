<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>User Login Page</title>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <s:url value="/static/js/jquery-3.3.1.min.js" var="jquery_url"/>
        <script src="${jquery_url}"></script>
        <script>
            function changeStatus(userId, loginStatus){
                $.ajax({
                    url: "change_status",
                    data: {userId:userId, loginStatus:loginStatus},
                    success: function (data){
                        alert(data);
                    }
                });
            }
            
        </script>
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
                    <h1>User list</h1>
                    <c:if test="${not empty listUser}">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>User ID</th>
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Username</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listUser}" var="row" varStatus="counter">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <td>
                                            ${row.userId}
                                        </td>
                                        <td>
                                            ${row.name}
                                        </td>
                                        <td>
                                            ${row.phone}
                                        </td>
                                        <td>
                                            ${row.email}
                                        </td>
                                        <td>
                                            ${row.address}
                                        </td>
                                        <td>
                                            ${row.loginName}
                                        </td>
                                        <td>
                                            <select id="id_${row.userId}" onchange="changeStatus(${row.userId}, $(this).val())">
                                                <option value="1">Active</option>
                                                <option value="2">Blocked</option>
                                            </select>
                                            <script>
                                                $("#id_${row.userId}").val(${row.loginStatus});
                                            </script>
                                        </td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>

                    <c:if test="${empty listUser}">
                        <h3>No user found</h3>
                    </c:if>


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