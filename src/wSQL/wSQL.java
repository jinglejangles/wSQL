package wSQL;

import javax.swing.SwingUtilities;


public class wSQL {
	
	wSQL(){
		myView v = new myView();
		System.out.println("Are we on the EDT? " + SwingUtilities.isEventDispatchThread());	
		Controller c = new Controller();
		myModel m =  new myModel();
		m.addObserver(v);
		v.addController(c);
		c.setView(v);
	
	}
}
