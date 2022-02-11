/**
 * Modela un producto no perecedero.
 * 
 * @author ThesplumCoder
 * @version 2022
 */
public class NoPerecedero extends Producto
{
    // Nos guarda una cadena que nos describe la posicion de este producto en la bodega.
    private String posicionEnBodega;

    /**
     * Constructor de la clase. Nos da un producto no perecedero con los valores
     * que le pasemos como argumentos.
     * 
     * @param id identificador del producto no perecedero.
     * @param nombre cadena con el nombre.
     */
    public NoPerecedero(int id, String nombre)
    {
        super(id, nombre);
        posicionEnBodega = "";
    }
    
    /**
     * Cambia la posicion del producto en bodega.
     * 
     * @param posicion cadena con la nueva posicion en bodega.
     */
    public void setPosicion(String posicion){
        posicionEnBodega = posicion;
    }
    
    /**
     * Sobreescritura del metodo toString.
     */
    public String toString(){
        return super.toString() + "\n" + "Bodega: " + this.posicionEnBodega;
    }
}
