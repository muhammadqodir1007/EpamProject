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
    <style>
        .be-comment-block {
            margin-bottom: 50px !important;
            border: 1px solid #edeff2;
            border-radius: 2px;
            padding: 50px 70px;
            border:1px solid #ffffff;
        }

        .comments-title {
            font-size: 16px;
            color: #262626;
            margin-bottom: 15px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-img-comment {
            width: 60px;
            height: 60px;
            float: left;
            margin-bottom: 15px;
        }

        .be-ava-comment {
            width: 60px;
            height: 60px;
            border-radius: 50%;
        }

        .be-comment-content {
            margin-left: 80px;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-name {
            font-size: 13px;
            font-family: 'Conv_helveticaneuecyr-bold';
        }

        .be-comment-content a {
            color: #383b43;
        }

        .be-comment-content span {
            display: inline-block;
            width: 49%;
            margin-bottom: 15px;
        }

        .be-comment-time {
            text-align: right;
        }

        .be-comment-time {
            font-size: 11px;
            color: #b4b7c1;
        }

        .be-comment-text {
            font-size: 13px;
            line-height: 18px;
            color: #7a8192;
            display: block;
            background: #f6f6f7;
            border: 1px solid #edeff2;
            padding: 15px 20px 20px 20px;
        }

        .form-group.fl_icon .icon {
            position: absolute;
            top: 1px;
            left: 16px;
            width: 48px;
            height: 48px;
            background: #f6f6f7;
            color: #b5b8c2;
            text-align: center;
            line-height: 50px;
            -webkit-border-top-left-radius: 2px;
            -webkit-border-bottom-left-radius: 2px;
            -moz-border-radius-topleft: 2px;
            -moz-border-radius-bottomleft: 2px;
            border-top-left-radius: 2px;
            border-bottom-left-radius: 2px;
        }

        .form-group .form-input {
            font-size: 13px;
            line-height: 50px;
            font-weight: 400;
            color: #b4b7c1;
            width: 100%;
            height: 50px;
            padding-left: 20px;
            padding-right: 20px;
            border: 1px solid #edeff2;
            border-radius: 3px;
        }

        .form-group.fl_icon .form-input {
            padding-left: 70px;
        }

        .form-group textarea.form-input {
            height: 150px;
        }


    </style>
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

            <div class="be-comment-block">
                <h1 class="comments-title">Comments (3)</h1>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">

				<span class="be-comment-name">
					<a href="blog-detail-2.html">Ravi Sah</a>
					</span>
                        <span class="be-comment-time">
					<i class="fa fa-clock-o"></i>
					May 27, 2015 at 3:14am
				</span>

                        <p class="be-comment-text">
                            Pellentesque gravida tristique ultrices.
                            Sed blandit varius mauris, vel volutpat urna hendrerit id.
                            Curabitur rutrum dolor gravida turpis tristique efficitur.
                        </p>
                    </div>
                </div>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar2.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">
			<span class="be-comment-name">
				<a href="blog-detail-2.html">Phoenix, the Creative Studio</a>
			</span>
                        <span class="be-comment-time">
				<i class="fa fa-clock-o"></i>
				May 27, 2015 at 3:14am
			</span>
                        <p class="be-comment-text">
                            Nunc ornare sed dolor sed mattis. In scelerisque dui a arcu mattis, at maximus eros commodo. Cras magna nunc, cursus lobortis luctus at, sollicitudin vel neque. Duis eleifend lorem non ant. Proin ut ornare lectus, vel eleifend est. Fusce hendrerit dui in turpis tristique blandit.
                        </p>
                    </div>
                </div>
                <div class="be-comment">
                    <div class="be-img-comment">
                        <a href="blog-detail-2.html">
                            <img src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="" class="be-ava-comment">
                        </a>
                    </div>
                    <div class="be-comment-content">
			<span class="be-comment-name">
				<a href="blog-detail-2.html">Cüneyt ŞEN</a>
			</span>
                        <span class="be-comment-time">
				<i class="fa fa-clock-o"></i>
				May 27, 2015 at 3:14am
			</span>
                        <p class="be-comment-text">
                            Cras magna nunc, cursus lobortis luctus at, sollicitudin vel neque. Duis eleifend lorem non ant
                        </p>
                    </div>
                </div>
                <form class="form-block">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6">
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-user"></i></div>
                                <input class="form-input" type="text" placeholder="Your name">
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6 fl_icon">
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-envelope-o"></i></div>
                                <input class="form-input" type="text" placeholder="Your email">
                            </div>
                        </div>
                        <br>
                        <div class="col-xs-12">
                            <div class="form-group">
                                <textarea class="form-input" required="" placeholder="Your text"></textarea>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-6">
                            <a class="btn btn-primary pull-right">submit</a>
                        </div>
                    </div>
                </form>
            </div>

            <!-- From -->
        </div>
        <jsp:include page="../extra/categorySearch.jsp"></jsp:include>
    </div>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
