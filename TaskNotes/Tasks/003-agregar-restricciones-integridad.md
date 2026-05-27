---
title: "Database: Agregar restricciones de integridad"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["database"]
phase: "Database"
executionOrder: 3
timeEstimate: 75
---

## Objetivo
Agregar restricciones para proteger datos importantes desde la base de datos.

## Criterio de completado
- [ ] El campo de login tiene `UNIQUE`.
- [ ] Precio y stock no pueden ser negativos.
- [ ] La cantidad de carrito no puede ser menor a 1.
