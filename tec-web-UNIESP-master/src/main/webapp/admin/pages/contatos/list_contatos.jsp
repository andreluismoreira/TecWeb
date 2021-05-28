<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	<jsp:attribute name="content">
		<div class="content">
			<div class="container-fluid">
	          <div class="row">
	          	<div class="card">
	          		<div class="card-header card-header-primary">
	                  <h4 class="card-title">Contatos</h4>
	                </div>
	          	</div>
	          	
	            <div class="col-md-12">
	              <c:if test="${not empty sucesso}">
	              	<div class="alert alert-success">
	              		${sucesso}
	              	</div>
	              </c:if>
	            </div>
	            
	            <div class="col-md-12">
	              <c:if test="${not empty remover}">
	              	<div class="alert alert-success">
	              		${remover}
	              	</div>
	              </c:if>
	            </div>
	            
	            <div>
	            	<a href="${pageContext.request.contextPath}/admin/pages/contatos/add_contatos.jsp">
	            		<button class="btn btn-primary pull-left">
	            			<i class="material-icons">person_add</i>
	            			Novo
	            		</button>
	            	</a>
	            </div>
	            <div class="table-responsive table-striped table-hover">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>ID</th>
                        <th>Name</th>
                        <th>Contato</th>
                        <th>Email</th>
                      </thead>
                      <tbody>
                      	<c:forEach var="contato" items="${contatos}">
	                      	<tr>
		                        <td><c:out value="${contato.id}"></c:out></td>
		                        <td><c:out value="${contato.name}"></c:out></td>
		                        <td><c:out value="${contato.contato}"></c:out></td>
		                        <td><c:out value="${contato.email}"></c:out></td>
		                        <td>
		                        	<a href="${pageContext.request.contextPath}/contatosServlet?id=${contato.id}&acao=remover">
		                   
		                        		<button class="btn btn-danger" value="remover">
			                        		<i class="material-icons">delete</i>
	                            		</button>
		                        	</a>
			                        
	                            	<a href="${pageContext.request.contextPath}/contatosServlet?id=${contato.id}&acao=getContato">
		                        		
		                        		<button class="btn btn-warning ml-2" value="editar">
	                            			<i class="material-icons">create</i>
	                            		</button>
		                        	</a>
	                            	
                            	</td>
		                        
	                        </tr>
                      	</c:forEach>
                      </tbody>
                    </table>
                    
                  </div>
	          </div>
	        </div>
        </div>
	</jsp:attribute>
</mt:admin_template>
