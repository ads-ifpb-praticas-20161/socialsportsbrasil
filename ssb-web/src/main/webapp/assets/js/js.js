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