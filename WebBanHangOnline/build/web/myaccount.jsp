<%-- 
    Document   : myaccount
    Created on : Apr 20, 2025, 2:49:33 PM
    Author     : ThankPad
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Coron-my account</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets\img\favicon.png">
		
		<!-- all css here -->
       <link rel="stylesheet" href="assets\css\bootstrap.min.css">
        <link rel="stylesheet" href="assets\css\plugin.css">
        <link rel="stylesheet" href="assets\css\bundle.css">
        <link rel="stylesheet" href="assets\css\style.css">
        <link rel="stylesheet" href="assets\css\responsive.css">
        <script src="assets\js\vendor\modernizr-2.8.3.min.js"></script>
    </head>
    <body>
            <!-- Add your site or application content here -->
            
            <!--pos page start-->
            <div class="pos_page">
                <div class="container">  
                    <!--pos page inner-->
                    <div class="pos_page_inner">  
                       <!--header area -->
                       <jsp:include page="header.jsp"></jsp:include> 
                        <!--header end -->
                        
                         <!--breadcrumbs area start-->
                        <div class="breadcrumbs_area">
                            <div class="row">
                                <div class="col-12">
                                    <div class="breadcrumb_content">
                                        <ul>
                                            <li><a href="index.html">home</a></li>
                                            <li><i class="fa fa-angle-right"></i></li>
                                            <li>my account</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->

                        <!-- Start Maincontent  -->
                        <section class="main_content_area">
                                <div class="account_dashboard">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-3 col-lg-3">
                                            <!-- Nav tabs -->
                                            <div class="dashboard_tab_button">
                                                <ul role="tablist" class="nav flex-column dashboard-list">
                                                    <li><a href="#dashboard" data-toggle="tab" class="nav-link active">Dashboard</a></li>
                                                    <li><a href="#orders" data-toggle="tab" class="nav-link">Orders</a></li>               
                                                    <li><a href="#address" data-toggle="tab" class="nav-link">Addresses</a></li>
                                                    <li><a href="#account-details" data-toggle="tab" class="nav-link">Account details</a></li>
                                                    <li><a href="logout" class="nav-link">logout</a></li>
                                                </ul>
                                            </div>    
                                        </div>
                                        <div class="col-sm-12 col-md-9 col-lg-9">
                                            <!-- Tab panes -->
                                            <div class="tab-content dashboard_content">
                                                <div class="tab-pane fade show active" id="dashboard">
                                                    <h3>Dashboard </h3>
                                                    <p>From your account dashboard. you can easily check &amp; view your <a href="#">recent orders</a>, manage your <a href="#">shipping and billing addresses</a> and <a href="#">Edit your password and account details.</a></p>
                                                </div>
                                                <div class="tab-pane fade" id="orders">
                                                    <h3>Orders</h3>
                                                    <div class="coron_table table-responsive">
                                                        <table class="table">
                                                            <thead>
                                                                <tr>
                                                                    <th>MÃ ĐƠN HÀNG</th>
                                                                    <th>TÊN KHÁCH HÀNG</th>
                                                                    <th>NGÀY TẠO ĐƠN HÀNG</th>
                                                                    <th>THÀNH TIỀN</th>
                                                                    <th>TRẠNG THÁI</th>
                                                                    <th>CHI TIẾT</th>
                                                                    <th>HỦY</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:forEach var="dh" items="${listdh}">                                                      
                                                                <tr>
                                                                    <td>${dh.maDH}</td>
                                                                    <td>${dh.tenKH}</td>
                                                                    <td>${dh.ngayTaoDH}</td>
                                                                    <td>$${dh.tongTien}</td>
                                                                    <td>${dh.trangThai}</td>
                                                                    <td><a href="#" class="view-order-detail" data-id="${dh.maDH}">View</a></td>
                                                                    <c:if test="${dh.trangThai != 'Đã thanh toán'}">
                                                                        <td><a href="removeDonHang?idDH=${dh.maDH}"><i class="fa fa-trash-o"></i></a></td>
                                                                    </c:if>
                                                                </tr>
                                                            </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                               
                                                <div class="tab-pane" id="address">
                                                   <p>Địa chỉ này sẽ được sử dụng mặc định khi thanh toán.</p>
                                                    <h4 class="billing-address">Địa chỉ thanh toán</h4>
                                                    
                                                    <p><strong>Địa chỉ</strong></p>
                                                   <address>
                                                    <%
                                                        // Lấy địa chỉ từ request attribute
                                                        String diaChi = (String) request.getAttribute("diaChiKH");
                                                        if (diaChi != null && !diaChi.isEmpty()) {
                                                            // Có thể cần format lại chuỗi địa chỉ nếu nó chỉ là 1 dòng
                                                            // Ví dụ đơn giản chỉ in ra
                                                            out.println(diaChi);
                                                        } else {
                                                            out.println("Chưa có thông tin địa chỉ.");
                                                        }
                                                    %>
                                                </address>
                                                     
                                                </div>
                                                <div class="tab-pane fade" id="account-details">
                                                <h3>Account details</h3>
                                                <div class="login">
                                                    <div class="login_form_container">
                                                        <div class="account_login_form">
                                                            <form action="MyAccountControl" method="POST">
                                                                <p>Already have an account? <a href="#">Log in instead!</a></p>
                                                                <label>Họ và tên</label>
                                                                <input type="text" name="hoTen" value="${requestScope.hoTen}"> <!-- Điền giá trị cũ nếu cần -->
                                                                <label>Số điện thoại</label>
                                                                <input type="text" name="soDienThoai" value="${requestScope.soDienThoai}">
                                                                <label>Giới tính</label>
                                                                <input type="text" name="gioitinh" value="${requestScope.gioitinh}">
                                                                <label>Địa chỉ</label>
                                                                <input type="text" name="diaChi" value="${requestScope.diaChi}">
                                                                <label>Mật khẩu mới</label>
                                                                <input type="password" name="matKhauMoi">
                                                                <br>
                                                                <span class="custom_checkbox">
                                                                    <input type="checkbox" value="1" name="optin">
                                                                    <label>Receive offers from our partners</label>
                                                                </span>
                                                                <br>
                                                                <span class="custom_checkbox">
                                                                    <input type="checkbox" value="1" name="newsletter">
                                                                    <label>Sign up for our newsletter<br><em>You may unsubscribe at any moment. For that purpose, please find our contact info in the legal notice.</em></label>
                                                                </span>
                                                                <div class="save_button primary_btn default_button">
                                                                    <button type="submit">Save</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>      	
                        </section>			
                        <!-- End Maincontent  --> 
                    </div>
                    <!--pos page inner end-->
                </div>
            </div>
            <!--pos page end-->
            
            <!--footer area start-->
            <jsp:include page = "footer.jsp"></jsp:include>
            <!--footer area end-->
            
            
            <div class="modal fade" id="order_detail_modal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="modal_body">
                            <div class="container">
                                <h2>Chi Tiết Đơn Hàng</h2>
                                <table class="table table-bordered" id="modal_product_table">
                                    <thead>
                                        <tr>
                                            <th>Mã đơn hàng</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Kích thước</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Dữ liệu sẽ được cập nhật bởi JavaScript -->
                                    </tbody>
                                </table>
                                <div class="text-center mt-3">
                                    <button id="pay-now-btn" class="btn btn-success">Thanh toán ngay</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            
      
		
		<!-- all js here -->
        <script src="assets\js\vendor\jquery-1.12.0.min.js"></script>
        <script src="assets\js\popper.js"></script>
        <script src="assets\js\bootstrap.min.js"></script>
        <script src="assets\js\ajax-mail.js"></script>
        <script src="assets\js\plugins.js"></script>
        <script src="assets\js\main.js"></script>
    </body>
</html>

<script> 
$(document).ready(function() {
    $('.view-order-detail').on('click', function(e) {
        e.preventDefault();
        var idOrder = $(this).data('id');
        console.log('ID Đơn Hàng:', idOrder);

        $.ajax({
            url: 'OrderDetailServlet',
            type: 'GET',
            data: { idOrder: idOrder },
            dataType: 'json',
            success: function(data) {
                console.log('Dữ liệu nhận được:', data);

                if (data.error) {
                    alert('Lỗi: ' + data.error);
                    return;
                }

                // Xóa dữ liệu cũ
                $('#modal_product_table tbody').html('');

                // Kiểm tra nếu danh sách rỗng
                if (!data.listCTDH || data.listCTDH.length === 0) {
                    $('#modal_product_table tbody').html('<tr><td colspan="5">Không có sản phẩm nào trong đơn hàng này.</td></tr>');
                } else {
                    var tableRows = '';
                    data.listCTDH.forEach(function(ct) {
                        tableRows += '<tr>' +
                            '<td>' + ct.maDH + '</td>' +
                            '<td>' + ct.tenSP + '</td>' +
                            '<td>$' + ct.donGia + '</td>' +
                            '<td>' + ct.soLuong + '</td>' +
                            '<td>' + ct.size + '</td>' +
                        '</tr>';
                    });

                    $('#modal_product_table tbody').html(tableRows);
                }

                // Hiển thị modal
                $('#order_detail_modal').modal('show');

                // Gán sự kiện cho nút thanh toán
                $('#pay-now-btn').off('click').on('click', function() {
                    window.location.href = 'thanhtoan.jsp?idOrder=' + idOrder;
                });
            },
            error: function(xhr, status, error) {
                console.log('Lỗi AJAX:', status, error);
                alert('Không thể tải thông tin đơn hàng.');
            }
        });
    });
});
</script>