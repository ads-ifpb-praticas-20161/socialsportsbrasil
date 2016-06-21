<%-- 
    Document   : login
    Created on : 20/06/2016, 22:49:43
    Author     : dijalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp" %>
    <body class="text-center">
        <h1>Login</h1>
        <br><br>
        <form class="form-group-sm" action="/user/login" method="POST">
            <div class="form-control-sm">
                <div class="form-horizontal">
                    <label>Username ou email:</label>
                    <input type="text" class="form-control" name="login" required=""/>
                </div><br>
                <div class="form-horizontal">
                    <label>Senha:</label>
                    <input type="password" class="form-control" name="senha" required=""/>
                </div><br>
            </div>
             <div>
                <input type="submit" class="btn btn-primary btn-lg" value="Entrar" />
            </div><br><br>
        </form>
        
    </body>
</html>
