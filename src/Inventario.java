import java.util.ArrayList;

public class Inventario {
    //Atributo
    private ArrayList<Producto> productos;

    //Metodo constructor
    public Inventario(){
        productos = new ArrayList<>();
    }

    //Metodo para agregar productos
    public void agregarProducto(int id, String nombre, int cantidad, double precio){
        /** Validar si ya existe un producto con el mismo ID
         * for (Producto producto : productos) {
         *    if (producto.getId() == id) {
         *       System.out.println("Error: Ya existe un producto con el ID " + id);
         *         return;
         *    }
         * }
         */
        Producto nuevoProducto = new Producto (id,nombre, cantidad, precio);
        productos.add(nuevoProducto);
    }

    public void consultarInventario (){
        if (productos.isEmpty()){
            System.out.println("El inventario está vacío.");
        }else{

        }
    }


}
