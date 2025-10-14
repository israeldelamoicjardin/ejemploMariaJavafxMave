# 📦 Proyecto Base Maven + MariaDB

Este repositorio contiene un **proyecto base en Java** que utiliza **Maven** como gestor de dependencias y se conecta a una base de datos **MariaDB**.

El objetivo principal es mostrar cómo cargar información desde MariaDB y mostrarla en un `TableView`. Incluye dos modos de carga de datos:

* 🔄 **Sincrónica**
* ⚡ **Asíncrona**

---

## ✅ Decálogo de Buena Construcción

Este proyecto sigue las 10 buenas prácticas recomendadas para un desarrollo limpio y profesional:

1. ✅ **Funciona**
2. 📝 **Documentado**
3. 📦 **Gestionado por Maven**
4. 🔄 **Control de versiones (SCV)**
5. 📁 **Empaquetado como `.jar` ejecutable**
6. 🧾 **Sistema de logging implementado**
7. 🗂️ **Estructura de carpetas conforme a estándares Maven**
8. 🖥️ **UI responsiva (no se aplasta)**
9. 🌐 **Soporte multi-idioma**
10. 🔐 **Sin credenciales públicas en el código**

---

## 🆔 Funcionalidad Principal

Este ejemplo **gestiona un solo DNI** (Documento Nacional de Identidad). El foco está en cómo estructurar un proyecto robusto más que en la funcionalidad extensa.

---

## 🛠️ Preparación del Entorno

Antes de ejecutar el proyecto, asegúrate de crear la base de datos en tu instancia de **MySQL/MariaDB** utilizando el script SQL incluido:

```bash
# Archivo SQL: estructura.sql (o el nombre que tenga tu script)
```

Este script crea la estructura necesaria para que el proyecto funcione correctamente.

---

## 🚀 Cómo Ejecutar

1. Clona el repositorio.
2. Importa el proyecto en tu IDE favorito (por ejemplo IntelliJ IDEA o Eclipse).
3. Asegúrate de tener MariaDB corriendo y configurado correctamente.
4. Ejecuta el proyecto desde la clase principal o genera el `.jar` ejecutable con Maven:

```bash
mvn clean package
java -jar .demoMARIADB-1.0-SNAPSHOT.jar

También se puede ejecutar dando doble click sobre el archivo si tenemos Oracle JDK instalado.
```

---

## 🧰 Tecnologías Usadas

* Java
* Maven
* MariaDB / MySQL
* JDBC
* JavaFX (para interfaz con TableView)
* SLF4J / Logback (para logging)

---

## 🔒 Seguridad

* El proyecto **no expone credenciales sensibles**.
* Recomendado utilizar un archivo de configuración externo o variables de entorno para gestionar accesos a base de datos en producción.

---

## 📄 Licencia

Este proyecto se distribuye bajo licencia [MIT](LICENSE).

---
