
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

<form  method="post" action="<c:url  value="/pessoa/${pessoa.id}"/>" >
		<fieldset>
			<legend>Editar Pessoa</legend>
			
			<input id="id" type="text" name="pessoa.id" value="${pessoa.id}" /> 
			<label for="nome">Nome:</label> 
			<input id="nome" type="text" name="pessoa.nome" value="${pessoa.nome}" /> 
			
			<label for="cpf">cpf:</label>
			<input id="cpf" type="text" name="pessoa.cpf" value="${pessoa.cpf}"></input>
			
			
			
			<button type="submit" name="_method" value="PUT">Enviar</button>
		</fieldset>
	</form>

</body>
