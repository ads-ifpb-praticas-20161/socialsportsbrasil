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
                    <img src="/assets/imagens/stars.png" class="imgCadastro" alt="Imagem do ídolo ou equipe"/> 
                </div>
                <div class="form-group-lg form-inline">
                    <a href="#" onclick="abrirNovoIdolo()"><img src="/assets/imagens/add.svg" id="novoIdolo"/></a>
                    <input type="text" class="form-control" name="idolo" required="" placeholder="Ídolo" list="idolos"/>
                    <datalist id="idolos">
                        <c:forEach items="${idolos}" var="idolo">
                            <option value="${idolo.id}">${idolo.nome}</option>
                        </c:forEach>
                    </datalist>
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
        <div class="modal-backdrop invisible" id="modal-newIdolo" align="center">
            <div class="text-right" id="xclose-image">
                <a href="#" onclick="fecharBackdrop()"><img src="/assets/imagens/close.png" width="20"/></a>
            </div>
            <div class="modal-content modal-lg" style="margin-top: 60px;">
                <div class="modal-header">
                    <h3>Novo Ídolo</h3>
                </div>
                <div class="modal-body modal-newIdolo">
                    <form class="form-group-sm" action="/idolo/new" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <img src="/assets/imagens/stars.png" class="imgCadastro" alt="Imagem do ídolo ou equipe"/>
                            <input type="button" class="btn btn-primary form-control" name="foto" id="buttonImagem" value="Escolher imagem" onclick="escolherFoto()" />
                            <input type="file" class="invisible" name="foto" id="inputImagem" onchange="loadPicture(this)"/>
                        </div>
                        <div class="form-group-lg">
                            <input class="form-control" placeholder="Nome do ídolo" name="nome" required="">
                        </div>
                        <div class="form-group-lg">
                            <select name="esporte" class="form-control" required="">
                                <option value="">Selecione o esporte</option>
                                <option value="Atletismo">Atletismo</option>
                                <option value="Basquete">Basquete</option>
                                <option value="Boxe">Boxe</option>
                                <option value="Corrida">Corrida</option>
                                <option value="Futebol">Futebol</option>
                                <option value="Ginástica">Ginástica</option>
                                <option value="Handebol">Handebol</option>
                                <option value="Natação">Natação</option>
                                <option value="Tênis">Tênis</option>
                                <option value="Vôlei">Vôlei</option>
                            </select>
                        </div>
                        <div class="form-group-lg">
                            <select name="tipo" class="form-control">
                                <option value="">Selecione o tipo do ídolo</option>
                                <option value="Atleta">Atleta</option>
                                <option value="Corredor">Corredor</option>
                                <option value="Equipe">Equipe</option>
                                <option value="Ginasta">Ginasta</option>
                                <option value="Jogador">Jogador</option>
                                <option value="Piloto">Piloto</option>
                                <option value="Tenista">Tenista</option>
                                <option value="Time">Time</option>
                            </select>
                        </div>
                        <br>
                        <div>
                            <input type="submit" class="btn btn-success form-control" value="Cadastrar" />
                        </div>
                        <div>
                            <input type="button" class="btn btn-danger form-control" value="Voltar" onclick="fecharBackdrop()"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
