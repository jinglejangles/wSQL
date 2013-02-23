package wSQL;
import java.util.Observable;


public class myModel extends Observable{
	
	public void hello(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean attemptConnect(String hostName, String userName, String pass) {
		System.out.println("I got some" + hostName + "plus some " + userName + "secrectstuff " + pass);
		return true;
		
	}
}
