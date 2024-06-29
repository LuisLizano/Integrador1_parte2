function toggleServices() {
    const submenu = document.getElementById('services-submenu');
    if (submenu.classList.contains('hidden')) {
        submenu.classList.remove('hidden');
    } else {
        submenu.classList.add('hidden');
    }
}

function collapseServices() {
    document.getElementById('services-submenu').classList.add('hidden');
}


