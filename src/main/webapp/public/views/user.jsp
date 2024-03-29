<jsp:include page="./partials/head.jsp" />

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="./partials/navbar.jsp" />
		
		<section class="center-section">
			<article class="center-box user-box">
				<p class="user-text">
					<c:out value="${firstName}" /> <c:out value="${lastName}" />
				</p>
				<p class="user-text">
					<c:out value="${email}" />
				</p>
				<div class="image-box">
					<img src="${pageContext.request.contextPath}/public/img/<c:out value="${image}" />" alt="user-image" />						
				</div>
				<form class="input-box" method="post" action="/nasa/auth/logout">
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
