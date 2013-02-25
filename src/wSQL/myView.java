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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class myView extends JFrame implements 
	java.util.Observer,WindowListener {
	
	private static final long serialVersionUID = 1L;
    private JButton b;
    private JTextField hostname;
    private JTextField username;
    private JPasswordField password;
	private JMenu about;
	private JPanel myPanel;
	
    @Override
	public void update(Observable o, Object arg) {
		if(arg instanceof JPanel){
			myPanel = (JPanel)arg;
		}
	}
	//Constructor for myView
	myView(){
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
					add(addPanel());
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
		 
		 //test functions for removal of current showing panel
		 
		 
		 //remove(myPanel);
		 //revalidate();
		 //repaint();
	}
	
	
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);	
	}
	
	/*
	 * @Func:		addPanel
	 * @param  		none 
	 * @Desc:		adds the initial content to the JPanel for the starting view
	 * 				The starting view contains labels and text areas for the 
	 * 				hostname/ip, login , and password
	 * 
	 */
	
	private JPanel addPanel(){
	    
		myPanel = new JPanel();
		myPanel.setLayout(new FlowLayout());
		GridBagConstraints c = new GridBagConstraints();
	    
	    //Hostname Section creation
	    JLabel myLabel = new JLabel("Hostname: ");
	    myPanel.add(myLabel);
	    hostname = new JTextField();
	    hostname.setColumns(20);
	    myPanel.add(hostname);
	 
	    //Username Section creation
	    JLabel myLabel2 = new JLabel("UserName: ");
	    myPanel.add(myLabel2);
	    username = new JTextField();
	    username.setColumns(20);
	    myPanel.add(username);
	    
	    //Password Section creation
	    JLabel myLabel3 = new JLabel("Password:");
	    myPanel.add(myLabel3);
	    password = new JPasswordField();
	    password.setColumns(20);
	    myPanel.add(password);
	    
	    //Button for connecting to database
	    b = new JButton("Connect");
	    myPanel.add(b);
	    
	    
	    /**TODO add a text label below button to signify that you 
	     * 		are trying to connect
	     */
	    
	    return myPanel;
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
	/*
	 * @Function:	getJMenu()
	 * @param:		none
	 * @Desc:		returns the about JMenu option used in conjunction with a
	 * 				listener so a pop up box will appear containing information
	 * 				about the program
	 */
	
	public JMenu getJMenu(){
		return about;
	}
	
	/*
	 * @Function:	createMenuBar()
	 * @paramL		None
	 * @Desc:		Returns the initial JMenuBar for the view 
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
	
	public void windowClosing(WindowEvent arg0) {
		System.out.println("Goodbye");
		this.dispose();
		System.exit(0);
	}
	/*
	 * Extended JFrame override functions not used within the program 
	 */
	public void windowActivated(WindowEvent arg0){}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
}
