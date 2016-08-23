/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
eventFinish = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
notification = true;

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

    $('.modal-notification').one(eventFinish, function () {
        if (notification) {
            $(this).removeClass("animated fadeInUp");
            setTimeout(function () {
                $('.modal-notification').addClass("animated fadeOutUp");
            }, '3000');
            notification = false;
        } else {
            notification = true;
        }
    });

    $("#inputIdolos").on('input', function () {
        alterarImagemJogador();
    });
});

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

function desativarContaInMobile() {
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

function abrirNovoIdolo() {
    $('#modal-newIdolo').removeClass("invisible");
}

function buscarIdolosPorNome() {
    var nome = $('#inputIdolos').val();
    $.ajax({
        url: "/idolo/" + nome,
        context: document.body,
        success: function (data) {

            resultBuscaPorIdolos(data);
        }
    });
}

function resultBuscaPorIdolos(data) {
    idolosEncontrados = data;
    list = "";
    $.each(idolosEncontrados, function (index, value) {
        list += "<option data-value=" + value.id + " value=" + value.nome + "/>\n";
    });
    $('#idolos').empty();
    $('#idolos').append(list);
}

function alterarImagemJogador() {
    var data = {};
    $("#idolos option").each(function (i, el) {
        data[$(el).data("value")] = $(el).val();
    });
    var inputIdolo = $('#inputIdolos').val();
    var id = $('#idolos [value="' + inputIdolo + '"]').data('value');
    if (id > 0) {
        $.each(idolosEncontrados, function (index, value) {
            if (value.id === id) {
                caminho = "data:image/png;base64," + value.foto;
            }
        });
        $('#imagemIdolo').attr('src', caminho);
    } else {
        $('#imagemIdolo').attr('src', "/assets/imagens/stars.png");
    }
}