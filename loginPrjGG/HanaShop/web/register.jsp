<%-- 
    Document   : register
    Created on : Jan 7, 2020, 10:41:56 PM
    Author     : Haima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Blog</title>
    </head>
    <%@include file="headerNew.jsp" %>
    <body>
           <div class="post-form">
        <h1 align="center">Register page</h1>
        <form action="register" method="POST">
            Username: <input type="text"  class="form-control"name="txtUsername" pattern="[a-zA-Z0-9]{4-20}}" value="${param.txtUsername}" title="Username is 5-10 char" required/><font color="red"> ${requestScope.DUP}</font>  <br/>
            Password:  <input name="txtPassword" type="password" class="form-control" pattern="\w{5,20}" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 5-20 characters' : '');
                    if (this.checkValidity())
                        form.txtPasswordConfirm.pattern = this.value;" required> <br/>
            Password Confirm:<input  class="form-control" name="txtPasswordConfirm" type="password" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');"  required><br/>
            Full Name: <input type="text" name="txtName" class="form-control" value="${param.txtName}" required/> <br/>
            <div align="center">
            <input type="submit" name="action" value="Register" />
            <input type="reset" value="Reset" />
           </div>
        </form>
           </div>
    </body>
</html>


