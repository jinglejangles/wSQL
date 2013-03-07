package wSQL;
import java.awt.event.ActionEvent;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class Controller implements java.awt.event.ActionListener{
	private myView view;
	private myModel model;
	
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
			model.attemptConnect(view.getHostName(),view.getUserName(),view.getPass());
		}
		if (e.getActionCommand()=="RunQuery"){
			System.out.println("Running Query");
			//model.runQuery();
		}
		
	}
}
