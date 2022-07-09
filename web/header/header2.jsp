<%--
  Created by IntelliJ IDEA.
  User: Temurbek
  Date: 6/14/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
<meta name="description" content=""/>
<meta name="author" content=""/>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="data:image/png;
base64,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"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous">
<%--<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>--%>
<%--<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css'>--%>
<style><%@include file="../assets/css/modalCss/styleModal.css"%></style>
