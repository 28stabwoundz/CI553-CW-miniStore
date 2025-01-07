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
   * @param theInputs Budget client has put in
   */
  public void doCheck(int theInputs )
  {
    model.doCheck(theInputs);
  }

  /**
   * Clearing the search
   */
  public void doClear()
  {
	  model.doClear();	//Clearing the search
  }
  
}
