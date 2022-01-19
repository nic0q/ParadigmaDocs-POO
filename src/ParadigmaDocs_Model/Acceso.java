package ParadigmaDocs_Model;

/**
 * Acceso
 */
public class Acceso {

  private Usuario user;
  private String permiso;

  public Acceso(Usuario user, String access) {
    this.user = user;
    this.permiso = access;
  }

  /**
   * @return Usuario que posee el acceso
   */
  public Usuario getUser() {
    return user;
  }

  /**
   * @param user
   */
  public void setUser(Usuario user) {
    this.user = user;
  }

  /**
   * @return Tipo de permiso de usuario
   */
  public String getPermiso() {
    return permiso;
  }

  /**
   * @param permiso
   */
  public void setPermiso(String permiso) {
    this.permiso = permiso;
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return "Acceso [permisos=" + permiso + ", user=" + user + "]";
  }

  /**
   * @return String
   */
  public String accessToString() {
    String permiso = this.getPermiso();
    if (permiso.equals("w")) {
      return "escribir";
    } else if (permiso.equals("c")) {
      return "comentar";
    } else {
      return "leer";
    }
  }
}