<%--
  Created by IntelliJ IDEA.
  User: phdan
  Date: 26/05/2020
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="stylesheet" href="css/admin_interface.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Product List</title>

</head>
<body>
<h3> Product List </h3>
<h4></h4>
<p>
    <a href="/product?action=create"> Add new product</a>
</p>
<p>
    <a href="/product?action=search"> Search product by ID </a>
</p>
<div style="width: 80%; margin: auto">
    <table class="table table-striped">
        <tr>
            <td> ID </td>
            <td> Name </td>
            <td> Price </td>
            <td> Quantity </td>
            <td> Color </td>
            <td> Category </td>
            <td> Action </td>
        </tr>
        <c:forEach  var="product" items="${productList}">
            <tr>
                <td> ${product.getId()} </td>
                <td> ${product.getName()} </td>
                <td> ${product.getPrice()} </td>
                <td> ${product.getQuantity()} </td>
                <td> ${product.getColor()} </td>
                <td> ${product.getCategory()} </td>
                <td>
                    <a href="/product?action=edit&id=${product.getId()}">Edit</a>
                    <a href="/product?action=delete&id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
