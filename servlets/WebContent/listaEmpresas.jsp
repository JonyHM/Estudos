<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de Empresas</title>
	</head>
	<body>
		Lista de Empresas: <br />
		<ul>
			<c:forEach items="${empresas}" var="e"> 
							
				<li>${e.nome} - <fmt:formatDate value="${e.dataAbertura}" pattern="dd/MM/yyyy"/></li>
			</c:forEach>
		</ul>
			
	</body>
</html>