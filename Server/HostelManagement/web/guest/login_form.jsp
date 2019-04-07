<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="../css/first.css" rel="stylesheet"/>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                $('#log').click(function () {
                    un = $('#username').val()
                    pw = $('#psd').val()
                    v = {
                        'username': un, 'psd': pw
                    }
                    $.post('login.jsp', v, function (dt) {
                        dt = dt.trim()
                        if (dt === '3')
                            $('#err').text('Deactivated ?\n contact admin !')
                        else if (dt === '2')
                            location.href = '../customer/home.jsp'
                        else
                            $('#err').text('Not a valid user!')
                    });
                });
            });
        </script>
        <style>
            .login{
                position: absolute;
                left: 50%; top: 50%;
                transform: translate(-50%,-50%);
            }
        </style>
    </head>
    <body>
        <div class="login">
            <h3><b>LOGIN</b></h3>
            <input type="text" name="username" id ="username" placeholder="User Name"/>
            <input type="password" name="psd" id="psd" placeholder="Password"/>
            <input type="button" value="Login" id="log"/>
            <h3 id="err"></h3>
            <h4>
                New User ?  Sign up from Menu.
            </h4>
        </div>
    </body>
</html>
