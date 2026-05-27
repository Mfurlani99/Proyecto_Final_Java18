---
title: "DAO: Crear DataAccessException"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["dao"]
phase: "DAO"
executionOrder: 6
timeEstimate: 30
---

## Objetivo
Centralizar errores de persistencia sin exponer detalles JDBC a capas superiores.

## Criterio de completado
- [ ] Existe `DataAccessException`.
- [ ] Los DAOs pueden usarla para envolver `SQLException`.
