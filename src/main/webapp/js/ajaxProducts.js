$(document).ready(function(){
    // let url = window.location.href;
    // let id = url.substring(url.lastIndexOf('=') + 1);
    // console.log('id:', id);
    $.ajax({
        url: `products?id=1`,
        type: 'GET',
        dataType:'json',
        success: function(data){
            console.log(data);
            $.each(data, function(index, product){
                var listItem = "<li>" + product.name + " - $" + product.price + "</li>";
                $("#products").append(listItem);
            });
        },
        error: function(request, status, error){
            alert(status);
        }
    })
});