(function () {
  console.log('Panel MiTienda cargado correctamente.');

  document.querySelectorAll('form').forEach(function (form) {
    form.addEventListener('submit', function (e) {
      e.preventDefault();
    });
  });

  document.querySelectorAll('.btn[type="submit"]').forEach(function (btn) {
    btn.addEventListener('click', function (e) {
      e.preventDefault();
    });
  });
})();
