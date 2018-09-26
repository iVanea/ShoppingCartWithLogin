<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #toCenter{
            width:500px;
            margin:auto;
            text-align: center;
        }
        .name{
            text-transform: capitalize;
        }
        .button {
            background-color: salmon;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }


        #bar {width:20%;
            float:left;
            position:relative;
            text-align: center;
        }
    </style>


    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/script.js"></script>
</head>
<body>
<div id="toCenter">
    <h2>Welcome Mr./Mrs.<span class="name">${user}</span> </h2><br/>
</div>

<div id="bar">
    <form action="logout" >
        <input type="submit" value="Logout" class="button"/>
    </form>
</div>

<div id="shopping">
    <table id="tbl_products">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Image</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td><img src="<c:url value="${product.img}"/>"/></td>
            </tr>
        </c:forEach>
        </tbody>

        <fieldset>
            <div>
                <label for="id">Id</label> <input type="text" name="id" id="product_id"
                                                  readonly="readonly" placeholder="Id" />
            </div>
            <div>
                <label for="name">Name</label> <input type="text" name="name" id="product_name"
                                                      placeholder="Name" />
            </div>
            <div>
                <label for="price">Price</label> <input type="text" name="price" id="product_price"
                                                        placeholder="Price" />
            </div>

            <div>
                <input id="btn_add" type="submit" value="Submit" />
            </div>
        </fieldset>
    </table>
</div>




</body>
</html>
