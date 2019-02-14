<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Empresas</title>
	</head>
	<body>
	
		<c:if test="${not empty empresa}">
			Cadastro da empresa ${ empresa } realizado com sucesso!
		</c:if>
		
		<br /> Lista de Empresas: <br />
		<ul>
			<c:forEach items="${empresas}" var="e"> 
							
				<li>
					${e.nome} - <fmt:formatDate value="${e.dataAbertura}" pattern="dd/MM/yyyy"/>
					<a href="/servlets/removerEmpresas?id=${e.id}">Remover</a>
					<a href="/servlets/alterarEmpresas?id=${e.id}">Alterar</a>
				</li>
			</c:forEach>
		</ul>
			
	</body>
</html>