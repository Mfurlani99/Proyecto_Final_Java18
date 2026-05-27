---
title: "Business Logic: Implementar registro en UserService"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["business-logic"]
phase: "Business Logic"
executionOrder: 11
timeEstimate: 90
---

## Objetivo
Crear el flujo de registro con validaciones y BCrypt.

## Criterio de completado
- [ ] Valida campos obligatorios.
- [ ] Valida formato basico de email.
- [ ] Impide emails duplicados.
- [ ] Guarda `passwordHash` con BCrypt.
