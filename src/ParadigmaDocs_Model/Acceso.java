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

  public Usuario getUser() {
    return user;
  }

  public void setUser(Usuario user) {
    this.user = user;
  }

  public String getPermiso() {
    return permiso;
  }

  public void setPermiso(String permiso) {
    this.permiso = permiso;
  }

  @Override
  public String toString() {
    return "Acceso [permisos=" + permiso + ", user=" + user + "]";
  }

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