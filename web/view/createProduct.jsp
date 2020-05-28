<%--
  Created by IntelliJ IDEA.
  User: phdan
  Date: 26/05/2020
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<div>
    <h1>User Management</h1>
    <h2>
        <a href="/product?action=products">List All Product</a>
    </h2>
</div>
<div align="center">
    <form method="post">
        <table class="table table-striped">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Description:</th>
                <td>
                    <input type="text" name="des" id="des" size="45"/>
                </td>
            </tr>
            <tr>
                <th> Category:</th>
                <td>
                    <input type="text" name="category" id="category" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Create"/>
                    <input type="submit" value="Back"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
