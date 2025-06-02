<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán b?ng QR Code</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }
        #qr-code { margin: 20px auto; }
        #payment-result { margin-top: 20px; }
        input, button { margin: 10px; padding: 10px; font-size: 16px; }
    </style>
</head>
<body>
    <h2>Thanh toán b?ng QR Code</h2>
    <form id="payment-form">
        <label>S? ti?n:</label>
        <input type="number" id="amount" name="amount" required min="1">
        <button type="submit">T?o mã QR</button>
    </form>
    <div id="qr-code"></div>
    <div id="payment-result"></div>

    <script>
        document.getElementById("payment-form").addEventListener("submit", function(e) {
            e.preventDefault();
            
            const amount = document.getElementById("amount").value;
            const paymentResult = document.getElementById("payment-result");
            const qrCodeDiv = document.getElementById("qr-code");
            
            if (amount <= 0) {
                paymentResult.innerHTML = "<p style='color:red;'>Vui lòng nh?p s? ti?n h?p l?.</p>";
                return;
            }

            // T?o d? li?u cho QR code (gi? l?p thông tin giao d?ch)
            const transactionData = {
                merchantId: "MERCHANT123",
                amount: amount,
                transactionId: "TX" + Date.now(),
                currency: "VND"
            };
            const qrData = JSON.stringify(transactionData);

            // Xóa mã QR c? (n?u có)
            qrCodeDiv.innerHTML = "";
            
            // T?o mã QR
            new QRCode(qrCodeDiv, {
                text: qrData,
                width: 200,
                height: 200
            });

            paymentResult.innerHTML = "<p>Quét mã QR ?? thanh toán " + amount + " VND</p>";

            // Gi? l?p ki?m tra tr?ng thái thanh toán sau khi quét
            setTimeout(function() {
                const success = Math.random() < 0.8; // Xác su?t thành công 80%
                if (success) {
                    paymentResult.innerHTML = "<p style='color:green;'>Thanh toán thành công!</p>";
                } else {
                    paymentResult.innerHTML = "<p style='color:red;'>Thanh toán th?t b?i. Vui lòng th? l?i.</p>";
                }
            }, 5000); // Gi? l?p th?i gian quét QR
        });
    </script>
</body>
</html>