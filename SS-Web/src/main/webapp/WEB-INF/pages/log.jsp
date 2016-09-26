<%-- 
    Document   : log
    Created on : 07/09/2016, 16:44:48
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
        <table class="table">
            <thead>
            <th>
            <tr>Evento</tr>
            <tr>Nome do objeto</tr>
            <tr>Data</tr>
        </th>
    </thead>
    <tbody>

    </tbody>
    <c:forEach items="${logs}" var="log">
        <th>
        <td>${log.event}</td>
        <td>${log.usuario}</td>
        <td>${log.data}</td>
            </th>
        </c:forEach>
</table>
</body>
</html>
