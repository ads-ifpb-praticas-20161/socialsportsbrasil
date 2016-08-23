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
        <h1 style="color: white">Novo grupo</h1>
        <br>
        <div class="modal-cadastro z-index-2">
            <form class="form-group-sm" action="/group/new" method="POST" enctype="multipart/form-data">

                <div class="form-horizontal text-center">
                    <img src="/assets/imagens/stars.png" class="imgCadastro" alt="Imagem do ídolo ou equipe" id="imagemIdolo"/> 
                </div>
                <div class="form-group-lg form-inline">
                    <a href="#" onclick="abrirNovoIdolo()"><img src="/assets/imagens/add.svg" id="novoIdolo"/></a>
                    <input type="text" class="form-control" name="idolo" required="" placeholder="Ídolo" list="idolos" id="inputIdolos" onkeyup="buscarIdolosPorNome()"/>
                    <datalist id="idolos" onselect="alterarImagemJogador()"></datalist>
                </div>
                <hr>
                <br>
                <div class="form-group-lg">
                    <input type="text" class="form-control" name="nome" placeholder="Nome do grupo" />
                </div>
                <div class="form-group-lg">
                    <textarea class="form-control" style="resize: none" placeholder="Descrição" rows="3"></textarea>
                </div>
                <br>
                <div>
                    <input type="submit" class="btn btn-success form-control" value="Cadastrar" />
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
        <%@include file="newIdolo.jsp" %>
    </body>
</html>
