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
    <form method="post">
        <table class="table table-striped">
            <tr>
                <td> ID </td>
                <td> Name </td>
                <td> Price </td>
                <td> Quantity </td>
                <td> Color </td>
                <td> Category </td>
            </tr>
            <c:forEach  var="product" items="${productList}">
                <tr>
                    <td>
                        <input type="text" name="country" size="25"
                                value="${product.name}"/>
                    </td>
                    <td>
                        <input type="text" name="country" size="25"
                               value="${product.price}"/>
                    </td>
                    <td>
                        <input type="text" name="country" size="25"
                               value="${product.quantity}"/>
                    </td>
                    <td>
                        <input type="text" name="country" size="25"
                               value="${product.color}"/>
                    </td>
                    <td>
                        <input type="text" name="country" size="25"
                               value="${product.category}"/>
                    </td>
                    <td>
                        <input type="text" name="country" size="25"
                               value="${product.des}"/>
                    </td>
                </tr>
                <tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
