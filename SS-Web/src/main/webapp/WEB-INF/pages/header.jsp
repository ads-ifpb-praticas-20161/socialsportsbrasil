<%-- 
    Document   : header
    Created on : 20/06/2016, 23:13:37
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="modalConfirmacao.jsp" %>
<header class="background-gradient z-index-1">
    <div class="text-left">
        <c:if test="${user.foto == null}">
            <img src="/assets/imagens/boy.svg" alt="${user.username}" class="imgPerfil"/>
        </c:if>
        <c:if test="${user.foto != null}">
            <img src="/user/image/${user.id}" alt="${user.username}" class="imgPerfil" onclick="abrirImagemDoUsuario(${user.id})"/>
        </c:if>
        <a href="/user/home"><label class="text-capitalize" style="color: white">${user.nome} ${user.sobrenome}</label></a>
    </div>
    <div class="text-right">
        <a href="/user/logout" id="sair"><img src="/assets/imagens/logout.png" title="Sair" width="30"/></a>
    </div>
    <%@include file="modalImagem.jsp" %>
</header>
<div class="aside-responsivo text-center">
    <img src="/assets/imagens/menu-white.png" />
</div>
<div class="modal-backdrop animated fadeIn invisible" id="modalLateral">
    <aside class="aside-lateral z-index-2 animated slideInLeft">
        <div>
            <div class="text-right">
                <a href="#" onclick="fecharBackdrop()"><img src="/assets/imagens/close-red.png" width="17"/></a>
            </div>
            <br>
            <label>Pontos: ${user.pontos}</label>
            <br><br>
            <div align="left">
                <a href="/user/following">Seguindo (${user.qtdeSeguindo()})</a>
                <form action="/user/searchUsers" method="POST">
                    <div class="form-group-sm has-feedback">
                        <input type="text" class="form-control" placeholder="Buscar usuário" id="nomeUsuario" name="nome"/>
                        <span class="glyphicon form-control-feedback"><img src="/assets/imagens/icons/search-black.png" /></span>
                    </div>
                    <div class="text-right">
                        <input type="submit" value="Buscar" class="btn btn-sm btn-default"/>
                    </div>
                </form>
                <hr class="linha-mais-escura">
                <a href="#">Grupos (${user.qtdeGrupos()})</a>
                <div class="form-group-sm has-feedback">
                    <input type="text" class="form-control" placeholder="Buscar grupos" />
                    <span class="glyphicon form-control-feedback"><img src="/assets/imagens/icons/search-black.png" /></span>
                </div>
                <div class="text-right">
                    <input type="submit" value="Buscar" class="btn btn-sm btn-default" />
                </div>
                <div class="text-left">
                    <a href="/group/new"><input type="button" value="Criar" class="btn btn-sm btn-default" id="criaGrupo"/></a>
                </div>
            </div>
            <hr class="linha-mais-escura">
            <div>
                <label>Configurações</label>
                <br>
                <div class="text-left">
                    <a href="/user/editProfile">Editar Perfil</a>
                    <br>
                    <a href="#" onclick="desativarContaInMobile()">Desativar Conta</a>
                </div>
            </div>
        </div>
    </aside>
</div>