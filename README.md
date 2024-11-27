# Sistema de Gestión de Inventario

Este proyecto tiene como objetivo desarrollar un sistema que permita gestionar el inventario de productos en una tienda
o almacén. El programa permitirá al usuario registrar productos, consultar cantidades, actualizar inventario y eliminar
productos, todo a través de un menú interactivo.

## ¿Qué se va a hacer?
- **Registro de productos:** El sistema permitirá agregar productos con ID, nombre, cantidad y precio.
- **Consulta de inventario:** El usuario podrá consultar el inventario de productos.
- **Actualización de productos:** Permite actualizar la cantidad o el precio de los productos registrados.
- **Eliminación de productos:** Los usuarios podrán eliminar productos del inventario.
- **Cálculo del valor total del inventario:** Función para calcular el valor total del inventario en función de
- las cantidades y precios.
- **Validación de datos:** Asegura que no se ingresen productos duplicados.

## Objetivos de Aprendizaje
- Uso de estructuras secuenciales y de control (`if`, `switch`).
- Modularización del código mediante funciones.
- Implementación de listas o arreglos para almacenar productos.
- Manejo de entrada y salida de datos en consola.

## Estructura de Clases
### Clase `Producto`
- **Atributos:** `id`, `nombre`, `cantidad`, `precio`.
- **Métodos:** Constructor, getters y setters.

### Clase `Inventario`
- **Atributo:** `ArrayList<Producto>` (en Java) o `List[Producto]` (en Python).
- **Métodos:** `agregarProducto`, `consultarInventario`, `eliminarProducto`, `calcularValorTotal`.


