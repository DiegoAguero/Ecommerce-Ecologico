var cartProducts = [];
document.addEventListener("DOMContentLoaded", ()=>{
    if(window.location.href === "http://localhost:8080/Ecommerce-Ecologico/finalizarCompra.html"){
        cartProducts = JSON.parse(localStorage.getItem('cart')) || [];
        cartLoad();
    }else{
        cartProducts = JSON.parse(localStorage.getItem('cart')) || [];
        cartLoad();
        checkCartProducts();

    }
})
function checkCartProducts(){
    let numberCart = document.getElementById("prodsInCart");
    numberCart.textContent = "0";
    cartProducts.map(prod=>{
        // numberCart
        let newNumber = parseInt(numberCart.textContent);
        newNumber++;
        numberCart.textContent = newNumber.toString();
    })
}
function addProductToCart(id){
    $.ajax({
        url: `apiAddToCart?idProd=${id}`,
        type: 'GET',
        dataType:'json',
        success: (data)=>{
            let bgColors = [
                "linear-gradient(to right, #00b09b, #96c93d)",
                "linear-gradient(to right, #ff5f6d, #ffc371)",
            ]
            let i = 0;
            let obj = {};
            let isProdFinded = cartProducts.some(prod => prod.id === id);
            if(isProdFinded){
                let prodFinded = cartProducts.find(prod => prod.id === id);
                prodFinded.quantity++;
                Toastify({
                    text:`Se añadió ${prodFinded.name} al carrito!`,
                    gravity:"bottom",
                    position: "right",
                    duration: 3000,
                    style:{
                        background: bgColors[i % 2]
                    }
                }).showToast();
            }else{
                obj = data;
                obj.quantity = 1;
                cartProducts.push(obj);
                let numberCart = document.getElementById("prodsInCart");
                let newNumber = parseInt(numberCart.textContent);
                newNumber++;
                numberCart.textContent = newNumber.toString();
                Toastify({
                    text:`Se añadió ${obj.name} al carrito!`,
                    gravity:"bottom",
                    position: "right",
                    duration: 3000,
                    style:{
                        background: bgColors[i % 2]
                    }
                }).showToast();
            }

            cartLoad();

        }
    });
}

function removeFromCart(productId){
    
    cartProducts.map(prod=>{
        if(prod.id === productId){
            if(prod.quantity === 1){
                cartProducts = cartProducts.filter(product => product.id !== productId);
                let numberCart = document.getElementById("prodsInCart");
                let newNumber = parseInt(numberCart.textContent);
                newNumber--;
                numberCart.textContent = newNumber.toString();
            }
            prod.quantity--;
            cartLoad();
            showDropdownCart();
        }
        
        $("ul.dropdown-menu").on("click", function(e) {
            e.stopPropagation();
        });
        
    });
    
}


$(document).delegate("ul.dropdown-menu [data-keepOpenOnClick]", "click", function(e) {
    e.stopPropagation();
});

function cartLoad(){
    localStorage.setItem('cart', JSON.stringify(cartProducts));
}
function showCart(){
    //TODO showCart LOGIC (finalizarCompra.html)
    let getUlById = document.getElementById("showProds");
    let totalProdPill = document.getElementById("totalProdsInCart");
    getUlById.innerHTML = "";
    let totalPrice = 0;
    cartProducts.map(prods=>{
        let listItem = 
        `
        <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
                <h6 class="my-0">${prods.name}</h6>
                <small class="text-body-secondary">${prods.description}</small>
                <small class="text-body-secondary">Cantidad: ${prods.quantity}</small>
            </div>
            <span class="text-body-secondary">€${prods.price}</span>
        </li>
        `
        totalPrice+=(prods.price * prods.quantity);
        getUlById.insertAdjacentHTML('beforeend', listItem);
    })
    totalProdPill.innerHTML = `${cartProducts.length}`;
    let totalPriceRounded = totalPrice.toFixed(2);
    let totalPriceHTML = `
        <li class="list-group-item d-flex justify-content-between">
            <span>Total: (EUR)</span>
            <strong id="totalPrice">€${totalPriceRounded}</strong>
        </li>
    `
    getUlById.insertAdjacentHTML('beforeend', totalPriceHTML);
}

function clearCart(){
    cartProducts = [];
    cartLoad();
}


function keepOpenOnClick() {
    $("ul.trashbut").on("click", function(e) {
        e.stopPropagation();
    });
};

$(function() {
    $("ul.dropdown-menu").on("click", "[data-keepOpenOnClick]", function(e) {
        e.stopPropagation();
    });
});

function showDropdownCart(){
    let ulDropdown = document.getElementById("dropdownCart");
    ulDropdown.innerHTML = "";
    if(cartProducts.length == 0){
        let listItem = `<p>No tienes ningun producto en el carrito! Añade uno para poder visualizarlo!</p>`;
        ulDropdown.insertAdjacentHTML('beforeend', listItem);
    }
    cartProducts.map(prods=>{
        let listItem = 
            `
            <li class="overflow-auto carritoil" data-keepOpenOnClick>  
                <p class="overflow-auto carritop">${prods.name}</p> <span> Cantidad: ${prods.quantity}</span>
                <button data-keepOpenOnClick class="trashbut" onclick="removeFromCart(${prods.id}) ">
                    <i class="fas fa-trash fa-lg text-dark text-center carritoi" data-keepOpenOnClick></i>
                </button>
            </li>
            `
        ulDropdown.insertAdjacentHTML('beforeend', listItem);
        
    })
}