package ApuntesThreads;

/* Para los casos en los que no es posible hacer que la clase definida extienda (herede) la
clase Thread.

Esto ocurre cuando en la clase que estamos definiendo (de la que se quiere ejecutar en un hilo independiente)
deba extender alguna otra clase.

Dado que no existe herencia múltiple en Java, la citada clase no puede extender a la vez la clase Thread y otra más.
Entonces se utiliza la opción de implementar la Interface Runnable. */

public class ThreadEjemploImplementsRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }

        System.out.println("Termina thread " + Thread.currentThread().getName());
    }
}
