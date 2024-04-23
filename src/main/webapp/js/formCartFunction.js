// import Swal from "../node_modules/sweetalert2/dist/sweetalert2.js";
import {fire} from "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js";
document.addEventListener("DOMContentLoaded", ()=>{
    let form = document.getElementById("form");
    form.addEventListener('submit', handleForm);
});

function handleForm(event){
    event.preventDefault();
    let street = document.getElementById('street').value;
    let postalCode = document.getElementById('postalCode').value;
    let door = document.getElementById('door').value;
    let floor = document.getElementById('floor').value;
    let stairs = document.getElementById('stairs').value;
    let name = document.getElementById('name').value;
    let email = document.getElementById('email').value;
    let telephoneNumber = document.getElementById('telephone').value;
    let totalPrice = document.getElementById('totalPrice').textContent.substring(1);
    let cartItems = JSON.parse(localStorage.getItem('cart'));

    let postData = {
        street: street,
        postalCode: postalCode,
        door: door,
        floor: floor,
        stairs: stairs,
        name: name,
        email: email,
        telephone: telephoneNumber,
        totalPrice: totalPrice,
        cart: cartItems
    };
    
    $.ajax({
        url: 'apiCheckout',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(postData),
        success: function(response){
            fire({
                title: "¡Hecho!",
                text: "¡Su compra ha sido confirmada con éxito!",
                icon: response.status,
                confirmButtonText: "¡Okay!"
            })
            clearCart();
        },
        error: function(xhr, status, error){
            console.error("Error al enviar el dato: ", error);
        }
    });
}