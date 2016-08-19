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
            <c:if test="${user.amigos.isEmpty() == false}">
                <h2>Seguindo</h2>
                <br><br><br>
                <div class="row">
                    <c:forEach items="${user.amigos}" var="usuario">
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
            <c:if test="${user.amigos.isEmpty() == true}">
                <h3>Você ainda não está seguindo ninguém.</h3>
                <br><br>
                <h4>Faça uma busca agora por outros usuários.</h4>
                <br><br>
                <form action="/user/searchUsers" method="POST" class="modal-sm modal-center">
                    <div class="form-group-sm">
                        <input type="text" class="form-control" placeholder="Buscar usuário" id="nomeUsuario" name="nome"/>
                    </div>
                    <div class="text-right">
                        <input type="submit" value="Buscar" class="btn btn-sm btn-default" onsubmit="buscaUsuarios()"/>
                    </div>
                </form>

            </c:if>
        </aside>
    </body>
</html>
