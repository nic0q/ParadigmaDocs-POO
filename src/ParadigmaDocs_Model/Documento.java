package ParadigmaDocs_Model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

/**
 * Clase Documento, nativa de el modelo, almacena la estructura de un documento
 * pregunta.
 * 
 * @author Nicolas Farfán Cheneaux
 */

public class Documento {
  // Atributos
  private static Integer idCont = -1;
  private Integer id;
  private String fecha;
  private Usuario autor;
  private String contenido;
  private String titulo;
  private ArrayList<Acceso> permisos;
  private ArrayList<Version> historial;

  // Constructor

  /**
   * Constructor de un documento
   * 
   * @param titulo    titulo de un documento
   * @param contenido contenido de un documento
   */
  public Documento(String titulo, String contenido) {
    SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    idCont = idCont + 1;
    this.id = idCont;
    this.fecha = formatFecha.format(date);
    this.titulo = titulo;
    this.contenido = contenido;
    this.historial = new ArrayList<>();
    this.permisos = new ArrayList<>();
    Version ver1 = new Version(contenido);
    ver1.setId(0);
    historial.add(ver1);
  }

  // Getters y Setters
  /**
   * @return ArrayList<Acceso> de accesos
   */
  public ArrayList<Acceso> getAccesses() {
    return permisos;
  }

  /**
   * @param permisos
   */
  public void setAccesses(ArrayList<Acceso> permisos) {
    this.permisos = permisos;
  }

  /**
   * @return Version, Version activa de el documento
   */
  public Version getActiva() {
    int size = getHistorial().size();
    return this.getHistorial().get(size - 1);
  }

  /**
   * @return Usuario, Autor de el documento
   */
  public Usuario getAutor() {
    return autor;
  }

  /**
   * @param autor
   */
  public void setAutor(Usuario autor) {
    this.autor = autor;
  }

  /**
   * @return Integer, Id de el documento
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return fecha de creacion del documento
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * @param fecha
   */
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   * @return contenido de el documento
   */
  public String getContenido() {
    return contenido;
  }

  /**
   * @param contenido
   */
  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  /**
   * @return Titulo de el documento
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   * @param titulo
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * @return ArrayList<Version> Historial de el documento (Lista de versiones)
   */
  public ArrayList<Version> getHistorial() {
    return historial;
  }

  /**
   * @param historial
   */
  public void setHistorial(ArrayList<Version> historial) {
    this.historial = historial;
  }

}
