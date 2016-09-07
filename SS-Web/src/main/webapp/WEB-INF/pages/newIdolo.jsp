<%-- 
    Document   : newIdolo
    Created on : 20/08/2016, 22:29:04
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="modal-backdrop invisible" id="modal-newIdolo" align="center">
    <div class="text-right" id="xclose-image">
        <a href="#" onclick="fecharBackdrop()"><img src="/assets/imagens/close.png" width="20"/></a>
    </div>
    <div class="modal-content modal-lg" style="margin-top: 60px;">
        <div class="modal-header">
            <h3>Novo Ídolo</h3>
        </div>
        <div class="modal-body modal-newIdolo">
            <form class="form-group-sm" action="/idolos/new" method="POST" enctype="multipart/form-data">
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
                        <option value="">Selecionar esporte</option>
                        <option value="ATLETISMO">Atletismo</option>
                        <option value="BASQUETE">Basquete</option>
                        <option value="BOXE">Boxe</option>
                        <option value="CORRIDA">Corrida</option>
                        <option value="FUTEBOL">Futebol</option>
                        <option value="GINASTICA">Ginástica</option>
                        <option value="HANDEBOL">Handebol</option>
                        <option value="NATAÇÃO">Natação</option>
                        <option value="TENIS">Tênis</option>
                        <option value="VOLEI">Vôlei</option>
                    </select>
                </div>
                <div class="form-group-lg">
                    <select name="tipo" class="form-control">
                        <option value="">Selecionar tipo de ídolo</option>
                        <option value="ATLETA">Atleta</option>
                        <option value="CORREDOR">Corredor</option>
                        <option value="EQUIPE">Equipe</option>
                        <option value="GINASTA">Ginasta</option>
                        <option value="JOGADOR">Jogador</option>
                        <option value="PILOTO">Piloto</option>
                        <option value="TENISTA">Tenista</option>
                        <option value="TIME">Time</option>
                    </select>
                </div>
                <br>
                <div>
                    <input type="submit" class="btn btn-success form-control" value="Cadastrar" />
                </div>
                <div>
                    <input type="button" class="btn btn-danger form-control" value="Cancelar" onclick="fecharBackdrop()"/>
                </div>
            </form>
        </div>
    </div>
</div>