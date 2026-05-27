---
title: "Business Logic: Alinear User y passwordHash"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["business-logic"]
phase: "Business Logic"
executionOrder: 9
timeEstimate: 45
---

## Objetivo
Evitar que la entidad persistida represente contrasenas en texto plano.

## Criterio de completado
- [ ] `User` usa `passwordHash`.
- [ ] No hay campo `password` plano en la entidad persistida.
