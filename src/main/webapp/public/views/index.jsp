<jsp:include page="./partials/head.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="./partials/navbar.jsp" />

		<nav class="home-navigation">
			<div>
				<a>
					Solar System
				</a>
			</div>
			<div>
				<a>
					Visible Earth
				</a>
			</div>
			<div>
				<a>
					Hubble Space Telescope
				</a>
			</div>
		</nav>
		
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
							From the <a><c:out value="${blog.collectionName}" /></a> collection.
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
