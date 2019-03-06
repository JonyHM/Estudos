<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">

<meta charset="UTF-8">
<title>Compra e venda de livros usados e novos, jogos e diversos
	itens - Sebo Didático</title>
</head>
<body>
	<h1>Sebo Didático</h1>
	<table>
		<tr>
			<td>Guerra dos Tronos</td>
			<td>Jogos de Ps1</td>
		</tr>
		<tr>
			<td>As Crônicas de Nárnia</td>
			<td>Discos de Vinil</td>
		</tr>
	</table>
</body>
</html>