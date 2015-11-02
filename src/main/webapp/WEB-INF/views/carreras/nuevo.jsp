<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="formTemplate">
	<tiles:putAttribute name="body">
	<div class="container">
		<h1>Carreras</h1>
		<form:form nethod="POST" id="form" data-toggle="validator" commandName="carrera"
				role="form" cssClass="form-horizontal">
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
				
			<div class="form-group">
				<div class="col-md-offset-2 col-md-5">
				 	<a class="btn btn-primary" role="button" href='<c:url value="/carreras/" />' title="Volver">Volver</a>
				</div>
				<div class="col-md-5">
					<button type="submit" class="btn btn-success">Guardar</button>
				</div>
			</div>
				
		</form:form>

	</div>
</tiles:putAttribute>
</tiles:insertDefinition>