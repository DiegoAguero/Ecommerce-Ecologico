// $(document).ready(function(){
//     // let url = window.location.href;
//     // let id = url.substring(url.lastIndexOf('=') + 1);
//     // console.log('id:', id);

// $(document).ready(function(){(

// ;
// });
function reloadCategory(id){
    $.ajax({
        url: `apiProducts?id=${id}`,
        type: 'GET',
        dataType:'json',
        success: function(data){
            // console.log(data);
            $("#products").html('');
            $.each(data, function(index, product){
                // var listItem = `<li id=${product.id}>` + product.name + " - $" + product.price + "</li>";
                let listItem = `
                <li class="productList" id=${product.id}>
                    <div class="card h-100" style="width: 18rem;">
                    <img src="${product.image_url}" class="card-img-top cardImg" alt="Producto">
                    <div class="card-body">
                        <h5 class="card-title text-center">${product.name}</h5>
                        <p class="card-text text-center">€${product.price}</p>
                    </div>
                    <div class="card-body contenedor">
                        <button onclick="addProductToCart(${product.id})">Añadir a la cesta</button>
                    </div>
                    </div>
                </li>
                `
                $("#products").append(listItem);
            });
        },
        error: function(request, status, error){
            alert(status, error);
        }
    });
}
function getOrderDetails(idOrder){
    $.ajax({
       url: `getOrderDetails?idOrder=${idOrder}`,
       type: 'GET',
       dataType: 'json',
       success: function(response){
            console.log("enviado");
       },
       error: function(xhr, status, error){
            console.error(status);
       }
    });
}