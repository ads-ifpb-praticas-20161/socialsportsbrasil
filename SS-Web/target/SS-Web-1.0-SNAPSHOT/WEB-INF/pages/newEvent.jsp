<%-- 
    Document   : newEvent
    Created on : 06/09/2016, 21:26:03
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal-backdrop invisible" id="newEvent">
    <div class="modal-event">
        <div class="text-right">
            <a href="#" onclick="fecharBackdrop()"><img src="/assets/imagens/close-red.png" width="17"/></a>
        </div>
        <br>
        <form action="/event" method="POST">
            <img class="img-thumbnail" src="/idolos/image/${group.idolo.id}" width="200"/>
            <div class="form-group text-left">
                <div class="form-group">
                    <label for="data">Ídolo:</label>
                    <input class="form-control" type="text" name="idolo" value="${group.idolo.nome}" disabled=""/>
                </div>
            </div>
            <div class="form-group text-left">
                <div class="form-group">
                    <label for="data">Data do evento:</label>
                    <input class="form-control" type="date" name="data"/>
                </div>
            </div>
            <div class="form-group text-left">
                <div class="form-group">
                    <label for="data">Descrição:</label>
                    <input class="form-control" type="text" name="descricao"/>
                </div>
            </div>
            <input class="invisible" name="id_group" value="${group.id}"/>
            <br><br>
            <input type="submit" class="btn btn-primary" value="Confirmar"/>
            <input type="button" class="btn btn-danger" value="Cancelar"/>
        </form>
    </div>
</div>