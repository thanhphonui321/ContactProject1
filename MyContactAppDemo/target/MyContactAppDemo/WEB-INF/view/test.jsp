<%-- 
    Document   : test
    Created on : Aug 22, 2018, 3:25:28 PM
    Author     : nguyenducthanh
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <s:url value="/static/js/jquery-3.3.1.min.js" var="jquery_url"/>
        <script src="${jquery_url}"></script>
        <script>
            $(document).ready(function () {
//                alert('jQuery is reaady and integrated');
                $("#btnTime").click(function () {
                    $.ajax({
                        url: 'get_Time',
                        success: function (data) {
                            $("#showTime").html(data);
                        }
                    });
                });
            });
        </script>
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Ajax test Page</h1>
        <input id="btnTime" type="submit" value="Get time" />
        <p id="showTime"></p>
    </body>
</html>
