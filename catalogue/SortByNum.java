package catalogue;
import java.util.Comparator;

/**
 * Sorts the products by number in the basket
 * @author  Francesca Yaxley University of Brighton
 * @version 1.0
 */


public class SortByNum implements Comparator<Product>{
	/**
	 *Compares the products by number
	 * @param p1 Product one in the list
	 * @param p2 Product two in the list
	 * @return products in correct order
	 */
	@Override
	public int compare(Product p1,Product p2) {
		return p1.getProductNum().compareTo(p2.getProductNum()); //Comparing the product numbers
	}
}
