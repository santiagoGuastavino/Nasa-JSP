<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- javascript -->
<script src="${pageContext.request.contextPath}/public/js/footer.js" defer type="text/javascript"></script>

<footer class="footer">
	<c:choose>
		<c:when test="${sessionScope.userEmail == null}">
			<a id="empty-session-link">
				<i id="icon"></i>
			</a>	
		</c:when>
		<c:otherwise>
			<a id="full-session-link">
				<i id="icon"></i>
			</a>
		</c:otherwise>
	</c:choose>
</footer>
