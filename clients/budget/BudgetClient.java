package clients.budget;

import catalogue.*;
import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

/**
 * The standalone Budget Client.
 */

public class BudgetClient
{
   public static void main (String args[])
   {
     
    RemoteMiddleFactory mrf = new RemoteMiddleFactory();       //
    displayGUI(mrf);                       // Create GUI
  }

/**
 * 
 * @param mf
 */
  private static void displayGUI(MiddleFactory mf)
  {     
    JFrame  window = new JFrame();
     
    window.setTitle( "Budget Client (MVC RMI)");
    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    BudgetModel      model = new BudgetModel(mf);
    BudgetView       view  = new BudgetView( window, mf, 0, 0 );
    BudgetController cont  = new BudgetController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    window.setVisible(true);         // Display Screen
    model.askForUpdate();
  }
}
