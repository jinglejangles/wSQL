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
			System.out.println("Attempting to Connect:");
			if (model.attemptConnect(view.getHostName(),view.getUserName(),view.getPass()));
			System.out.println("Changing view");
		}else{
			System.out.println("PROBLEM?");
		}
	}
}
