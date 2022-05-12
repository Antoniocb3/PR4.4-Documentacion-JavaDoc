package gestisimal.exceptions;

/**
 * Esta excepcion se lanza si el articulo esta repetido
 * 
 * @author Antonio Carmona Bascon
 *
 */
public class WarehouseArticleRepeatedException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Se encarga de lanzar  la excepcion con el mensaje
   * 
   * @param msg mensaje de la excepcion
   */
  public WarehouseArticleRepeatedException(String msg) {
    super(msg);
    System.err.println(msg);
  }
}
