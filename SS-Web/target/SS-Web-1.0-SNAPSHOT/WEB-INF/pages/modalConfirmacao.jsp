<%-- 
    Document   : modalConfirmacao
    Created on : 13/08/2016, 16:56:24
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<div class="modal-backdrop invisible" id="modalConfirmacao">
    <div class="modal_confirmacao">
        <div class="modal-content">
            <div class="modal-header">
                <h3>Deseja mesmo desativar sua conta?</h3>
            </div>
            <div class="modal-body">
                <br>
                <p>Para reativar sua conta basta efetuar o login novamente, utilizando seu username ou email
                e senha.</p>
                <br>
                <br>
                <div class="text-center">
                    <a href="/user/disable/${user.id}" class="btn btn-primary">Confirmar</a>
                    <a href="#" onclick="fecharBackdrop()" class="btn btn-danger">Cancelar</a>
                </div>
            </div>
        </div>
    </div>
</div>
