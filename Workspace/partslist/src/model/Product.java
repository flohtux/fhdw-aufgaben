
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Product extends model.Component implements PersistentProduct{
    
    
    public static PersistentProduct createProduct(String name) throws PersistenceException{
        return createProduct(name,false);
    }
    
    public static PersistentProduct createProduct(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newDelayedProduct(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newProduct(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentProduct createProduct(String name,boolean delayed$Persistence,PersistentProduct This) throws PersistenceException {
        PersistentProduct result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newDelayedProduct(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProductFacade
                .newProduct(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("parts", this.getParts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Product provideCopy() throws PersistenceException{
        Product result = this;
        result = new Product(this.name, 
                             this.currentState, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Product_PartsProxi parts;
    
    public Product(String name,PersistentState currentState,PersistentComponent This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentState)currentState,(PersistentComponent)This,id);
        this.parts = new Product_PartsProxi(this);        
    }
    
    static public long getTypeId() {
        return 104;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 104) ConnectionHandler.getTheConnectionHandler().theProductFacade
            .newProduct(name,this.getId());
        super.store();
        this.getParts().store();
        
    }
    
    public Product_PartsProxi getParts() throws PersistenceException {
        return this.parts;
    }
    public PersistentProduct getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProduct result = new ProductProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentProduct)this.This;
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(ComponentHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(ComponentHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getParts().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<PersistentQPart> iterator0 = getThis().getParts().iterator();
		while(iterator0.hasNext())
			if(((ComponentHierarchyHIERARCHY)iterator0.next()).containsComponentHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProduct)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$parts$$Product = strategy.initialize$$Product$$parts(getThis(), parameter);
		java.util.Iterator<?> iterator$$ = getThis().getParts().iterator();
		while (iterator$$.hasNext()){
			PersistentQPart current$$Field = (PersistentQPart)iterator$$.next();
			T current$$ = current$$Field.strategyComponentHierarchy(result$$parts$$Product, strategy);
			result$$parts$$Product = strategy.consolidate$$Product$$parts(getThis(), result$$parts$$Product, current$$);
		}
		return strategy.finalize$$Product(getThis(), parameter,result$$parts$$Product);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addComponent(final PersistentComponent newComponent, final long amount) 
				throws model.CycleException, PersistenceException{
        PersistentQPart found = getThis().getParts().findFirst(new Predcate<PersistentQPart>() {
			public boolean test(PersistentQPart argument) throws PersistenceException {
				return argument.getComponent().equals(newComponent);
			}
		});
        if (found == null){
	    	PersistentQPart qPart = QPart.createQPart(amount, newComponent);
	        getThis().getParts().add(qPart);
        } else {
        	found.setAmount(found.getAmount() + amount);
        }
        getThis().notifyChangedMateriallist();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setCurrentState(NotCached.createNotCached());
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void notifyChangedMateriallist() 
				throws PersistenceException{
        getThis().setCurrentState(NotCached.createNotCached());
        getThis().getPartOf().applyToAll(new Procdure<PersistentQPart>() {
			
			@Override
			public void doItTo(PersistentQPart argument) throws PersistenceException {
				argument.getMaster().notifyChangedMateriallist();
				
			}
		});
    }
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentMateriallist createMateriallist() 
				throws PersistenceException{
		final PersistentMateriallist m = Materiallist.createMateriallist();
    	getThis().getParts().applyToAll(new Procdure<PersistentQPart>() {
			public void doItTo(PersistentQPart argument) throws PersistenceException {
				m.addAll(argument.getComponent().fetchMateriallist().multiply(argument.getAmount()));
			}
		});
    	
    	return m;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
