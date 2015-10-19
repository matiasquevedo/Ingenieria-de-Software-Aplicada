<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<title>Nuevo Alumno</title>
</head>
<body>
	<div class="container">
		<h1>Alumno</h1>
		<form:form nethod="POST" id="form" commandName="alumno"
				role="form" cssClass="form-horizontal">
				<spring:bind path="legajo">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="legajo">Legajo:</label>
						<div class="col-md-10">
							<form:input id="legajo" cssClass="form-control" path="legajo"
								placeholder="Nro Legajo" 
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="nombre">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="nombre">Nombre:</label>
						<div class="col-md-10">
							<form:input id="nombre" cssClass="form-control" path="nombre"
								placeholder="Nombre" 
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="apellido">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="apellido">Apellido:</label>
						<div class="col-md-10">
							<form:input id="legajo" cssClass="form-control" path="apellido"
								placeholder="Apellido" 
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="dni">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="dni">Apellido:</label>
						<div class="col-md-10">
							<form:input id="dni" cssClass="form-control" path="dni"
								placeholder="Nro DNI" 
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				<spring:bind path="carrera">
				<div class="form-group ${status.error ? 'has-error' : '' }">
					<label class="control-label col-md-2" for="provincia">Carrera:</label>
					<div class="col-md-10">
						<form:select cssClass="form-control" path="carrera"
							items="${carreras}" itemLabel="nombre" itemValue="id" />
						<c:if test="${status.error}">
							<span class="text-danger">${status.errorMessage}</span>
						</c:if>
					</div>
				</div>
			</spring:bind>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-5">
				 	<a class="btn btn-primary" role="button" href='<c:url value="/alumnos/" />' title="Volver">Volver</a>
				</div>
				<div class="col-md-5">
					<button type="submit" class="btn btn-success">Guardar</button>
				</div>
			</div>
				
		</form:form>

	</div>
</body>
</html>