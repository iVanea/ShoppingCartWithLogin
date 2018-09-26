<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>Login Form</title>
    <style>
        #loginform{
            width: 500px;
            margin:auto;
            text-align: center;
        }
        .button {
            background-color: #4CAF50; /* Green */
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

        #warning{
            color: red;
            font-weight: bold;
            font-size:16px;
        }

        .login {width: 50%;}
    </style>
</head>
<body>
   <form action="login" method="post" id="loginform" class="login">
       Username   <input type="text" name="username" value="${cookie.user.value}"/> <br/>
       Password  <input type="password" name="password"/> <br/>
   <input type="submit" value="Login" class="button"/> <br/>
       Remember me <input type="checkbox"    <c:if test="${cookie.containsKey('user')}">checked </c:if>  name="remember" value="yes"/>
   </form>

   <span id="warning"> ${error} </span>

</body>
</html>
