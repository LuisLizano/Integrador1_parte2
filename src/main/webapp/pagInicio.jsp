<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans&display=swap" rel="stylesheet">       
        <link href="Css/index.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-bootstrap-4/bootstrap-4.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Validar">
            <div class="container">
                <h1>Sistema de Biblioteca</h1>
                <label class="label">
                    <input type="text" placeholder=" " class="input" name="usuario">
                    <span class="label__name">Ingresa tu usuario</span>
                </label>
                <label class="label">
                    <input type="password" placeholder=" " class="input" id="password" name="contraseña">
                    <span class="label__name">Ingresa tu contraseña</span>
                    <span class="toggle-password" onclick="togglePassword('password')">👁️</span>
                </label>
                <div class="buttons">
                    <button class="btn" name="opc" value="1">Ingresar</button>
                    <button class="btn" name="opc" value="2">Crear cuenta</button>
                </div>
            </div>
        </form>

        <script src="Javascript/script.js"></script>
    </body>
</html>
