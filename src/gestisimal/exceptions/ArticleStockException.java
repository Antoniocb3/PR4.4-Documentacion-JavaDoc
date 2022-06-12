package gestisimal.exceptions;

/**
 * Esta excepcion se lanza con respecto al stock del arcticulo
 * 
 * @author Antonio Carmona Bascon
 *
 */
public class ArticleStockException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Se encarga de lanzar la excepcion con el mensaje
   * 
   * @param msg mensaje de la excepcion
   */
  public ArticleStockException(String msg) {
    super(msg);
  }
}
