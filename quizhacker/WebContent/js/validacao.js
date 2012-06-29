$().ready(function() {
  var validator = $("#myform").bind("invalid-form.validate", function() {}).validate({
      errorElement: "em",
      errorPlacement: function(error, element) {
        element.parent("td").next("td").html(error);        
      },
      success: function(label) {
        label.text("ok!").removeClass('error').addClass("success");
      },
      submitHandler: function(form) {
        form.submit();
      },
      rules: {
        myemail: {
          required: true,
          email: true
        },
        nome: {
          required: true,
          lettersonly: true
        }
      },
      messages: {				
        nome: {
          required: "Campo requerido!",
          email: "Digite um email válido!"
        },
        letters: {
          required: "Campo requerido!",
          lettersonly: "Somente letras são aceitas!"
        }		
      }
   });		
});
