<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- javascript -->
<script src="${pageContext.request.contextPath}/public/js/navbar.js" defer type="text/javascript"></script>

<div class="nav-wrapper">
	<nav class="nav">
		<img src="${pageContext.request.contextPath}/public/img/logo.png" alt="nasa-main" />
		<h1>
			Nasa Blog
		</h1>
		<span><c:out value="${subtitle}" /></span>
	</nav>
</div>
