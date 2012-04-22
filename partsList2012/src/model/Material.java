package model;
import java.util.Vector;


public class Material extends ComponentCommon {


	private static final String UnstructuredMaterialMessage = "Materialien haben kein Struktur!";
	public static Material create(String name) {
		return new Material(name);
	}
	public Material(String name) {
		super(name);
	}
	public void addPart(Component part, int amount) throws Exception {
		throw new Exception(UnstructuredMaterialMessage);
	}
	public boolean contains(Component component) {
		return false;
	}
	public Vector<QuantifiedComponent> getDirectParts() {
		return new Vector<QuantifiedComponent>();
	}
	public int getNumberOfMaterials() {
		return 1;
	}

}
