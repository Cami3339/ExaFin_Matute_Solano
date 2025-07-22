# Sistema de Gestión de Reservas de Hotel

## Integrantes
- Camila Matute (Vista/Controlador)
- Andres Solano (Modelo/Persistencia)

## Requisitos
- Java 11 o superior
- IDE compatible (NetBeans, IntelliJ, Eclipse)
- Librerías adicionales: Ninguna (opcionalmente SQLite, JCalendar)

## Instrucciones
1. Clonar el repositorio:  
   git clone https://github.com/AndresS505-star/ExaFin_Matute_Solano
2. Compilar y ejecutar desde IDE o consola:  
   javac -d bin src/**/*.java  
   java main.Main

## Capturas de Pantalla
1. Login  
![Login]("C:\Users\Usuario\Pictures\Screenshots\Captura de pantalla 2025-07-22 134141.png")

2. Menú Principal  
![Menú]("C:\Users\Usuario\Pictures\Screenshots\Captura de pantalla 2025-07-22 134127.png")

3. Formulario de Reserva  
![Reserva]("C:\Users\Usuario\Pictures\Screenshots\Captura de pantalla 2025-07-22 134040.png")

4. Tabla de Habitaciones  
![Habitaciones]("C:\Users\Usuario\Pictures\Screenshots\Captura de pantalla 2025-07-22 134027.png")

## Diagrama UML
![UML](/resources/diagramas/uml_hotel.png)

## Estructura del Proyecto
Sistema_Hotel_Matute_Solano/
├── src/
│ ├── controlador/ # Lógica de control e interacción
│ ├── modelos/ # Clases del dominio (Cliente, Reserva, etc.)
│ ├── util/ # Utilidades (manejo de archivos)
│ ├── vista/ # Interfaces gráficas
│ └── main/ # Clase principal del sistema
└── resources/
├── screenshots/ # Capturas de pantalla
└── diagramas/ # Diagrama UML
