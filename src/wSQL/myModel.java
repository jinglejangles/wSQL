package wSQL;
import java.util.Observable;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class myModel extends Observable{
	
	private DBConImpl db;
	private JPanel modelPanel;
	
	public void hello(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void attemptConnect(String hostName, String userName, String pass) {
		db.setHostname(hostName);
		db.setUsername(userName);
		db.setPass(pass);
		if(db.attemptConnect()){
			buildConnectedPanel();
		}else{
			
		}
		
	}
	public myModel() {
		db = new DBConImpl();
	}

	public void runQuery() {
		// TODO Auto-generated method stub
		
	}
	private void buildConnectedPanel(){
		modelPanel = new JPanel();
		modelPanel.setLayout(new FlowLayout());
		GridBagConstraints c = new GridBagConstraints();
	    
	    //Hostname Section creation
	    JLabel myLabel = new JLabel("Connected to " + db.getHostname() + " under user: " + db.getUsername());
	    modelPanel.add(myLabel);
	   
	    JTextArea myTextArea = new JTextArea("THIS IS THE TEXT AREA");
	    myTextArea.setRows(20);
	    myTextArea.setColumns(50);
	    myTextArea.setEditable(false);
	    modelPanel.add(myTextArea);
	    JTextField hostname = new JTextField();
	    hostname.setColumns(20);
	    modelPanel.add(hostname);
		this.setChanged();
		this.notifyObservers(modelPanel);
	}
}
