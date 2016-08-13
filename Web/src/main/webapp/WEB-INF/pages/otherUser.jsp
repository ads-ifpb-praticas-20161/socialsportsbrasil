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
            <div>
                <c:if test="${outroUsuario.foto == null}">
                    <img src="/assets/imagens/boy.svg" alt="${outroUsuario.username}" align="down" class="imgVisit"/>
                </c:if>
                <c:if test="${outroUsuario.foto != null}">
                    <img src="/user/image/${outroUsuario.id}" alt="${outroUsuario.username}" align="down" class="imgVisit"/>
                </c:if>
                <h4>${outroUsuario.nome} /<span> Pontos: 0</span></h4>
            </div>
            <br><br><br><br>
            <div>
                <input class="btn btn-lg btn-primary" value="Solicitar Amizade" type="submit" />
            </div>
        </aside>
        <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
