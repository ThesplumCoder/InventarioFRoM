PROYECTO:   inventario 
PRÓPOSITO:  Evaluar habilidades de desarrollo de aplicaciones con POO en Java
            Nivel Intermedio: Herencia y polimorfismo.
AUTOR:      FRoM
FECHA:      07.02.2020
=========================================================================================
INSTRUCCIONES:
Salve su proyecto con su nombre y antes de realizar cada cambio guarde una nueva version.
Cuando sea el momento de entregar comprima su proyecto con winzip, envielo a 
oop.eisi@gmail.com y en asunto ponga su nombre y el grupo al que pertenece.
En la clase Demo, cambie los nombres de los 6 productos que se crean (3 NO perecederos
y 3 perecederos).
=========================================================================================
Los propietarios de un almacen que usaban esta app decidieron dividir los productos entre
perecederos y no perecederos. 
Un producto perecedero es aquel que tiene una fecha de vencimiento.
Para los productos perecederos se registra su posicion en una bodega que haga mas facil
encontrarlos para la venta.
Su mision es hacer que la app maneje productos perecederos y no perecederos, de forma que
se pueda soicitar la lista de productos perecederos a vencer la siguiente semana y realizar
una rebaja del precio 20% de esos productos. Para ello debe implementar herencia y 
los metodos de la clase GestorDeInventario que faltan.
La clase Fecha se usa como esta; no necesita cambios ni codigo nuevo.
=========================================================================================
La salida del Demo es algo similar a esto:

***** APLICACION DE INVENTARIO *****
Guitarra Taylor agregado
Les-Paul Gibson Guitar agregado
Ibanez JS-1200 Guitar agregado
Limpia Cuerdas agregado
GuitarPlayer-Yogurt agregado
Musician-Kumis agregado
***** Pruebas positivas agregaProducto() pasadas *****

4 recibidos de Guitarra Taylor
2 recibidos de Les-Paul Gibson Guitar
3 recibidos de Ibanez JS-1200 Guitar
24 recibidos de Limpia Cuerdas
12 recibidos de GuitarPlayer-Yogurt
12 recibidos de Musician-Kumis
***** Pruebas positivas recibeProducto() pasadas *****
------- Productos en Inventario -------
13: Guitarra Taylor - Disponibles: 4
Bodega: p1b1e3
46: Les-Paul Gibson Guitar - Disponibles: 2
Bodega: p3b4e1
79: Ibanez JS-1200 Guitar - Disponibles: 3
Bodega: p5b3e7
80: Limpia Cuerdas - Disponibles: 24
En vitrina - Vence antes de: WEDNESDAY, 15 JUNE 2022
32: GuitarPlayer-Yogurt - Disponibles: 12
En vitrina - Vence antes de: MONDAY, 21 MARCH 2022
33: Musician-Kumis - Disponibles: 12
En vitrina - Vence antes de: MONDAY, 21 MARCH 2022

Producto no esta en inventario
Cantidad debe ser > 0
***** Pruebas negativas recibeProducto() pasadas *****
No hay para la venta: Guitarra Taylor

Se vendio: 79: Ibanez JS-1200 Guitar - Disponibles: 2
Bodega: p5b3e7
***** Pruebas positivas vendeProductos() pasadas *****

Cantidad a vender no valida

Se vendio: 46: Les-Paul Gibson Guitar - Disponibles: 1
Bodega: p3b4e1
Producto no esta en inventario
***** Pruebas negativas vendeProductos() pasadas *****

13: Guitarra Taylor - Disponibles: 1
Bodega: p1b1e3
46: Les-Paul Gibson Guitar - Disponibles: 1
Bodega: p3b4e1
79: Ibanez JS-1200 Guitar - Disponibles: 2
Bodega: p5b3e7
***** Pruebas positivas pocos items pasada *****

***** PRODUCTOS SIMILARES *****
13: Guitarra Taylor - Disponibles: 1
Bodega: p1b1e3
46: Les-Paul Gibson Guitar - Disponibles: 1
Bodega: p3b4e1
79: Ibanez JS-1200 Guitar - Disponibles: 2
Bodega: p5b3e7
32: GuitarPlayer-Yogurt - Disponibles: 12
En vitrina - Vence antes de: MONDAY, 21 MARCH 2022
