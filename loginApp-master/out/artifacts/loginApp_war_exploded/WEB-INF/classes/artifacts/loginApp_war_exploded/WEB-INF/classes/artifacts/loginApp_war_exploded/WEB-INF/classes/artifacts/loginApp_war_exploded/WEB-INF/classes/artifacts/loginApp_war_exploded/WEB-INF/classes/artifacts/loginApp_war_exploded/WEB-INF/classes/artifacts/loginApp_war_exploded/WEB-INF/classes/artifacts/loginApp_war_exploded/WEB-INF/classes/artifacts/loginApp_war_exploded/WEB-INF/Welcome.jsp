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


        .logout {width: 50%;}
    </style>
</head>
<body>
<div id="toCenter">
    <h2>Welcome <span class="name">${user}</span> </h2><br/>

<form action="logout" >
    <input type="submit" value="Logout" class="button"/>
</form>
</div>

</body>
</html>
