---
title: "Business Logic: Crear SaleService transaccional"
status: "open"
priority: "medium"
projects: ["[[MiTienda Java Web]]"]
contexts: ["business-logic"]
phase: "Business Logic"
executionOrder: 39
timeEstimate: 90
---

## Objetivo
Confirmar compras de forma atomica.

## Criterio de completado
- [ ] Valida stock disponible.
- [ ] Crea venta y detalle en una transaccion.
- [ ] Descuenta stock en la misma transaccion.
- [ ] Hace rollback si falla.
