package wSQL;
import java.util.Observable;


public class myModel extends Observable{
	
	public void hello(){
		this.setChanged();
		this.notifyObservers();
	}
}
