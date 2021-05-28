<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template>
	<jsp:attribute name="content">
		<div class="content">
			<div class="container-fluid">
	          <div class="row">
	            <div class="col-md-12">
	              <div class="card">
	                <div class="card-header card-header-primary">
	                  <h4 class="card-title">Adicionar Usuarios</h4>
	                  <p class="card-category">Preencha os dados de usuario</p>
	                </div>
	                <br>
	                <div class="col-md-12">
		              <c:if test="${not empty error}">
		              	<div class="alert alert-danger">
		              		${error}
		              	</div>
		              </c:if>
		            </div>
	                <br>
	                <div class="card-body">
	                  <form action="${pageContext.request.contextPath}/usuariosServlet?acao=salvar" method="post">
	                    <div class="row">
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Username</label>
	                          <input type="text" name="username" class="form-control" maxlength="50" required="required">
	                        </div>
	                      </div>
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Password</label>
	                          <input type="password" name="password" class="form-control" maxlength="50" required="required">
	                        </div>
	                      </div>
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Confirmação Password</label>
	                          <input type="password" name="cfpassword" class="form-control" maxlength="50" required="required">
	                        </div>
						  </div>
						
	                    </div>                   
	                                                   
	                    <button type="submit" class="btn btn-primary pull-right">
							Salvar
						</button>
	                    <div class="clearfix"></div>
	                    
	                  </form>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
        </div>
	</jsp:attribute>
</mt:admin_template>