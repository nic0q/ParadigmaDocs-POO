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

  public ArrayList<Comentario> getComentarios() {
    return comentarios;
  }

  public void setComentarios(ArrayList<Comentario> comentarios) {
    this.comentarios = comentarios;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
