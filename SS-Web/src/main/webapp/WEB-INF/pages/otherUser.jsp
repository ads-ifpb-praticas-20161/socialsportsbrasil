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
                    <img src="/user/image/${outroUsuario.id}" alt="${outroUsuario.username}" align="down" class="imgVisit" onclick="abrirImagemDoUsuario(${outroUsuario.id})"/>
                </c:if>
                <h4>${outroUsuario.nome} ${outroUsuario.sobrenome}/<span> Pontos: ${outroUsuario.pontos}</span></h4>
            </div>
            <br><br><br><br>
            <div>
                <c:if test="${user.isFollowingUser(outroUsuario.id) == false}">
                    <a class="btn btn-lg btn-primary" href="/user/follow/${outroUsuario.id}">Seguir</a>
                </c:if>
                <c:if test="${user.isFollowingUser(outroUsuario.id) != false}">
                    <a class="btn btn-lg btn-danger" href="/user/unfollow/${outroUsuario.id}">Deixar de seguir</a>
                </c:if>
            </div>
        </aside>
        <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
