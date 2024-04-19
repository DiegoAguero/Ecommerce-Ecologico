let cartProducts = [];
document.addEventListener("DOMContentLoaded", ()=>{
    cartProducts = JSON.parse(localStorage.getItem('cart')) || []; 
})

function addProductToCart(id){
    $.ajax({
        url: `apiAddToCart?idProd=${id}`,
        type: 'GET',
        dataType:'json',
        success: (data)=>{
            console.log("Conseguido: " + data);
        }
    });
}
function cartLoad(){

}