---
title: "DAO: Crear ConnectionFactory"
status: "open"
priority: "high"
projects: ["[[MiTienda Java Web]]"]
contexts: ["dao"]
phase: "DAO"
executionOrder: 5
timeEstimate: 60
---

## Objetivo
Reemplazar la conexion singleton por una fabrica de conexiones JDBC.

## Criterio de completado
- [ ] Existe `ConnectionFactory`.
- [ ] Lee `database.properties`.
- [ ] Devuelve una conexion nueva por operacion.
