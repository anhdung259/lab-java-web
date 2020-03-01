<%-- 
    Document   : shoplist
    Created on : Feb 22, 2020, 8:22:55 PM
    Author     : Haima
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <c:if test="${not empty requestScope.LIST}">
            <c:set var="list" value="${requestScope.LIST}"/>
            <c:set var="link" value="load?page="/>
        </c:if>
        <c:if test="${not empty requestScope.LISTSEARCH}">
            <c:set var="list" value="${requestScope.LISTSEARCH}"/>
            <c:set var="link" value="search?txtSearch=${param.txtSearch}&txtPriceF=${param.txtPriceF}&txtPriceT=${param.txtPriceT}&cbCagtegory=${param.cbCagtegory}&action=Search&page="/>
        </c:if>
       

        <div class="col-sm-9">
            <c:if test="${empty requestScope.LISTSEARCH && empty requestScope.LIST}">
        Không tìm được food nào
    </c:if>
            <c:forEach var="dto" items="${list}">
                <div class="col-sm-3">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="${dto.image}" alt="" />
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">
                                ${dto.foodName}</h4>
                            <p class="group inner list-group-item-text">
                                ${dto.description}</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead">
                                        ${dto.price}đ</p>
                                </div>


                                <div class="col-xs-12 col-md-6">
                                    <form action="addToCart" method="POST">
                                        <input type="hidden" name="txtFoodID" value="${dto.foodID}" >
                                        <input type="hidden" name="txtFoodName" value="${dto.foodName}" >
                                        <input type="hidden" name="txtImage" value="${dto.image}" >
                                        <input type="hidden" name="txtPrice" value="${dto.price}" >
                                        <input type="submit" class="btn btn-success" value="Add to cart" >                                   
                                    </form>
                                </div>                 

                                <div></div>
                            </div>
                        </div>
                    </div>
                </div>


            </c:forEach>
            <c:if test="${currentPage != 1}">
                <td><a href="${link}${currentPage - 1}">Previous</a></td>
            </c:if>
            <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <td>${i}</td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="${link}${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                </tr>
            </table>
            <c:if test="${currentPage lt noOfPages}">
                <td><a href="${link}${currentPage + 1}">Next</a></td>
            </c:if>
        </div>
    </div>
</div>
</div>
</div>

</body>
</html>
