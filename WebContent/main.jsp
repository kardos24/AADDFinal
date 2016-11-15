<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/ad" prefix="aadd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina principal</title>
</head>
<body>
<h1>Bienvenido: ${nombre}</h1>
<p> Accedido en: ${header['Host']}

<aadd:enlace texto="google" url="www.google.es"/>

<table>
<aadd:catalogos lista="${sessionScope.getAttribute('listaCatalogos')}">
<tr>
	<td>${nombre}</td><td>${web}</td>
</tr>
</aadd:catalogos>
</table>

</body>
</html>