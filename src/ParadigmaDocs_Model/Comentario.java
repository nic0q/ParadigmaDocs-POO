package ParadigmaDocs_Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comentario {
  private String fecha;
  private Usuario autor;
  private String contenido;
  private String comentario;

  public Comentario(Usuario usuario, String contenido, String comentario) {
    SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
    Date tempDate = new Date();
    this.setFecha(tipo.format(tempDate));
    this.autor = usuario;
    this.contenido = contenido;
    this.comentario = comentario;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public Usuario getAutor() {
    return autor;
  }

  public void setAutor(Usuario autor) {
    this.autor = autor;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  @Override
  public String toString() {
    return " * * Comentario * * \n\t[" + autor.getUsername() + "] [" + fecha + "]" + "\n\t*" + contenido + "* -> ["
        + comentario
        + "]";

  }

}
