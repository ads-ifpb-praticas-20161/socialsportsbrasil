<%-- 
    Document   : newUser
    Created on : 20/06/2016, 21:13:18
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="text-center">
        <h1>Novo usuário</h1>
        <br><br>
        <form class="form-group-sm" action="/user/new" method="POST" enctype="multipart/form-data">
            <div class="form-control-sm">
                <div class="form-horizontal">
                    <label>Foto:</label>
                    <input type="file" class="form-control" name="foto"/>
                </div><br>
                <div class="form-horizontal">
                    <label>Nome*:</label>
                    <input type="text" class="form-control" name="nome" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Sobrenome*:</label>
                    <input type="text" class="form-control" name="sobrenome" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Username*:</label>
                    <input type="text" class="form-control" name="username" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Email*:</label>
                    <input type="email" class="form-control" name="email" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Senha*:</label>
                    <input type="password" class="form-control" name="senha" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Data de Nascimento*:</label>
                    <input type="date" class="form-control" name="dataDeNascimento" required=""/>
                </div><br>
            </div>
            <div>
                <input type="submit" class="btn btn-primary btn-lg" value="Cadastrar-se" />
            </div><br><br>
        </form>
    <c:if test="${result != null}" >
        <%@include file="notification.jsp" %>
    </c:if>
</body>
</html>
