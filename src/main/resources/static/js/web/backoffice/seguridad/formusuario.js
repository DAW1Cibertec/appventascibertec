$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtemail").val("");
    $("#txtusuario").val("");
    $("#txtpassword").val("");
    $("#hddidusuario").val("0");
    $("#switchusuario").hide();
    $("#cbactivo").prop("checked", false);
    $("#modalusuario").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/"+$(this).attr("data-usuid"),
        dataType: "json",
        success: function(resultado){
           $("#txtnombre").val(resultado.nombres);
           $("#txtapellido").val(resultado.apellidos);
           $("#txtemail").val(resultado.email);
           $("#txtusuario").val(resultado.nomusuario);
           $("#hddidusuario").val($(this).attr("data-usuid"));
            $("#switchusuario").show();
           if(resultado.activo)
              $("#cbactivo").prop("checked", true);
           else
              $("#cbactivo").prop("checked", false);
        }
    })
    $("#modalusuario").modal("show");
    /*$("#txtnomproduct").val($(this).attr("data-prodname"));
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
    $("#modalproduct").modal("show");*/
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

