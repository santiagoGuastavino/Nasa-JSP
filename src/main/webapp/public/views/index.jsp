<jsp:include page="./partials/head.jsp" />

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<body class="wrapper">
	<main class="layout" style="margin-bottom: -1px">
		<jsp:include page="./partials/navbar.jsp" />
		
		<section class="home-section">
			<c:forEach var="blog" items="${blogs}">
				<article class="blog-article" id="blog-<c:out value="${blog.id}" />">
					<div class="blog-text">
						<p class="blog-title">
							<c:out value="${blog.title}" />
						</p>
						<p>
							Year: <c:out value="${blog.year}" />.
						</p>
						<p class="blog-collection">
							From <a>the <c:out value="${blog.collectionName}" /> collection.</a> 
						</p>					
					</div>
					<img
						class="blog-img"
						src="<c:out value="${blog.image}" />"
						alt="blog-${blog.id}-img"
					/>
				</article>
			</c:forEach>
			<div class="empty-separator-lol"></div>
		</section>
		
		<jsp:include page="./partials/footer.jsp" />
	</main>
</body>
</html>
