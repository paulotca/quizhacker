<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div align="center">
		<form id="pessoaForm" action="<c:url value="/pessoa"/>" method="post">


			<fieldset>

				<legend>Adicionar Pessoa</legend>

				<table border="1">
					<tr>
						<td><label for="nome">Nome:</label></td>
						<td><input id="nome" class="required" minlength="3" type="text" name="pessoa.nome"
							value="${pessoa.nome}" /></td>
					</tr>
					<tr>
						<td><label for="cpf">cpf:</label></td>
						<td><input id="cpf" type="text" name="pessoa.cpf"
							value="${pessoa.cpf}" /></td>
					</tr>

					
					<tr>
						<td>
							<button type="reset">Limpar</button>
						</td>
						<td>
							<button type="submit">Enviar</button>
						</td>
					</tr>
				</table>
				<br />

			</fieldset>

		</form>
					<script type="text/javascript">
				$('#pessoaForm').validate();
			</script>

	</div>


