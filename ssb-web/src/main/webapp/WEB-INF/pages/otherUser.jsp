<%-- 
    Document   : home
    Created on : 20/06/2016, 23:12:43
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="asideUser.jsp" %>
        <aside class="conteudo">
            <br><br><br>
            <h2>Nome do suposto amigo</h2>
            <br><br>
            <h4>Pontos: 0</h4>
            <br><br><br><br>
            <div>
                <input class="btn btn-lg btn-success" value="Solicitar Amizade" type="submit" />
            </div>
        </aside>
    <c:if test="${result != null}" >
        <%@include file="notification.jsp" %>
    </c:if>
    </body>
</html>
