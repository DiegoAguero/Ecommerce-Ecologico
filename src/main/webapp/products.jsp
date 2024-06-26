<%-- 
    Document   : products
    Created on : 16 abr 2024, 13:22:40
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link rel="stylesheet" href="./css/style.css" />
    
        <!--Pruebas para el carrito-->
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script src="https://kit.fontawesome.com/60f68411d6.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastify-js/1.12.0/toastify.js" integrity="sha512-ZHzbWDQKpcZxIT9l5KhcnwQTidZFzwK/c7gpUUsFvGjEsxPusdUCyFxjjpc7e/Wj7vLhfMujNx7COwOmzbn+2w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastify-js/1.12.0/toastify.css" integrity="sha512-kT0v1BxcibEO2Yc+6Z3W1gNsN+2cZ/U6uITqHhIJl8SAvt9vpO8llugdCPXA7cCnp8G1xbuSqHNMRaR3Zlz9yA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!--Scroll-->
        <!-- <script src="js/scroll.js"></script> -->
        <script src="js/cart.js"></script>
        
        <link rel="stylesheet" href="./scss/styles.css" />
        
        <script src="./node_modules/bootstrap/dist/js/bootstrap.bundle.js"></script>
      </head>
    <body>
        <header>
          <nav class="navbar navbar-expand-lg bg-body-tertiary, head">
            <div class="container-fluid" style="justify-content: center;">
              <a class="navbar-brand navLogo" href="index.html"><img id="logo" src="./images/simbolo.png"
                  alt="Logo GreenEssentials" /></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse justify-content-md-center" id="navbarSupportedContent">
                <ul class="navbar-nav nav justify-content-center">
                            <li class="nav-item navli navlipro">
                                <button class="nav-link active menutop" style="padding-left: 50px; padding-right: 50px;" onclick="reloadCategory(5)">Frutas</button>
                            </li>
                            <li class="nav-item navli navlipro">
                                <button class="nav-link active menutop" style="padding-left: 50px; padding-right: 50px;" onclick="reloadCategory(6)">Verduras</button>
                            </li>
                        </ul>
                    </div> 

                    <div class="btn-group dropstart navCarrito" style="position: absolute;">
                      <button type="button" class="btn-secondary dropdown-toggle cartpos" data-bs-toggle="dropdown" aria-expanded="false" onclick="showDropdownCart()">
                        <i class="fas fa-shopping-cart fa-xl text-dark"></i>
                        <div class="text-center navNumber" id="hideNumber">
                          <p id="prodsInCart" style="color: white; font-size: small;">0</p>
                        </div>
                      </button>
                      <ul class="dropdown-menu" data-keepOpenOnClick>
                        <!-- Dropdown -->
                        <ul class="overflow-auto" data-keepOpenOnClick id="dropdownCart" style="height: 150px; width:40vw; padding-left: 10px; padding-right: 10px;" data-keepOpenOnClick>
                          <il class="carritoil">  
                            <p class="carritop">Nombre de producto</p>
                            <button class="trashbut">
                              <i class="fas fa-trash fa-lg text-dark text-center carritoi"></i>
                            </button>
                          </il>
                        </ul>
                        <div class="button" data-keepOpenOnClick>
                          <a href="finalizarCompra.html" class="button">Finalizar la compra</a>
                        </div>
                      </ul>
                    </div>
        </header>
       
        <main>

          <ul id="products" class="position-relative fullWidth grid"
          style="list-style: none; scrollbar-width: none;">
              <c:forEach var="product" items="${allProds}">
                  <li class="productList" id=${product.id}>
                      <div class="card h-100" style="width: 18rem;">
                      <img src="${product.image_url}" class="card-img-top cardImg" alt="Producto">
                      <div class="card-body">
                          <h5 class="card-title text-center">${product.name}</h5>
                          <p class="card-text text-center">€${product.price}</p>
                          <p class="card-text text-center">Stock: ${product.stock}</p>
                      </div>
                      <div class="card-body contenedor">
                          <button class="rounded-pill" onclick="addProductToCart(${product.id})">Añadir a la cesta</button>
                      </div>
                      </div>
                  </li>
              </c:forEach>
          </ul>

         
          <script src="./js/ajaxProducts.js"></script>
          <script src="js/cart.js"></script>



        </main>
       
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
                <h5 class="text-uppercase"><a href="index.html" class="link">Inicio</a></h5>
              </div>
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
