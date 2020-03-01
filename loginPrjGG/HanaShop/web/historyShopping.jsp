<%-- 
    Document   : historyShopping
    Created on : Feb 27, 2020, 11:56:58 PM
    Author     : Haima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="headerHistory.jsp" %>
    <body>
        <c:if test="${not empty requestScope.LISTHISTORY}">
             <c:set var="list" value="${requestScope.LISTHISTORY}"></c:set>
        </c:if>
          <c:if test="${not empty requestScope.LISTSEARCH}">
             <c:set var="list" value="${requestScope.LISTSEARCH}"></c:set>
        </c:if>
         
        
        <div class="post-form">
            <h1 align="center">   HISTORY SHOPPING   </h1>
            <c:if test="${empty requestScope.LISTSEARCH}">
                <font color="red"> Không có food nào </font>
        </c:if>
                <table class="table table-striped" >
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>ItemID</th>
                            <th>Food Name</th>
                            <th>Quantity</th>
                            <th>Order Date</th>

                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="dto" items="${list}" varStatus="counter">

                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.itemID}</td>
                            <td>${dto.foodName}</td>
                            <td>${dto.quantity}</td>
                            <td> ${dto.orderDate}</td>

                        </tr>

                    </c:forEach>
                </tbody>
            </table>


        </div>

    </body>
</html>
