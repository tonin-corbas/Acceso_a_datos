public class Libro {
    private String titulo;
    private String autor;
    private String any;
    private String resum;

    public Libro(String titulo, String autor, String any, String resum) {
        this.titulo = titulo;
        this.autor = autor;
        this.any = any;
        this.resum = resum;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAny() {
        return any;
    }

    public String getResum() {return resum;}

    @Override
    public String toString() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nAño: " + any + "\nResumen:" + resum +  "\n------------------------";
    }
}
