<%--
  Created by IntelliJ IDEA.
  User: phdan
  Date: 26/05/2020
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="css/admin_interface.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 80%; margin: auto">
    <table class="table table-striped">
        <tr>
            <td> ID</td>
            <td> Name</td>
            <td> Price</td>
            <td> Quantity</td>
            <td> Color</td>
            <td> Category</td>
            <td> Action</td>
        </tr>
        <tr>
            <td> ${product.getId()} </td>
            <td> ${product.getName()} </td>
            <td> ${product.getPrice()} </td>
            <td> ${product.getQuantity()} </td>
            <td> ${product.getColor()} </td>
            <td> ${product.getCategory()} </td>
            <td>
                <a href="/product?action=edit&id=${user.getId()}">Edit</a>
                <a href="/product?action=delete&id=${user.getId()}">Delete</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
