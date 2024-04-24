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
            if(prod.cantidad === 1){
                cartProducts = cartProducts.filter(product => product.id !== productId);
            }
            prod.cantidad--;
            cartLoad();
        }
    });
    
}
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

function showDropdownCart(){
    
}