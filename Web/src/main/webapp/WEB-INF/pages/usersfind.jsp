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
            <c:if test="${usuariosEncontrados.isEmpty() == false}">
                <h2>Usuários Encontrados</h2>
                <br><br><br>
                <div class="row">
                    <c:forEach items="${usuariosEncontrados}" var="usuario">
                        <div class="col-lg-3 col-sm-4 col-xs-12 col-md-4">
                            <c:if test="${usuario.foto == null}">
                                <img src="/assets/imagens/boy.svg" alt="${usuario.nome}" class="imgPerfil">
                            </c:if>
                            <c:if test="${usuario.foto != null}">
                                <img src="/user/image/${usuario.id}" alt="${usuario.nome}" class="imgPerfil" onclick="abrirImagemDoUsuario(${usuario.id})">
                            </c:if>
                            <h4><a href="/user/otherUser/${usuario.id}">${usuario.nome} ${usuario.sobrenome}</a></h4>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${usuariosEncontrados == null}">
                <h3>Ninguém foi encontrado</h3>
            </c:if>
        </aside>
         <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
