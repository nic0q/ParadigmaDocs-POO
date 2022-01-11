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

  public void create(String titulo, Usuario logeado, String contenido) {
    ParadigmaDocs pDocs = getParadigmaDocs();
    Documento doc = new Documento(titulo, contenido);
    doc.setAutor(logeado);
    logeado.getDocsCreados().add(doc);
    pDocs.getDocumentos().add(doc);
    System.out.println("Documento creado con exito");
  }

}