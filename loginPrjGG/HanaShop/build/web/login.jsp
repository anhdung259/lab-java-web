<%-- 
    Document   : login
    Created on : Jan 8, 2020, 1:25:56 AM
    Author     : Haima
--%>
<%@ page contentType="text/html;encoding=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <title>HanaShop</title>
    </head>
    <%@include file="headerNew.jsp" %>
    <body>

        <div class="post-form">
            <font color="green">${requestScope.OK} </font>
            <h1 align="center">Login Page</h1>

            <form action="login" method="POST">
                Username:   <input type="text" name="txtUsername" class="form-control" value="${param.txtUsername}" /> <br/>
                Password:   <input type="password" name="txtPassword" class="form-control" value="" /> <br/>
                <div align="center">  <input type="submit" value="Login" class="btn btn-success" name="action" /> </br>
                    <font color="red"> ${requestScope.FAIL} </font>
                </div>
                <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
                <script>
                    function onSignIn(googleUser) {
                        // Useful data for your client-side scripts:
                        var profile = googleUser.getBasicProfile();
                        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
                        console.log('Full Name: ' + profile.getName());
                        console.log('Given Name: ' + profile.getGivenName());
                        console.log('Family Name: ' + profile.getFamilyName());
                        console.log("Image URL: " + profile.getImageUrl());
                        console.log("Email: " + profile.getEmail());
                        window.location.href='login?name='+profile.getName()+'&email='+profile.getEmail()+'&id='+profile.getId()+'&role=user&action=Google';
                        // The ID token you need to pass to your backend:
                        var id_token = googleUser.getAuthResponse().id_token;
                        console.log("ID Token: " + id_token);
                    }
                </script>
            </form>

            <p align="center"> Do you have account?<a href="register.jsp">Register here</a> </p>
        </div>
    </body>
</html>
