package model;

import model.visitor.StateReturnVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentCached;
import persistence.PersistentComponent;
import persistence.PersistentMaterial;
import persistence.PersistentNotCached;
import persistence.PersistentProduct;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}
	
	@Override
	public void handleProduct(PersistentProduct product)
			throws PersistenceException {
		this.handleComponent(product);
	}
	
	@Override
	public void handleMaterial(PersistentMaterial material)
			throws PersistenceException {
		this.handleComponent(material);
	}
	
	public void handleComponent(PersistentComponent comp) throws PersistenceException {
		result = comp.getCurrentState().accept(new StateReturnVisitor<Integer>() {

			@Override
			public Integer handleNotCached(PersistentNotCached notCached)
					throws PersistenceException {
				return common.ViewConstants.COMPONENT_NOT_CACHED_ICON;
			}

			@Override
			public Integer handleCached(PersistentCached cached)
					throws PersistenceException {
				return common.ViewConstants.COMPONENT_CACHED_ICON;
			}
		});
	}
	

}
