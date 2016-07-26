<%-- 
    Document   : asideUser
    Created on : 21/06/2016, 01:10:58
    Author     : dijalma
--%>

<br><br><br><br>
<aside class="functionsUser">
    <br><br>
    <label>Pontos: 0</label>
    <br><br>
    <a href="#">Ver Amigos</a>
    <br><br>
    <div class="form-group-sm">
        <input type="text" class="form-control" placeholder="Buscar usuário" onkeyup="buscaUsuarios(this)"/>
    </div>
    <div class="text-right">
        <input type="submit" value="Buscar" class="btn btn-sm btn-default" />
    </div>
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
            <a href="#">Editar Perfil</a>
            <br><br>
            <a href="#">Desativar Conta</a>
        </div>
    </div>
</aside>