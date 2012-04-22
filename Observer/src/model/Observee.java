package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class Observee {
	private final Collection<Observer> observers;
	
	public Observee() {
		this.observers = new ArrayList<Observer>();
	}
	
	public void register(Observer o) {
		this.getObservers().add(o);
	}
	public void deregister(Observer o) {
		this.getObservers().remove(o);
	}
	
	public void notifyObservers() {
		Iterator<Observer> obs = this.getObservers().iterator();
		while (obs.hasNext()) {
			Observer current = obs.next();
			current.update();
		}
	}

	public Collection<Observer> getObservers() {
		return observers;
	}
}
