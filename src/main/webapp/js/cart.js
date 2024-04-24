var cartProducts = [];
document.addEventListener("DOMContentLoaded", ()=>{
    cartProducts = JSON.parse(localStorage.getItem('cart')) || [];
    cartLoad();
})
function addProductToCart(id){
    $.ajax({
        url: `apiAddToCart?idProd=${id}`,
        type: 'GET',
        dataType:'json',
        success: (data)=>{
            let obj = {};
            let prodFinded = cartProducts.some(prod => prod.id === id);
            if(prodFinded){
                let prodFinded = cartProducts.find(prod => prod.id === id);
                prodFinded.quantity++;
            }else{
                obj = data;
                obj.quantity = 1;
                cartProducts.push(obj);
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
    let totalPriceHTML = `
        <li class="list-group-item d-flex justify-content-between">
            <span>Total: (EUR)</span>
            <strong id="totalPrice">€${totalPrice}</strong>
        </li>
    `
    getUlById.insertAdjacentHTML('beforeend', totalPriceHTML);
}

function clearCart(){
    localStorage.setItem('cart', []);
    cartProducts = localStorage.getItem('cart');
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