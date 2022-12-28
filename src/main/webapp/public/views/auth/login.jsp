<jsp:include page="../partials/head.jsp" />

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<script src="${pageContext.request.contextPath}/public/js/auth.js" defer type="text/javascript"></script>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="../partials/navbar.jsp" />
		
		<section class="center-section">

			<form class="center-box" method="post" action="/nasa/auth/login">
				<div class="input-box">
					<label class="input-label">
						Email
					</label>
					<input
						class="input"
						type="text"
						name="email"
						id="email"
						value="<c:out value="${email}" />"
					/>
				</div>
				<div class="input-box">
					<label class="input-label">
						Password
					</label>
					<input
						class="input"
						type="password"
						name="password"
						id="password"
					/>
				</div>
				<div class="input-box">
					<button type="submit" class="input button">
						<p>Log in</p>
					</button>
				</div>
			</form>
			
			<div class="switch-auth">
				<p></p>
			</div>
			
			<div id="form-message-container">
				<c:forEach var="message" items="${messages}">
					<span>
	  					<c:out value="${message}" />
	  				</span>
				</c:forEach>
			</div>
		</section>

		<jsp:include page="../partials/footer.jsp" />
	</main>
</body>
</html>
