/**
 * Modela un producto perecedero.
 * 
 * @author ThesplumCoder 
 * @version 2022
 */
public class Perecedero extends Producto
{
    private Fecha fechaVencimiento;

    /**
     * Nos da un objeto con los argumentos que le pasemos y le pone como
     * fecha de vencimiento un valor nulo.
     * 
     * @param id identificador del producto perecedero.
     * @param nombre cadena con el nombre.
     */
    public Perecedero(int id, String nombre)
    {
        super(id, nombre);
        fechaVencimiento = null;
    }
    
    /**
     * Nos configura la fecha de vencimiento con el objeto Fecha que le pasemos.
     * 
     * @param fecha objeto con una fecha personalizable.
     */
    public void setFecha(Fecha fecha){
        fechaVencimiento = fecha;
    }

}
