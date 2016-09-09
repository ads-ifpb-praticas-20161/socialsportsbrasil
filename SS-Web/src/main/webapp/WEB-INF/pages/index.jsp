<%-- 
    Document   : index
    Created on : 15/06/2016, 14:10:42
    Author     : Dijalma Silva <dijalmacz@gmail.com>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="text-center background-gradient">
        <br><br>
        <img src="/assets/imagens/icons/logo_name.png" width="250" alt="SocialSportsBrasil"/>
        <br><br>
        <hr class="line-logo">
        <br>
        <div id="modal-login" class="z-index-1">
            <div class="modal-login-header">
                <h3>Bem vindo!</h3>
                <hr>
            </div>
            <form action="/user/login" method="POST">
                <div class="form-group-lg has-feedback">
                    <input type="text" class="form-control" name="login" required="" placeholder="Nome de usuário" autofocus=""/>
                    <span class="glyphicon form-control-feedback"><img src="/assets/imagens/icons/user-black.png" /></span>
                </div>
                <div class="form-group-lg has-feedback">
                    <input type="password" class="form-control" name="senha" required="" placeholder="Senha"/>
                    <span class="glyphicon form-control-feedback"><img src="/assets/imagens/icons/lock-black.png" /></span>
                </div>
                <hr>
                <div>
                    <input type="submit" class="btn btn-primary form-control" value="Entrar" />
                </div>
                <div>
                    <a href="/newUser"><input type="button" class="btn btn-success form-control" value="Cadastre-se" /></a>
                </div><br>
            </form>
        </div>
        <br><br>
    <c:if test="${result != null}" >
        <%@include file="notification.jsp" %>
    </c:if>
</body>
</html>
