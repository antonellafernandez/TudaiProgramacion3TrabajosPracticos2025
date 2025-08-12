package Final27FEB2025;

/* Ejercicio 5

Dada la definición de la clase ThreadEjemplo en JAVA. Reescriba el código de manera que la clase
ThreadEjemplo tenga un comportamiento similar, o sea que sea un Thread, pero que pueda extender
de otra clase A que no hereda de Thread.
 */

import ApuntesThreads.ThreadEjemploImplementsRunnable;

public class Ejercicio5 {
    // Clase ThreadEjemplo con extends Thread
    public class ThreadEjemplo extends Thread {
        public ThreadEjemplo(String str) {
            super(str);
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + getName());
            }

            System.out.println("Termina thread " + getName());
        }

        public static void main(String[] args) {
            new ThreadEjemplo("Pepe").start();
            new ThreadEjemplo("Juan").start();
            System.out.println("Termina thread main");
        }
    }

    // Clase ThreadEjemplo con implements Runnable
    public class ThreadEjemploImplementsRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }

            System.out.println("Termina thread " + Thread.currentThread().getName());
        }
    }

    // Main Runnable
    public static void main(String[] args) {
        new Thread (new ThreadEjemploImplementsRunnable(), "Pepe").start(); // Thread Pepe
        new Thread (new ThreadEjemploImplementsRunnable(), "Juan").start(); // Thread Juan
        System.out.println("Termina thread main");
    }
}
