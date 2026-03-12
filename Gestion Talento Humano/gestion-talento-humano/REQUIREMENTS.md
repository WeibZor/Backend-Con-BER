# Requerimientos del Sistema

## Requerimientos Funcionales
1. El sistema permitirá registrar aspirantes con datos personales y puesto deseado.
2. Debe mantener un catálogo de aspirantes y permitir consultar su estado de selección.
3. Debe registrar evaluaciones de selección y almacenar comentarios.
4. Deberá generar registros de contratación vinculando aspirantes con empleados.
5. Generar y almacenar nómina por empleado para períodos definidos.
6. Registrar formaciones realizadas por empleados y las competencias adquiridas.
7. Registrar evaluaciones de desempeño con puntuaciones y observaciones.
8. Mantener registros de retención y SST asociados a empleados.
9. Proveer puertos para que interfaces externas (web, móviles) interactúen con la lógica.

## Requerimientos No Funcionales
- **Seguridad:** control de acceso y cifrado de datos sensibles.
- **Rendimiento:** operaciones CRUD deben responder en menos de 2 segundos.
- **Disponibilidad:** 99,5% uptime planificado, con respaldo diario de información.
- **Escalabilidad:** arquitectura modular que permita agregar nuevos procesos sin cambios masivos.
- **Mantenibilidad:** código documentado y pruebas unitarias.
- **Compatibilidad:** debe correr en Java 17+, usando Maven como gestor de dependencias.
