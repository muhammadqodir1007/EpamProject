<%@ page import="database.DB" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="controller.Login" %>
<%@ page import="java.util.Stack" %>
<%@ page import="entity.ProductBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.people.PeopleService" %>
<%@ page import="entity.PeopleBean" %><%--
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

    Connection connection = DB.getConnection();
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select count(*) from public.\"product\"");
    int numberOfNews = 0;
    while (resultSet.next()) {
        numberOfNews = resultSet.getInt(1);
    }
    Statement statement1 = connection.createStatement();
    ResultSet resultSet1 = statement1.executeQuery("select count(*) from public.\"users\"");
    int numberOfUsers = 0;
    while (resultSet1.next()) {

        numberOfUsers = resultSet1.getInt(1);

    }
    connection.close();
    Connection connection1 = DB.getConnection();
    Statement statement2 = connection1.createStatement();
    ResultSet rs = statement2.executeQuery("select * from public.\"product\" order by \"createdTime\" desc limit 10");
    List<ProductBean> list = new ArrayList<>();


    while (rs.next()) {
        ProductBean productBean = new ProductBean();
        productBean.setId(rs.getInt(1));
        productBean.setTitles(rs.getString(2));
        productBean.setDescription(rs.getString(3));
        productBean.setSourceLinkTo(rs.getString(4));
        productBean.setCreatedTime(rs.getDate(5));
        productBean.setCategoryId(rs.getInt(6));
        productBean.setPhotoFile(rs.getBytes(7));
        productBean.setText(rs.getString(8));
        list.add(productBean);

    }

    PeopleService peopleService=new PeopleService();
    List<PeopleBean> all = peopleService.getAll();



%>
<div class="sidebar">
    <div class="logo-details">
        <i class='bx bxl-c-plus-plus'></i>
        <span class="logo_name">NewsPortal</span>
    </div>
    <ul class="nav-links">
        <li>
            <a href="index.jsp" class="active">
                <i class='bx bx-grid-alt'></i>
                <span class="links_name">Dashboard</span>
            </a>
        </li>
        <li>
            <a href="/viewNews">
                <i class='bx bx-box'></i>
                <span class="links_name">Product</span>
            </a>
        </li>
        <li>
            <a href="viewUsers">
                <i class='bx bx-list-ul'></i>
                <span class="links_name">Users list</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-pie-chart-alt-2'></i>
                <span class="links_name">Analytics</span>
            </a>
        </li>
        <li>
            <a href="/addNews">
                <i class='bx bx-coin-stack'></i>
                <span class="links_name">AddNews</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-book-alt'></i>
                <span class="links_name"></span>
            </a>
        </li>
        <li>
            <a href="/viewUsers.jsp">
                <i class='bx bx-user'></i>
                <span class="links_name">Team</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-message'></i>
                <span class="links_name">Messages</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-heart'></i>
                <span class="links_name">Favrorites</span>
            </a>
        </li>
        <li>
            <a href="#">
                <i class='bx bx-cog'></i>
                <span class="links_name">Setting</span>
            </a>
        </li>
        <li class="log_out">
            <a href="#">
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
            <span class="admin_name"><%=Login.name%></span>
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
                    <div class="box-topic">Total Users</div>
                    <div class="number"><%=numberOfUsers%>
                    </div>
                    <div class="indicator">
                        <i class='bx bx-up-arrow-alt'></i>
                        <span class="text">Up from yesterday</span>
                    </div>
                </div>
                <i class='bx bxs-cart-add cart two'></i>
            </div>
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Total Profit</div>
                    <div class="number">$12,876</div>
                    <div class="indicator">
                        <i class='bx bx-up-arrow-alt'></i>
                        <span class="text">Up from yesterday</span>
                    </div>
                </div>
                <i class='bx bx-cart cart three'></i>
            </div>
            <div class="box">
                <div class="right-side">
                    <div class="box-topic">Total Return</div>
                    <div class="number">11,086</div>
                    <div class="indicator">
                        <i class='bx bx-down-arrow-alt down'></i>
                        <span class="text">Down From Today</span>
                    </div>
                </div>
                <i class='bx bxs-cart-download cart four'></i>
            </div>
        </div>

        <div class="sales-boxes">
            <div class="recent-sales box">
                <div class="title">Recently added News</div>

                <%--                <div class="sales-details">--%>
                <ul class="details" style="font-family: 'Arial Black'">
                    <li><a href="/returnOne?id=<%=list.get(0).getId()%>"><%=list.get(list.size()-1).getCreatedTime()%></a>    <%=list.get(0).getTitles()%></li>
                    <li><a href="/returnOne?id=<%=list.get(1).getId()%>"><%=list.get(list.size()-2).getCreatedTime()%></a>    <%=list.get(1).getTitles()%></li>
                    <li><a href="/returnOne?id=<%=list.get(2).getId()%>"><%=list.get(list.size()-3).getCreatedTime()%></a>    <%=list.get(2).getTitles()%></li>
                    <li><a href="/returnOne?id=<%=list.get(3).getId()%>"><%=list.get(list.size()-4).getCreatedTime()%></a>    <%=list.get(3).getTitles()%></li>
                    <li><a href="/returnOne?id=<%=list.get(4).getId()%>"><%=list.get(list.size()-5).getCreatedTime()%></a>    <%=list.get(4).getTitles()%></li>
                </ul>
            </div>
            <div class="recent-sales box">
                <div class="title">Recently Registered Users</div>
                                    <ul class="details">

                                        <li><a href="viewUsers"><%=all.get(all.size()-1).getFullName()%></li>
                                        <li><a href="viewUsers"><%=all.get(all.size()-2).getFullName()%></a></li>
                                        <li><a href="viewUsers"><%=all.get(all.size()-3).getFullName()%></a></li>
                                        <li><a href="viewUsers"><%=all.get(all.size()-4).getFullName()%></a></li>
                                        <li><a href="viewUsers"><%=all.get(all.size()-5).getFullName()%></a></li>
                                    </ul>
            </div>

        </div>
    </div>
    </div>
</section>


</body>
</html>

