
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class QPart extends PersistentObject implements PersistentQPart{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentQPart getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theQPartFacade.getClass(objectId);
        return (PersistentQPart)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentQPart createQPart(long amount,PersistentComponent component) throws PersistenceException, CycleException{
        return createQPart(amount,component,false);
    }
    
    public static PersistentQPart createQPart(long amount,PersistentComponent component,boolean delayed$Persistence) throws PersistenceException, CycleException {
        PersistentQPart result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQPartFacade
                .newDelayedQPart(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQPartFacade
                .newQPart(amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("component", component);
        try{
            result.initialize(result, final$$Fields);
            result.initializeOnCreation();            
        }catch(persistence.PersistenceExceptionCycleTunnel ce){
            throw ce.cycleException;
        }
        return result;
    }
    
    public static PersistentQPart createQPart(long amount,PersistentComponent component,boolean delayed$Persistence,PersistentQPart This) throws PersistenceException, CycleException {
        PersistentQPart result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theQPartFacade
                .newDelayedQPart(amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theQPartFacade
                .newQPart(amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("amount", amount);
        final$$Fields.put("component", component);
        try{
            result.initialize(This, final$$Fields);
            result.initializeOnCreation();            
        }catch(persistence.PersistenceExceptionCycleTunnel ce){
            throw ce.cycleException;
        }
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("amount", new Long(this.getAmount()).toString());
            AbstractPersistentRoot component = (AbstractPersistentRoot)this.getComponent();
            if (component != null) {
                result.put("component", component.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    component.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && component.hasEssentialFields())component.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot master = (AbstractPersistentRoot)this.getMaster();
            if (master != null) {
                result.put("master", master.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    master.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && master.hasEssentialFields())master.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public QPart provideCopy() throws PersistenceException{
        QPart result = this;
        result = new QPart(this.amount, 
                           this.component, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long amount;
    protected PersistentComponent component;
    protected PersistentQPart This;
    
    public QPart(long amount,PersistentComponent component,PersistentQPart This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.amount = amount;
        this.component = component;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 105) ConnectionHandler.getTheConnectionHandler().theQPartFacade
            .newQPart(amount,this.getId());
        super.store();
        if(this.getComponent() != null){
            this.getComponent().store();
            ConnectionHandler.getTheConnectionHandler().theQPartFacade.componentSet(this.getId(), getComponent());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theQPartFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theQPartFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public PersistentComponent getComponent() throws PersistenceException {
        return this.component;
    }
    public void setComponent(PersistentComponent newValue) throws PersistenceException , model.CycleException{
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.containsComponentHierarchy(getThis())) throw new model.CycleException("Cycle in ComponentHierarchy detected!");
        if(newValue.equals(this.component)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.component = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQPartFacade.componentSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentQPart newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentQPart)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theQPartFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentQPart getThis() throws PersistenceException {
        if(this.This == null){
            PersistentQPart result = new QPartProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentQPart)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    public void accept(ComponentHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(ComponentHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(ComponentHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(ComponentHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQPart(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQPart(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQPart(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQPart(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsComponentHierarchy(final ComponentHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		if(getThis().getComponent() != null && getThis().getComponent().containsComponentHierarchy(part)) return true;
		return false;
    }
    public PersistentProduct getMaster() 
				throws PersistenceException{
        PersistentProduct result = null;
		try {
			if (result == null) result = (PersistentProduct)ConnectionHandler.getTheConnectionHandler().theProductFacade
							.inverseGetParts(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentQPart)This);
		if(this.equals(This)){
			this.setAmount((Long)final$$Fields.get("amount"));
			try { this.setComponent((PersistentComponent)final$$Fields.get("component")); } catch (model.CycleException e){throw new persistence.PersistenceExceptionCycleTunnel(e);}
		}
    }
    public <T> T strategyComponentHierarchy(final T parameter, final ComponentHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$component$$QPart = strategy.initialize$$QPart$$component(getThis(), parameter);
		result$$component$$QPart = this.getComponent().strategyComponentHierarchy(result$$component$$QPart, strategy);
		return strategy.finalize$$QPart(getThis(), parameter,result$$component$$QPart);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
					} catch (model.UserException e) {
						//Handle user exception!
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
				}
			}
		}).start();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
