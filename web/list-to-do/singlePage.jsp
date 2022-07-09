<%@ page import="service.product.ProductServiceImpl" %>
<%@ page import="entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/19/2022
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>This is one news</title>
    <jsp:include page="../header/header2.jsp"></jsp:include>

</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-lg-8">
            <div class="card mb-4">
                <a href="#">
                    <img class="card-img-top"
                         src="data:image/png;base64,${currentProduct.photofile}" width="600" height="350"
                         alt="..."/>
                </a>
                <div class="card-body">
                    <div class="small text-muted"><c:out value="${currentProduct.created_at}"/>
                    </div>
                    <h2 class="card-title "><c:out value="${currentProduct.titles}"/>
                    </h2>
                    <p class="card-text fw-bold"><c:out value="${currentProduct.description}"/>
                    </p>
                    <br>
                    <p class="lh-lg">
                        <c:out value="${currentProduct.textData}" escapeXml="false"/>
                    </p>
                </div>
            </div>

            <!-- From -->
        </div>
        <jsp:include page="../extra/categorySearch.jsp"></jsp:include>
    </div>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
