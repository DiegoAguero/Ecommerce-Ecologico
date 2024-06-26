function reloadCategory(id){
    $.ajax({
        url: `apiProducts?id=${id}`,
        type: 'GET',
        dataType:'json',
        success: function(data){
            $("#products").html('');
            $.each(data, function(index, product){
                let listItem = `
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
                `
                $("#products").append(listItem);
            });
        },
        error: function(request, status, error){
            alert(status, error);
        }
    });
}
