<%--
  Created by IntelliJ IDEA.
  User: Muhammadqodir
  Date: 6/25/2022
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .gradient-custom {
            background: radial-gradient(50% 123.47% at 50% 50%, #00ff94 0%, #720059 100%),
            linear-gradient(121.28deg, #669600 0%, #ff0000 100%),
            linear-gradient(360deg, #0029ff 0%, #8fff00 100%),
            radial-gradient(100% 164.72% at 100% 100%, #6100ff 0%, #00ff57 100%),
            radial-gradient(100% 148.07% at 0% 0%, #fff500 0%, #51d500 100%);
            background-blend-mode: screen, color-dodge, overlay, difference, normal;
        }
    </style>
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-xl-10">

                <div class="card">
                    <div class="card-body p-5">

                        <form class="d-flex justify-content-center align-items-center mb-4">
                            <div class="form-outline flex-fill">
                                <input type="text" id="form2" class="form-control" />
                                <label class="form-label" for="form2">New task...</label>
                            </div>
                            <button type="submit" class="btn btn-info ms-2">Add</button>
                        </form>

                        <!-- Tabs navs -->
                        <ul class="nav nav-tabs mb-4 pb-2" id="ex1" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" id="ex1-tab-1" data-mdb-toggle="tab" href="#ex1-tabs-1" role="tab"
                                   aria-controls="ex1-tabs-1" aria-selected="true">All</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" id="ex1-tab-2" data-mdb-toggle="tab" href="#ex1-tabs-2" role="tab"
                                   aria-controls="ex1-tabs-2" aria-selected="false">Active</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link" id="ex1-tab-3" data-mdb-toggle="tab" href="#ex1-tabs-3" role="tab"
                                   aria-controls="ex1-tabs-3" aria-selected="false">Completed</a>
                            </li>
                        </ul>
                        <!-- Tabs navs -->

                        <!-- Tabs content -->
                        <div class="tab-content" id="ex1-content">
                            <div class="tab-pane fade show active" id="ex1-tabs-1" role="tabpanel"
                                 aria-labelledby="ex1-tab-1">
                                <ul class="list-group mb-0">
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." checked />
                                        <s>Cras justo odio</s>
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." checked />
                                        <s>Dapibus ac facilisis in</s>
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Morbi leo risus
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Porta ac consectetur ac
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-0 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Vestibulum at eros
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-pane fade" id="ex1-tabs-2" role="tabpanel" aria-labelledby="ex1-tab-2">
                                <ul class="list-group mb-0">
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Morbi leo risus
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Porta ac consectetur ac
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-0 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." />
                                        Vestibulum at eros
                                    </li>
                                </ul>
                            </div>
                            <div class="tab-pane fade" id="ex1-tabs-3" role="tabpanel" aria-labelledby="ex1-tab-3">
                                <ul class="list-group mb-0">
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." checked />
                                        <s>Cras justo odio</s>
                                    </li>
                                    <li class="list-group-item d-flex align-items-center border-0 mb-2 rounded"
                                        style="background-color: #f4f6f7;">
                                        <input class="form-check-input me-2" type="checkbox" value="" aria-label="..." checked />
                                        <s>Dapibus ac facilisis in</s>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- Tabs content -->

                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
</body>
</html>
