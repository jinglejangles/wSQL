package wSQL;

//import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
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
import javax.swing.JTextArea;
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
    JTextArea hostname;
    JTextArea username;
    JTextArea password;
	
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
					pack();
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
	 * addContent
	 * @param  - content pane 
	 * adds initial content pane for hostname/ip,login, and password
	 */
	private void addContent(Container pane){
		  if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        }
	 
	        JButton button;
	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    if (shouldFill) {
	    //natural height, maximum width
	    c.fill = GridBagConstraints.HORIZONTAL;
	    }
	 
	    b = new JButton("Button 1");
	    if (shouldWeightX) {
	    c.weightx = 0.5;
	    }
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    pane.add(b, c);
	 
	    button = new JButton("Button 2");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 0;
	    pane.add(button, c);
	 
	    button = new JButton("Button 3");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
	    pane.add(button, c);
	 
	    button = new JButton("Long-Named Button 4");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 40;      //make this component tall
	    c.weightx = 0.0;
	    c.gridwidth = 3;
	    c.gridx = 0;
	    c.gridy = 1;
	    pane.add(button, c);
	 
	    button = new JButton("5");
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.ipady = 0;       //reset to default
	    c.weighty = 1.0;   //request any extra vertical space
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.insets = new Insets(10,0,0,0);  //top padding
	    c.gridx = 1;       //aligned with button 2
	    c.gridwidth = 2;   //2 columns wide
	    c.gridy = 2;       //third row
	    pane.add(button, c);
		System.out.println("Are we on the EDT? " + SwingUtilities.isEventDispatchThread());	

	}
		
	public String getHostName(){
		return hostname.getText();
	}
	public String getUserName(){
		return username.getText();
		
	}
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

	public void addController(Controller c) {
		b.addActionListener(c);

	}
	
}
