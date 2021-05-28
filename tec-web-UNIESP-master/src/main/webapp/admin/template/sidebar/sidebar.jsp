<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="sidebar" data-color="purple" data-background-color="white"
	data-image="${pageContext.request.contextPath}/assets/img/sidebar-1.jpg">
	<div class="logo">
		<a href="${pageContext.request.contextPath}/home" class="simple-text logo-normal">
			Creative Tim </a>
	</div>
	<div class="sidebar-wrapper">
		<ul class="nav">
			<li class="nav-item active">
				<a class="nav-link"	href="${pageContext.request.contextPath}/home"> 
					<i class="material-icons">dashboard</i>
					<p>Dashboard</p>
				</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/contatosServlet?acao=listar">
					<i class="material-icons">person</i>
					<p>Contatos</p>
				</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="${pageContext.request.contextPath}/usuariosServlet?acao=listar">
					<i class="material-icons">language</i>
					<p>Usuarios</p>
				</a>
			</li>
			
		</ul>
	</div>
</div>
