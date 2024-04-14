$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitpriceproduct").val("");
    $("#hddprodcod").val("0");
    listarCboCategorySupplier(0, 0);
    $("#modalproduct").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunipriceproduct").val($(this).attr("data-produnit"));
    $("#hddprodcod").val($(this).attr("data-prodcod"));
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCboCategorySupplier($(this).attr("data-prodcateg"),
                $(this).attr("data-prodsupp"));
    $("#modalproduct").modal("show");
})

function listarCboCategorySupplier(idCategory, idSupplier){
    $.ajax({
        type: "GET",
        url: "/category/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategory").append(
                    `<option value="${value.categoryid}">${value.categoryname}</option>`
                )
            });
            if(idCategory > 0){
                $("#cbocategory").val(idCategory);
            }
            $.ajax({
                    type: "GET",
                    url: "/supplier/get",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cbosupplier").append(
                                `<option value="${value.supplierid}">${value.companyname}</option>`
                            )
                        });
                        if(idSupplier > 0){
                            $("#cbosupplier").val(idSupplier);
                        }
                    }
                })
        }
    })
}