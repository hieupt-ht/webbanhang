<%-- 
    Document   : thanhtoan
    Created on : Jun 2, 2025, 4:09:04 PM
    Author     : ThankPad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        document.getElementById("payment-result").innerHTML = "<p>Đang xử lý thanh toán...</p>";

        setTimeout(function() {
            var success = Math.random() < 0.8; // Xác suất 80% thành công
            if (success) {
                document.getElementById("payment-result").innerHTML = "<p style='color:green;'>Thanh toán thành công!</p>";
            } else {
                document.getElementById("payment-result").innerHTML = "<p style='color:red;'>Thanh toán thất bại. Vui lòng thử lại.</p>";
            }
        }, 2000);
    });
</script>
