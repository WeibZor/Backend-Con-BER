# Gestión de Talento Humano

Este repositorio contiene un prototipo de software para un sistema de **Gestión de Talento Humano** construido con arquitectura hexagonal.

## Objetivos del proyecto
- Centralizar los datos de procesos de RH que actualmente se encuentran dispersos.
- Reducir el tiempo de ejecución de los flujos críticos (registro de aspirantes, selección, formación, contratación, nómina, retención y evaluación del desempeño).

## Estructura del proyecto

```
gestion-talento-humano/
├─ pom.xml
├─ README.md
├─ src/
│  └─ main/
│     └─ java/
│        └─ com/gestiontalentohumano/
│           ├─ domain/              # entidades y modelos (POJOs)
│           ├─ application/         # servicio de aplicación y puertos
│           │  ├─ ports/
│           │  └─ services/
│           └─ infrastructure/      # adaptadores (repositorios, APIs, etc.)
```

Dentro de `domain` se encuentran las clases generadas a partir del diagrama de clases (Persona, Aspirante, Empleado, Seleccion, Formacion, Contratacion, Nomina, Retencion, EvaluacionDesempenio) y las relaciones de herencia, asociación y dependencia entre ellas.

## Procesos identificados y clases relacionadas
1. **Registro de aspirantes (reclutamiento)** – `Aspirante`.
2. **Selección** – `Seleccion` asocia un `Aspirante` y evalúa su estado.
3. **Formación** – `Formacion` ligado a `Empleado`.
4. **Contratación** – `Contratacion` enlaza `Aspirante` y `Empleado`.
5. **Nómina** – `Nomina` asociado a `Empleado`.
6. **Retención (SST)** – `Retencion` ligado a `Empleado`.
7. **Evaluación del desempeño** – `EvaluacionDesempenio` asociado a `Empleado`.

Las relaciones de herencia se usan para que `Aspirante` y `Empleado` extiendan `Persona`. Las asociaciones son explícitas en los constructores.

## Requerimientos funcionales (ejemplo)
1. El sistema debe permitir registrar aspirantes con información básica.
2. El sistema debe gestionar el ciclo de selección y almacenar el estado de cada aspirante.
3. Debe generar un empleado al contratar un aspirante aprobado.
4. Debe calcular y almacenar registros de nómina por empleado.
5. Registrar formaciones, evaluaciones, y controles de SST asociados a empleados.
6. Proveer APIs o puertos para que la interfaz de usuario interactúe con la aplicación.

## Requerimientos no funcionales
- Seguridad: autenticación y autorización en futuras versiones.
- Rendimiento: tiempos de respuesta < 2s para operaciones CRUD básicas.
- Disponibilidad: 99,5% uptime planificado.
- Escalabilidad: diseño modular y desacoplado (hexagonal) para fácil extensión.

## Líder técnico y Scrum Master
- **Líder técnico:** Nombre del líder (por ejemplo, `Carlos Pérez`).
- **Scrum Master:** Nombre del scrum master (por ejemplo, `María Gómez`).

> Nota: estos roles se anotan en documentación del proyecto o en la herramienta de gestión de tareas.

## Herramientas de seguimiento (recomendado)
Se sugiere utilizar **JIRA**, **ClickUp** o **Trello** para la gestión ágil de tareas. Un tablero puede contener columnas como "Backlog", "En progreso", "Revisión" y "Hecho".

## Historias de usuario (muestra)
- *Como reclutador* quiero registrar nuevos aspirantes para tener un catálogo central.
- *Como gerente de selección* necesito ver el estado de cada aspirante para tomar decisiones.
- *Como analista de nómina* deseo generar el registro de pago de un empleado para cumplir con períodos.
- *Como empleado* quiero revisar mi historial de evaluaciones de desempeño.
- *Como administrador* requerido visualizar reportes de retención y formación.

> Historias de usuario de frontend: los usuarios interactúan mediante formularios web; por ejemplo, un formulario para cargar datos de aspirantes o empleado.

## Diagrama de clases (texto simplificado)
```
Persona
├─ Aspirante
└─ Empleado

Seleccion *--- Aspirante
Contratacion *--- Aspirante, Empleado
Formacion *--- Empleado
Nomina *--- Empleado
Retencion *--- Empleado
EvaluacionDesempenio *--- Empleado
```

*(el primer asterisco indica asociación)*

## Mapas de proceso
Se ha utilizado el modelo de diagnóstico de ARH mostrado en el enunciado como guía para identificar los flujos.

## Ramas de Git
La entrega debe seguir la estrategia de ramas (ej. `main`, `develop`, `feature/...`). Consultar con el profesor Juan Jo para vistas y revisiones.

---

Este README servirá como base inicial; la lógica de negocio se irá complementando y los requerimientos ampliando a medida que avanza el cliente real.