<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<%@ attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html lang="en">

	<jsp:include page="/admin/template/head/head.jsp"></jsp:include>
	
	<body>
		<div class="wrapper">
			<jsp:include page="/admin/template/sidebar/sidebar.jsp"></jsp:include>
	
			<div class="main-panel">
				<jsp:include page="/admin/template/navbar/navbar.jsp"></jsp:include>
				
				<jsp:invoke fragment="content"></jsp:invoke>
	
				<jsp:include page="/admin/template/footer/footer.jsp"></jsp:include>
			</div>
		</div>
	
		<jsp:include page="/admin/template/filter/filter.jsp"></jsp:include>
	
		<jsp:include page="/admin/template/js/js.jsp"></jsp:include>
	</body>

</html>