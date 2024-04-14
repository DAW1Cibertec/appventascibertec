$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunitpriceproduct").val("");
    $("#hddprodcod").val("0");
    $("#modalproduct").modal("show");
})

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunipriceproduct").val($(this).attr("data-produnit"));
    $("#hddprodcod").val($(this).attr("data-prodcod"));
    $("#modalproduct").modal("show");
})

function listarCboCategorySupplier(idCategory, idSupplier){



}