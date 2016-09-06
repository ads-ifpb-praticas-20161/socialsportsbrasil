<%-- 
    Document   : home
    Created on : 20/06/2016, 23:12:43
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="asideUser.jsp" %>
        <aside class="conteudo">
            <c:if test="${gruposEncontrados.isEmpty() == false}">
                <h2>Grupos encontrados</h2>
                <br><br><br>
                <div class="row">
                    <c:forEach items="${gruposEncontrados}" var="group">
                        <div class="col-lg-3 col-sm-4 col-xs-12 col-md-4 card">
                            <h4>
                                <a href="/groups/${group.id}">${group.nome}</a>
                            </h4>
                            <p>Dono:
                                <c:if test="${group.dono.id == user.id}"><a href="#">Você</a></c:if>
                                <c:if test="${group.dono.id != user.id}"><a href="/user/otherUser/${group.dono.id}">${group.dono.nome}</a></c:if>
                            </p>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${gruposEncontrados.isEmpty() != false}">
                <h3>Não foi encontrado nenhum grupo.</h3>
            </c:if>
        </aside>
         <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
