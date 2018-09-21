<c:forEach items="${ bricks }" var="brick">
	<div class="row">
		<div style="background-color: #ffece6; margin: 20px;" class="col-md-12">
			<header class="headerMessage">
				<span>
				 	<c:if test = "${ brick.user.id == sessionScope.user.id }"> 
						 <c:choose>
							<c:when test="${ brick.share && brick.user.id == sessionScope.user.id }">
								<a href="<c:url value = "/wall?id=${ brick.id }&partage=0" />">partage plus</a>
							</c:when>

							<c:otherwise>
								<a href="<c:url value = "/wall?id=${ brick.id }&partage=1"/>">on partage</a>
							</c:otherwise>
						</c:choose>
					</c:if> 	
				</span>
			</header>
			
			<p><a href='<c:url value="/user?id=${ brick.user.id }" />'>${ brick.user.firstName } ${ brick.user.lastName }</a> ${ brick.html }</p>
				
			<footer class="footerMessage">
				<span>il y a environ une heure</span>
				<span><a href="<c:url value = "" />">J'aime</a></span>
				<span><a href="<c:url value = "/comment/add?id=${ brick.id }" />">Commenter</a></span>
				<span><a href="<c:url value = "/comment" />">Afficher le suivi</a></span>
			</footer>
		</div>
	</div>
</c:forEach>