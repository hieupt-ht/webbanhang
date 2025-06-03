<%-- 
    Document   : thanhtoan
    Created on : Jun 2, 2025, 4:09:04 PM
    Author     : ThankPad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay Page</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f9; /* Màu nền nhạt */
                display: flex;
                justify-content: center; /* Căn giữa theo chiều ngang */
                align-items: center; /* Căn giữa theo chiều dọc */
                min-height: 100vh; /* Chiều cao tối thiểu full màn hình */
                margin: 0;
                padding: 20px;
            }

            #fake-payment-form {
                background-color: #ffffff; /* Nền trắng cho form */
                padding: 30px;
                border-radius: 10px; /* Bo góc */
                box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Hiệu ứng bóng nhẹ */
                width: 100%;
                max-width: 400px; /* Chiều rộng tối đa */
            }

            label {
                display: block;
                font-size: 14px;
                font-weight: 600; /* Chữ đậm */
                color: #333; /* Màu chữ tối */
                margin-bottom: 8px; /* Khoảng cách dưới nhãn */
            }

            input[type="text"] {
                width: 100%;
                padding: 12px; /* Khoảng cách bên trong */
                margin-bottom: 20px; /* Khoảng cách giữa các input */
                border: 1px solid #
            }
        </style>
    </head>
    <body>
        <form id="fake-payment-form">
            <label>Số thẻ tín dụng:</label>
            <input type="text" name="cardNumber" required>

            <label>Tên chủ thẻ:</label>
            <input type="text" name="cardHolder" required>

            <label>Ngày hết hạn:</label>
            <input type="text" name="expiryDate" required>

            <label>CVC:</label>
            <input type="text" name="cvc" required>

            <button type="submit">Thanh toán</button>
        </form>
        <div id="payment-result"></div>
        
    
    </body>
    
    
</html>

<script>
    document.getElementById("fake-payment-form").addEventListener("submit", function(e) {
        e.preventDefault();

        const cardNumber = document.querySelector('input[name="cardNumber"]').value;
        const paymentResult = document.getElementById("payment-result");

        // Check if card number is exactly 12 digits
        if (!/^\d{12}$/.test(cardNumber)) {
            paymentResult.innerHTML = "<p style='color:red;'>Số thẻ tín dụng phải gồm đúng 12 chữ số.</p>";
            return;
        }

        paymentResult.innerHTML = "<p>Đang xử lý thanh toán...</p>";

        setTimeout(function() {
                paymentResult.innerHTML = "<p style='color:green;'>Thanh toán thành công!</p>";
        }, 2000);
    });
</script>