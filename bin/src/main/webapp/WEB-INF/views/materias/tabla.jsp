<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="listTemplate">
	<tiles:putAttribute name="body">
<div class="container">
	<h1>Listado de Materias</h1>
	<table class="table table-bordered table-hover" id="dataTables">
	<thead>
          <tr>
          	  <th><a href="" title="">Legajo</a></th>
	          <th><a href="" title="">Nombre</a></th>
	          <th><a href="" title="">Creditos</a></th>
	          <th><a href="" title="">Carrera</a></th>
	          <th><a href="" title="">Acciones</a></th>
          </tr>
    </thead>
    <tbody>
    <c:forEach items="${materias}" var="materia">
		<tr class="odd gradeX">
			<td><c:out value="${materia.legajo}" /></td>
			<td><c:out value="${materia.nombre}" /></td>
			<td><c:out value="${materia.creditos}" /></td>
			<td><c:out value="${materia.carrera.nombre}" /></td>
			<td>
				<a class="btn btn-success btn-sm" role="button" href='<c:url value="/materias/${materia.id}/editar" />' title="Editar"><span class="glyphicon glyphicon-pencil"></span> editar</a>
				<a class="btn btn-danger btn-sm" role="button" href='<c:url value="/materias/${materia.id}/borrar" />' title="Borrar"><span class="glyphicon glyphicon-remove"></span> borrar</a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
	<div class="row">
		<div class="col-md-12">
			<a class="btn btn-primary" role="button" href='<c:url value="/materias/nuevo" />' title="Volver"><span class="glyphicon glyphicon-plus"></span> Nuevo</a>
		</div>
	</div>
	</div>
</tiles:putAttribute>
</tiles:insertDefinition>