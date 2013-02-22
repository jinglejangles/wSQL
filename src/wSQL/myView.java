package wSQL;

//import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.Label;
//import java.awt.Panel;
//import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
//import javax.swing.JMenuBar;
import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;

public class myView extends JFrame implements java.util.Observer,WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    JButton b;
    JTextField hostname;
    JTextField username;
    JPasswordField password;
	
    @Override
	public void update(Observable o, Object arg) {
		if (arg instanceof connectedView){
		
		}		
	}
	
	myView(){
		super("SQLVIEW");
		
		 try {
			SwingUtilities.invokeAndWait(new Runnable(){

				public void run() {
					System.out.println("Are we on the EDT? " + SwingUtilities.isEventDispatchThread());
					addContent(getContentPane());
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setSize(250, 200);
					setResizable(false);
					setVisible(true);
					System.out.println("Are we on the EDT? " + SwingUtilities.isEventDispatchThread());	
				}
			 });
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);	
	}
	
	
	
	/*
	 * @Func:		addContent
	 * @param  		content pane 
	 * @Desc:		adds the initial content to the pane for the starting view
	 * 				The starting view contains labels and text areas for the 
	 * 				hostname/ip, login , and password
	 * 
	 */
	private void addContent(Container pane){
		if (RIGHT_TO_LEFT) {
			//pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
	 
	    pane.setLayout(new FlowLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    if (shouldFill) {
	    	//natural height, maximum width
	    	//c.fill = GridBagConstraints.HORIZONTAL;
	    }
	    
	    //Hostname Label creation
	    
	    JLabel myLabel = new JLabel("Hostname: ");
	    //c.weightx = 0.1;
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 0;
	    c.insets = new Insets(1,1,1,1);
	    pane.add(myLabel,c);
	    
	    //Submit Button
	    

	    //Textarea for Hostname input
	    
	    hostname = new JTextField();
	    //hostname.setMinimumSize(new Dimension(10,10));
	    //hostname.setMaximumSize(new Dimension(10,10));
	    hostname.setColumns(20);
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.weightx= 0.1;
	    //c.gridx = 1;
	    //c.gridy = 0;
	    pane.add(hostname, c);
	 
	    //Label for username
	    
	    JLabel myLabel2 = new JLabel("UserName: ");
	    //c.weightx = 0.5;
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 1;
	    pane.add(myLabel2,c);
	    
	    //Text area for username input
	    
	    username = new JTextField();
	    username.setColumns(20);
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.weightx = 0.5;
	    //c.gridx = 1;
	    //c.gridy = 1;
	    pane.add(username, c);
	 
	    JLabel myLabel3 = new JLabel("Password:");
	    c.insets = new Insets(2,2,2,2);
	    //c.weightx = 0.5;
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 2;
	    pane.add(myLabel3,c);
	    
	    
	    
	    password = new JPasswordField();
	    //c.fill = GridBagConstraints.HORIZONTAL;    
	    //c.weightx = 0.0;
	    //c.gridwidth = 3;
	    //c.gridx = 1;
	    //c.gridy = 2;
	    password.setColumns(20);
	    pane.add(password, c);
	 
	    /*
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.weighty = 1.0;   //request any extra vertical space
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(10,0,0,0);  //top padding
	    c.gridx = 1;       //aligned with button 2
	    c.gridwidth = 2;   //2 columns wide
	    c.gridy = 2;       //third row
	    pane.add(button, c);
		*/
	    
	    b = new JButton("Button 1");
	    if (shouldWeightX) {
	    	//c.weightx = 0.5;
	    }
	    
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 4;
	    pane.add(b, c);
	    
	    
		System.out.println("Are we on the EDT? " + SwingUtilities.isEventDispatchThread());	
	}
		

	/*
	 * @Function:	addController
	 * @param:		Controller c
	 * @desc:		sets an action listener for the connect button 
	 * 				and sends this action off to the controller for input
	 */
	
	public void addController(Controller c) {
		b.addActionListener(c);
	}
	
	//Getters for certain fields
	
	/*
	 * @Function:	getHostName()
	 * @param:		none
	 * @Desc:		returns Hostname text.		
	 */
	
	public String getHostName(){
		return hostname.getText();
	}
	/*
	 * @Function:	getUserName()
	 * @param:		None
	 * @Desc:		Returns Username text
	 */
	
	public String getUserName(){
		return username.getText();	
	}
	
	/*
	 * @Function:	getPass()
	 * @param:		None
	 * @Desc:		Returns Password text
	 */
	
	public String getPass(){
		return password.getText();
	}
	
	/*
	 * Extended JFrame override functions not used within the program 
	 */
	
	public void windowActivated(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
}
