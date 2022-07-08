<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/15/2022
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="../header/header2.jsp"></jsp:include>
<!-- Font Awesome -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
        rel="stylesheet"
/>
<!-- Google Fonts -->
<link
        href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
        rel="stylesheet"
/>
<!-- MDB -->
<link
        href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css"
        rel="stylesheet"
/>

<style>
    .gradient-custom {
        background: #fafafa;
    }

    .card-registration .select-input.form-control[readonly]:not([disabled]) {
        font-size: 1rem;
        line-height: 2.15;
        padding-left: .75em;
        padding-right: .75em;
    }

    .card-registration .select-arrow {
        top: 13px;
    }

    .modal-confirm {
        color: #636363;
        width: 325px;
        font-size: 14px;
    }

    .modal-confirm .modal-content {
        padding: 20px;
        border-radius: 5px;
        border: none;
    }

    .modal-confirm .modal-header {
        border-bottom: none;
        position: relative;
    }

    .modal-confirm h4 {
        text-align: center;
        font-size: 26px;
        margin: 30px 0 -15px;
    }

    .modal-confirm .form-control, .modal-confirm .btn {
        min-height: 40px;
        border-radius: 3px;
    }

    .modal-confirm .close {
        position: absolute;
        top: -5px;
        right: -5px;
    }

    .modal-confirm .modal-footer {
        border: none;
        text-align: center;
        border-radius: 5px;
        font-size: 13px;
    }

    .modal-confirm .icon-box {
        color: #fff;
        position: absolute;
        margin: 0 auto;
        left: 0;
        right: 0;
        top: -70px;
        width: 95px;
        height: 95px;
        border-radius: 50%;
        z-index: 9;
        background: #82ce34;
        padding: 15px;
        text-align: center;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
    }

    .modal-confirm .icon-box i {
        font-size: 58px;
        position: relative;
        top: 3px;
    }

    .modal-confirm.modal-dialog {
        margin-top: 80px;
    }

    .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
        background: #82ce34;
        text-decoration: none;
        transition: all 0.4s;
        line-height: normal;
        border: none;
    }

    .modal-confirm .btn:hover, .modal-confirm .btn:focus {
        background: #6fb32b;
        outline: none;
    }

    .trigger-btn {
        display: inline-block;
        margin: 100px auto;
    }
</style>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/">Bosh menu</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Subscribtion</a></li>
                <li class="nav-item"><a class="nav-link active" href="#">
                    <img data-toggle="modal" data-target="#loginModal" width="20"
                         src="https://img.icons8.com/fluency-systems-regular/48/undefined/user.png" alt="">
                </a>
                </li>

                <li class="nav-item"><a class="nav-link" href="#">sfds
                </a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header border-bottom-0">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-title text-center">
                    <h4>Login</h4>
                </div>
                <div class="d-flex flex-column text-center">
                    <form action="login" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" id="username" placeholder="Username...">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="password" placeholder="Your password...">
                        </div>
                        <button type="submit" class="btn btn-info btn-block btn-round">Login</button>
                    </form>

                    <div class="text-center text-muted delimiter">or use a social network</div>
                    <div class="d-flex justify-content-center social-buttons">
                        <button type="button" class="btn btn-secondary btn-round" data-toggle="tooltip"
                                data-placement="top" title="Twitter">
                            <i class="fab fa-twitter"></i>
                        </button>
                        <button type="button" class="btn btn-secondary btn-round" data-toggle="tooltip"
                                data-placement="top" title="Facebook">
                            <i class="fab fa-facebook"></i>
                        </button>
                        <button type="button" class="btn btn-secondary btn-round" data-toggle="tooltip"
                                data-placement="top" title="Linkedin">
                            <i class="fab fa-linkedin"></i>
                        </button>
                        </di>
                    </div>
                </div>
            </div>
            <div class="modal-footer d-flex justify-content-center">
                <div class="signup-section">Not a member yet?
                    <a href="registration" class="text-info"> Sign Up</a>.
                </div>
            </div>
        </div>
    </div>
</div>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                        <form action="<%=request.getContextPath()%>/registration" method="post">

                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="username" class="form-control form-control-lg"/>
                                        <label class="form-label">Your name </label>

                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" name="fullName" class="form-control form-control-lg"/>
                                        <label class="form-label">Full name</label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">

                                    <div class="form-outline datepicker w-100">
                                        <input type="password" name="password" class="form-control form-control-lg">
                                        <label class="form-label">Password</label>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="email" name="email" class="form-control form-control-lg"/>
                                        <label class="form-label">Email</label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">

                                <div class="col-md-12 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="tel" name="phoneNumber" class="form-control form-control-lg"/>
                                        <label class="form-label">Phone Number</label>
                                    </div>

                                </div>
                            </div>
                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>
