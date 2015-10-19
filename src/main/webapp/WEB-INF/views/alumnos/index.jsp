<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>Usuarios</title>
</head>
<body>
<div class="container">
	
	<h1>Listado de Alumnos</h1>
	<table class="table table-bordered table-hover">
	<thead>
          <tr>
          <th><a href="" title="">Legajo</a></th>
          <th><a href="" title="">Apellido</a></th>
          <th><a href="" title="">Nombre</a></th>
          <th><a href="" title="">Carrera</a></th>
          <th><a href="" title="">Acciones</a></th>
          </tr>
    </thead>
    <tbody>
    <c:forEach items="${alumnos}" var="alumno">
		<tr>
			<td><c:out value="${alumno.legajo}" /></td>
			<td><c:out value="${alumno.apellido}" /></td>
			<td><c:out value="${alumno.nombre}" /></td>
			<td><c:out value="${alumno.carrera.nombre}" /></td>
			<td>
				<a class="btn btn-success btn-sm" role="button" href='<c:url value="/usuario/${alumno.id}/editar" />' title="Editar"><span class="glyphicon glyphicon-pencil"></span> editar</a>
				<a class="btn btn-danger btn-sm" role="button" href='<c:url value="/usuario/${alumno.id}/borrar" />' title="Borrar"><span class="glyphicon glyphicon-remove"></span> borrar</a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
	<div class="row">
		<div class="col-md-12">
			<a class="btn btn-primary" role="button" href='<c:url value="/alumnos/nuevo" />' title="Volver"><span class="glyphicon glyphicon-plus"></span> Nuevo</a>
		</div>
	</div>
	
	</div>
</body>
</html>