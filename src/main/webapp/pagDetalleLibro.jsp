
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/pagDetalleLibro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Detalle del Libro</h1>

            <form id="detailForm">
                <div class="left">
                    <img id="detailImagePreview" src="" alt="Imagen del Libro">
                    <label for="detailImage">Seleccionar Imagen:</label>
                    <input type="file" id="detailImage" name="detailImage" accept="image/*">
                </div>
                <div class="right">
                    <label for="detailTitle">Título:</label>
                    <input type="text" id="detailTitle" name="detailTitle" required>

                    <label for="detailAuthor">Autor:</label>
                    <input type="text" id="detailAuthor" name="detailAuthor" required>

                    <label for="detailCategories">Categorías:</label>
                    <input type="text" id="detailCategories" name="detailCategories" required>

                    <label for="detailType">Tipo:</label>
                    <input type="text" id="detailType" name="detailType" required>

                    <label for="detailStock" id="detailStockLabel">Stock:</label>
                    <input type="number" id="detailStock" name="detailStock" min="0">

                    <label for="detailDescription">Descripción:</label>
                    <textarea id="detailDescription" name="detailDescription" rows="4"></textarea>

                    <div class="button-container">
                        <button type="button" id="backButton">Regresar</button>
                        <button type="submit">Guardar Cambios</button>
                    </div>
                </div>
            </form>
        </div>

        <script src="scripts.js"></script>
        <script>
            document.getElementById('detailImage').addEventListener('change', function () {
                var reader = new FileReader();

                reader.onload = function (e) {
                    document.getElementById('detailImagePreview').setAttribute('src', e.target.result);
                }

                reader.readAsDataURL(this.files[0]);
            });
        </script>
    </body>
</html>
