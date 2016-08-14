<%-- 
    Document   : asideUser
    Created on : 21/06/2016, 01:10:58
    Author     : dijalma
--%>

<br><br><br><br>
<aside class="functionsUser">
    <br><br>
    <label>Pontos: ${user.pontos}</label>
    <br><br>
    <a href="#">Ver Amigos</a>
    <br><br>
    <form action="/user/searchUsers" method="POST">
        <div class="form-group-sm">
            <input type="text" class="form-control" placeholder="Buscar usuário" id="nomeUsuario" name="nome"/>
        </div>
        <div class="text-right">
            <input type="submit" value="Buscar" class="btn btn-sm btn-default" onsubmit="buscaUsuarios()"/>
        </div>
    </form>
    <br><br>
    <a href="#">Ver Grupos</a>
    <br><br>
    <div class="form-group-sm">
        <input type="text" class="form-control" placeholder="Buscar grupos" />
    </div>
    <div class="text-right">
        <input type="submit" value="Buscar" class="btn btn-sm btn-default" />
    </div>
    <div class="text-left">
        <input type="submit" value="Criar" class="btn btn-sm btn-default" id="criaGrupo"/>
    </div>
    <br><br>
    <div>
        <label>Segurança</label>
        <br><br>
        <div class="text-left">
            <a href="/user/editProfile">Editar Perfil</a>
            <br><br>
            <a href="#" onclick="desativarConta()">Desativar Conta</a>
        </div>
    </div>
    <%@include file="modalConfirmacao.jsp" %>
</aside>