<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: quans
  Date: 9/29/21
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded navbar-padding-0 mt-2" style="height: 50px" aria-label="Eleventh navbar example">
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="https://getbootstrap.com/" target="_blank">
                        <img src="/img/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Bootstrap
                    </a>
                </div>
            </nav>

            <div class="collapse navbar-collapse" id="navbarsExample09">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                </ul>
                <form action="/orders" method="post">
                    <div class="row mt-2">
                        <div class="col">
                            <select name="filter" class="form-select form-select-sm mb-3 mt-3" style="width: 250px; height: 37px" aria-label=".form-select-lg example">
                                <option selected>Search By</option>
                                <option value="bigger">Total payment bigger than</option>
                                <option value="smaller">Total payment smaller than</option>
                                <option value="3">Year</option>
                                <option value="3">Month</option>
                                <option value="3">Id</option>
                            </select>
                        </div>
                        <div class="col">
                            <input class="form-control mt-3 " style="size: 200px" type="text" placeholder="Search" aria-label="Search" name="q">
                        </div>
                        <div class="col">
                            <button type="submit" class="btn btn-outline-primary mt-3">Search</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </nav>
    <div class="row mt-3" style="min-height: 80%">
        <div class="col-2" >
            <div class="card" style="min-height: 100%">
                <div class="position-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home" aria-hidden="true"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                                Dashboard
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/dashboard">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file" aria-hidden="true"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                Orders
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                Products
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customers">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users" aria-hidden="true"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                                Customers
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/orders">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2" aria-hidden="true"><line x1="18" y1="20" x2="18" y2="10"></line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
                                Orders
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employees">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers" aria-hidden="true"><polygon points="12 2 2 7 12 12 22 7 12 2"></polygon><polyline points="2 17 12 22 22 17"></polyline><polyline points="2 12 12 17 22 12"></polyline></svg>
                                Employee
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-10">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col">
                            <h5 class="mt-2">Order Management</h5>
                        </div>

                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <tr>
                            <th>#Id</th>
                            <th>Order Date</th>
                            <th>Customer</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Total Payment</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${orderList}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td><fmt:formatDate value="${order.createdDate}" pattern="yyyy-MM-dd" /></td>
                                <td>${order.consignee}</td>
                                <td>${order.phone}</td>
                                <td>${order.addressOrder}</td>
                                <td><fmt:formatNumber type="number" maxFractionDigits = "0"  value="${totalPayment.get(order.id)}"/> </td>
                                <c:choose>
                                    <c:when test="${order.status == true}">
                                        <td>Shipped</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>Processing</td>
                                    </c:otherwise>
                                </c:choose>

                                <td>
                                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop${order.id}">
                                        Details
                                    </button>
                                    <button type="button" class="btn btn-warning btn-sm">
                                        <a style="color: white" href="/orders?action=edit&id=${order.id}">Edit</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
                <div class="card-footer">
                    <nav aria-label="Search results pages">
                        <ul class="pagination">
                            <li class="page-item ${pre}">
                                <a class="page-link" href="/orders?page=${selectedPage-1}" tabindex="-1">Previous</a>
                            </li>
                            <c:forEach var="i" begin="1" end="${totalPage}" step="1">
                                <c:choose>
                                    <c:when test="${i == selectedPage}">
                                        <li class="page-item active">
                                            <a class="page-link" href="/orders?page=${i}">${i}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a class="page-link" href="/orders?page=${i}">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>

                            </c:forEach>
                            <li class="page-item ${next}">
                                <a class="page-link" href="/orders?page=${selectedPage+1}">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <c:forEach items="${orderList}" var="order">
            <div class="modal fade" id="staticBackdrop${order.id}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel${order.id}">Order #${order.id} Details</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <table class="table table-striped">
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Price sell Actual</th>
                                    <th>Payment</th>
                                </tr>
                                <c:forEach items="${orderDetailList}" var="orderDetail">
                                    <c:if test="${order.id == orderDetail.orderId}">
                                        <tr>
                                            <td>${orderDetail.productName}</td>
                                            <td>${orderDetail.quantity}</td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits = "0"  value="${orderDetail.price}"/> </td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits = "0"  value="${orderDetail.saleOff}"/> </td>
                                            <td><fmt:formatNumber type="number" maxFractionDigits = "0"  value="${orderDetail.total}"/> </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                <tr>
                                    <th colspan="4">Tổng</th>
                                    <td><fmt:formatNumber type="number" maxFractionDigits = "0"  value="${totalPayment.get(order.id)}"/> </td>
                                </tr>
                            </table>
                            <p>Order note: ${order.note}</p>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <footer class="d-flex flex-wrap justify-content-between align-items-center py-2 my-3 border-top">
        <p class="col-md-4 mb-0 text-muted">© 2021 Company, Inc</p>

        <ul class="nav col-md-4 justify-content-end">
            <li class="nav-item"><a href="/user" class="nav-link px-2 text-muted">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
        </ul>
    </footer><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</div>
</body>
</html>
