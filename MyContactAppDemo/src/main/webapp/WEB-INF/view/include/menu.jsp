
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url value="/logout" var="logout_url"/>
<s:url value="/registerForm" var="registerForm_url"/>
<s:url value="/user/saveContactForm" var="saveContactForm_url"/>
<s:url value="/user/clist" var="clist_url"/>
<s:url value="/admin/vlist" var="vlist_url"/>
<s:url value="/index" var="login_url"/>
<!--// guest-->
<c:if test="${empty sessionScope.USER}">
    <a href="${login_url}">Home</a> | <a href="${login_url}">Login</a> | <a href="${registerForm_url}">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
    
    <!--// general user-->
    <c:if test="${sessionScope.USER.role eq 2}">
     <a href="#">Home</a> | <a href="${saveContactForm_url}">Add contact</a>| <a href="${clist_url}">Contact list</a>| <a href="${logout_url}">Logout</a>
</c:if>
    
    <!--//admin-->
<c:if test="${sessionScope.USER.role eq 1}">
    <a href="#">Home</a> | <a href="${vlist_url}">User list</a>| <a href="${logout_url}">Logout</a>
</c:if>

