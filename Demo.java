import java.util.ArrayList;
/**
 * Demostración de las clases GestorDeInventario y Producto.
 * La demostración se hace adecuadamente funcional al
 * implementar herencia de clases.
 * 
 * @author  FRoM, ThesplumCoder
 * @version 2022
 */
public class Demo
{
    public Demo()
    {
        GestorDeInventario gestor = new GestorDeInventario();

        System.out.println( "***** APLICACION DE INVENTARIO *****" );
        // Productos NO perecederos
        System.out.println( gestor.agregaProducto( new NoPerecedero( 13, "Guitarra Taylor" ) ) );
        System.out.println( gestor.agregaProducto( new NoPerecedero( 46, "Les-Paul Gibson Guitar" ) ) );
        System.out.println( gestor.agregaProducto( new NoPerecedero( 79, "Ibanez JS-1200 Guitar" ) ) );
        
        // Productos perecederos
        System.out.println( gestor.agregaProducto( new Perecedero( 80, "Limpia Cuerdas" ) ) );
        System.out.println( gestor.agregaProducto( new Perecedero( 32, "GuitarPlayer-Yogurt" ) ) );
        System.out.println( gestor.agregaProducto( new Perecedero( 33, "Musician-Kumis" ) ) );
        
        // Asigna precios a productos
        gestor.buscaProducto(13).setPrecio(700);
        gestor.buscaProducto(46).setPrecio(3000);
        gestor.buscaProducto(79).setPrecio(2000);
        gestor.buscaProducto(80).setPrecio(5);
        gestor.buscaProducto(32).setPrecio(2);
        gestor.buscaProducto(33).setPrecio(3);
        
        // Asigna posicion en bodega a NO perecederos
        ((NoPerecedero) gestor.buscaProducto(13)).setPosicion("p1b1e3");
        ((NoPerecedero) gestor.buscaProducto(46)).setPosicion("p3b4e1");
        ((NoPerecedero) gestor.buscaProducto(79)).setPosicion("p5b3e7");
        
        // Asigna fecha de vencimiento a perecederos
        ((Perecedero)gestor.buscaProducto(80)).setFecha(new Fecha(2022,6,15));
        ((Perecedero)gestor.buscaProducto(32)).setFecha(new Fecha(2022,3,21));
        ((Perecedero)gestor.buscaProducto(33)).setFecha(new Fecha(2022,3,21));

        System.out.println( "***** Pruebas positivas agregaProducto() pasadas *****" );
        System.out.println();

        System.out.println( gestor.recibeProducto( 13, 4 ) );
        System.out.println( gestor.recibeProducto( 46, 2 ) );
        System.out.println( gestor.recibeProducto( 79, 3 ) );
        System.out.println( gestor.recibeProducto( 80, 24 ) );
        System.out.println( gestor.recibeProducto( 32, 12 ) );
        System.out.println( gestor.recibeProducto( 33, 12 ) );
        System.out.println( "***** Pruebas positivas recibeProducto() pasadas *****" );
        
        // Empieza prueba negativa recibeProducto() 
        System.out.println( "------- Productos en Inventario -------" );
        System.out.println( gestor.muestraDetallesProductos() );

        System.out.println( gestor.recibeProducto( 12, 3 ) );
        System.out.println( gestor.recibeProducto( 46, -5 ) );        
        System.out.println( "***** Pruebas negativas recibeProducto() pasadas *****" );
        
        // Empieza prueba positiva vendeProducto()
        System.out.println( gestor.vendeProducto( 13, 3 ) );
        System.out.println( gestor.vendeProducto( 79, 1 ) );
        System.out.println( "***** Pruebas positivas vendeProductos() pasadas *****" );      
        System.out.println();

        System.out.println( gestor.vendeProducto( 13, 0 ) );
        System.out.println( gestor.vendeProducto( 46, 1 ) );
        System.out.println( gestor.vendeProducto( 12, 2 ) );
        gestor.muestraDetallesProductos();
        System.out.println( "***** Pruebas negativas vendeProductos() pasadas *****" );
        System.out.println();

        ArrayList<Producto> renovables = gestor.productosConPocosItems( 5 );
        for( Producto producto : renovables ){
            System.out.println( producto );
        }
        System.out.println( "***** Pruebas positivas pocos items pasada *****" );
        System.out.println();        

        System.out.println( "***** PRODUCTOS SIMILARES *****" );
        ArrayList<Producto> similares = gestor.buscaSimilares( "Guitar" );
        for( Producto producto : similares )
            System.out.println( producto );
    }
        
    public static void main(){
        Demo arranque = new Demo();
    }
}