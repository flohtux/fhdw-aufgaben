package model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


public class Product extends ComponentCommon {

	private static final String CycleMessage = "Zyklen sind in der Aufbaustruktur nicht erlaubt!";

	public static Product create(String name) {
		return new Product(name,new HashMap<String, QuantifiedComponent>());
	}
	private final HashMap<String,QuantifiedComponent> components;
	
	protected Product(String name, HashMap<String,QuantifiedComponent> components) {
		super(name);
		this.components = components;
	}

	public void addPart(Component part, int amount) throws Exception{
		if (part.contains(this))throw new Exception(CycleMessage);
		final String partName = part.getName();
		if (this.getComponents().containsKey(partName)){
			final QuantifiedComponent oldQuantification = this.getComponents().get(partName); 
			oldQuantification.setQuantity(oldQuantification.getQuantity() + amount);
		}else{
			this.getComponents().put(partName, QuantifiedComponent.createQuantifiedComponent(amount, part));
		}
	}

	private HashMap<String,QuantifiedComponent> getComponents() {
		return this.components;
	}

	public boolean contains(Component component) {
		if (this.equals(component)) return true;
		Iterator<QuantifiedComponent> i = this.getComponents().values().iterator();
		while (i.hasNext()){
			QuantifiedComponent current = i.next();
			if (current.contains(component))return true;
		}
		return false;
	}

	public Vector<QuantifiedComponent> getDirectParts() {
		return new Vector<QuantifiedComponent>(this.getComponents().values());
	}

	public int getNumberOfMaterials() {
		int result = 0;
		Iterator<QuantifiedComponent> i = this.getComponents().values().iterator();
		while (i.hasNext()){
			QuantifiedComponent current = i.next();
			result = result + current.getNumberOfMaterials();
		}
		return result;
	}


}
