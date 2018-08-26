<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<s:url value="/registerForm" var="registerForm_url"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>User Login Page</title>
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
                    <h1>Contact List</h1>
                    <c:if test="${param.act eq 'saved'}">
                        <p class="success">Save contact successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'deleted'}">
                        <p class="success">Delete contact successfully</p>
                    </c:if>
                    <c:if test="${not empty err}">
                        <p class="success">${err}</p>
                    </c:if>


                    <form action="searchContact" method="get">
                        <input type="text" name="searchValue" value="${param.searchValue}" />
                        <input type="submit" value="Search" />
                    </form>
                    <c:if test="${not empty listContact}">



                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Contact ID</th>
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Remark</th>
                                    <th>Action</th>
                                    <th>Choose</th>
                                </tr>
                            </thead>
                            <tbody>
                            <form action="multipleDelete" method="post">

                                <c:forEach items="${listContact}" var="row" varStatus="counter">
                                    <tr>
                                        <td>
                                            ${counter.count}
                                        </td>
                                        <td>
                                            ${row.contactId}
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
                                            ${row.remark}
                                        </td>
                                        <s:url value="/user/deleteContact" var="del_link">
                                            <s:param name="contactId" value="${row.contactId}"/>
                                        </s:url>
                                        <s:url value="/user/prepare_edit" var="edit_link">
                                            <s:param name="contactId" value="${row.contactId}"/>
                                        </s:url>
                                        <td>
                                            <a href="${del_link}">DELETE</a> | <a href="${edit_link}">EDIT</a>
                                        </td>
                                        <td>
                                            <input type="checkbox" name="mulDelValue" value="${row.contactId}"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                                    <tr>
                                        <td colspan="9">
                                            <input type="submit" value="Delete all seleted" />
                                        </td>
                                    </tr>
                            </form>
                            </tbody>
                        </table>
                    </c:if>

                    <c:if test="${empty listContact}">
                        <h3>No contact found</h3>
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