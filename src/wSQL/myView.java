package wSQL;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class myView extends JFrame implements 
	java.util.Observer,WindowListener {
	
	private static final long serialVersionUID = 1L;
	//final static boolean shouldFill = true;
    //final static boolean shouldWeightX = true;
    //final static boolean RIGHT_TO_LEFT = false;
    
    JButton b;
    private JTextField hostname;
    private JTextField username;
    private JPasswordField password;
	JMenu about;
    @Override
	public void update(Observable o, Object arg) {
		if (arg instanceof connectedView){
		
		}		
	}
	//Constructor for myView
	myView(){
		//super
		super("SQLVIEW");
		addWindowListener(this);
		 try {
			 //invoke and wait for creating the initial view
			 //Needed so it can run on the EDT Thread
			SwingUtilities.invokeAndWait(new Runnable(){
				
				public void run() {
					//is this on the dispatch thread?
					System.out.println("Are we on the EDT? " + 
							SwingUtilities.isEventDispatchThread());
					
					setJMenuBar(createMenuBar());
					addContent(getContentPane());
					//current default close operation
					//will change when a pop up menu is implemented 
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setSize(250, 230);
					setResizable(false);
					setVisible(true);
					System.out.println("Are we on the EDT? " + 
							SwingUtilities.isEventDispatchThread());	
				}
			 });
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
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
		
		/*if (RIGHT_TO_LEFT) {
			//pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}*/
		JMenuBar menuBar = new JMenuBar();
		about = new JMenu("About");
		menuBar.add(about);
	    pane.setLayout(new FlowLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    /*
	    if (shouldFill) {
	    	//natural height, maximum width
	    	//c.fill = GridBagConstraints.HORIZONTAL;
	    }*/
	    
	    //Hostname Label creation
	    
	    JLabel myLabel = new JLabel("Hostname: ");
	    //c.weightx = 0.1;
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 0;
	    //c.insets = new Insets(1,1,1,1);
	    pane.add(myLabel,c);   

	    //Textarea for Hostname input
	    
	    hostname = new JTextField();
	    //hostname.setMinimumSize(new Dimension(10,10));
	    //hostname.setMaximumSize(new Dimension(10,10));
	    hostname.setColumns(20);
	    pane.add(hostname, c);
	 
	    //Label for username
	    
	    JLabel myLabel2 = new JLabel("UserName: ");
	    pane.add(myLabel2);
	    
	    //Text area for username input
	    
	    username = new JTextField();
	    username.setColumns(20);
	    pane.add(username, c);
	 
	    //Label for Password
	    JLabel myLabel3 = new JLabel("Password:");
	    //c.insets = new Insets(2,2,2,2);
	    //c.weightx = 0.5;
	    //c.fill = GridBagConstraints.HORIZONTAL;
	    //c.gridx = 0;
	    //c.gridy = 2;	   
	    pane.add(myLabel3,c);
	    
	    
	    //Textfield entry for password
	    
	    password = new JPasswordField();
	    //c.fill = GridBagConstraints.HORIZONTAL;    
	    //c.weightx = 0.0;
	    //c.gridwidth = 3;
	    //c.gridx = 1;
	    //c.gridy = 2;
	    password.setColumns(20);
	    pane.add(password, c);
	    
	    //Attempt to Connect Button
	    b = new JButton("Connect");
	    pane.add(b, c);
	    
	    /**TODO add a text label below button to signify that you 
	     * 		are trying to connect
	     */
		
	    //System.out.println("Are we on the EDT? " + 
	    //SwingUtilities.isEventDispatchThread());	
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
		return new String(password.getPassword());
	}
	
	public JMenu getJMenu(){
		return about;
	}
	
	/*
	 * @Function:	createMenuBar()
	 * @paramL		None
	 * @Desc:		Returns the initial JMenuBar in use with j 
	 */
	
	private JMenuBar createMenuBar(){
		JMenuBar myMenu = new JMenuBar();
		JMenu file = new JMenu("File");
		myMenu.add(file);
		JMenuItem myAbout = new JMenuItem("About");
		JMenuItem exit =  new JMenuItem("Exit");
		file.add(myAbout);
		file.add(exit);
		return myMenu;
	}
	
	/*
	 * Extended JFrame override functions not used within the program 
	 */
	
	public void windowActivated(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0) {
		System.out.println("Goodbye");
		this.dispose();
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
}
