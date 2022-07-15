<%@ page import="database.DB" %>
<%@ page import="controller.Login" %>
<%@ page import="java.util.Stack" %>
<%@ page import="entity.ProductBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.people.PeopleService" %>
<%@ page import="entity.PeopleBean" %>
<%@ page import="java.sql.*" %>
<%@ page import="static controller.Login.*" %><%--
  Created by IntelliJ IDEA.
  User: Muhammadqodir
  Date: 6/24/2022
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="Home.css">

    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<%


    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }

    Connection connection = DB.getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select count(*) from public.\"product\"");
    int numberOfNews = 0;
    while (resultSet.next()) {
        numberOfNews = resultSet.getInt(1);
    }
    connection.close();
    Connection connection1 = DB.getConnection();
    PreparedStatement preparedStatement = connection1.prepareStatement("select count(*) from public.product where \"publisher_id\"=?");

    int numberOfNewsByPublisher=0;
    try {

        preparedStatement.setInt(1, Math.toIntExact(Login.publisher.getId()));
        ResultSet resultSet1 = preparedStatement.executeQuery();

        while (resultSet1.next()) {
            numberOfNewsByPublisher = resultSet1.getInt(1);


        }


    } catch (SQLException e) {
        e.printStackTrace();
    }


    Connection connection2 = DB.getConnection();
    Statement statement3 = connection2.createStatement();
    ResultSet resultSet2 = statement3.executeQuery("select count (*) from public.category");
    int numberOfCat = 0;
    while (resultSet2.next()) {
        numberOfCat = resultSet2.getInt(1);
    }
    connection.close();


%>
<div class="sidebar">
    <div class="logo-details">
        <i class='bx bxl-c-plus-plus'></i>
        <span class="logo_name">NewsPortal</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="HomeP.jsp" class="active">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="/viewNewsByPublisher">
                <i class='bx bx-box'></i>
                <span class="links_name">Product</span>
            </a>
        </li>



        <li>
            <a href="/addNewsByPublisher">
                <i class='bx bx-coin-stack'></i>
                <span class="links_name">AddNews</span>
            </a>
        </li>



        <li class="log_out">
            <a href="/logout">
                <i class='bx bx-log-out'></i>
                <span class="links_name">Log out</span>
            </a>
        </li>
    </ul>
</div>
<section class="home-section">
    <nav>
        <div class="sidebar-button">
            <i class='bx bx-menu sidebarBtn'></i>
            <span class="dashboard">Dashboard</span>
        </div>
        <div class="search-box">
            <input type="text" placeholder="Search...">
            <i class='bx bx-search'></i>
        </div>
        <div class="profile-details">
            <!--<img src="images/profile.jpg" alt="">-->
            <span class="admin_name"><%=name%></span>
            <i class='bx bx-chevron-down'></i>
        </div>
    </nav>

    <div class="home-content">
        <div class="overview-boxes">
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Total News</div>
                    <div class="number"><%=numberOfNews%>
                    </div>
                    <div class="indicator">
                        <i class='bx bx-up-arrow-alt'></i>
                        <span class="text">Up from yesterday</span>
                    </div>
                </div>
                <i class='bx bx-cart-alt cart'></i>
            </div>
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Total Categories</div>
                    <div class="number"><%=numberOfCat%>
                    </div>
                    <div class="indicator">
                        <i class='bx bx-up-arrow-alt'></i>
                        <span class="text">Up from yesterday</span>
                    </div>
                </div>
                <i class='bx bx-cart-alt cart'></i>
            </div>

            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Number of my news</div>
                    <div class="number"><%=numberOfNewsByPublisher%>
                    </div>
                    <div class="indicator">
                        <i class='bx bx-up-arrow-alt'></i>
                        <span class="text">Up from yesterday</span>
                    </div>
                </div>
                <i class='bx bxs-cart-add cart two'></i>
            </div>


        </div>

        <div class="sales-boxes">
            <div class="recent-sales box">


                <%--                <div class="sales-details">--%>

            </div>

        </div>
    </div>
    </div>
</section>


</body>
</html>

