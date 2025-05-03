package TrabajosPracticos.TP2_Arboles;

import java.util.ArrayList;

public class Book {
    private long id;
    private String autor;
    private ArrayList<String> generos;
    private int anioPublicacion, cantEjemplares;

    public Book(long id, String autor, int anioPublicacion, int cantEjemplares) {
        this.id = id;
        this.autor = autor;
        this.generos = new ArrayList<>();
        this.anioPublicacion = anioPublicacion;
        this.cantEjemplares = cantEjemplares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ArrayList<String> getGeneros() {
        return new ArrayList<String>(this.generos);
    }

    public void addGenero(String genero) {
        if (!this.generos.contains(genero)) {
            this.generos.add(genero.toUpperCase());
        }
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", generos=" + generos +
                ", anioPublicacion=" + anioPublicacion +
                ", cantEjemplares=" + cantEjemplares +
                '}';
    }
}
