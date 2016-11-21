<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Registro Usuario</title>
</head>
<body>
	<f:view>
		<h:form>
			<b> <h:outputText value="No se le permite registrar los datos de usuario de: " /></b>
			<h:outputText value="#{registroUsuarioBean.usuario}" />
			<br>
			<br>
			<h:commandLink action="registrarUsuario">
				<h:outputText value="Volver" />
			</h:commandLink>
			<br>
			<br>
			<h:commandLink action="login">
				<h:outputText value="Login" />
			</h:commandLink>
		</h:form>
	</f:view>
</body>
</html>