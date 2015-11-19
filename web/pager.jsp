<%@ page contentType="text/html; charset=UTF-8"%>

<!-- 分页标签 -->
<s:if test="pager.list!=null and pager.pagerSize>1">
	<ul class="pagination pagination-sm" style="margin: 0px;">
		<pg:pager url="${pager.pagerUrl}" items="${pager.total}"
			export="currentPageNumber=pageNumber"
			maxPageItems="${pager.pageSize}" maxIndexPages="4" isOffset="true">
			<s:if test="orderBy!=0">
				<pg:param name="orderBy"/>
			</s:if>
			
			<s:if test="#request.isSearch==1">
				<pg:first>
					<li><a href="${pageUrl}&key=${key}">首页</a></li>
				</pg:first>
				<pg:prev>
					<li><a href="${pageUrl}&key=${key}">上一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber==pageNumber}">
							<li class="disabled"><a href="#" style="background-color: red;border-color: red;cursor: default;">${pageNumber}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}&key=${key}">${pageNumber}</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li><a href="${pageUrl}&key=${key}">下一页</a></li>
				</pg:next>
				<pg:last>
					<li><a href="${pageUrl}&key=${key}">尾页</a></li>
				</pg:last>
			</s:if>
			<s:else>
				<pg:first>
					<li><a href="${pageUrl}">首页</a></li>
				</pg:first>
				<pg:prev>
					<li><a href="${pageUrl}">上一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber==pageNumber}">
							<li class="disabled"><a href="#" style="background-color: red;border-color: red;cursor: default;">${pageNumber}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}">${pageNumber}</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li><a href="${pageUrl}">下一页</a></li>
				</pg:next>
				<pg:last>
					<li><a href="${pageUrl}">尾页</a></li>
				</pg:last>
			</s:else>
			
			
		</pg:pager>
	</ul>
</s:if>
