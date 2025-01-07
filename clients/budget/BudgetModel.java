package clients.budget;

import catalogue.Basket;
import catalogue.BetterBasket;
import catalogue.Product;
import debug.DEBUG;
import middle.*;
import clients.budget.*;

import java.util.Observable;

/**
 * 
 */
public class BudgetModel extends Observable
{

  private StockReadWriter theStock     = null;

  /**
   * Construct the model of the Cashier
   * @param mf The factory to create the connection objects
   */

  public BudgetModel(MiddleFactory mf)
  {
    try                                           // 
    {      
      theStock = mf.makeStockReadWriter();        // Database access
    } catch ( Exception e )
    {
      DEBUG.error("BudgetModel.constructor\n%s", e.getMessage() );
    }
  }
  

  /**
   * Check if the product is in Stock
   * @param productNum The product number
   */
  public void doCheck(int theInputs )
  {
	String theAction = "";
    try
    {
      if ( theInputs > 0)              
      {                                         // T
    	  Product pr1 = theStock.getDetails("0001");   //  Get details
    	  Product pr2 = theStock.getDetails("0002");
    	  Product pr3 = theStock.getDetails("0003");
    	  Product pr4 = theStock.getDetails("0004");
    	  Product pr5 = theStock.getDetails("0005");
    	  Product pr6 = theStock.getDetails("0006");
    	  Product pr7 = theStock.getDetails("0007");                                  //  T
          theAction = 
        		("You can buy " + (int) (theInputs/pr1.getPrice()) + " " + pr1.getDescription() + " \n"
          		+"You can buy " + (int) (theInputs/pr2.getPrice()) + " " + pr2.getDescription() + " \n"
        		+"You can buy " + (int) (theInputs/pr3.getPrice()) + " " + pr3.getDescription() + " \n"
          		+"You can buy " + (int) (theInputs/pr4.getPrice()) + " " + pr4.getDescription() + " \n"
          		+"You can buy " + (int) (theInputs/pr5.getPrice())+ " " + pr5.getDescription() + " \n"
          		+"You can buy " + (int) (theInputs/pr7.getPrice()) + " " + pr7.getDescription());
          
        } else if (theInputs < 0) {                                //  F
          theAction =                           
        		  "!!! Invalid amount";
        } else if (theInputs > 10000) {
        	theAction =
        			"!!! Over store limit";
        }else {
        	theAction = 
        			"Invalid input";
        }
    } catch( StockException e )
    {
      DEBUG.error( "%s\n%s", 
            "BudgetModel.doCheck", e.getMessage() );
      theAction = e.getMessage();
    }
    setChanged(); notifyObservers(theAction);
  }

  
  public void doClear()
  {
	  String theAction = "";
	    theAction = "Search deleted";       // Set display                           // No picture
	    setChanged(); notifyObservers(theAction);
  }

  /**
   * ask for update of view called at start of day
   * or after system reset
   */
  public void askForUpdate()
  {
    setChanged(); notifyObservers("Welcome");
  }
  

}
