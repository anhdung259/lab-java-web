<%-- 
    Document   : cart
    Created on : Feb 26, 2020, 10:04:59 PM
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
        <script>
            function ConfirmDelete()
            {
                var x = confirm("Are you sure you want to delete?");
                if (x)
                    return true;
                else
                    return false;
            }
        </script>
    <body>
        <div class="col-sm-9">
             <c:set var="cart" value="${sessionScope.CART}"/>
             <c:if test="${empty cart}">
                 Cart is empty!!!
             </c:if>
                  <c:if test="${not empty cart}">
                
            
            <table id="cart" class="table table-hover table-condensed">
                   <font color="green"> ${requestScope.OKE} </font>
                 <font color="red"> ${requestScope.FAIL} </font>
                <thead>
                    <tr>
                        <th style="width:50%">Food or Drink</th>
                        <th style="width:10%">Price</th>
                        <th style="width:8%">Quantity</th>
                        <th style="width:22%" class="text-center">Subtotal</th>
                        <th style="width:10%"></th>
                    </tr>
                </thead>
                   <c:forEach var="dto" items="${cart.items}">
                <tbody>
                    
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-4 hidden-xs"><img src="${dto.value.image}" alt="..." class="img-responsive"/></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin">${dto.value.foodName}</h4>
                                   
                                </div>
                            </div>
                        </td>
                        <td data-th="Price">${dto.value.price}đ</td>
                <form action="updateCart" method="POST">
                        <td data-th="Quantity">
                            <input type="number" name="txtQuantity" class="form-control text-center" value="${dto.value.quantity}">
                        </td>
                        <td data-th="Subtotal" class="text-center">${dto.value.price * dto.value.quantity}đ</td>
                        <td class="actions" data-th>
                            
                          
                                <input type="hidden" name="txtFoodID" value="${dto.key}" />
                                <input type="submit" class="btn btn-success" name="action" value="update">
                       
                        </td>
                </form>
                        <td class="actions" data-th>
                               <form action="removeCart" method="POST">
                                   <input type="hidden" name="txtFoodID" value="${dto.key}" />
                                   <input type="submit" class="btn btn-warning" onclick="ConfirmDelete()" name="action" value="Delete">
                            </form>
                            
                        </td>
                    </tr>
                </tbody
                   </c:forEach>
                <tfoot>
                  
                    <tr>
                        <td><a href="load" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                        <td colspan="2" class="hidden-xs"></td>
                        <td class="hidden-xs text-center"><strong>Total ${sessionScope.Total}đ</strong></td>
                        <td>
                            <form action="buy" method="Post">
                           
                            <input type="submit" class="btn btn-success btn-info" name="action" value="Checkout">
                            
                        </form>
                        
                        </td>
                    </tr>
                </tfoot>
            </table>
          
        </div>
                         </c:if>
    </body>
</html>
