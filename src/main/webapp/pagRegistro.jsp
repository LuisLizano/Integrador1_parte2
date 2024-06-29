<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrarse</title>
        <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans&display=swap" rel="stylesheet">
        <link href="Css/registro.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <form action="controlCliente">
            <div class="container">
                <h1>Registrarse</h1>
                <label class="label">
                    <input type="text" placeholder=" " class="input" name="nombres">
                    <span class="label__name">Nombres</span>
                </label>
                <div class="half-inputs">
                    <label class="label">
                        <input type="text" placeholder=" " class="input" name="apellidoP">
                        <span class="label__name">Apellido Paterno</span>
                    </label>
                    <label class="label">
                        <input type="text" placeholder=" " class="input" name="apellidoM">
                        <span class="label__name">Apellido Materno</span>
                    </label>
                </div>
                <div class="half-inputs">
                    <label class="label half-width">
                        <input type="dni" pattern="[0-9]*" placeholder=" " class="input" name="dni" maxlength="8">
                        <span class="label__name">Dni</span>
                    </label>
                    <label class="label half-width">
                        <input type="tel" pattern="[0-9]*" placeholder=" " class="input" name="telefono" maxlength="9">
                        <span class="label__name">Teléfono</span>
                    </label>    
                    <label class="label half-width">
                        <input type="number" placeholder=" " class="input" name="edad" maxlength="2" min="1">
                        <span class="label__name">Edad</span>
                    </label>
                </div>
                <label class="label">
                    <input type="text" placeholder=" " class="input" name="usuario">
                    <span class="label__name">Ingresa tu usuario</span>
                    <div class="error-message" id="error-usuario"></div>
                </label>
                <label class="label">
                    <input type="password" placeholder=" " class="input" id="password" name="contraseña">
                    <span class="label__name">Ingresa tu contraseña</span>
                    <span class="toggle-password" onclick="togglePassword('password')">👁️</span>
                    <span class="info-icon" onmouseover="showRequirements()" onmouseout="hideRequirements()">ℹ️</span>
                    <div class="requirements" id="password-requirements">
                        <p>La contraseña debe contener:</p>
                        <ul>
                            <li id="length" class="invalid">Al menos 6 caracteres</li>
                            <li id="uppercase" class="invalid">Al menos una letra mayúscula</li>
                            <li id="number" class="invalid">Al menos un número</li>
                        </ul>
                    </div>
                </label>
                <div class="buttons">
                    <button class="btn green" onclick="alerta()" name="opc" value="1">Registrarse</button>
                    <a href="pagInicio.jsp" class="btn gray">Regresar</a>
                </div>
            </div> 
        </form>

        <script src="Javascript/script.js"></script>
    </body>
</html>