package gestisimal.exceptions;

/**
 * Esta excepcion se lanza si el argumento introducido es ilegal
 * 
 * @author Antonio Carmona Bascon
 *
 */
public class ArticleIllegalArgumentException extends RuntimeException {

  private static final long serialVersionUID = 1L;
/**
 * Se encarga de lanzar  la excepcion con el mensaje
 * 
 * @param msg mensaje de la excepcion
 */
  public ArticleIllegalArgumentException(String msg) {
    super(msg);
  }
}
