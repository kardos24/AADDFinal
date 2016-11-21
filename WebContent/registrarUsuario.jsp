<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Usuario</title>
</head>
<body>
	<f:view>
		<h:form id="RegitroForm">
			<h:outputText value="Usuario: " />
			<h:inputText id="usuario" value="#{registroUsuarioBean.usuario}"
				required="true" />
			<h:message for="usuario" />
			<br />

			<h:outputText value="Nombre: " />
			<h:inputText id="nombre" value="#{registroUsuarioBean.nombre}"
				required="true" />
			<h:message for="nombre" />
			<br />

			<h:outputText value="NIF: " />
			<h:inputText id="nif" value="#{registroUsuarioBean.nif}"
				required="true">

			</h:inputText>
			<h:message for="nif" />
			<br />

			<h:outputText value="Email: " />
			<h:inputText id="email" value="#{registroUsuarioBean.email}"
				required="true" 
				validator="#{registroUsuarioBean.validarMail }">
				<f:validator validatorId="aadd.validadores.Mail"/>
				</h:inputText>
			<h:message for="email" />
			<br />

			<h:outputText value="Clave: " />
			<h:inputSecret id="clave" value="#{registroUsuarioBean.clave}"
				required="true" />
			<h:message for="clave" />
			<br />

			<h:outputText value="Repetir Clave: " />
			<h:inputSecret id="clave2" value="#{registroUsuarioBean.clave2}"
				required="true" />
			<h:message for="clave2" />
			<br />
			<h:outputText value="Fecha (dd/MM/yyyy): " />
			<h:inputText id="fecha"
				value="#{registroUsuarioBean.fechaNacimiento}" required="false">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:inputText>
			<h:message for="fecha" />
			<br>
			<h:commandButton id="submit"
				action="#{registroUsuarioBean.registrar}" value="Guardar" />
			<br>
		</h:form>
	</f:view>
</body>
</html>