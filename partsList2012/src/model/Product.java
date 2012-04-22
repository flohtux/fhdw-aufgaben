package model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;


public class Product extends ComponentCommon {

	private static final String CycleMessage = "Zyklen sind in der Aufbaustruktur nicht erlaubt!";

	public static Product create(String name, int price) {
		return new Product(name,price,new HashMap<String, QuantifiedComponent>());
	}
	private final HashMap<String,QuantifiedComponent> components;
	
	protected Product(String name, int price, HashMap<String,QuantifiedComponent> components) {
		super(name, price);
		this.components = components;
	}

	@Override
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

	@Override
	public boolean contains(Component component) {
		if (this.equals(component)) return true;
		Iterator<QuantifiedComponent> i = this.getComponents().values().iterator();
		while (i.hasNext()){
			QuantifiedComponent current = i.next();
			if (current.contains(component))return true;
		}
		return false;
	}

	@Override
	public Vector<QuantifiedComponent> getDirectParts() {
		return new Vector<QuantifiedComponent>(this.getComponents().values());
	}

	@Override
	public int getNumberOfMaterials() {
		int result = 0;
		Iterator<QuantifiedComponent> i = this.getComponents().values().iterator();
		while (i.hasNext()){
			QuantifiedComponent current = i.next();
			result = result + current.getNumberOfMaterials();
		}
		return result;
	}

	@Override
	public int getOverallPrice() {
		int overallPrice = 0;
		overallPrice += this.getPrice();
		Iterator<QuantifiedComponent> comp = this.getDirectParts().iterator();
		while (comp.hasNext()) {
			QuantifiedComponent current = comp.next();
			overallPrice += current.getQuantity() * current.getComponent().getOverallPrice();
		}
		return overallPrice;
	}


}
