<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServlet" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Novo Cadastro de Empresa</title>
	</head>
	<body>
		
		<c:import url="logout-parcial.jsp"/>
		
		<form action="${linkServlet}" method="post">
			
			Nome: <input type="text" name="nome"/>
			Data de Abertura: <input type="text" name="data"/>
			
			<input type="hidden" name="acao" value="NovaEmpresa"/>
			
			<input type="submit"/>
			
		</form>
	
	</body>
</html>