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
<img width="505" height="336" alt="image" src="https://github.com/user-attachments/assets/c0372742-71ac-4894-8437-f67b6e8e63f6" />




2. Menú Principal  
<img width="981" height="735" alt="Captura de pantalla 2025-07-22 134027" src="https://github.com/user-attachments/assets/c954339b-3409-4efa-9657-8b3e1b234b43" />

3. Formulario de Reserva  
<img width="976" height="732" alt="Captura de pantalla 2025-07-22 134127" src="https://github.com/user-attachments/assets/abc356b5-7994-4479-ab74-e90443693b74" />



4. Tabla de Habitaciones  
<img width="975" height="748" alt="Captura de pantalla 2025-07-22 134040" src="https://github.com/user-attachments/assets/c116a9a5-4a34-406b-96d2-37bbd5dba479" />

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
