
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/pagGestionLibros.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="container">
        <h1>Gestión de Libros</h1>
        
        <input type="text" id="searchInput" placeholder="Buscar por título...">

        <form id="addBookForm">
            <h2>Añadir Libro</h2>
            <label for="bookTitle">Título:</label>
            <input type="text" id="bookTitle" name="bookTitle" required>
            
            <label for="bookAuthor">Autor:</label>
            <input type="text" id="bookAuthor" name="bookAuthor" required>
            
            <label for="bookCategories">Categorías:</label>
            <div class="custom-select">
                <select id="bookCategories" name="bookCategories" multiple required>
                    <option value="Ficción">Ficción</option>
                    <option value="No Ficción">No Ficción</option>
                    <option value="Ciencia">Ciencia</option>
                    <option value="Tecnología">Tecnología</option>
                    <!-- Agregar más categorías según sea necesario -->
                </select>
            </div>
            
            <label for="bookType">Tipo:</label>
            <select id="bookType" name="bookType" required>
                <option value="Físico">Físico</option>
                <option value="Digital">Digital</option>
            </select>
            
            <label for="bookStock" id="stockLabel">Stock:</label>
            <input type="number" id="bookStock" name="bookStock" min="0">
            
            <label for="bookDescription">Descripción:</label>
            <textarea id="bookDescription" name="bookDescription" rows="4"></textarea>
            
            <label for="bookImage">Imagen Referencial:</label>
            <input type="file" id="bookImage" name="bookImage" accept="image/*">
            
            <button type="submit">Añadir Libro</button>
        </form>
        
        <table id="booksTable">
            <thead>
                <tr>
                    <th>Imagen</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Categorías</th>
                    <th>Tipo</th>
                    <th>Stock</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Aquí irán los libros -->
            </tbody>
        </table>
    </div>

    <script src="scripts.js"></script>
</body>
</html>
