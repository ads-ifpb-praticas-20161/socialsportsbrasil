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
        <div class="modal-cadastro z-index-2 text-left" style="padding: 10px;">
            <form class="form-group-sm" action="/group/save" method="POST" enctype="multipart/form-data">
                <br>
                <div class="form-group">
                    <label class="control-label" for="nomegrupo">Nome do grupo</label>
                    <input type="text" class="form-control" name="nome" placeholder="Nome do grupo" id="nomegrupo"/>
                </div><hr>
                <div class="form-group">
                    <label class="control-label">Descrição</label>
                    <textarea class="form-control" style="resize: none" placeholder="Descrição" rows="3"></textarea>
                </div>
                <hr>
                <label class="control-label">Escolha o ídolo do grupo</label>
                <div align="left">
                    <img src="/assets/imagens/stars.png" class="imgCadastro" alt="Imagem do ídolo ou equipe" id="imagemIdolo" align="center"/> 
                </div>
                <div class="form-group-lg has-feedback" id="modal-idolo">
                    <input type="text" class="form-control" name="idolo" required="" placeholder="Buscar Ídolo" list="idolos" id="inputIdolos" autocomplete="off"/>
                    <span class="form-control-feedback glyphicon" style="margin-top: 8px"><img src="/assets/imagens/icons/search-black.png"/></span>
                    <datalist id="idolos" onselect="alterarImagemJogador()"></datalist>
                </div>
                <button type="button" class="btn btn-primary form-control" style="margin-top: 7px" onclick="abrirNovoIdolo()">Cadastrar novo ídolo</button>
                <hr>
                <br>
                <div>
                    <input type="submit" class="btn btn-success form-control" value="Criar grupo" />
                </div>
                <div>
                    <a href="/user/home"><input type="button" class="btn btn-danger form-control" value="Cancelar"/></a>
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
