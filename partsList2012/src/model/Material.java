package model;
import java.util.Vector;


public class Material extends ComponentCommon {


	private static final String UnstructuredMaterialMessage = "Materialien haben kein Struktur!";
	public static Material create(String name, int price) {
		return new Material(name, price);
	}
	public Material(String name, int price) {
		super(name, price);
	}
	@Override
	public void addPart(Component part, int amount) throws Exception {
		throw new Exception(UnstructuredMaterialMessage);
	}
	@Override
	public boolean contains(Component component) {
		return false;
	}
	@Override
	public Vector<QuantifiedComponent> getDirectParts() {
		return new Vector<QuantifiedComponent>();
	}
	@Override
	public int getNumberOfMaterials() {
		return 1;
	}
	@Override
	public int getOverallPrice() {
		return this.getPrice();
	}

}
