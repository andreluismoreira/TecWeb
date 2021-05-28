<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "mt" tagdir="/WEB-INF/tags"%>

<script	type="text/javascript" src="${pageContext.request.contextPath}/assets/js/core/jquery.min.js"></script>
<script	type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/jquery.mask.min.js"></script>

<mt:admin_template>
	<jsp:attribute name="content">
		<div class="content">
			<div class="container-fluid">
	          <div class="row">
	            <div class="col-md-12">
	              <div class="card">
	                <div class="card-header card-header-primary">
	                  <h4 class="card-title">Editar Contato</h4>
	                  <p class="card-category">Preencha seus dados</p>
	                </div>
	                
	                <div class="card-body">
	                  <form action="${pageContext.request.contextPath}/contatosServlet?acao=editar" method="post">
	                    <div class="row">
	                      
	                      <div class="col-md-12" hidden="true">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">ID</label>
								<input type="text" name="id" class="form-control" maxlength="10" required="required" 
                          		value="${contato.id}">
	                        </div>
	                      </div>
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nome</label>
	                          <input type="text" name="nome" class="form-control" maxlength="50" required="required"
	                          value="${contato.name}">
	                        </div>
	                      </div>
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Contato</label>
	                          <input type="text" name="contato" id="contato" class="form-control" maxlength="11" required="required"
	                          value="${contato.contato}">
	                        </div>
	                      </div>
	                      
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email</label>
	                          <input type="email" name="email" class="form-control" maxlength="50" required="required"
	                          value="${contato.email}">
	                        </div>
	                      </div>
	                      
	                    </div>                                 
	                    <button type="submit" class="btn btn-primary pull-right">
							Editar
						</button>
	                    <div class="clearfix"></div>
	                  </form>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
        </div>
<script	type="text/javascript"> 
	$("#contato").mask("(00) 000000009")
</script>
	</jsp:attribute>
</mt:admin_template>