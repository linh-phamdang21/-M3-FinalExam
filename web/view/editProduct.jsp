<%--
  Created by IntelliJ IDEA.
  User: phdan
  Date: 26/05/2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Product Management</h1>
    <h2>
        <a href="/product?action=products">List All Products</a>
    </h2>
</div>
<div style="width: 80%; margin: auto">
    <form>
        <table class="table table-striped">
            <tr>
                <td> Name</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.name}"/>
                </td>
            </tr>
            <tr>
                <td> Price</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.price}"/>
                </td>
            </tr>
            <tr>
                <td> Quantity</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.quantity}"/>
                </td>
            </tr>
            <tr>
                <td> Color</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.color}"/>
                </td>
            </tr>
            <tr>
                <td> Category</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.category}"/>
                </td>
            </tr>
            <tr>
                <td> Description</td>
                <td>
                    <input type="text" name="country" size="25"
                           value="${product.des}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Update"/>
                    <form method="get" action="product">
                        <input type="submit" value="Back"/>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
