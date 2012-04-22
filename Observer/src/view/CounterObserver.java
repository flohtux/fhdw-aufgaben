package view;

import model.Counter;
import model.Observer;

@SuppressWarnings("serial")
public class CounterObserver extends View implements Observer {
	
	public static CounterObserver createCounterObserver(){
		return new CounterObserver(Counter.getTheCounter());
	}
	
	private final Counter counter;
	public Counter getCounter() {
		return counter;
	}

	private int currentValue;
	
	private CounterObserver(Counter counter){
		this.counter = counter;
	}
	private void refresh(){
		this.currentValue = this.counter.getCurrentValue();
		super.refreshView(this.currentValue);
	}
	protected void deregister() {
		this.getCounter().deregister(this);
	}
	protected void register() {
		this.getCounter().register(this);
	}
	protected void down() {
		this.counter.down();
		this.refresh();
	}
	protected void up() {
		this.counter.up();
		this.refresh();
	}
	@Override
	public void update() {
		this.refresh();
		
	}
}
