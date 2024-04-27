$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitprice").val("");
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCategoriasProveedores(0, 0);
    $("#modalproduct").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunitprice").val($(this).attr("data-produnitprice"));
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCategoriasProveedores($(this).attr("data-prodcategory"),
                        $(this).attr("data-prodsupplier"));
    $("#modalproduct").modal("show");
});

function listarCategoriasProveedores(idcategoria, idproveedor){
    $.ajax({
        type: "GET",
        url: "/category/list",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategory").append(
                   `<option value="${value.categoryid}">${value.categoryname}</option>`
                );
            });
            if(idcategoria > 0)
                $("#cbocategory").val(idcategoria);
            $.ajax({
                type: "GET",
                url: "/supplier/list",
                dataType: "json",
                success: function(resultado){
                    $.each(resultado, function(index, value){
                        $("#cbosupplier").append(
                            `<option value="${value.supplierid}">${value.companyname}</option>`
                        );
                    });
                    if(idproveedor > 0)
                        $("#cbosupplier").val(idproveedor);
                }
            });
        }
    });

}