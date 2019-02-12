<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServlet" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulario Teste</title>
	</head>
	<body>
	
		<form action="${linkServlet}" method="post">
			
			Nome: <input type="text" name="nome"/>
			Data de Abertura: <input type="text" name="data"/>
			
			<input type="submit"/>
			
		</form>
	
	</body>
</html>