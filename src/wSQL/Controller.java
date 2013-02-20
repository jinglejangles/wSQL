package wSQL;
import java.awt.event.ActionEvent;


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
			System.out.println("SUP NIGGA");
	}
}
