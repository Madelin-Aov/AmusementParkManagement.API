# Amusement Park Management - API

Esta API permite gestionar la venta de entradas para los juegos ofrecidos en el parque. 
Se pueden crear y administrar entidades como la de clientes, empleados, juegos, tickets, ventas.

## Endpoints
### Compradores
- **'GET /buyer/getAll'**: Obtiene la lista de todos los vendedores registrados en el sistema.
- **'POST /buyer/create'**: Crea un nuevo vendedor en el sistema.
- **'PUT /buyer/{id}'**: Actualiza los detalles de un vendedor específico por su ID.
- **'DELETE /buyer/{id}'**: Elimina un vendedor específico por su ID.

### Empleados
- **'GET /employee/getAll'**: Obtiene la lista de todos los empleados registrados en el sistema.
- **'POST /employee/create'**: Crea un nuevo empleado en el sistema.
- **'PUT /employee/{id}'**: Actualiza los detalles de un empleado específico por su ID.
- **'DELETE /employee/{id}'**: Elimina un empleado específico por su ID.

### Juegos
- **'GET /game/getAll'**: Obtiene la lista de todos los juegos registrados en el sistema.
- **'POST /game/create'**: Crea un nuevo juego en el sistema.
- **'PUT /game/{id}'**: Actualiza los detalles de un juego específico por su ID.
- **'DELETE /game/{id}'**: Elimina un juego específico por su ID.

### Tickets
- **'GET /ticket/getAll'**: Obtiene la lista de todos los tickets registrados en el sistema.
- **'POST /ticket/create'**: Crea un nuevo ticket en el sistema.
- **'PUT /ticket/{id}'**: Actualiza los detalles de un ticket específico por su ID.
- **'DELETE /ticket/{id}'**: Elimina un ticket específico por su ID.


### Usuario
- **'GET /user/getAll'**: Obtiene la lista de todos los usuarios registrados en el sistema.
- **'POST /user/create'**: Crea un nuevo usuario en el sistema.
- **'PUT /user/{id}'**: Actualiza los detalles de un usuario específico por su ID.
- **'DELETE /user/{id}'**: Elimina un usuario específico por su ID.


