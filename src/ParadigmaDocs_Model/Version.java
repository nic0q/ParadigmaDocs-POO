package ParadigmaDocs_Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Version {
  private Integer id;
  private String contenido;
  private String fecha;
  private ArrayList<Comentario> comentarios;

  public Version(String contenido) {
    SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
    Date tempDate = new Date();
    this.setFecha(tipo.format(tempDate));
    this.setContenido(contenido);
    this.comentarios = new ArrayList<>();
  }

  /**
   * @return ArrayList<Comentario>
   */
  public ArrayList<Comentario> getComentarios() {
    return comentarios;
  }

  /**
   * @param comentarios comentarios
   */
  public void setComentarios(ArrayList<Comentario> comentarios) {
    this.comentarios = comentarios;
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
   * @return String c
   */
  public String getContenido() {
    return contenido;
  }

  /**
   * @param contenido fecha del comentario
   */
  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  /**
   * @return Integer id comentario
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id id comentario
   */
  public void setId(Integer id) {
    this.id = id;
  }
}
