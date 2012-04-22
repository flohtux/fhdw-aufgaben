package model;
import java.util.HashMap;
import java.util.Vector;


public class PartsList {
	
	private static final String DoubleDefinitionMessage = "Name bereits vorhanden!";

	public static PartsList create (){
		return new PartsList(new HashMap<String, Component>());
	}
	final private HashMap<String, Component> componentsMap;
	
	private PartsList(HashMap<String, Component> componentsMap){
		this.componentsMap = componentsMap;
	}

	private HashMap<String, Component> getComponentsMap(){
		return this.componentsMap;
	}
	public void createMaterial(String name, int price) throws Exception {
		if (this.getComponentsMap().containsKey(name))
			throw new Exception(DoubleDefinitionMessage);
		Material newMaterial = Material.create(name, price);
		this.getComponentsMap().put(name, newMaterial);
	}
	public void createProduct(String name, int price) throws Exception {
		if (this.getComponentsMap().containsKey(name))
			throw new Exception(DoubleDefinitionMessage);
		Product newProduct = Product.create(name, price);
		this.getComponentsMap().put(name, newProduct);
	}
	public void addPart(Component whole, Component part, int amount) throws Exception {
		whole.addPart(part,amount);
	}
	public int getPartCount(Component component) {
		return component.getNumberOfMaterials();
	}
	public Vector<Component> getComponents() {
		return new Vector<Component>(this.getComponentsMap().values());
	}
	public Vector<QuantifiedComponent> getParts(Component component) {
		return component.getDirectParts();
	}

	public Vector<QuantifiedComponent> getMaterialList(Component component) {
		//TODO implement getMaterialList !
		return new Vector<QuantifiedComponent>();
	}

	public String getOverallPrice(Component component) {
		return component.getOverallPrice() + "";
	}

	public void changePrice(Component component, int newPrice) {
		component.setPrice(newPrice);
	}
}
