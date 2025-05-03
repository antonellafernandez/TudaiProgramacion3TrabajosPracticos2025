package TP3_EstructurasDeDispersion;

public class Main {public static void main(String[] args) {

    /* Ejercicio 1
    Dado el conjunto de elementos: X= {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61,
    50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92} Realizar la inserción de los mismos en una estructura
    de Hashing com la que se especifica en cada punto, con las siguientes técnicas de
    tratamiento de desbordes, muestre gráficamente cómo se va armando la estructura y cómo
    queda luego de insertar hasta el último elemento:
    a.- Hashing separado (con M=7 y rp=1, rs=1).
    b.- Hashing separado con crecimiento (con el comportamiento de HashTable de JAVA) (con M=7, ρd=0,9). */

    int[] elements = {68, 42, 47, 5, 76, 95, 23, 88, 90, 85, 31, 71, 60, 10, 46, 61,
            50, 92, 74, 6, 97, 66, 1, 56, 27, 7, 14, 92};
    int M = 7;
    HashTable hashTable = new HashTable();

    System.out.println("Insertando elementos en Hashing Separado: ");

    for (int element : elements) {
        hashTable.insert(element);
        hashTable.printTable();
        System.out.println();
    }

    float loadFactor = 0.9f;
    DynamicHashTable dynamicHashTable = new DynamicHashTable(M, loadFactor);

    System.out.println("Insertando elementos en Hashing Separado con Crecimiento: ");
    for (int element : elements) {
        dynamicHashTable.insert(element);
        dynamicHashTable.printTable();
        System.out.println();
    }

    /* Ejercicio 2
    Conteste si es posible o no y justifique:
    1. Si se quisiera listar en orden todas las claves almacenadas en una estructura de
    hashing, ¿se podría? ¿Cómo? ¿Es la estructura más adecuada?

    No, no es posible listar en orden todas las claves almacenadas en una estructura de hashing de
    manera eficiente. El hashing asigna claves a ubicaciones en la tabla de hash mediante una
    función de dispersión, lo que no garantiza un orden específico.

    Si se necesita un orden específico, es mejor usar otras estructuras de datos
    como árboles binarios de búsqueda.

    2. ¿Qué tipos de servicios resuelve un hashing? Es posible responder por ejemplo: La
    lista de todos los alumnos que obtuvieron una nota mayor que x en un curso dado?

    El hashing es útil principalmente para la búsqueda rápida y eficiente de elementos
    a través de sus claves. Sin embargo, no es adecuado para operaciones como obtener listas ordenadas
    de elementos o realizar búsquedas por rangos de valores. Para obtener la lista de todos
    los alumnos que obtuvieron una nota mayor que x en un curso dado, se necesitaría utilizar una
    estructura de datos diferente como árboles binarios de búsqueda o estructuras de índice que
    admitan búsquedas por rango. */

    /* Ejercicio 3
    Se está desarrollando una aplicación que almacena los datos y el saldo de las tarjetas de
    compra de comida del comedor de una universidad. Cada cliente es identificado por su
    número de DNI, y se poseen además sus datos personales y de la carrera que estudia.

    CLIENTE: DNI, Nombre, Apellido, fecha de nacimiento, domicilio, CP ciudad de origen, saldo
    de la cuenta, nombre carrera estudia

    Se quiere:

    a) Dado un DNI de cliente, responder el saldo de su cuenta.

    RTA: HashTable donde las claves sean los números de DNI de los clientes y los valores sean los saldos
    de sus cuentas.

    b) Imprimir un listado de Nombre y Apellido de todos los clientes que tienen en su saldo
    de cuenta menos de un valor X dado.

    RTA: Árbol de búsqueda binario.

    c) Dado un código postal, listar todos los clientes que provengan de esa ciudad.

    RTA: HashTable donde las claves sean los códigos postales y los valores sean listas enlazadas
    de clientes que provienen de esa ciudad. Cada cliente tendría asociado su nombre y apellido.

    Proponga y describa qué estructuras de datos utilizaría para responder eficientemente a los
    servicios pedidos. Muestre gráficamente cómo se relacionan. */

    /* Ejercicio 4 (2do intento)
    Se desea desarrollar una aplicación para mejorar la atención de una biblioteca en cuanto a la
    búsqueda de libros dentro del catálogo disponible. Cada libro estará compuesto por un
    identificador único y datos propios de los libros (título, autor, géneros, año de publicación,
    cantidad de ejemplares, etc.)

    Se sabe, además, que los libros nuevos se agregan al catálogo en horarios fuera de la
    atención al público.

    Se desean proveer los siguientes servicios:

    • Obtener la cantidad de ejemplares de un libro dado su identificador único.
    • Obtener todos los libros de un género dado.
    • Obtener todos los libros publicados entre dos años de publicación dados.

    Responda y justifique:

    1) ¿Qué estructura de datos utilizaría para almacenar todos los libros en memoria dentro
    de la aplicación?

    Utilizaría un árbol de búsqueda binario ordenado por el identificador único de los libros.
    Esto permitiría una búsqueda rápida de libros por su identificador único y también proporcionaría
    una forma eficiente de agregar nuevos libros al catálogo.

    2) ¿Cómo resolvería cada uno de los servicios solicitados? ¿Utilizaría alguna estructura
    adicional de acceso para mejorar el costo de respuesta de cada servicio?

    • Obtener la cantidad de ejemplares de un libro dado su identificador único.
    Para este servicio, simplemente se buscaría el libro por su identificador único en el árbol de búsqueda. La cantidad de ejemplares se obtendría del nodo correspondiente encontrado en el árbol.

    • Obtener todos los libros de un género dado.
    Se podría mejorar la eficiencia de este servicio utilizando un índice adicional que mapee
    cada género a una lista de libros que pertenecen a ese género.

    • Obtener todos los libros publicados entre dos años de publicación dados.
    Similar al servicio 2, se podría utilizar un índice adicional que mapee los años de publicación
    a una lista de libros publicados en ese año. */
    }
}
