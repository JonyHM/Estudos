<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServlet" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Faça seu login!</title>
	</head>
	<body>
	
		<br>
		Primeiro é necessário realizar o login!
		<br><br>
		<form action="${linkServlet}" method="post">
			
			Login: <input type="text" name="login"/><br>
			Senha: <input type="password" name="senha"/>
			
			<input type="hidden" name="acao" value="Login"/>
			
			<input type="submit"/>
			
		</form>
	
	</body>
</html>