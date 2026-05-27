---
title: "Business Logic: Implementar login en AuthService"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["business-logic"]
phase: "Business Logic"
executionOrder: 12
timeEstimate: 75
---

## Objetivo
Validar credenciales sin exponer el hash de contrasena.

## Criterio de completado
- [ ] Busca usuario por login.
- [ ] Compara password con BCrypt.
- [ ] Devuelve resultado claro para credenciales invalidas.
