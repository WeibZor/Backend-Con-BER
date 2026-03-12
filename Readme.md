🛴 City Scooter

Sistema de gestión de scooters eléctricos compartidos desarrollado con Spring Boot.
El proyecto permite administrar usuarios, scooters disponibles, viajes y pagos dentro de una plataforma de movilidad urbana.

Este repositorio forma parte de un proyecto académico enfocado en el análisis, diseño e implementación de un sistema basado en dominio.

📌 Objetivos

Identificar los procesos principales del sistema City Scooter.

Definir requerimientos funcionales y no funcionales.

Diseñar el diagrama de clases del sistema.

Crear la estructura del proyecto basada en Spring Boot.

Implementar POJOs y entidades del dominio según el modelo.

Establecer roles dentro del equipo (Líder Técnico y Scrum Master).

Utilizar herramientas de gestión de proyecto (JIRA, ClickUp o Trello).

Elaborar historias de usuario para el desarrollo ágil del sistema.

⚙️ Tecnologías utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

Maven

PostgreSQL / MySQL

Mermaid / PlantUML para diagramas

📂 Estructura del proyecto
city-scooter
│
├── src
│   └── main
│       └── java
│           └── com.cityscooter
│               ├── domain
│               │   ├── model
│               │   ├── repository
│               │   └── service
│               │
│               ├── application
│               │
│               ├── infrastructure
│               │
│               └── CityScooterApplication.java
│
├── docs
│   ├── diagrama_clases.md
│   ├── requisitos.md
│   └── historias_usuario.md
│
└── README.md
🚀 Funcionalidades principales

Registro y gestión de usuarios

Administración de scooters

Inicio y finalización de viajes

Gestión de estaciones o zonas

Sistema de pagos y tarifas

Monitoreo del estado de scooters

🔄 Flujo del sistema

Un usuario se registra en la plataforma.

Busca un scooter disponible cercano.

Escanea el código del scooter para iniciar el viaje.

El sistema registra duración y recorrido.

Se calcula el costo del viaje.

El usuario finaliza el viaje y realiza el pago.

📊 Documentación

La documentación del proyecto se encuentra en la carpeta docs:

docs/diagrama_clases.md → Diagrama de clases del sistema

docs/requisitos.md → Requerimientos funcionales y no funcionales

docs/historias_usuario.md → Historias de usuario

🧑‍💻 Metodología de trabajo

El proyecto se desarrolla utilizando metodologías ágiles.

Se recomienda:

Uso de Git Flow

Gestión de tareas con JIRA, ClickUp o Trello

Revisión de código mediante Pull Requests

👥 Equipo de desarrollo

Equipo City Scooter

Iván Molina

Juanes Garcés

Andrés Pacheco

Franklin Chaverra

Maicol Montoya

📚 Notas

El proyecto está desarrollado con Spring Boot siguiendo buenas prácticas de arquitectura.

Los diagramas se documentan utilizando Mermaid o PlantUML.

El enfoque principal es el diseño del dominio y la implementación de entidades del sistema.
