package ParadigmaDocs_Controller;

import ParadigmaDocs_Model.*;

/**
 * Controller
 * Clase donde se crean los métodos funcionales de ParadigmaDocs
 * 
 * @author Nícolas Farfán Cheneaux
 */
public class Controller {
  // Atributos
  private ParadigmaDocs paradigmaDocs;

  // Constructor
  /**
   * @param paradigmaDoc instancia de la clase ParadigmaDocs
   */
  public Controller(ParadigmaDocs paradigmaDocs) {
    this.paradigmaDocs = paradigmaDocs;
  }

  // Getter
  /**
   * @return ParadigmaDocs la plataforma
   */
  public ParadigmaDocs getParadigmaDocs() {
    return paradigmaDocs;
  }

  // Métodos
  /**
   * @return boolean
   */
  public boolean isLogeado() {
    ParadigmaDocs pDocs = getParadigmaDocs();
    return pDocs.isConectado();
  }

  /**
   * @return Usuario
   */
  public Usuario getLogeado() {
    ParadigmaDocs pDocs = getParadigmaDocs();
    return pDocs.getLogeado();

  }
  // Métodos
  // Register

  /**
   * Método que permite registrar un nuevo usuario en paradigmaDocs
   * 
   * @param username El username del usurio
   * @param password La contraseña del usuario
   */
  public void register(String username, String password) {
    ParadigmaDocs pDocs = getParadigmaDocs();
    for (int i = 0; i < pDocs.getUsuarios().size(); i++) {
      if (pDocs.getUsuarios().get(i).getUsername().equals(username)) {
        System.out.println("El username " + username + " ya existe");
        return;
      }
    }
    Usuario nuevUsuario = new Usuario(username, password);
    pDocs.getUsuarios().add(nuevUsuario);
  }

  /**
   * Método que permite iniciar sesión a un usuario previamente registrado
   * 
   * @param username El username del usurio
   * @param password La contraseña del usuario
   */
  public void login(String username, String password) {
    ParadigmaDocs pDocs = getParadigmaDocs();
    for (int i = 0; i < pDocs.getUsuarios().size(); i++) {
      if (pDocs.getUsuarios().get(i).getUsername().equals(username)
          && pDocs.getUsuarios().get(i).getPassword().equals(password)) {
        pDocs.setLogeado(pDocs.getUsuarios().get(i));
        pDocs.setConectado(true);
        System.out.println("Logeo Exitoso");
        return;
      }
    }
    System.out.println("Usuario no registrado");
  }

  /**
   * Método que permite cerrar sesión al usuario que tiene iniciada sesión
   */
  public void logout() {
    ParadigmaDocs pDocs = getParadigmaDocs();
    pDocs.setConectado(false);
  }

  /**
   * Método que permite crear un documento en la plataforma a un usuario
   * 
   * @param titulo    Titulo del documento
   * @param logeado   Usuario logeado
   * @param contenido Contenido del documento a crear
   */
  public void create(String titulo, Usuario logeado, String contenido) {
    ParadigmaDocs pDocs = getParadigmaDocs();
    Documento doc = new Documento(titulo, contenido);
    doc.setAutor(logeado);
    logeado.getDocsCreados().add(doc);
    pDocs.getDocumentos().add(doc);
    System.out.println("Documento creado con exito");
  }

  /**
   * Método que permite compartir un documento al dueño de este
   * 
   * @param logeado         Usuario logeado
   * @param id              Id del documento
   * @param usuariosPermiso lista usuarios que se quiere dar el permiso
   * @param access          permiso otorgado [w|r|c]
   */
  public void share(Usuario logeado, Integer id, String[] usuariosPermiso, String access) {
    ParadigmaDocs pDocs = getParadigmaDocs();
    // Se comprueban los permisos
    if (!(access.equals("w") || access.equals("c") || access.equals("r"))) {
      System.out.println("El permiso ingresado no es del tipo [w, r, c]");
      return;
    }
    for (int i = 0; i < logeado.getDocsCreados().size(); i++) {
      if (logeado.getDocsCreados().get(i).getId() == id) {
        for (int k = 0; k < usuariosPermiso.length; k++) {
          for (int j = 0; j < pDocs.getUsuarios().size(); j++) {
            if (pDocs.getUsuarios().get(j).getUsername().equals(usuariosPermiso[k])
                && !usuariosPermiso[k].equals(logeado.getUsername())) {
              Acceso acceso = new Acceso(pDocs.getUsuarios().get(j), access);
              logeado.getDocsCreados().get(i).getAccesses().add(acceso);
              pDocs.getUsuarios().get(j).getDocsAcceso().add(logeado.getDocsCreados().get(i));
              System.out.println("Permiso concedido a " + usuariosPermiso[k]);
            }
          }
        }
      }
    }
  }

  /**
   * Método que determina si un usuario es editor de un documento mediante su id
   * 
   * @param logeado Usuario logeado
   * @param id      Id del documento
   * @return boolean
   */
  public boolean isEditor(Usuario logeado, Integer id) {
    for (int i = 0; i < logeado.getDocsAcceso().size(); i++) {
      if (logeado.getDocsAcceso().get(i).getId() == id) {
        for (int j = 0; j < logeado.getDocsAcceso().get(i).getAccesses().size(); j++) {
          if (logeado.getDocsAcceso().get(i).getAccesses().get(i).getUser().equals(logeado)) {
            if (logeado.getDocsAcceso().get(i).getAccesses().get(i).getPermiso().equals("w")) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  /**
   * Método que permite añadir texto a una version del documento, se requiere
   * permiso de edición.
   * 
   * @param logeado   Usuario logeado
   * @param idd       Id del documento
   * @param contenido Contenido del documento
   */

  public void add(Usuario logeado, Integer id, String contenido) {
    if (getIndexDocCreados(id, logeado) != -1) {
      String contenidoAnt = logeado.getDocsCreados().get(getIndexDocCreados(id, logeado)).getContenido();
      String contenidoMod = contenidoAnt.concat(contenido);
      Version version = new Version(contenidoMod);
      version.setId(logeado.getDocsCreados().get(getIndexDocCreados(id, logeado)).getHistorial().size());
      logeado.getDocsCreados().get(getIndexDocCreados(id, logeado)).getHistorial().add(version);
      logeado.getDocsCreados().get(getIndexDocCreados(id, logeado)).setContenido(contenidoMod);
      System.out.println("Se agrego " + contenido + " en documento id(" + id + ")");
      return;
    }
    if (isEditor(logeado, id)) {
      String contenidoAnta = logeado.getDocsAcceso().get(getIndexDocAcceso(id, logeado)).getContenido();
      String contenidoModi = contenidoAnta.concat(contenido);
      Version version = new Version(contenidoModi);
      version.setId(logeado.getDocsAcceso().get(getIndexDocAcceso(id, logeado)).getHistorial().size());
      logeado.getDocsAcceso().get(getIndexDocAcceso(id, logeado)).getHistorial().add(version);
      logeado.getDocsAcceso().get(getIndexDocAcceso(id, logeado)).setContenido(contenidoModi);
      System.out.println("Se agrego " + contenido + " en documento id(" + id + ")");
      return;
    }
    System.out.println("Operacion no exitosa");
    return;
  }

  /**
   * Método que convierte toda la plataforma de paradigmadocs a String
   * 
   * @return StringBuilder
   */
  public StringBuilder pDocsToString() {
    StringBuilder string = new StringBuilder();
    string.append("* * * * * * * * * * ParadigmaDocs * * * * * * * * * *\n\n");
    string.append("-> Usuarios registrados:");
    for (int i = 0; i < paradigmaDocs.getUsuarios().size(); i++) {
      string
          .append(
              "\n\tUsuario: " + paradigmaDocs.getUsuarios().get(i).getUsername() + " miebro desde ["
                  + paradigmaDocs
                      .getUsuarios().get(i).getFecha()
                  + "]");
    }
    string.append("\n\n-> Documentos:");
    for (int j = 0; j < paradigmaDocs.getDocumentos().size(); j++) {
      string.append("\n\t* * * * * " + paradigmaDocs.getDocumentos().get(j).getTitulo() + " id("
          + paradigmaDocs.getDocumentos().get(j).getId() + ") * * * * * ");

      string.append("\nCreado por " + paradigmaDocs.getDocumentos().get(j).getAutor().getUsername() + " el ["
          + paradigmaDocs.getDocumentos().get(j).getFecha() + "]");

      string.append("\n" + paradigmaDocs.getDocumentos().get(j).getContenido() + "\nVersiones:");
      for (int i = 0; i < paradigmaDocs.getDocumentos().get(j).getHistorial().size(); i++) {
        string.append("\n\t(" + paradigmaDocs.getDocumentos().get(j).getHistorial().get(i).getId() + ") "
            + paradigmaDocs.getDocumentos().get(j).getHistorial().get(i).getContenido());
      }
      string
          .append("\n-> Permisos ");// String Permisos
      for (int k = 0; k < paradigmaDocs.getDocumentos().get(j).getAccesses().size(); k++) {
        string
            .append("\n\t" + paradigmaDocs
                .getDocumentos().get(j).getAccesses().get(k).getUser().getUsername()
                + " -> " + paradigmaDocs.getDocumentos().get(j).getAccesses().get(k).accessToString());
      }
    }
    return string;
  }

  /**
   * Metodo que convierte a string todos los documentos creados o compartidos a un
   * String ententidble por el usuario
   * 
   * @param logeado Usuario logeado
   * @return StringBuilder
   */
  public StringBuilder editorString(Usuario logeado) {
    StringBuilder editorString = new StringBuilder();
    editorString.append("* * * * * * * * * * " + logeado.getUsername() + " * * * * * * * * * *\n" + "Miembro desde ["
        + logeado.getFecha() + "]");
    for (int i = 0; i < logeado.getDocsCreados().size(); i++) { // String Version Activa
      editorString.append("\n\t* * * * * " + logeado.getDocsCreados().get(i).getTitulo() + " id("
          + logeado.getDocsCreados().get(i).getId() + ") * * * * * \n"
          + logeado.getDocsCreados().get(i).getContenido());

      for (int j = 0; j < logeado.getDocsCreados().get(i).getHistorial().size(); j++) { // String Versiones
        editorString.append("\n(" + logeado
            .getDocsCreados().get(i).getHistorial().get(j).getId() + ") "
            + logeado.getDocsCreados().get(i).getHistorial().get(j).getContenido() + " ["
            + logeado.getDocsCreados().get(i).getFecha() + "]");
        for (int j2 = 0; j2 < logeado.getDocsCreados().get(i).getHistorial().get(j).getComentarios().size(); j2++) {
          editorString
              .append("\n\t"
                  + logeado.getDocsCreados().get(i).getHistorial().get(j).getComentarios().get(i).toString());
        }
      }
      editorString.append("\n-> Permisos");
      for (int j = 0; j < logeado.getDocsCreados().get(i).getAccesses().size(); j++) {
        editorString.append("\n\t" + logeado.getDocsCreados().get(i).getAccesses().get(j).getUser().getUsername()
            + " -> " + logeado.getDocsCreados().get(i).getAccesses().get(j).accessToString());
      }
    }
    editorString.append("\nDocumentos con acceso: ");
    for (int i = 0; i < logeado.getDocsAcceso().size(); i++) {// String Version Activa
      editorString
          .append("\n\t* * * * * " + logeado.getDocsAcceso().get(i).getTitulo() + " id("
              + logeado.getDocsAcceso().get(i).getId() + ") * * * * * ");
      editorString
          .append("\nAutor: " + logeado.getDocsAcceso().get(i).getAutor().getUsername());
      editorString
          .append("\n" + logeado.getDocsAcceso().get(i).getContenido());
      for (int j = 0; j < logeado.getDocsAcceso().get(i).getHistorial().size(); j++) {// String Versiones
        editorString
            .append("\n(" + logeado
                .getDocsAcceso().get(i).getHistorial().get(j).getId() + ") "
                + logeado.getDocsAcceso().get(i).getHistorial().get(j).getContenido() + " ["
                + logeado.getDocsAcceso().get(i).getFecha() + "]"
                + logeado.getDocsAcceso().get(i).getHistorial().get(j).getComentarios().toString());
      }
      editorString
          .append("\n-> Permisos ");// String Permisos
      for (int j = 0; j < logeado.getDocsAcceso().get(i).getAccesses().size(); j++) {
        editorString
            .append("\n\t" + logeado.getDocsAcceso().get(i).getAccesses().get(j).getUser().getUsername()
                + " -> " + logeado.getDocsAcceso().get(i).getAccesses().get(j).accessToString());
      }
    }
    return editorString;
  }

  /**
   * Método que obtiene el indice de la lista de documentos con acceso del usuario
   * 
   * @param id      Id del documento
   * @param logeado Usuario logeado
   * @return Integer
   */
  public Integer getIndexDocAcceso(Integer id, Usuario logeado) {
    for (int i = 0; i < logeado.getDocsAcceso().size(); i++) {
      if (logeado.getDocsAcceso().get(i).getId().equals(id)) {
        return i;
      }
    }
    return -1; // Retorna -1 cuando no encuentra el documento
  }

  /**
   * Método que obtiene el indice de la lista de documentos que el usuario es
   * dueño
   * 
   * @param id      Id del documento
   * @param logeado Usuario logeado
   * @return Integer
   */
  public Integer getIndexDocCreados(Integer id, Usuario logeado) {
    for (int i = 0; i < logeado.getDocsCreados().size(); i++) {
      if (logeado.getDocsCreados().get(i).getId().equals(id)) {
        return i;
      }
    }
    return -1;
  }
}
