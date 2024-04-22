var cartProducts = [];
document.addEventListener("DOMContentLoaded", ()=>{
    cartProducts = JSON.parse(localStorage.getItem('cart')) || [];
    cartLoad();
    let form = document.getElementById("form");
    form.addEventListener('submit', handleForm);
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
function cartLoad(){
    localStorage.setItem('cart', JSON.stringify(cartProducts));
}
function showCart(){
    //TODO showCart LOGIC (finalizarCompra.html)
    let getUlById = document.getElementById("showProds");
    let totalProdPill = document.getElementById("totalProdsInCart");
    getUlById.innerHTML = "";
    let totalPrice = 0;
    // let totalPriceHTML = document.getElementById("totalPrice");
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
    // totalPriceHTML.innerHTML = `€${totalPrice}`
    let totalPriceHTML = `
        <li class="list-group-item d-flex justify-content-between">
            <span>Total: (EUR)</span>
            <strong id="totalPrice">€${totalPrice}</strong>
        </li>
    `
    getUlById.insertAdjacentHTML('beforeend', totalPriceHTML);
}
function handleForm(event){
    event.preventDefault();
    // Retrieve form data
    let street = document.getElementById('street').value;
    let postalCode = document.getElementById('postalCode').value;
    let door = document.getElementById('door').value;
    let floor = document.getElementById('floor').value;
    let stairs = document.getElementById('stairs').value;
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let telephoneNumber = document.getElementById('telephone').value;

    // Retrieve data from localStorage
    let cartItems = JSON.parse(localStorage.getItem('cart'));

    // Create an object with form data and localStorage data
    let postData = {
        street: street,
        postalCode: postalCode,
        door: door,
        floor: floor,
        stairs: stairs,
        name: name,
        email: email,
        telephone: telephoneNumber,
        cart: cartItems
    };
    $.ajax({
        url: 'apiCheckout',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(postData),
        success: function(response){
            console.log("Enviada la peticion al servidor");
        },
        error: function(xhr, status, error){
            console.error("Error al enviar el dato: ", error);
        }

    });
}
// function checkout(){

// }
// let form = document.getElementById("form");
// form.addEventListener('submit', handleForm);
