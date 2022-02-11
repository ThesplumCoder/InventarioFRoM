import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gestiona inventario de productos en una bodega.
 * 
 * @author  FRoM 
 * @version 2020
 */
public class GestorDeInventario
{
    private ArrayList<Producto> inventario;

    /**
     * Da un GestorDeInventario con una coleccion vacia llamada 'inventario'.
     * Esa coleccion almacena objetos que heredan de Producto.
     */
    public GestorDeInventario()
    {
        inventario = new ArrayList<>();
    }

    /**
     * Agrega un producto a la lista. NO lo agrega si ya existe.
     * @param  producto a ser agregado.
     * @return String que indica el resultado de la operacion.
     */
    public String agregaProducto( Producto producto )
    {   
        String str = null;
        if( producto == null )
            str = "No hay producto a agregar.";
        else{
            // Para que se cumpla debe ser valido y no debe existir en el inventario.
            if( esValido( producto.getNombre() ) && !yaExiste( producto.getNombre() ) )
            {
                inventario.add ( producto );
                str = producto.getNombre() + " agregado";
            }
            // Alguna de las dos condiciones no se cumple, no sabemos cual.
            else
                str = producto + " ya existe en el inventario";
        }
        return str;
    }

    /**
     * Verifica que no sea cadena vacia ni null.
     * @param   nombre del producto.
     */
    private boolean esValido( String producto )
    {
        if( producto != null && producto != "" )
            return true;
        else
            return false;
    }

    /**
     * Verifica si un producto ya es parte del inventario.
     * @param   nombre del producto.
     */    
    private boolean yaExiste( String buscado )
    {
        for( Producto producto : inventario )
        {
            if( producto.getNombre().equals(buscado) )
                return true;
        }
        return false;
    } 

    /**
     * Imprime todos los productos con todos sus atributos.
     * @return String que indica el resultado de la operacion.
     */
    public StringBuilder muestraDetallesProductos()
    {
        StringBuilder str = new StringBuilder();
        for( Producto producto : inventario )
        {
            str.append( producto + "\n" );
        }
        return str;
    }

    /**
     * Busca un producto con el ID dado, y devuelve cuantos items
     * hay en stock. Si el ID no coincide con ningún producto, 
     * devuelve -1.
     * @param id  El ID del producto.
     * @return  La cantidad de items en el inventario; -1 si el producto no existe.
     */
    public int cantidadEnInventario( int id )
    {
        int canti = -1;
        for( Producto producto : inventario )
        {
            if( producto.getID() == id )
                canti = producto.getCantidad();
        }
        return canti;
    }

    /** 
     * Busca un producto.
     * @param id  el identificador del producto.
     * @return Producto     el producto buscado si lo encuentra. 
     *                      Si no lo encuentra devuelve null.
     */
    public Producto buscaProducto( int id )
    {
        for( Producto producto : inventario )
        { 
            if( producto.getID() == id )
                return producto;
        }
        return null;
    } 

    /**
     * Recibe producto que existe en inventario 
     * para aumentar la cantidad en existencia.
     * @param id  El ID del producto a incrementar.
     * @param cantidad valor a aumentar.
     * @return String que indica el resultado de la operacion.
     */
    public String recibeProducto( int id, int cantidad )
    {
        /* Validamos que la cantidad tenga un valor logico, no hay
         * cantidades negativas de un producto. Por otra parte
         * tambien se quita el hecho de que si vas a poner cero en
         * cantidad entonces pase de largo, no hay que procesar nada.
        */
        if(cantidad > 0){
            Producto producto = buscaProducto( id );
            if(producto != null){
                /* El metodo que invocamos abajo ya nos valida que la
                 * cantidad sea mayor que cero.
                */
                producto.aumentaCantidad( cantidad );
                String res = "" + cantidad + " recibidos de " + producto.getNombre();
                return res;
            }
            else{
                return "Producto no esta en inventario";
            }
        }
        else{
            return "Cantidad debe ser > 0";
        }
    }

    /**
     * Disminuye la cantidad de items vendidos del producto
     * @param id  El ID del producto a vender.
     * @param cantidad vendida.
     * @return String que indica el resultado de la operacion.
     */
    public String vendeProducto( int id, int cantidad )
    {        
        if(cantidad > 0){
            Producto producto = buscaProducto( id );
            if(producto != null){
                // Guardamos la cantidad que tenemos de ese producto.
                int stock = producto.getCantidad();
                
                /* Validamos que el stock no sea cero ni que sea menos de lo
                 * que necesitamos vender.
                 */
                if(stock != 0 && stock >= cantidad){
                    for(int i = 1 ; i <= cantidad ; i++ ){
                        producto.vendeUno();
                    }
                    return "Se vendio: " + producto.toString();
                }
                else{
                    return "No hay para la venta: " + producto.getNombre();
                }
            }
            else{
                return "Producto no esta en inventario"; 
            }
        }
        
        return "Cantidad a vender no valida";
    }

    /**
     * Imprime productos con cantidad baja en inventario.
     * @param minimo    Cantidad minima en inventario que deben 
     *                  tener todos los productos.
     * @return ArrayList<Producto> productos con menos items de los permitidos.
     */
    public ArrayList<Producto> productosConPocosItems( int minimo )
    {
        /* Construimos una lista con la cual podemos responder cuando invoquen
         * este metodo.
         */
        ArrayList<Producto> respuesta = new ArrayList<>();
        
        // Iteramos en todo el inventario, producto por producto.
        for(Producto i : inventario){
            if(i.getCantidad() <= minimo){
                respuesta.add(i);
            }
        }
        return respuesta;
    }   

    /** 
     * Busca productos que contengan palabra de busqueda.
     * @return  coleccion de productos buscados. 
     *          Si no encuentra devuelve null.
     */
    public ArrayList<Producto> buscaSimilares( String busqueda )
    {
        /* Construimos una lista con la cual podemos responder cuando invoquen
         * este metodo.
         */
        ArrayList<Producto> respuesta = new ArrayList<>();
        
        if(busqueda != ""){
            for(Producto i : inventario){
                /* Aqui creamos una variable con el nombre del producto que vamos
                 * iterando, entramos al condicional, utilizamos el metodo 'contains'
                 * para validar si contiene la palabra y lo ponemos en caso de que
                 * si sea.
                 * 
                 * Una aclaracion es que constains recibe una interface, pero como
                 * la clase String la implementa entonces podemos utilizar este tipo.
                 */
                String nombre = i.getNombre();
                if(nombre.contains(busqueda)){
                    respuesta.add(i);
                }
            }
        }
        return respuesta;
    }
}