<%@ page import="entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="payload.ProductResponse" %>
<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/13/2022
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Online news blog</title>
    <jsp:include page="header/header2.jsp"></jsp:include>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <!-- Blog entries-->
        <div class="col-lg-8">
            <!-- Featured blog post-->
            <div class="card mb-4">

                <img class="card-img-top"
                     src="data:image/png;base64,${latestProduct.photofile}" width="700" height="350"
                     alt="..."/>
                <div class="card-body">
                    <div class="small text-muted"><i class="bi bi-calendar"></i>
                        <c:out value='${latestProduct.created_at}'/>
                    </div>
                    <h2 class="card-title"><c:out value='${latestProduct.titles}'/>
                    </h2>
                    <p class="card-text"><c:out value='${latestProduct.description}'/>
                    </p>
                    <a href="singleData?id=<c:out value='${latestProduct.id}' />"
                       class="btn btn-primary">Read more →</a>
                </div>
            </div>
            <!-- Nested row for non-featured blog posts-->
            <div class="row">

                <%
                    List<ProductResponse> productList=(List<ProductResponse>) session.getAttribute("productList");
                    for (ProductResponse product : productList) {
                %>
<%--                <c:forEach var="news" items="${productList}">--%>

                    <div class="col-lg-6">
                        <!-- Blog post-->
                        <div class="card mb-4">

                            <img class="card-img-top"
                                 src="data:image/png;base64,<%=product.getPhotofile()%>"
                                 width="500" height="250"
                                 alt="..."/>

                            <div class="card-body">
                                <div style="display: flex; justify-content: space-between">
                                    <div>
                                        <div class="small text-muted">
                                            <i class="bi bi-calendar"></i>
                                            <%=product.getCreated_at()%>
                                        </div>
                                    </div>
                                    <div class="small text-muted">
                                        <%=product.getName()%>
                                    </div>
                                </div>
                                <h2 class="card-title h4">
                                    <%=product.getTitles()%>
                                </h2>
                                <p class="card-text">
                                    <%=product.getDescription()%>
                                </p><br>
                                <a href="singleData?id=<%=product.getId()%>"
                                   class="btn btn-outline-success btn-sm">Read More</a>

                            </div>
                        </div>
                    </div>
                <%}%>
<%--                </c:forEach>--%>
            </div>
            <!-- Pagination-->
            <nav aria-label="Pagination">
                <hr class="my-0"/>
                <ul class="pagination">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage - 1}">Previous</a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${numb}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <li class="page-item active"><a class="page-link" href="#">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <%--                        <li class="page-item active"><a class="page-link" href="#">2</a></li>--%>

                    <c:if test="${currentPage lt numb}">
                        <li class="page-item"><a class="page-link" href="?page=${currentPage + 1}">Next</a></li>
                    </c:if>
                </ul>
            </nav>

        </div>
        <!-- Side widgets-->

        <jsp:include page="extra/categorySearch.jsp"></jsp:include>
<%--        <jsp:include page="publishers/publisher.jsp"></jsp:include>--%>
    </div>

</div>
<jsp:include page="footer/footer.jsp"></jsp:include>
</body>
</html>
