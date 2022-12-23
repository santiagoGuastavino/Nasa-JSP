<jsp:include page="../partials/head.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/public/js/auth.js" defer type="text/javascript"></script>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="../partials/navbar.jsp" />
		
		<section class="center-section">

			<form class="user-form" method="post" action="/Nasa-JSP/auth/register">
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
						<p>Register</p>
					</button>
				</div>	
			</form>
			
			<div class="switch-auth">
				<p></p>
			</div>
			
			<div id="form-message-container">
				<c:forEach var="message" items="${messages}">
					<p>
	  					<c:out value="${message}" />
	  				</p>
				</c:forEach>
			</div>
		</section>

		<jsp:include page="../partials/footer.jsp" />
	</main>
</body>
</html>
