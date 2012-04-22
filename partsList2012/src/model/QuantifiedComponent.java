package model;

public class QuantifiedComponent {
	
	public static QuantifiedComponent createQuantifiedComponent (int quantity, Component component){
		return new QuantifiedComponent(quantity,component);
	}
	private int quantity;
	final private Component component;
	
	private QuantifiedComponent(int quantity, Component component){
		this.quantity = quantity;
		this.component = component;
	}

	public Component getComponent() {
		return component;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public boolean contains(Component part) {
		return this.getComponent().contains(part);
	}
	public String toString() {
		return this.getComponent().toString() + "(" + this.getQuantity() + ")";
	}

	public int getNumberOfMaterials() {
		return this.getComponent().getNumberOfMaterials() * this.getQuantity();
	}
}
