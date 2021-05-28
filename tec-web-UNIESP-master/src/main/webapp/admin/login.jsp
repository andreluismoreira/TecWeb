<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
		#login .container #login-row #login-column #login-box {
			margin-top: 120px;
			max-width: 600px;
			height: 320px;
			border: 1px solid #9C9C9C;
			background-color: #EAEAEA;
		}
		
		#login .container #login-row #login-column #login-box #login-form {
			padding: 20px;
		}
		
		#login .container #login-row #login-column #login-box #login-form #register-link
			{
			margin-top: -85px;
		}
		
		.text-info {
			color: #9c27b0 !important;
		}
		
		.btn-info {
			color: #fff;
			background-color: #9c27b0;
			border-color: #9c27b0;
		}
		
		.btn-info:hover {
			color: #fff;
			background-color: #8000ff;
			border-color: #8000ff;
		}
	</style>
</head>
<body>
	<div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
	        
            <div id="login-row" class="row justify-content-center align-items-center">				
                <div id="login-column" class="col-md-6">
                	<div class="col-md-12">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
					</div>
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="loginServlet" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Login">
                            </div>
                            <div id="register-link" class="text-right">
                            	<br>
                                <a href="#" class="text-info">Register here</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>