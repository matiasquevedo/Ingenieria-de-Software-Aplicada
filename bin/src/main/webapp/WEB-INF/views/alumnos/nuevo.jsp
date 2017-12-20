<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="formTemplate">
	<tiles:putAttribute name="body">
	<div class="container">
		<h1>Alumno</h1>
		<form:form nethod="POST" id="form" data-toggle="validator" commandName="alumno"
				role="form" cssClass="form-horizontal">
				<spring:bind path="legajo">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="legajo">Legajo:</label>
						<div class="col-md-10">
							<form:input id="legajo" cssClass="form-control" path="legajo"
								placeholder="Nro Legajo" required="required" />
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
								placeholder="Nombre" required="required"
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
								placeholder="Apellido" required="required"
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="dni">
					<div class="form-group ${status.error ? 'has-error' : '' }">
						<label class="control-label col-md-2" for="dni">DNI:</label>
						<div class="col-md-10">
							<form:input id="dni" cssClass="form-control" path="dni"
								placeholder="Nro DNI" type="number" required="required"  pattern="^[0-9]$" data-minlength="7"
								 />
							<c:if test="${status.error}">
								<span class="text-danger">${status.errorMessage}</span>
							</c:if>
						</div>
					</div>
				</spring:bind>
				<spring:bind path="carrera">
				<div class="form-group ${status.error ? 'has-error' : '' }">
					<label class="control-label col-md-2" for="carrera">Carrera:</label>
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
</tiles:putAttribute>
</tiles:insertDefinition>