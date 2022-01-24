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

  /**
   * @return String
   */
  public String getComentario() {
    return comentario;
  }

  /**
   * @param comentario comentario
   */
  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  /**
   * @return String fecha del comentario
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * @param fecha fecha del comentario
   */
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   * @return Usuario del comentario
   */
  public Usuario getAutor() {
    return autor;
  }

  /**
   * @param autor del comentario
   */
  public void setAutor(Usuario autor) {
    this.autor = autor;
  }

  /**
   * @return String contenido del comentario
   */
  public String getContenido() {
    return contenido;
  }

  /**
   * @param contenido  contenido del comentario
   */
  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return "\n * * Comentario * * \n\t[" + autor.getUsername() + "] [" + fecha + "]" + "\n\t* " + contenido + " * -> ["
        + comentario
        + "]";

  }
}
