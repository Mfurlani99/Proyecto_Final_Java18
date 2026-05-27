---
title: "Controllers: Crear LoginServlet"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["controllers"]
phase: "Controllers"
executionOrder: 15
timeEstimate: 75
---

## Objetivo
Crear sesion HTTP despues de login correcto.

## Criterio de completado
- [ ] Lee parametros del login.
- [ ] Llama a `AuthService`.
- [ ] Guarda usuario autenticado en `HttpSession`.
- [ ] Redirige a productos si funciona.
