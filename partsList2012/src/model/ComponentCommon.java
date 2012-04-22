package model;


public abstract class ComponentCommon implements Component {

	private final String name;
	private int price;

	protected ComponentCommon(String name, int price) {
		this.name = name;
		this.setPrice(price);
	}

	@Override
	public String getName() {
		return name;
	}
	@Override
	public String toString(){
		return this.getName();
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
