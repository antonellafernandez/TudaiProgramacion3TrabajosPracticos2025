package ApuntesThreads;

public class MainRunnable {
    public static void main(String[] args) {
        Thread t = new Thread (new ThreadEjemploImplementsRunnable());
        t.start();  // Thread-0

        new Thread (new ThreadEjemploImplementsRunnable()).start(); // Thread-1

        new Thread (new ThreadEjemploImplementsRunnable(), "Pepe").start(); // Thread Pepe
        new Thread (new ThreadEjemploImplementsRunnable(), "Juan").start(); // Thread Juan
        System.out.println("Termina thread main");
    }
}
