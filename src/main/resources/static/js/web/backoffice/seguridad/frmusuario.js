$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtemail").val("");
    $("#txtemail").prop('readonly', false);
    $("#txtusuario").val("");
    $("#txtusuario").prop('readonly', false);
    $("#switchusuario").hide();
    $("#btnenviar").hide();
    $("#divmensajepassword").show();
    $("#cbactivo").prop("checked", false);
    $("#hddidusuario").val("0");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $.ajax({
        type: "GET",
        url: "/seguridad/usuario/"+$(this).attr("data-idusuario"),
        dataType: "json",
        success: function(resultado){
            $("#txtnombre").val(resultado.nombres);
            $("#txtapellido").val(resultado.apellidos);
            $("#txtemail").val(resultado.email);
            $("#txtemail").prop('readonly', true);
            $("#txtusuario").val(resultado.nomusuario);
            $("#txtusuario").prop('readonly', true);
            $("#btnenviar").show();
            $("#divmensajepassword").hide();
            $("#switchusuario").show();
            if(resultado.activo){
                $("#cbactivo").prop("checked", true);
            }else $("#cbactivo").prop("checked", false);
            $("#modalNuevo").modal("show");
        }
    });
});