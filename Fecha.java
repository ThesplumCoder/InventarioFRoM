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

    public Fecha(){
        setHoy();
    }

    public Fecha(int agnio, int mes, int dia){
        fecha = LocalDate.of(agnio, mes, dia);
    }
    
    public LocalDate getFecha(){
        return fecha;
    }

    public LocalDate getHoy(){
        return hoy;
    }

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
