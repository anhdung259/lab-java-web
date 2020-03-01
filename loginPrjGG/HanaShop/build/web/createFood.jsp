<%-- 
    Document   : createFood
    Created on : Feb 24, 2020, 12:26:16 PM
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
            <font color="green">${requestScope.OK} </font>
            <h1 align="center">CREATE CATEGORY</h1
            <font color="green">${requestScope.DONE} </font>
            <form action="newCategory" method="POST">
                Category Name:  <input type="text" name="txtNewCategory" class="form-control" value="${param.txtCategory}" /> <font color="red">${requestScope.FAILCATE} </font>
                <div align="center">
                    <input type="submit" class="btn btn-success" value="Create Category" name="action" />
                </div>
            </form>



            <h1 align="center">CREATE FOOD</h1>

            <form action="createnew" method="POST">
                Food & Drink'name:  <input type="text" name="txtName" class="form-control" value="${param.txtNname}"  required=""/> <br/>
                Description: <input type="text" name="txtDescription" class="form-control" value="${param.txtDescription}" required=""/><br/>
                <c:set var="listcate" value="${requestScope.LISTCATE}"/>                                 
                Category Food : <select class="form-control" name ="txtCategory"> 
                    <c:forEach var="dtoCate" items="${listcate}">
                        <option>${dtoCate.categoryName}</option>
                    </c:forEach>

                </select>

                Price: <input type="text" name="txtPrice" pattern="[0-9]+" title="Price is number" class="form-control" value="${dtoCate.txtPrice}" required=""/> <br/>
                Quantity: <input type="text" name="txtQuantity" pattern="[0-9]+" title="Quantity is number" class="form-control" value="${dtoCate.txtPrice}"required="" /> <br/>
                Image: <input type="file" name="txtImage"  class="form-control-file border" accept="image/x-png,image/gif,image/jpeg" value="${param.txtImage}"required=""/> 
                <img src="${param.txtImage}">
                <div align="center">
                    <input type="submit" class="btn btn-success" value="Create Food" name="action" />
                </div>
            </form>

            <font color="red">${requestScope.FAIL} </font> <br/>

        </div>

    </body>
</html>
