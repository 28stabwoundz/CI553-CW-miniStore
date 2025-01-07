package clients.budget;

import catalogue.Basket;
import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockReadWriter;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


/**
 * View of the model 
 */
public class BudgetView implements Observer
{
  private static final int H = 300;       // Height of window pixels
  private static final int W = 400;       // Width  of window pixels
   
  private static final String CHECK  = "Check";
  private static final String DELETE = "Delete";
  private final JLabel      pageTitle  = new JLabel();
  private final JLabel      theAction  = new JLabel();
  //private final JTextField  theInput   = new JTextField();
  SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 100000, 10);
  private final JSpinner	theInputs  = new JSpinner(model);
  private final JTextField  theAmount   = new JTextField();
  public final JTextArea   theOutput  = new JTextArea();
  private final JScrollPane theSP      = new JScrollPane();
  private final JButton     theBtCheck = new JButton( CHECK );
  private final JButton     theBtDelete = new JButton( DELETE );

  private StockReadWriter theStock     = null;
  private OrderProcessing theOrder     = null;
  private BudgetController cont       = null;
  
  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param mf    Factor to deliver order and stock objects
   * @param x     x-coordinate of position of window on screen 
   * @param y     y-coordinate of position of window on screen  
   */
          
  public BudgetView(  RootPaneContainer rpc,  MiddleFactory mf, int x, int y  )
  {
    try                                           // 
    {      
      theStock = mf.makeStockReadWriter();        // Database access
      theOrder = mf.makeOrderProcessing();        // Process order
    } catch ( Exception e )
    {
      System.out.println("Exception: " + e.getMessage() );
    }
    Container cp         = rpc.getContentPane();    // Content Pane
    Container rootWindow = (Container) rpc;         // Root Window
    cp.setLayout(null);                             // No layout manager
    rootWindow.setSize( W, H );                     // Size of Window
    rootWindow.setLocation( x, y );
    Font f = new Font("Monospaced",Font.PLAIN,12);  // Font f is
    pageTitle.setBounds( 110, 0 , 270, 20 );      
    pageTitle.setText( "Welcome" );                        
    cp.add( pageTitle );  
    cp.setBackground(new java.awt.Color(186, 216, 182));					// Change colour
    
    theBtCheck.setBounds( 16, 25+60*0, 80, 40 );    // Check Button
    theBtCheck.addActionListener(                   // Call back code
      e -> cont.doCheck((Integer) theInputs.getValue()));
    theBtCheck.setForeground(Color.red);	
    cp.add( theBtCheck );                           //  Add to canvas


    theBtDelete.setBounds( 16, 25+60*1, 80, 40);
    theBtDelete.addActionListener(
    	e -> cont.doClear() );
    cp.add( theBtDelete);

    theAction.setBounds( 110, 25, 600, 20 );       // Message area
    theAction.setText( "Enter your budget below" );                        // Blank
    cp.add( theAction );                            //  Add to canvas

    /*theInput.setBounds( 110, 50, 270, 40 );         // Input Area
    theInput.setText("Input money here");                           // Blank
    theInput.setBackground(new java.awt.Color(225, 234, 205));
    theInput.setForeground(Color.gray);
    cp.add( theInput );                             //  Add to canvas
    */
    
    theInputs.setBounds(110, 50, 270, 40);                           // Blank
    theInputs.setBackground(new java.awt.Color(225, 234, 205));
    theInputs.setForeground(Color.gray);
    cp.add( theInputs );  
    
    
    theSP.setBounds( 110, 100, 270, 160 );          // Scrolling pane
    theOutput.setText( "" );                        //  Blank
    theOutput.setFont( f );                         //  Uses font
    theOutput.setBackground(new java.awt.Color(225, 234, 205));
    cp.add( theSP );                                //  Add to canvas
    theSP.getViewport().add( theOutput );           //  In TextArea
    rootWindow.setVisible( true );                  // Make visible
    theInputs.requestFocus();                        // Focus is here
  }

  /**
   * The controller object, used so that an interaction can be passed to the controller
   * @param c   The controller
   */

  public void setController( BudgetController c )
  {
    cont = c;
  }

  /**
   * Update the view
   * @param modelC   The observed model
   * @param arg      Specific args 
   */
  @Override
  public void update( Observable modelC, Object arg )
  {
    BudgetModel model  = (BudgetModel) modelC;
    String      message = (String) arg;
    String 		messages = (String) arg;
    theAction.setText( message );
    theOutput.setText( messages );
    
    theInputs.requestFocus();               // Focus is here
    
    if(message.equals("!!! Not enough money") || message.contains("Checked")) {}
    theInputs.setValue("1");
  }

}
