<%-- 
    Document   : header
    Created on : 20/06/2016, 23:13:37
    Author     : dijalma
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="background-gradient z-index-1">
    <div class="text-left">
        <c:if test="${user.foto == null}">
            <img src="/assets/imagens/boy.svg" alt="${user.username}" class="imgPerfil"/>
        </c:if>
        <c:if test="${user.foto != null}">
            <img src="/user/image/${user.id}" alt="${user.username}" class="imgPerfil"/>
        </c:if>
        <label class="text-capitalize" style="color: white">${user.username} ${user.sobrenome}</label>
    </div>
    <div class="text-right">
        <a href="/user/logout" id="sair"><button class="btn btn-danger">Sair</button></a>
    </div>
</header>