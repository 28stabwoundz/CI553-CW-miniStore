package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * BetterBasket is a better version of Basket, including a merge of the products 
 * instead of making the list longer, which saves space and also it will sort
 * the products by number.
 * @author  Francesca Yaxley
 * @version 1.0
 */
public class BetterBasket extends Basket
{
	/**
	 * Merging the total of one product instead of adding a new line
	 * @param pr Product client has bought
	 * @return return if true
	 */
	@Override
  	public boolean add( Product pr)
  	{
	  for(Product prInList: this) {
		  if(prInList.getProductNum().equals(pr.getProductNum())) {
			  int quantity = pr.getQuantity()+prInList.getQuantity();
			  prInList.setQuantity(quantity);
			  return (true);
		  }
	  }
		  super.add(pr);
		  Collections.sort(this, new SortByNum());
		  return(true);
  	}
}

