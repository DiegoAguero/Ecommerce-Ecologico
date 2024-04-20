<%-- 
    Document   : products
    Created on : 16 abr 2024, 13:22:40
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    </head>
    
    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-body-tertiary, head">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#"><img id="logo" src="./images/simbolo.png" alt="Logo GreenEssentials"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                <div class="collapse navbar-collapse justify-content-md-center" id="navbarSupportedContent">
                    <ul class="navbar-nav nav justify-content-center">
                        <li class="nav-item navli">
                            <a class="nav-link active" href="/Ecommerce-Ecologico/products?id=1">Frutas y verduras</a>
                        </li>
                        <li class="nav-item navli">
                            <a class="nav-link active" href="/Ecommerce-Ecologico/products?id=2">Frescos</a>
                        </li>
                        <li class="nav-item navli">
                            <a class="nav-link active" href="/Ecommerce-Ecologico/products?id=3">Dulces y desayunos</a>
                        </li>
                        <li class="nav-item navli">
                            <a class="nav-link active" href="/Ecommerce-Ecologico/products?id=4">Bebidas y bodegas</a>
                        </li>
                    </ul>
                </div>
                <a class="navbar-brand" href="#">
                  <img id="cart" src="./images/carrito.png" alt="Bootstrap" width="30" height="24" />
                </a>
                </div>
            </nav>
        </header>
        <ul id="products"></ul>
        <script src="./js/ajaxProducts.js"></script>
    </body>
</html>
