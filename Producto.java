/**
 * Representa un producto almacenado en bodega listo para la venta.
 * 
 * @author  FRoM 
 * @version 2020
 */
public abstract class Producto
{
    // Un identificador para este producto
    private int id;
    // El nombre de este producto
    private String nombre;
    // La cantidad de productos en inventario
    private int cantidad;
    // valor cobrado por este producto
    private double precioVenta;    

    /**
     * Constructor de objetos de la clase producto.
     * La cantidad de stock inicial es cero.
     * @param id  El numero identificacion del producto.
     * @param name  El nombre del producto.
     */
    public Producto( int id, String nombre )
    {
        this.id = id;
        this.nombre = nombre;
        cantidad = 0;
    }
    
    public void setPrecio(double precio){
        if( precio > 0){
            precioVenta = precio;
        }
    }
    
    public double getPrecio(){
        return precioVenta;
    }

    /**
     * @return  El id del producto.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return El nombre del producto.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return  La cantidad en inventario.
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * @return  Cadena de texto con id, nombre y cantidad en inventario.
     */
    public String toString()
    {
        return id + ": " + nombre + " - Disponibles: " + cantidad;
    }

    /**
     * Repoblar este producto con la cantidad dada.
     * La cantidad actual de este producto se incrementa en la cantidad dada.    
     * @param nuevos  cantidad de nuevos items a ser agregados al inventario;
     *                debe ser mayor que cero.
     */
    public void aumentaCantidad( int nuevos )
    {
        if( nuevos > 0 )
            cantidad += nuevos;
    }

    /**
     * Vender un item de este producto.
     * @return boolean  true si se pudo vender el producto; false si no (cuando cantidad 
     *                  es cero).
     */
    public boolean vendeUno()
    {
        boolean fueVendido = false;
        if( cantidad > 0 )
        {
            cantidad = cantidad - 1;
            fueVendido = true;
        }
        return fueVendido;
    }
}
