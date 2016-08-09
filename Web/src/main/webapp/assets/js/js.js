/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    
    $('#notification').mouseenter(function (){
        fecharNotificacao();
    });
});

function fecharNotificacao(){
    
    $('#notification').fadeOut(4000);
}

function buscaUsuarios(campo){
    nome = $(campo).val();
    console.log(nome);
    $.ajax({
        url: "/user/search/"+nome+"",
        success: function (result) {
            console.log("Deu certo - "+result);
        }
    });
}

function escolherFoto(){
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