<jsp:include page="./partials/head.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body class="wrapper">
	<main class="layout">
		<jsp:include page="./partials/navbar.jsp" />
		
		<section class="center-section">

			<c:out value="${error}" />
			<c:out value="${cause}" />
			<c:out value="${message}" />
			<c:out value="${anotherMessage}" />
			<c:out value="${toString}" />
			
			<c:catch var="myExceptionObject">
    			Code that might throw Exception
			</c:catch>

			<c:if test="${myExceptionObject} != null">
			    There was an exception: ${myExceptionObject.message}
			</c:if>

		</section>
		
		<jsp:include page="./partials/footer.jsp" />
	</main>
</body>
</html>
