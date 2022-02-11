import java.time.LocalDate;

/**
 * Representa fecha de vencimiento de un producto.
 * 
 * @author  FRoM
 * @version 2020
 */
public class Fecha
{
    private LocalDate fecha;
    private LocalDate hoy;

    /**
     * Nos da Fecha con los datos del dia actual, los toma del sistema.
     */
    public Fecha(){
        // Método público de esta clase.
        setHoy();
    }

    /**
     * Nos da Fecha con los datos que le pasamos.
     * @param agnio valor entero entre los limites de LocalDate.
     * @param mes valor entero entre 1 y 12.
     * @param dia valor entre 1 y 31.
     */
    public Fecha(int agnio, int mes, int dia){
        /* Pone la fecha como se le indique en la entrada, entonces
         * la variable 'fecha' referencia a un objeto LocalDate con
         * esos datos.
         */
        fecha = LocalDate.of(agnio, mes, dia);
    }
    
    /**
     * Retorna 'fecha' de Fecha.
     * @return fecha.
     */
    public LocalDate getFecha(){
        return fecha;
    }

    /**
     * Retorna 'hoy' de Fecha.
     * @return hoy.
     */
    public LocalDate getHoy(){
        return hoy;
    }

    /**
     * Obtiene la fecha del sistema en un objeto tipo LocalDate, luego asigna
     * a 'hoy' ese objeto.
     */
    public void setHoy(){
        hoy = LocalDate.now(); 
    }

    public String toString(){
        String str = fecha.getDayOfWeek().toString();
        str += ", " + fecha.getDayOfMonth();
        str += " " + fecha.getMonth();
        str += " " + fecha.getYear();
        return str;
    }

    public String toStringOld(){
        return "" + fecha;
    }
}
