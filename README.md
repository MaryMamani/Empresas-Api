<a name="readme-top"></a>
<br />
<div align="center">
  <h1 align="center">Empresas Api</h1>

  <p align="center">
    Evaluacion programador Java, Api de empresas
  </p>
</div>


<details>
  <summary>Tabla de contenido</summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre el proyecto</a>
      <ul>
        <li><a href="#built-with">Construido con</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Despliegue</a>
      <ul>
        <li><a href="#prerequisites">Pre requisitos</a></li>
        <li><a href="#installation">Instalación</a></li>
      </ul>
    </li>
    <li>
       <a href="#usage">Uso</a>
       <ul>
        <li><a href="#backend-services">Backend</a></li>
        <li><a href="#documentation">Documentación Swagger</a></li>
        <li><a href="#urls-api">URL's y solicitudes disponibles</a></li>
       </ul>
    </li>
  </ol>
</details>


## Sobre el Proyecto

Este proyecto es una Api de empresas.

<p align="right">(<a href="#readme-top">ir al inicio</a>)</p>



### Construido con:

* [![Spring][Spring]][Spring-url]
* [![Java][Java]][Java-url]

<p align="right">(<a href="#readme-top">ir al inicio</a>)</p>

## Despliegue

### Pre requisitos:

* Java JDK 17+

### Instalación:


1. Clonar el repositorio
   ```sh
   git clone https://github.com/MaryMamani/empresas-api.git
   ```
2. Instalar paquetes de Maven en backend
   ```sh
   cd backend-app
   mvn clean install -U
   ```

## Uso

### Backend Service:

1. Iniciar el servicio de back-end
   ```sh
   cd backend-app
   mvn spring-boot:run
   ```

### Documentación y prueba de endpoints en Swagger:

1. Después de ejecutar backend, siga este enlace:
   ```sh
   http://localhost:8090/swagger-ui/index.html
   ```
2. Haz clic en el botón "Authorize" en la parte superior derecha de la página de Swagger.
3. Ingresa las credenciales en los campos correspondientes para autenticarte.
   ```sh
   Admin:
   - Username: mary
   - Password: password
   
   User:
   - Username: invitado
   - Password: password
   ```

### URL's y solicitudes disponibles en la API:

Registrar una empresa
```sh
URL: /api/v1/empresas
Método: POST
Descripción: Esta solicitud permite crear una nueva empresa en el sistema.
Permisos requeridos: Admin (administrador).
```
Obtener los ultimos 3 registros de la empresa
```sh
URL: /api/v1/empresas/ultimos-registros
Método: GET
Descripción: Esta solicitud permite obtener los ultimos registros, por default trae los ultimos 3, pero se puede cambiar la cantidad de los ultimos registros que se quiere obtener.
Permisos requeridos: User (usuario normal) o Admin (administrador).
```
Obtener todos los registros
```sh
URL: /api/v1/empresas
Método: GET
Descripción: Esta solicitud permite obtener todas la empresas registradas.
Permisos requeridos: User (usuario normal) o Admin (administrador).
```
<p align="right">(<a href="#readme-top">ir al inicio</a>)</p>

[Spring]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[Java-url]: https://www.java.com/en/
