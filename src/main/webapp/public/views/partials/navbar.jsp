<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="nav-wrapper">
	<nav class="nav">
		<img src="${pageContext.request.contextPath}/public/img/logo.png" alt="nasa-main" />
		<h1>
			Nasa Blog
		</h1>
		<span class="session-span">
			<c:out value="${sessionScope.userEmail}" />
		</span>
	</nav>
</div>
