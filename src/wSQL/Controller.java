package wSQL;
import java.awt.event.ActionEvent;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class Controller implements java.awt.event.ActionListener{
	myView view;
	myModel model;
	
	Controller(){ }
	public void setView(myView view){
		this.view = view;
	}
	public void setModel(myModel model){
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="Connect"){	
			
		}else{
			System.out.println("PROBLEM?");
		}
	}
}
