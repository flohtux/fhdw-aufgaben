
package model;

import persistence.*;
import model.meta.ComponentSwitchPARAMETER;
import model.meta.StringFACTORY;
import model.visitor.*;


/* Additional import section end */

public class PartsListManager extends PersistentObject implements PersistentPartsListManager{
    
    private static PersistentPartsListManager thePartsListManager = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentPartsListManager getThePartsListManager() throws PersistenceException{
        if (thePartsListManager == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        PartsListManagerProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.getThePartsListManager();
                            thePartsListManager = proxi;
                        }
                        if(proxi.getId() < 0) {
                            proxi.setId(proxi.getId() * -1);
                            proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                            proxi.initializeOnCreation();
                        }
                    } catch (PersistenceException e){
                        exception = e;
                    }
                    synchronized ($$lock){$$lock.notify();}
                }
                PersistentPartsListManager getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return thePartsListManager;
                }
            }
            synchronized ($$lock) {
                reset$For$Test = false;
                Initializer initializer = new Initializer();
                new Thread(initializer).start();
                try {$$lock.wait();}catch (InterruptedException e) {} //Need not to be interrupted
                return initializer.getResult();
            }
        }
        return thePartsListManager;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public PartsListManager provideCopy() throws PersistenceException{
        PartsListManager result = this;
        result = new PartsListManager(this.This, 
                                      this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentPartsListManager This;
    
    public PartsListManager(PersistentPartsListManager This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    protected void setThis(PersistentPartsListManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPartsListManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentPartsListManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPartsListManager result = new PartsListManagerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentPartsListManager)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddComponentCommand command = model.meta.AddComponentCommand.createAddComponentCommand(amount, now, now);
		command.setProduct(product);
		command.setNewPart(newPart);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createComponent(final String name, final String componentType, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateComponentCommand command = model.meta.CreateComponentCommand.createCreateComponentCommand(name, componentType, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPartsListManager)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addComponent(final PersistentProduct product, final PersistentComponent newPart, final long amount) 
				throws model.CycleException, PersistenceException{
    	product.addComponent(newPart, amount);
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public long count(final PersistentComponent component) 
				throws PersistenceException{
    	return component.strategyComponentHierarchy((long)0, new ComponentHierarchyHIERARCHYStrategy<Long>() {

			public Long initialize$$Product$$parts(PersistentProduct ths,
					Long parameter) throws PersistenceException {
				return (long)0;
			}
			public Long consolidate$$Product$$parts(PersistentProduct ths, Long result, Long current) throws PersistenceException {
				return result + current;
			}
			
			public Long finalize$$Material(PersistentMaterial ths, Long parameter) throws PersistenceException {
				return (long)1;
			}
			public Long finalize$$Product(PersistentProduct ths,
					Long parameter, Long parts) throws PersistenceException {
				return parts + 1;
			}
			public Long finalize$$QPart(PersistentQPart ths, Long parameter,
					Long component) throws PersistenceException {
				return component * ths.getAmount();
			}
        	public Long initialize$$QPart$$component(PersistentQPart ths,
					Long parameter) throws PersistenceException {
				return (long)0;
			}
		});
    }
    public PersistentComponent createComponent(final String name, final String componentType) 
				throws model.DoubleDefinitionException, PersistenceException{
    	if (Component.getComponentByName(name).iterator().hasNext()) { throw new DoubleDefinitionException();}
        PersistentComponent newComponent = StringFACTORY.createObjectBySubTypeNameForComponent(componentType, new ComponentSwitchPARAMETER() {
			public PersistentProduct handleProduct() throws PersistenceException {
				return Product.createProduct(name);
			}
			public PersistentMaterial handleMaterial() throws PersistenceException {
				return Material.createMaterial(name);
			}
		});
        return newComponent;
    }
    public PersistentMateriallist fetchMateriallist(final PersistentComponent component) 
				throws PersistenceException{
    	return component.fetchMateriallist();
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
