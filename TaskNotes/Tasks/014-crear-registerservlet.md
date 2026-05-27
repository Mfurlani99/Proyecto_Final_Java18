---
title: "Controllers: Crear RegisterServlet"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["controllers"]
phase: "Controllers"
executionOrder: 14
timeEstimate: 75
---

## Objetivo
Conectar el formulario de registro con `UserService`.

## Criterio de completado
- [ ] Lee parametros del request.
- [ ] Construye `RegisterUserDto`.
- [ ] Redirige a login si el registro funciona.
- [ ] Muestra error si falla.
