# Sistema de Gestión de Inventarios

Este proyecto tiene como objetivo desarrollar un sistema que permita gestionar el inventario de productos en una tienda o almacén. El programa permite al usuario registrar productos, consultar cantidades, actualizar inventario y eliminar productos, todo a través de un menú interactivo.

## Funcionalidades
- **Registro de productos:** El sistema permite agregar productos con ID, nombre, cantidad y precio.
- **Consulta de inventario:** El usuario puede consultar el inventario de productos.
- **Actualización de productos:** Permite actualizar la cantidad o el precio de los productos registrados.
- **Eliminación de productos:** Los usuarios pueden eliminar productos del inventario.
- **Cálculo del valor total del inventario:** Calcula el valor total del inventario en función de las cantidades y precios.
- **Validación de datos:** Asegura que no se ingresen productos duplicados.

## Estructura del Proyecto
- **src/**: Contiene el código fuente del proyecto.
- **lib/**: Librerías externas necesarias para el funcionamiento del sistema.
- **resources/**: Archivos adicionales, como configuraciones o bases de datos.
- **docs/**: Documentación relacionada con el proyecto.

## Estructura de Clases
### Clase `com.mycompany.proyectofinal.Producto`
- **Atributos:** `id`, `nombre`, `cantidad`, `precio`.
- **Métodos:** Constructor, getters y setters.

### Clase `com.mycompany.proyectofinal.Inventario`
- **Atributo:** `ArrayList<com.mycompany.proyectofinal.Producto>`.
- **Métodos:** `agregarProducto`, `consultarInventario`, `eliminarProducto`, `calcularValorTotal`.

## Requisitos Previos
1. Tener instalado [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versión 8 o superior).
2. Un IDE compatible con Java, como [Eclipse](https://www.eclipse.org/) o [IntelliJ IDEA](https://www.jetbrains.com/idea/).

## Instrucciones de Configuración
1. **Clonar o descargar el repositorio:** Extrae los archivos del proyecto en una carpeta local.
2. **Configurar las librerías externas:**
    - Asegúrate de incluir las librerías del directorio `lib/` en el classpath del proyecto en tu IDE.
3. **Base de datos:**
    - Si el sistema utiliza una base de datos, verifica la conexión en el archivo de configuración correspondiente ubicado en `resources/config`.

## Ejecución
1. Abre el proyecto en tu IDE.
2. Asegúrate de que todas las dependencias estén correctamente configuradas.
3. Ejecuta el archivo principal del proyecto (`Main.java`) desde la carpeta `src/`.

## Créditos
Este proyecto fue desarrollado como una solución para la gestión eficiente de inventarios.



