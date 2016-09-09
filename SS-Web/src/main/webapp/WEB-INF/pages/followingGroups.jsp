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
            <c:if test="${user.grupos.isEmpty() == false}">
                <h2>Grupo</h2>
                <br><br><br>
                <div class="row" >
                    <c:forEach items="${user.grupos}" var="grupo">
                        <div class="col-lg-3 col-sm-4 col-xs-12 col-md-4 card">
                            <h4><a href="/groups/${grupo.id}">${grupo.nome}</a></h4>
                            <h5>Dono: <c:if test="${grupo.dono.id == user.id}"><a href="#">Você</a></c:if>
                                <c:if test="${grupo.dono.id != user.id}"><a href="/user/otherUser/${grupo.dono.id}">${grupo.dono.nome}</a></c:if>
                                </h5>
                            </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${user.amigos.isEmpty() == true}">
                <h3>Você ainda não está seguindo nenhum grupo.</h3>
            </c:if>
        </aside>
    </body>
</html>
