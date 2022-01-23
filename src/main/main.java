package main;

import ParadigmaDocs_Controller.Controller;
import ParadigmaDocs_Model.*;
import ParadigmaDocs_View.Menu;

public class main {
  public static void main(String[] args) {
    Editor paradigmaDocs = new Editor();
    Controller controller = new Controller(paradigmaDocs);
    Menu menu = new Menu(controller);
    menu.menu();
    return;
  }
}
