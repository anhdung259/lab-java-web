<%-- 
    Document   : detail
    Created on : Feb 24, 2020, 6:27:46 PM
    Author     : Haima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="headerNew.jsp" %>
    <body> 
        <div class="post-form">
            <font color="green">${requestScope.DONE} </font>
            <font color="red">${requestScope.WRONG} </font>
            <h1 align="center">UPDATE FOOD</h1>
            <c:set var="dto" value="${requestScope.DETAIL}"/>
            <form action="update" method="POST">
                Food & Drink'name:  <input type="text" name="txtName" class="form-control" value="${dto.foodName}" /> <br/>
                Description: <input type="text" name="txtDescription" class="form-control" value="${dto.description}" /><br/>
                <c:set var="listcate" value="${requestScope.LISTCATE}"/>                                 
                Category Food : <select class="form-control" name ="txtCategory"> 
                    <c:forEach var="dtoCate" items="${listcate}">

                        <option>${dtoCate.categoryName}</option>

                    </c:forEach>
                    <option selected> ${requestScope.NAMECATE} </option>

                </select>
                Status : <select class="form-control" name ="txtStatus"> 

                    <option>${dtoCate.categoryName}</option>
                    <option>Active</option>
                    <option>Inactive</option>
                    <option selected> ${dto.status} </option>

                </select>

                Price: <input type="text" name="txtPrice" pattern="[0-9.]+" title="Price is number" class="form-control" value="${dto.price}" /> <br/>
                Quantity: <input type="text" name="txtQuantity" pattern="[0-9]+" title="Quantity is number" class="form-control" value="${dto.quantity}" /> <br/>
                <img src="${dto.image}"> </br>
                <input type="hidden" class="form-control" name="foodID" value="${dto.foodID}">
                <input type="hidden" class="form-control" name="txtImage" value="${dto.image}">
                <input type="file" class="form-control-file border" name="txtImages" accept="image/x-png,image/gif,image/jpeg" value="${dto.image}"> </br>
        
                <div align="center">
                    <input type="submit" class="btn btn-success" value="Update" name="action" />
                </div>
            </form>
        </div>

    </body>
</html>
