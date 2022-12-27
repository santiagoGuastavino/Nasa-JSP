<jsp:include page="./partials/head.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="./partials/navbar.jsp" />
		
		<section class="center-section">
			<article class="center-box user-box">
				<p class="user-name">
					<c:out value="${firstName}" /> <c:out value="${lastName}" />
				</p>
				<div class="image-box">
					<img src="${pageContext.request.contextPath}/public/img/<c:out value="${image}" />" alt="user-image" />						
				</div>
				<form class="input-box" method="post" action="/Nasa-JSP/auth/logout">
					<button type="submit" class="input button">
						<p>Log out</p>
					</button>
				</form>
			</article>
		</section>

		<jsp:include page="./partials/footer.jsp" />
	</main>
</body>
</html>
