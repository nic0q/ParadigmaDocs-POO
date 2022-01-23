package ParadigmaDocs_Model;

import java.util.ArrayList;

public class Editor {
  private ArrayList<Usuario> usuarios;
  private ArrayList<Documento> documentos;
  private Usuario logeado;
  private boolean conectado = false;

  // Constructor
  public Editor() {
    this.usuarios = new ArrayList<>();
    this.documentos = new ArrayList<>();

    // Se crean 10 usuarios de forma inicial
    Usuario user1 = new Usuario("nico", "qwerty");
    Usuario user2 = new Usuario("kim", "1234");
    Usuario user3 = new Usuario("saul", "4321");
    Usuario user4 = new Usuario("chuck", "qwert");
    Usuario user5 = new Usuario("howard", "abc");

    usuarios.add(user1);
    usuarios.add(user2);
    usuarios.add(user3);
    usuarios.add(user4);
    usuarios.add(user5);

    // Se crea el documento 1 perteneciente a user1 "nico"
    Documento doc1 = new Documento("Informe 1", "Introduccion", user1);
    user1.getDocsCreados().add(doc1);
    documentos.add(doc1);

    // Se crea el documento 2 perteneciente a user2 "kim"
    Documento doc2 = new Documento("Articulo 3", "ContenidoABC", user2);
    user2.getDocsCreados().add(doc2);
    documentos.add(doc2);

    // Se crea el documento 3 perteneciente a user3 "saul"
    Documento doc3 = new Documento("Info Secreta", "SuperSecreto", user3);
    user3.getDocsCreados().add(doc3);
    documentos.add(doc3);

    // Se crea el documento 4 perteneciente a user4 "chuck"
    Documento doc4 = new Documento("Libro Magico", "Capitulo I", user4);
    user4.getDocsCreados().add(doc4);
    documentos.add(doc4);

    // Se crea el documento 5 perteneciente a user5 "howard"
    Documento doc5 = new Documento("Listado de Notas", "Paradigmas E1", user5);
    user5.getDocsCreados().add(doc5);
    documentos.add(doc5);

    // Se crea el documento 6 perteneciente a user1 "nico"
    Documento doc6 = new Documento("Informe 2", "Intro", user1);
    user1.getDocsCreados().add(doc6);
    documentos.add(doc6);

    // Se crea el documento 7 perteneciente a user1 "nico"
    Documento doc7 = new Documento("Periodico Anual", "Nota Periodistica 1", user2);
    user2.getDocsCreados().add(doc7);
    documentos.add(doc7);

    // Se crea el documento 8 perteneciente a user1 "nico"
    Documento doc8 = new Documento("Info aun mas secreta", "Team Secret", user3);
    user3.getDocsCreados().add(doc8);
    documentos.add(doc8);

    // Se crea el documento 9 perteneciente a user1 "nico"
    Documento doc9 = new Documento("Libro de Fantasia", "Prefacio", user4);
    user4.getDocsCreados().add(doc9);
    documentos.add(doc9);

    // Se crea el documento 10 perteneciente a user1 "nico"
    Documento doc10 = new Documento("Calificaciones Finales", "Seccion B1", user5);
    user4.getDocsCreados().add(doc10);
    documentos.add(doc10);

  }

  /**
   * @return ArrayList<Usuario>
   */
  public ArrayList<Usuario> getUsuarios() {
    return usuarios;
  }

  /**
   * @param usuarios
   */
  public void setUsuarios(ArrayList<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  /**
   * @return ArrayList<Documento>
   */
  public ArrayList<Documento> getDocumentos() {
    return documentos;
  }

  /**
   * @param documentos
   */
  public void setDocumentos(ArrayList<Documento> documentos) {
    this.documentos = documentos;
  }

  /**
   * @return Usuario logeado
   */
  public Usuario getLogeado() {
    return logeado;
  }

  /**
   * @param logeado usuario logeado
   */
  public void setLogeado(Usuario logeado) {
    this.logeado = logeado;
  }

  /**
   * @return boolean si esta conectado o no
   */
  public boolean isConectado() {
    return conectado;
  }

  /**
   * @param conectado boolean si esta conectado
   */
  public void setConectado(boolean conectado) {
    this.conectado = conectado;
  }

}
