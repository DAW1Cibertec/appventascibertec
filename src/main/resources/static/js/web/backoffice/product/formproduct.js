$(document).on("click", "#btnagregar", function(){
    $("#txtnomproduct").val("");
    $("#txtunipriceproduct").val("");
    $("#hddprodcod").val("0");
    listarCboCategorySupplier(0, 0);
    $("#switchproducto").hide();
    $("#cbdiscontinued").prop("checked", false);
    $("#modalproduct").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproduct").val($(this).attr("data-prodname"));
    $("#txtunipriceproduct").val($(this).attr("data-produnit"));
    $("#hddprodcod").val($(this).attr("data-prodcod"));
    $("#cbocategory").empty();
    $("#cbosupplier").empty();
    listarCboCategorySupplier($(this).attr("data-prodcateg"),
                $(this).attr("data-prodsupp"));
    $("#switchproducto").show();
    if($(this).attr("data-proddiscont") === "true"){
        $("#cbdiscontinued").prop("checked", true);
    }else
        $("#cbdiscontinued").prop("checked", false);
    $("#modalproduct").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/product/register",
        contentType: "application/json",
        data: JSON.stringify({
            productid: $("#hddprodcod").val(),
            productname: $("#txtnomproduct").val(),
            unitprice: $("#txtunipriceproduct").val(),
            categoryid: $("#cbocategory").val(),
            supplierid: $("#cbosupplier").val(),
            discontinued: $("#cbdiscontinued").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalproduct").modal("hide");
});

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/product/list",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append(`<tr>`+
                `<td>${value.productid}</td>`+
                `<td>${value.productname}</td>`+
                `<td>${value.unitprice}</td>`+
                `<td>${value.category.categoryname}</td>`+
                `<td>${value.supplier.companyname}</td>`+
                `<td><button type='button' class='btn btn-primary btnactualizar' `+
                    `data-prodcod="${value.productid}" `+
                    `data-prodname="${value.productname}" `+
                    `data-produnit="${value.unitprice}" `+
                    `data-prodcateg="${value.category.categoryid}" `+
                    `data-prodsupp="${value.supplier.supplierid}" `+
                    `data-proddiscont="${value.discontinued}">Actualizar`+
                `</button></td>`+
                `</tr>`);
            });
        }
    });
}

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