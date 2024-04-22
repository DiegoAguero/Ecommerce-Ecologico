let cartProducts = [];
window.onload = ()=>{
    cartProducts = JSON.parse(localStorage.getItem('cart')) || [];
    cartLoad(); 
}
function addProductToCart(id){
    $.ajax({
        url: `apiAddToCart?idProd=${id}`,
        type: 'GET',
        dataType:'json',
        success: (data)=>{
            for (const product in data) {
                const obj = {quantity: 1};
                console.log(product);
                if(product === "id"){
                    const prodExiste = cartProducts.some(product => product.id === id)
                    if(prodExiste){
                        const prodFinded = cartProducts.find(product => product.id === id);
                        ++prodFinded.quantity;
                    }else{
                        obj[product] = data[product];
                        cartProducts.push(obj);
                    }
                    cartLoad();
                }
            }
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
}