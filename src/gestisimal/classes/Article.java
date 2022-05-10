
package gestisimal.classes;


import java.util.Objects;
import gestisimal.exceptions.ArticleIllegalArgumentException;

/**
 * Esta clase se usa para crear articulos
 * 
 * @author Antonio Carmona Bascon
 *
 */
public class Article {
  private static int lastCode = 0;
  private int code;
  private String name;
  private String brand;
  private double buyingPrice;
  private double sellingPrice;
  private int units;
  private int securityStock;
  private int maxStock;
  
  
  
  /**
   * Crea un articulo con los siguientes parámetros
   * 
   * @param name
   * @param brand
   * @param buyingPrice
   * @param sellingPrice
   * @param units
   * @param securityStock
   * @param maxStock
   */
  Article(String name, String brand, double buyingPrice, double sellingPrice, int units, int securityStock, int maxStock) {
    this.code = Article.lastCode++;
    setName(name);
    setBrand(brand);
    setBuyingPrice(buyingPrice);
    setSellingPrice(sellingPrice);
    setUnits(units);
    setSecurityStock(securityStock);
    setMaxStock(maxStock);
  }

  
  /**
   * Crea un articulo con los siguientes parámetros
   * 
   * @param name
   * @param brand
   * @param buyingPrice
   * @param sellingPrice
   * @param units
   */
  Article(String name, String brand, double buyingPrice, double sellingPrice, int units){
    this(name, brand, buyingPrice, sellingPrice, units, 0, 0);
  }

  /**
   * 
   */
  @Override
  public String toString() {
    return "Article [code=" + code + ", name=" + name + ", brand=" + brand + ", buyingPrice="
        + buyingPrice + ", sellingPrice=" + sellingPrice + ", units=" + units + ", securityStock="
        + securityStock + ", maxStock=" + maxStock + "]";
  }

  /**
   * Obtiene y devuelve el codigo del articulo
   * 
   * @return code
   */
  public int getCode() {
    return code;
  }
  
  /**
   * Cambia el código del articulo
   * @param code
   */
  void setCode(int code) {
    this.code = code;
  }

  /**
   * Obtiene y devuelve el nombre del articulo
   * 
   * @return name
   */
  String getName() {
    return name;
  }

  /**
   * Cambia el nombre del artículo
   * 
   * @param name
   */
  void setName(String name) {
    throwExceptionIfStringIsNotValid(name);
    this.name = name;
  }

  /**
   * Obtiene y devuelve la marca del articulo
   * 
   * @return brand
   */
  String getBrand() {
    return brand;
  }
  
  /**
   * Cambia la marca del artículo
   * 
   * @param brand
   */
  void setBrand(String brand) {
    throwExceptionIfStringIsNotValid(brand);
    this.brand = brand;
  }

  /**
   * Obtiene y devuelve el precio de compra del articulo
   * 
   * @return buyingPrice
   */
  double getBuyingPrice() {
    return buyingPrice;
  }

  /**
   * Cambia el precio de compra del artículo
   * 
   * @param buyingPrice
   */
  void setBuyingPrice(double buyingPrice){
    throwExceptionIfNegativePrice(buyingPrice);
    this.buyingPrice = buyingPrice;
  }

  /**
   * Obtiene y devuelve el precio de venta del articulo
   * 
   * @return sellingPrice
   */
  double getSellingPrice() {
    return sellingPrice;
  }

  /**
   * Cambia el precio de venta del artículo
   * 
   * @param sellingPrice
   */
  void setSellingPrice(double sellingPrice){
    throwExceptionIfNegativePrice(sellingPrice);
    this.sellingPrice = sellingPrice;
  }

  /**
   * Obtiene y devuelve las unidades del articulo
   * 
   * @return units
   */
  int getUnits() {
    return units;
  }

  /**
   * Cambia las unidades del articulo
   * 
   * @param units
   */
  void setUnits(int units) {
    throwsExceptionIfUnitsAreNegative(units);
    this.units = units;
  }
  
  /**
   * Aumenta las unidades del articulo
   * 
   * @param units
   */
  void increaseUnits(int units) {
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units += units;
  }

  /**
   * Disminuye las unidades del articulo
   * 
   * @param units
   */
  void decreaseUnits(int units){
    throwsExceptionIfArticleUnitsAreNegative(units);
    this.units -= units;
  }

  /**
   * Obtiene y devuelve el stock de seguridad del articulo
   * 
   * @return securityStock
   */
  int getSecurityStock() {
    return securityStock;
  }

  /**
   * Cambia el stock de seguridad del articulo
   * 
   * @param securityStock
   */
  void setSecurityStock(int securityStock) {
    this.securityStock = securityStock;
  }

  /**
   * Obtiene y devuelve el stock máximo del articulo
   * 
   * @return maxStock
   */
  int getMaxStock() {
    return maxStock;
  }

  /**
   * Cambia el stock máximo
   * 
   * @param maxStock
   */
  void setMaxStock(int maxStock) {
    this.maxStock = maxStock;
  }

  @Override
  public int hashCode() {
    return Objects.hash(brand, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Article other = (Article) obj;
    return Objects.equals(brand, other.brand) && Objects.equals(name, other.name);
  }
  
  /**
   * Comprueba si las unidades son negativas
   * 
   * @param units
   */
  private void throwsExceptionIfUnitsAreNegative(int units) {
    if(units < 0) {
      throw new ArticleIllegalArgumentException("Las unidades a modificar no pueden ser negativa");
    }
  }
  
  /**
   * Comprueba que el precio no puede ser negativo
   * 
   * @param buyingPrice
   */
  void throwExceptionIfNegativePrice(double buyingPrice) {
    if (buyingPrice < 0) {
      throw new ArticleIllegalArgumentException("El precio no puede ser negativo");
    }
  }

  /**
   * Comprueba que la cadena no puede ser null / no puede estar vacia
   * 
   * @param name
   */
  private void throwExceptionIfStringIsNotValid(String name) {
    if (name == null || name == "") {
      throw new ArticleIllegalArgumentException("La cadena no puede ser null o estar vacia.");
    }
  }
  
  /**
   * Comprueba que las unidades no pueden ser negativas
   * 
   * @param units
   */
  private void throwsExceptionIfArticleUnitsAreNegative(int units){
    if ((this.units-units) <= 0) {
      throw new ArticleIllegalArgumentException("Las unidades no pueden ser negativas.");
    }
  }
}
