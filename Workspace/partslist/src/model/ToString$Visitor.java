package model;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentCached;
import persistence.PersistentMaterial;
import persistence.PersistentMateriallist;
import persistence.PersistentMateriallistValue;
import persistence.PersistentNotCached;
import persistence.PersistentPartsListManager;
import persistence.PersistentProduct;
import persistence.PersistentQPart;
import persistence.PersistentServer;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private String result;
	
	public ToString$Visitor() {
	}
	public synchronized String toString(Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		return result;
	}
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}
	@Override
	public void handlePartsListManager(
			PersistentPartsListManager partsListManager)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleProduct(PersistentProduct product)
			throws PersistenceException {
		result = "Produkt: " + product.getName();
		
	}
	@Override
	public void handleQPart(PersistentQPart qPart) throws PersistenceException {
		result = qPart.getAmount() + ";" + qPart.getComponent().toString(true);
		
	}
	@Override
	public void handleMaterial(PersistentMaterial material)
			throws PersistenceException {
		result = "Material: " + material.getName();
		
	}
	@Override
	public void handleServer(PersistentServer server)
			throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleMateriallist(PersistentMateriallist materiallist)
			throws PersistenceException {
		result = "Materialliste";
		
	}
	@Override
	public void handleMateriallistValue(
			PersistentMateriallistValue materiallistValue)
			throws PersistenceException {
		result = materiallistValue.getAmount() + ";" + materiallistValue.getMaterial().toString(true);
	}
	@Override
	public void handleNotCached(PersistentNotCached notCached)
			throws PersistenceException {
		result = "not cached";
		
	}
	@Override
	public void handleCached(PersistentCached cached)
			throws PersistenceException {
		result=  "cached";
		
	}

}
