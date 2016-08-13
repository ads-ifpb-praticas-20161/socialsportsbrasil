<%-- 
    Document   : newUser
    Created on : 20/06/2016, 21:13:18
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="text-center background-gradient">
        <h1 style="color: white">Novo usuário</h1>
        <br>
        <div class="modal-cadastro z-index-2">
            <form class="form-group-sm" action="/user/new" method="POST" enctype="multipart/form-data">

                <div class="form-horizontal text-center">
                    <c:if test="${user.foto == null}">
                        <img src="/assets/imagens/boy.svg" alt="${user.username}" class="imgPerfil"/>
                    </c:if>
                    <c:if test="${user.foto != null}">
                        <img src="/user/image/${user.id}" alt="${user.username}" class="imgPerfil"/>
                    </c:if>
                    <div>
                        <input type="button" class="btn btn-primary form-control" name="foto" id="buttonImagem" value="Escolher imagem" onclick="escolherFoto()" />
                        <input type="file" class="invisible" name="foto" id="inputImagem" onchange="loadPicture(this)"/>
                    </div>
                </div>
                <div class="form-group-lg">
                    <input type="text" class="form-control" name="username" required="" placeholder="Username" value="${user.username}" disabled=""/>
                </div>
                <div class="form-group-lg">
                    <input type="email" class="form-control" name="email" required="" placeholder="Email" value="${user.email}" disabled=""/>
                </div>
                <div class="form-group-lg">
                    <input type="text" class="form-control" name="nome" required="" placeholder="Nome" value="${user.nome}"/>
                </div>
                <div class="form-group-lg">
                    <input type="text" class="form-control" name="sobrenome" required="" placeholder="Sobrenome" value="${user.sobrenome}"/>
                </div>
                <div class="form-group-lg">
                    <input type="password" class="form-control" name="senha" required="" placeholder="Senha" value="${user.senha}"/>
                </div>

                <br>
                <div>
                    <input type="submit" class="btn btn-success form-control" value="Editar" />
                </div>
                <div>
                    <a href="/user/home"><input type="button" class="btn btn-primary form-control" value="Voltar" /></a>
                </div>
            </form>
        </div>
        <br><br>
        <c:if test="${result != null}" >
            <%@include file="notification.jsp" %>
        </c:if>
    </body>
</html>
