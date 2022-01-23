package ParadigmaDocs_Model;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Usuario {
  // Atributos
  private String fecha;
  private String username;
  private String password;
  private ArrayList<Documento> docsCreados;
  private ArrayList<Documento> docsAcceso;

  // Constructor
  public Usuario(String username, String password) {
    SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    this.fecha = formatFecha.format(date);
    this.username = username;
    this.password = password;
    this.docsCreados = new ArrayList<>();
    this.docsAcceso = new ArrayList<>();
  }

  /**
   * @return fecha de creacion de cuenta
   */
  public String getFecha() {
    return fecha;
  }

  /**
   * @param fecha fecha de creacion de cuenta
   */
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  /**
   * @return String
   */
  // Getters and Setters
  public String getUsername() {
    return username;
  }

  /**
   * @param username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return String
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return ArrayList<Documento>
   */
  public ArrayList<Documento> getDocsCreados() {
    return docsCreados;
  }

  /**
   * @param docsCreados
   */
  public void setDocsCreados(ArrayList<Documento> docsCreados) {
    this.docsCreados = docsCreados;
  }

  /**
   * @return ArrayList<Documento>
   */
  public ArrayList<Documento> getDocsAcceso() {
    return docsAcceso;
  }

  /**
   * @param docsAcceso
   */
  public void setDocsAcceso(ArrayList<Documento> docsAcceso) {
    this.docsAcceso = docsAcceso;
  }
}
