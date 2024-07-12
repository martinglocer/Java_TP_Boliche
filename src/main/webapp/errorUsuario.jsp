<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/Estilos/index.css">
		<title>Pagina no autorizada</title>
</head>
<body>
	
	<jsp:include page="menu_cabecera_usuario.jsp" />
	<div>
		<h1 id="error" class="errorUsuario"> Usted no tiene permiso para navegar en esta pagina.</h1>
	</div>
	<div>
		<h4><a class="button-link back-to-main" href="menu.jsp">Volver al menú principal</a> </h4>
	</div>
</body>
</html>