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
        <%@include file="newEvent.jsp" %>
        <aside class="conteudo">
            <div>
                <div class="title-group">
                    <h2>${group.nome}</h2>
                    <c:if test="${group.dono.id == user.id}">
                        <a class="btn btn-sm btn-danger" href="/groups/${group.id}/delete">Excluir grupo</a>
                        <a class="btn btn-sm btn-primary" href="/groups/${group.id}/edit">Editar grupo</a>
                        <a class="btn btn-sm btn-success" href="#" onclick="novoEvento(group.idolo)">Novo evento</a>
                    </c:if>
                    <c:if test="${group.dono.id != user.id}">
                        <c:if test="${user.isFollowingGroup(group.id) == false}">
                            <a class="btn btn-sm btn-primary" href="/groups/follow/${group.id}">Seguir</a>
                        </c:if>
                        <c:if test="${user.isFollowingGroup(group.id) != false}">
                            <a class="btn btn-sm btn-danger" href="/groups/unfollow/${group.id}">Deixar de seguir</a>
                        </c:if>
                    </c:if>
                </div>
                <br><br>
                <div>
                    <h4>Ídolo do grupo</h4>
                    <img src="/idolos/image/${group.idolo.id}" alt="$ {group.idolo.nome}" class="imgVisit"/>
                    <h5>${group.idolo.nome}</h5>
                </div>
                <br><br>
                <div class="">
                    <h4>Descrição do grupo</h4>
                    <p>${group.descricao}</p>
                </div>
            </div>
        </aside>
        <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
