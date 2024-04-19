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
        <link rel="stylesheet" href="./css/style.css" />

        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <link rel="stylesheet" href="./scss/styles.css" />
       
        <script src="./node_modules/bootstrap/dist/js/bootstrap.bundle.js"></script>
      </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg bg-body-tertiary head">
                <div class="container-fluid">
                    <a class="navbar-brand" href="index.html"><img id="logo" src="./images/simbolo.png"
                        alt="Logo GreenEssentials" /></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-md-center" id="navbarSupportedContent">
                        <ul class="navbar-nav nav justify-content-center">
                            <li class="nav-item navli">
                                <a class="nav-link active" href="/Ecommerce-Ecologico/products.jsp?id=1">Frutas y verduras</a>
                            </li>
                            <li class="nav-item navli">
                                <a class="nav-link active" href="/Ecommerce-Ecologico/products.jsp?id=2">Frescos</a>
                            </li>
                            <li class="nav-item navli">
                                <a class="nav-link active" href="/Ecommerce-Ecologico/products.jsp?id=3">Dulces y desayunos</a>
                            </li>
                            <li class="nav-item navli">
                                <a class="nav-link active" href="/Ecommerce-Ecologico/products.jsp?id=4">Bebidas y bodegas</a>
                            </li>
                        </ul>
                    </div>
                    <a class="navbar-brand" href="carrito.html">
                    <img id="cart" src="./images/carrito.png" alt="Bootstrap" width="30" height="24" />
                    </a>
                </div>
            </nav>
        </header>
        <ul id="products" class="d-flex flex-row list-group-horizontal position-relative overflow-auto fullWidth mt-4"
        style="list-style: none; scrollbar-width: none">

        </ul>
        <script src="./js/ajaxProducts.js"></script>
        <footer class="text-center text-lg-start text-white"
        style="background: linear-gradient(rgb(60, 190, 76), 80%, rgb(7,122,21)); ">
        <!-- Grid container -->
        <div class="container footer_basic pb-0 text-center">
          <!-- Section: Links -->
          <section class="pb-5">
            <!--Grid row-->
            <div class="row">
              <!--Grid column-->
              <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
                <h5 class="text-uppercase"><a href="conocenos.html" class="link">conocenos</a></h5>
              </div>
              <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
                <h5 class="text-uppercase"><a href="contacto.html" class="link">contacto</a></h5>
              </div>
              <!--Grid column-->
            </div>
            <!--Grid row-->
          </section>
    
          <!-- Section: Social media -->
          <section class="mb-4 text-center">
            <!-- Facebook -->
            <a>
              <img src="./images/facebook.png" class="icon">
            </a>
    
            <!-- twitter -->
            <a>
              <img src="./images/twitter.png" class="icon">
            </a>
    
            <!-- Github -->
            <a>
              <img src="./images/github.png" class="icon">
            </a>
          </section>
          <!-- Section: Social media -->
        </div>
        <!-- Grid container -->
    
        <!-- Copyright -->
        <div class="text-center footer_darker" style="background-color: rgba(0, 0, 0, 0.0)">
          © 2024 Copyright:
          <p class="text-white">GreenEssentials</p>
        </div>
        <!-- Copyright -->
        </footer>
    </body>
</html>
