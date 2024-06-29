<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Biblioteca</title>
        <link href="Css/principal.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="Javascript/principalJs.js"></script>
    </head>
    <body>
        <style>
            .dropdown .btn {
                border: none;
                color: black;
            }

            .dropdown .btn:hover {
                background-color: #aaaaaa; 
            }

            .dropdown .dropdown-item:hover{
                background-color: red;
                cursor: pointer;
            }
        </style>
        <div class="sidebar-left">
            <h2><i class="fas fa-book"></i> Biblioteca</h2>
            <ul>                
                <li><a href="pagPerfil.jsp" target="main-iframe" onclick="collapseServices()"><i class="fas fa-user"></i>  Perfil</a></li>
                <li><a onclick="toggleServices()"><i class="fas fa-cogs"></i> Servicios</a>
                    <ul id="services-submenu" class="hidden">
                        <li><a href="pagPrestamos.jsp" target="main-iframe" onclick="collapseServices()"><i class="fas fa-book-open"></i> Préstamo</a></li>
                        <li><a href="pagReserva.jsp" target="main-iframe" onclick="collapseServices()"><i class="fas fa-calendar-check"></i>  Reserva</a></li>
                    </ul>
                </li>
                <li><a href="#" target="main-iframe" onclick="collapseServices()"><i class="fas fa-exclamation-triangle"></i> Penalizaciones</a></li>
            </ul>
        </div>
        <div class="main-content">
            <div class="user-bar">
                <p>Bienvenido al sistema</p>
                <div class="dropdown">
                    <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Usuario Ingresado
                    </button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item-user" >Luis Alessandro</a>
                        <a class="dropdown-item">Salir</a>
                    </div>
                </div>
            </div>
            <iframe id="main-iframe" name="main-iframe" src="" frameborder="0"></iframe>
        </div>

    </body>
</html>
