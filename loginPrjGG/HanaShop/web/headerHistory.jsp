<!DOCTYPE html>
<html lang="vn">
    <head>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <title>HANA SHOP</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function() { $( ".datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' }); });        </script>
        <style>
            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */

            /* Set gray background color and 100% height */
            .sidenav {
                background-color: #f7f7f7;
                height: 100%;
            }
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }

            /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
            .row.content {height: 2000px}

            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }

            /* Set black background color, white text and some padding */
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }
            .post-form {
                width: 500px;
                margin: 60px auto;
            }
            .post-form form {
                margin-bottom: 20px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }  
            .table>tbody>tr>td, .table>tfoot>tr>td{
                vertical-align: middle;
            }
            <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
            <script src="//code.jquery.com/jquery-1.10.2.js"></script>
            <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
            <link rel="stylesheet" href="/resources/demos/style.css">
            <script>
            $(function() {
                $( "#datepicker" ).datepicker();
            });
            </script>
            @media screen and (max-width: 600px) {
                table#cart tbody td .form-control{
                    width:40%;
                    display: inline !important;
                }
                .actions .btn{
                    width:45%;
                    margin:1.5em 0;
                }

                .actions .btn-info{
                    float:left;
                }
                .actions .btn-danger{
                    float:right;
                }

                table#cart thead { display: none; }
                table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
                table#cart tbody tr td:first-child { background: #333; color: #fff; }
                table#cart tbody td:before {
                    content: attr(data-th); font-weight: bold;
                    display: inline-block; width: 20rem;



                }
                table#cart tfoot td{display:block; }
                table#cart tfoot td .btn{display:block;}
                /* On small screens, set height to 'auto' for the grid */
                @media screen and (max-width: 767px) {
                    .row.content {height: auto;} 
                }
            </style>
        </head>
        <body>

            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                        </button>
                        <a class="navbar-brand" href="#">HANA SHOP</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li><a href="load">Home</a></li>
                                <c:if test="${sessionScope.ROLE eq 'user'}">
                                <li  class="active"><a href="history">History shopping</a></li>                       
                                </c:if>
                                <c:if test="${sessionScope.ROLE eq 'admin' }">
                                <li><a href="categoryload">Create Food</a></li>
                                <li><a href="#"></a></li>
                                <li><a href="#"></a></li>  
                                </c:if>

                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <c:if test="${sessionScope.ROLE eq 'user'}">
                                <li><a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> </a></li>
                                </c:if>
                                <c:if test="${sessionScope.ROLE eq 'user' || sessionScope.ROLE eq 'admin'}">

                                <li><a href="Logout">    <font color="white"> Welcome,${sessionScope.NAME} </font> <span class="glyphicon glyphicon-log-out"></span> Logout</a></li>  

                            </c:if>

                            <c:if test="${sessionScope.ROLE ne 'user' && sessionScope.ROLE ne 'admin'}">
                                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                                </c:if>


                        </ul>
                    </div>
                </div>
            </nav>
            <div class="container-fluid">

                <div class="row content">
                    <div class="col-sm-2 sidenav hidden-xs">
                        <ul class="nav nav-pills nav-stacked">

                            <form action="searchHistory" method="GET">

                                <input type="text" class="form-control" name="txtSearch" placeholder="Name of Food" value="${param.txtSearch}" />                          
                                 
                                History Date: <input type="text" name="txtDate" class="datepicker"></p>                       


                                <input type="submit" class="btn btn-success" value="Search History" name="action" />
                            </form>


                        </ul><br>
                    </div>  
                    <br>

