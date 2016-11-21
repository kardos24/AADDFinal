<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><f:view>
		<f:loadBundle basename="resources.application" var="msg" />
		<title><h:outputText value="#{msg.titulo}" /></title>
	</f:view></title>
</head>
<body>
	<!-- h son para mostrar HTML, f es para funcionalidad -->
	<f:view locale="#{localeManagerBean.locale}">
		<h:outputFormat binding="#{localeManagerBean.htmlOutputText}"
			value="#{msg.welcomeHeading}">
			<f:param value="#{registroUsuarioBean.usuario}"></f:param>
		</h:outputFormat>
		<h:form>
			<!-- Esto ejecutara el setLanguage -->
			<h:selectOneMenu value="#{localeManagerBean.language}"
				onchange="submit()">
				<f:selectItem itemValue="es" itemLabel="Español" />
				<f:selectItem itemValue="en" itemLabel="English" />
			</h:selectOneMenu>
			<br />
			<h:dataTable id="tablaUsuarios"
				values="#{listarUsuariosBean.usuarios}" var="usuario">
				<h:column>
					<f:facet name="header">
					<h:outputText value="Usuario"/>
					</f:facet>
					<h:outputText value="#{usuario.usuario }">
					</h:outputText>

				</h:column>
				<h:column>
					<f:facet name="header">
					<h:outputText value="Nombre"/>
					</f:facet>
					<h:outputText value="#{usuario.nombre }">
					</h:outputText>

				</h:column>
				<h:column>
					<f:facet name="header">
					<h:outputText value="Correo"/>
					</f:facet>
					<h:outputText value="#{usuario.mail }">
					</h:outputText>

				</h:column>
				<h:column>
					<f:facet name="header">
					<h:outputText value="Nif"/>
					</f:facet>
					<h:outputText value="#{usuario.nif }">
					</h:outputText>

				</h:column>
				<h:column>
				<h:commandButton id="Seleccionar"
					action="verDetalleUsuario"
					actionListener="#{listarUsuariosBean.seleccionarUsuarios }"
				>
				<f:param name="id_usuario" value="#{usuario.usuario }"/>
				</h:commandButton>
				</h:column>

			</h:dataTable>
			<br>
			<h:outputText value="#{listarUsuariosBean.usuarioSeleccionado}"/>
		</h:form>
		<br />





	</f:view>
</body>
</html>