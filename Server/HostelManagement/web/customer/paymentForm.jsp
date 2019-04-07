<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <link href="../css/first.css" rel="stylesheet"/>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                $('#pay').click(function () {
                    mode = $('#mode').val()
                    amt = $('#amt').val()
                    bid = $('#bid').val()
                    v = {
                        'mode': mode, 'amt': amt,'bid' : bid
                    }
                    $.post('payment.jsp', v, function (dt) {
                        $('#err').text(dt)
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="login">
            <%
                String bid = request.getParameter("bid");

            %>
            <h3>Payment</h3>
            <input type="hidden" id="bid" value="<%=bid%>"/>
            <select id="mode">
                <option>Online</option>
                <option>Cash</option>
            </select>
            <input type="text" name="amt" id="amt" placeholder="Amount"/>
            <input type="button" value="Pay" id="pay"/>
            <h3 id="err"></h3>
            <a href="viewPayment.jsp?bid=<%=bid%>">Back</a>
            <br>
             <a href="../customer/viewHostels.jsp" class="button_login">Logout</a>
        </div>
    </body>
</html>
