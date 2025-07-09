package ApuntesThreads;

/* Usar la clase Thread (es decir que la clase que implementemos debe heredar de la clase Thread).
La clase Thread implementa la Interface Runnable.

Se debe redefinir el método run(). Este método es invocado cuando se inicia el hilo (mediante una llamada al método start()
de la clase Thread). El hilo inicia su ejecución en el método run() y termina cuando éste termina.

El método main crea dos objetos de clase ThreadEjemplo y los inicia con la llamada al método start()
(el cual inicia el nuevo hilo y llama al método run()). */

public class ThreadEjemploExtendsThread extends Thread {
    public ThreadEjemploExtendsThread(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + getName());
        }

        System.out.println("Termina thread " + getName());
    }

    public static void main(String[] args) {
        new ThreadEjemploExtendsThread("Pepe").start(); // Thread Pepe
        new ThreadEjemploExtendsThread("Juan").start(); // Thread Juan
        System.out.println("Termina thread main");
    }
}
