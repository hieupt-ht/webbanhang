<%-- 
    Document   : thanhtoan
    Created on : Jun 2, 2025, 4:09:04 PM
    Author     : ThankPad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Online Payment - Demo</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap');

            body {
                margin: 0;
                font-family: 'Montserrat', sans-serif;
                background: linear-gradient(135deg, #72edf2 10%, #5151e5 100%);
                min-height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 20px;
                color: #333;
            }

            .container {
                background: #fff;
                border-radius: 12px;
                box-shadow: 0 16px 40px rgba(0, 0, 0, 0.25);
                max-width: 480px;
                width: 100%;
                padding: 30px 40px;
            }

            h1 {
                margin-bottom: 1rem;
                font-weight: 600;
                text-align: center;
                color: #222;
            }

            .purchase-summary {
                border-bottom: 2px solid #eee;
                margin-bottom: 20px;
                padding-bottom: 20px;
            }

            .purchase-summary h2 {
                font-size: 1.25rem;
                margin-bottom: 10px;
                color: #444;
            }

            .purchase-item {
                display: flex;
                justify-content: space-between;
                margin-bottom: 8px;
                font-weight: 500;
                color: #555;
            }

            .purchase-total {
                font-weight: 700;
                font-size: 1.15rem;
                color: #111;
                margin-top: 12px;
                border-top: 1px solid #ccc;
                padding-top: 10px;
            }

            form {
                display: flex;
                flex-direction: column;
            }

            label {
                font-weight: 600;
                margin-bottom: 6px;
                margin-top: 14px;
                color: #333;
            }

            input[type="text"],
            input[type="email"],
            input[type="tel"],
            input[type="password"],
            input[type="number"] {
                padding: 12px 14px;
                border-radius: 8px;
                border: 1.8px solid #ddd;
                font-size: 1rem;
                transition: border-color 0.3s;
            }

            input[type="text"]:focus,
            input[type="email"]:focus,
            input[type="tel"]:focus,
            input[type="password"]:focus,
            input[type="number"]:focus {
                border-color: #5151e5;
                outline: none;
            }

            .flex-row {
                display: flex;
                gap: 16px;
            }

            .flex-grow {
                flex: 1;
            }

            .btn-pay {
                margin-top: 30px;
                background: #5151e5;
                border: none;
                color: white;
                padding: 14px 0;
                border-radius: 10px;
                font-weight: 700;
                font-size: 1.2rem;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .btn-pay:hover {
                background: #3a3abf;
            }

            .message {
                margin-top: 20px;
                padding: 12px;
                border-radius: 8px;
                font-weight: 600;
                text-align: center;
                display: none;
            }

            .message.success {
                background-color: #d4edda;
                color: #155724;
            }

            .message.error {
                background-color: #f8d7da;
                color: #721c24;
            }

            @media (max-width: 500px) {
                .container {
                    padding: 25px 20px;
                }
                .flex-row {
                    flex-direction: column;
                }
            }
        </style>
    </head>
    <body>
        <div class="container" role="main">
            <h1>Online Payment Demo</h1>

            <section class="purchase-summary" aria-label="Purchase summary">
                <h2>Purchase Summary</h2>
<!--                <div class="purchase-item">
                    <span>Awesome Gadget x1</span>
                    <span>$49.99</span>
                </div>
                <div class="purchase-item">
                    <span>Shipping</span>
                    <span>$5.00</span>
                </div>-->
                <div class="purchase-total">
                    Total: ${sessionScope.sum}
                </div>
            </section>

            <form id="paymentForm" novalidate aria-label="Payment form" action="paysanphamonline" method="post"> 
                <label for="cardName">Cardholder Name</label>
                <input type="text" id="cardName" name="cardName" placeholder="John Doe" required autocomplete="cc-name" />

                <label for="cardNumber">Card Number</label>
                <input
                    type="text"
                    id="cardNumber"
                    name="cardNumber"
                    placeholder="Black card"
                    maxlength="19"
                    inputmode="numeric"
                    autocomplete="cc-number"
                    required
                    aria-describedby="cardNumberHelp"
                    />
                <div id="cardNumberHelp" class="helper-text" style="font-size:0.9rem; color:#666; margin-top:2px;">
                    Nhập số thẻ bất kỳ (yêu cầu ít nhất 6 chữ số)
                </div>

                <div class="flex-row">
                    <div class="flex-grow">
                        <label for="expDate">Expiration Date (MM/YY)</label>
                        <input
                            type="text"
                            id="expDate"
                            name="expDate"
                            placeholder="MM/YY"
                            pattern="(0[1-9]|1[0-2])\/\d{2}"
                            maxlength="5"
                            required
                            autocomplete="cc-exp"
                            />
                    </div>
                    <div class="flex-grow" style="max-width:120px;">
                        <label for="cvc">CVC</label>
                        <input type="text" id="cvc" name="cvc" placeholder="123" maxlength="4" pattern="\d{3,4}" required autocomplete="cc-csc" />
                    </div>
                </div>

                <label for="email">Billing Email</label>
                <input type="email" id="email" name="email" placeholder="you@example.com" required autocomplete="email" />

                <label for="address">Billing Address</label>
                <input type="text" id="address" name="address" placeholder="123 Main St, City, Country" autocomplete="street-address" />

                <button type="submit" class="btn-pay">Pay Now</button>

                <div id="message" class="message" role="alert" aria-live="assertive"></div>
            </form>
        </div>

        <script>
            const form = document.getElementById('paymentForm');
            const messageBox = document.getElementById('message');
            const cardNumberInput = form.cardNumber;

            function clearMessage() {
                messageBox.style.display = 'none';
                messageBox.textContent = '';
                messageBox.className = 'message';
            }

            function showMessage(text, type = 'success') {
                messageBox.textContent = text;
                messageBox.className = 'message ' + (type === 'success' ? 'success' : 'error');
                messageBox.style.display = 'block';
            }

            // Format card number input as 4-digit blocks separated by spaces
            cardNumberInput.addEventListener('input', e => {
                let cursorPosition = cardNumberInput.selectionStart;
                // Get digits only
                let numbers = cardNumberInput.value.replace(/\D/g, '');
                // Limit max length to 19 digits
                if (numbers.length > 19) {
                    numbers = numbers.slice(0, 19);
                }
                // Insert spaces every 4 digits
                let formatted = '';
                for (let i = 0; i < numbers.length; i++) {
                    if (i > 0 && i % 4 === 0) {
                        formatted += ' ';
                        if (cursorPosition >= i + Math.floor(i / 4))
                            cursorPosition++;
                    }
                    formatted += numbers[i];
                }
                cardNumberInput.value = formatted;
                cardNumberInput.setSelectionRange(cursorPosition, cursorPosition);
            });

            form.addEventListener('submit', (e) => {
                e.preventDefault(); // chặn submit mặc định để validate

                clearMessage();

                const cardName = form.cardName.value.trim();
                const cardNumber = form.cardNumber.value.replace(/\s+/g, ''); // no spaces
                const expDate = form.expDate.value.trim();
                const cvc = form.cvc.value.trim();
                const email = form.email.value.trim();

                if (!cardName) {
                    showMessage('Please enter the cardholder name.', 'error');
                    form.cardName.focus();
                    return;
                }

                if (!/^\d{6,19}$/.test(cardNumber)) {
                    showMessage('Please enter a valid card number with at least 6 digits.', 'error');
                    form.cardNumber.focus();
                    return;
                }

                if (!/^(0[1-9]|1[0-2])\/\d{2}$/.test(expDate)) {
                    showMessage('Expiration date must be in MM/YY format.', 'error');
                    form.expDate.focus();
                    return;
                }

                const parts = expDate.split('/');
                const expMonth = parseInt(parts[0], 10);
                const expYear = 2000 + parseInt(parts[1], 10);
                const now = new Date();
                const exp = new Date(expYear, expMonth - 1, 1);
                if (exp < new Date(now.getFullYear(), now.getMonth(), 1)) {
                    showMessage('The card expiration date is in the past.', 'error');
                    form.expDate.focus();
                    return;
                }

                if (!/^\d{3,4}$/.test(cvc)) {
                    showMessage('Please enter a valid CVC code.', 'error');
                    form.cvc.focus();
                    return;
                }

                if (!email || !/\S+@\S+\.\S+/.test(email)) {
                    showMessage('Please enter a valid email address.', 'error');
                    form.email.focus();
                    return;
                }

                // Nếu đến đây là hợp lệ, submit form thật
                form.submit();
            });

        </script>
    </body>
</html>

