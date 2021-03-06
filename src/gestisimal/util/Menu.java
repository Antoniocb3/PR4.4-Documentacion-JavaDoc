package gestisimal.util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Programa/clase menú que se implementa en otros programas
 * 
 * @author Antonio
 *
 */

public class Menu {

  private String cabecera;
  private String[] opciones;
  private Scanner sc = new Scanner(System.in);
  
  /**
   * Establece la cabecera para el menu
   * @param cabecera
   * @param opciones
   */
  public Menu(String cabecera, String ... opciones) {
    this.cabecera = cabecera;
    this.opciones = opciones;
  }
  
  /**
   * Establece la cabecera para el menu
   * 
   * @param cabecera
   */
  public void setCabecera(String cabecera) {
    this.cabecera = cabecera;
  }

  /**
   * Lee las opciones que el usuario ponga
   * @return option
   */
  private int leerOpciones() {
    System.out.print("Introduzca una opción (1-" + opciones.length + "): ");
    int option = sc.nextInt();
    sc.nextLine();  // sacamos el salto de línea del buffer de teclado
    System.out.println();
    return option;
  }
  
  /**
   * Comprueba que el usuario eliga una opción dentro del rango
   * 
   * @param opcion
   */
  public void remove(int opcion) { 
    if (opcion < 1 || opcion > this.opciones.length) {
      throw new IndexOutOfBoundsException("Opción seleccionada fuera del rango de opciones");
    }
    String[] opciones = Arrays.copyOf(this.opciones, this.opciones.length-1);
    for (int i = opcion; i < this.opciones.length; i++) {
      opciones[i-1] = this.opciones[i];
    }
    this.opciones = opciones;
  }
  
  /**
   * Permite al usuario elegir una opción
   * 
   * @return opcion
   */
  public int choose() {
    while (true) {
      if (cabecera != null && !cabecera.isEmpty()) {
        System.out.println(cabecera);
        System.out.println("-".repeat(cabecera.length()));
      }
      int aux = 0;
      for (String opcionDelMenu: this.opciones) {
        System.out.println(++aux + ". " + opcionDelMenu);
      }
      System.out.println();
      int opcion = leerOpciones();
      if (opcion >= 1 && opcion <= this.opciones.length) {
        return opcion;
      }
      System.out.println("Opción incorrecta. Pulse Intro para continuar...");
      sc.nextLine();
      System.out.println();
    }
  }  
  
  /**
   * Copia un array establecido anteriormente
   * 
   * @param opcion
   */
  public void add(String opcion) {
    String[] opcionesAux = Arrays.copyOf(this.opciones, this.opciones.length+1);
    opcionesAux[opcionesAux.length-1] = opcion;
    this.opciones = opcionesAux;
  }

  @Override
  public String toString() {
    return "Menu [title=" + cabecera + ", options=" + Arrays.toString(opciones) + "]";
  }

  /**
   * Devuelve la longitud de menu
   * 
   * @return opciones.length
   */
  public int lastOption() {
    return opciones.length;
  }

}