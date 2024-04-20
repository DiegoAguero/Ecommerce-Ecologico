let cartProducts = [];
// document.addEventListener("DOMContentLoaded", ()=>{
//     cartProducts = JSON.parse(localStorage.getItem('cart')) || []; 
// })
window.onload = ()=>{
    cartProducts = JSON.parse(localStorage.getItem('cart')) || []; 
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

                }
            }
            // console.log(cartProducts);
        }
    });
    cartLoad();
}
function cartLoad(){
    localStorage.setItem('cart', JSON.stringify(cartProducts));
}
function showCart(){
    
}