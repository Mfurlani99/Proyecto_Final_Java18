---
title: "DAO: Implementar UserDao basico"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["dao"]
phase: "DAO"
executionOrder: 7
timeEstimate: 90
---

## Objetivo
Implementar persistencia minima de usuarios.

## Criterio de completado
- [ ] `create(User user)` inserta usuarios.
- [ ] La busqueda por login devuelve un `User`.
- [ ] Se usa `PreparedStatement`.
