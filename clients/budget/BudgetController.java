package clients.budget;

import clients.budget.BudgetModel;
import clients.budget.BudgetView;

/**
 * The Budget Controller
 */

public class BudgetController
{
  private BudgetModel model = null;
  private BudgetView  view  = null;

  /**
   * Constructor
   * @param model The model 
   * @param view  The view from which the interaction came
   */
  public BudgetController( BudgetModel model, BudgetView view )
  {
    this.view  = view;
    this.model = model;
  }

  /**
   * Check interaction from view
   * @param pn The product number to be checked
   */
  public void doCheck(int theInputs )
  {
    model.doCheck(theInputs);
  }


  public void doClear()
  {
	  model.doClear();
  }
  
}
