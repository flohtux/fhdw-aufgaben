package model;


public abstract class ComponentCommon implements Component {

	private final String name;

	protected ComponentCommon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public String toString(){
		return this.getName();
	}

}
