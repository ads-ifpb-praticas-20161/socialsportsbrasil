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
        <a href="/groups/my">Grupos (${user.qtdeGrupos()})</a>
        <div class="form-group-sm has-feedback">
            <form action="/groups/findByName" method="POST">
                <input type="text" class="form-control" placeholder="Buscar grupos" name="nome"/>
                <span class="glyphicon form-control-feedback"><img src="/assets/imagens/icons/search-black.png" /></span>
            </form>
        </div>
        <div class="text-right">
            <input type="submit" value="Buscar" class="btn btn-sm btn-default" />
        </div>
        <div class="text-left">
            <a href="/groups/new"><input type="button" value="Criar" class="btn btn-sm btn-default" id="criaGrupo"/></a>
        </div>
        <hr class="linha-mais-escura">
    </div>
    <div>
        <label>Configurações</label>
        <br>
        <div class="text-left">
            <a href="/user/editProfile">Editar Perfil</a>
            <br>
            <a href="#" onclick="desativarContaInMobile()">Desativar Conta</a>
        </div>
    </div>
</aside>