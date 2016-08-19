/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $('.aside-lateral').css({
        height: $(window).height() + 'px'
    });
    $(window).resize(function () {
        height = $(window).height();
        $('.aside-lateral').css({
            height: height + 'px'
        });
    });

    $('.aside-responsivo').click(function () {
        $('#modalLateral').removeClass('invisible');
    });
});

function buscaUsuarios() {
    nome = $('#nomeUsuario').val();
    console.log(nome);
    $.ajax({
        url: "/user/search/" + nome + "",
        success: function (result) {
            console.log("Deu certo - " + result);
        }
    });
}

function escolherFoto() {
    $('#inputImagem').trigger('click');
}

function loadPicture(valor) {
    var reader = new FileReader(valor);
    reader.onload = function (e) {
        setImage(e.target.result);
    };

    reader.readAsDataURL(valor.files[0]);
}

function setImage(image) {
    $('.imgCadastro').attr('src', image);
}

function desativarConta() {
    $('#modalConfirmacao').removeClass('invisible');
}

function desativarContaInMobile(){
    fecharBackdrop();
    $('#modalConfirmacao').removeClass('invisible');
}

function fecharBackdrop() {
    $('.modal-backdrop').addClass('invisible');
}

function abrirImagemDoUsuario(id) {
    $('#fotoSelecionada').attr('src', '/user/image/' + id);
    $('#modalImagem').removeClass("invisible");
}

function abrirNovoIdolo(){
    $('#modal-newIdolo').removeClass("invisible");
}