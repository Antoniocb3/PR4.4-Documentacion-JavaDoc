package gestisimal.exceptions;


/**
 * Esta excepcion se lanza si el articulo "Warehouse" no existe
 * 
 * @author Antonio Carmona Bascon
 *
 */
public class WarehouseArticleNotExistsException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Se encarga de lanzar  la excepcion con el mensaje
   * 
   * @param msg mensaje de la excepcion
   */
  public WarehouseArticleNotExistsException(String msg) {
    super(msg);
    System.err.println(msg);
  }
}
