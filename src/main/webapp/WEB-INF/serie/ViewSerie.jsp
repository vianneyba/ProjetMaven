<%-- <c:set var="titlePage" value="Ajout d'un Film" scope="session"/> --%>
<c:choose>
	<c:when test="${ error != true }">
		<div class="row">
			<div class="col-md-4">
				<ul class="list-group">
					<c:if test="${ sessionScope.user != null  }">
						<li>
							<a href='<c:url value="/people/add?function=actor&type=movie&id=${ serie.id }" />'>
								<button type="button" class="btn btn-secondary btn-xs">Ajouter un acteur</button>
							</a>
						</li>
					</c:if>
					
					<c:forEach items="${ serie.actors }" var="actor">
						<li class="list-group-item">
							<a href='<c:url value="/people?id=${ actor.id }" />' >${ actor.firstName } ${ actor.lastName }</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="col-md-8">
				<h3>${ serie.title } (${ serie.releaseDate }) </h3>
				
				<c:if test="${ sessionScope.user != null  }">
					<jsp:include page="/WEB-INF/layout/LikeDislike.jsp" >
						<jsp:param name="likeCount" value="${ movie.likeCount }" />
						<jsp:param name="dislikeCount" value="${ movie.dislikeCount }" />
						<jsp:param name="progressBar" value="${ 100*(movie.likeCount/(movie.likeCount+movie.dislikeCount)) }" />
						<jsp:param name="myVote" value="is-disliked" />
						<jsp:param name="url" value="&id=${ movie.id }&type=movie" />
					</jsp:include>
				</c:if>
			</div>
		</div>
	</c:when>
	
	<c:otherwise>
		<h1>Serie introuvable</h1>
	</c:otherwise>
</c:choose>