package model;

public class Counter extends Observee {
	
	private static final int CounterInitialvalue = 0;
	
	private static Counter theCounter = null;
	
	public static Counter getTheCounter(){
		if(theCounter == null) theCounter = new Counter(CounterInitialvalue);
		return theCounter;
	}
	
	private int currentValue;
	
	private Counter(int value){
		this.currentValue = value;
	}
	public void up(){
		currentValue = this.getCurrentValue() + 1;
		this.notifyObservers();
	}
	public void down(){
		currentValue = getCurrentValue() - 1;
		this.notifyObservers();
	}
	public int getCurrentValue() {
		return this.currentValue;
	}
}
