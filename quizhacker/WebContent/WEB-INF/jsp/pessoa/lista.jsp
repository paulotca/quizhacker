<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Cpf</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pessoaList}" var="pessoa">
			<tr>
				<td>${pessoa.nome}</td>
				<td>${pessoa.cpf}</td>
		
				<td><a href="<c:url value="/pessoa/${pessoa.id}"/>">Editar</a></td>
				<td>
					<form action="<c:url value="/pessoa/${pessoa.id}"/>" method="post">
						<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
