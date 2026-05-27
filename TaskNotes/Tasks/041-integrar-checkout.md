---
title: "Integration: Integrar checkout y verificar stock"
status: "open"
priority: "medium"
projects: ["[[MiTienda Java Web]]"]
contexts: ["integration"]
phase: "Integration"
executionOrder: 41
timeEstimate: 90
---

## Objetivo
Probar compra real desde navegador.

## Criterio de completado
- [ ] Venta exitosa crea filas en `ventas`.
- [ ] Venta exitosa crea filas en `detalle_venta`.
- [ ] El stock baja correctamente.
- [ ] Venta sin stock suficiente falla sin cambios parciales.
