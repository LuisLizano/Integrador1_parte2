function togglePassword(id) {
    const passwordInput = document.getElementById(id);
    if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
    } else {
        passwordInput.type = 'password';
    }
}

function showRequirements() {
    const requirements = document.getElementById('password-requirements');
    requirements.style.display = 'block';
}

function hideRequirements() {
    const requirements = document.getElementById('password-requirements');
    requirements.style.display = 'none';
}


function alerta() {
    // Validación de campos vacíos y contraseña
    var inputs = document.querySelectorAll('.input');
    var passwordInput = document.querySelector('input[name="password"]');
    var passwordSpan = passwordInput.nextElementSibling;

    // Validación campos vacíos y cambiar color de span
    var camposVacios = false;
    inputs.forEach(function(input) {
        var spanLabel = input.nextElementSibling;
        if (input.value.trim() === '') {
            spanLabel.style.color = 'red';
            camposVacios = true;
        } else {
            spanLabel.style.color = ''; // Reestablecer color por defecto si el campo no está vacío
        }
    });

    // Validación de la contraseña
    var passwordValue = passwordInput.value;
    var hasLength = passwordValue.length >= 6;
    var hasUpperCase = /[A-Z]/.test(passwordValue);
    var hasNumber = /\d/.test(passwordValue);

    if (!hasLength || !hasUpperCase || !hasNumber) {
        passwordSpan.style.color = 'red';
    } else {
        passwordSpan.style.color = ''; // Reestablecer color por defecto si la contraseña cumple los requisitos
    }

    // Mostrar mensaje de éxito si todos los campos están llenos y la contraseña cumple los requisitos
    if (!camposVacios && hasLength && hasUpperCase && hasNumber) {
        Swal.fire({
            title: 'Buen trabajo',
            text: 'Haz click en el botón',
            icon: 'success',
            confirmButtonText: 'Listo'
        });
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Algunos campos no están llenos correctamente'           
        });
    }
}
    
    

