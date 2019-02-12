<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>	
		<meta charset="UTF-8">
		<title>Cadastro Realizado!</title>
	</head>
	
	<body>	
	
		<c:if test="${not empty empresa}">
			Cadastro da empresa ${ empresa } realizado com sucesso!
		</c:if>
		
		<c:if test="${empty empresa}">
			Nenhuma empresa cadastrada!
		</c:if>
							
	</body>
	
</html>