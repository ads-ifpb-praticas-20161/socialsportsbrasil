<%-- 
    Document   : modalImagem
    Created on : 13/08/2016, 17:53:16
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="modal-backdrop animated fadeIn invisible" id="modalImagem">
    <div class="modal-imagem animated zoomIn">
        <div style="color: white">
            <h3 id="donoFoto"></h3>
            <div class="text-right">
                <a href="#" onclick="fecharBackdrop()"><img src="/assets/imagens/close.png" width="20"/></a>
            </div>
        </div>
        <div class="modal-body text-center modal-body-imagem">
            <img id="fotoSelecionada" src="" alt="" />
        </div>
    </div>
</div>