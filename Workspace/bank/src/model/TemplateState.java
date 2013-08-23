package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class TemplateState extends model.DebitTransferState implements PersistentTemplateState{
    
    private static PersistentTemplateState theTemplateState = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentTemplateState getTheTemplateState() throws PersistenceException{
        if (theTemplateState == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        TemplateStateProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theTemplateStateFacade.getTheTemplateState();
                            theTemplateState = proxi;
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
                PersistentTemplateState getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theTemplateState;
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
        return theTemplateState;
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
    
    public TemplateState provideCopy() throws PersistenceException{
        TemplateState result = this;
        result = new TemplateState(this.subService, 
                                   this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public TemplateState(SubjInterface subService,PersistentDebitTransferState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentDebitTransferState)This,id);        
    }
    
    static public long getTypeId() {
        return 138;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentTemplateState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTemplateState result = new TemplateStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTemplateState)this.This;
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTemplateState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTemplateState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTemplateState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTemplateState(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTemplateState)This);
		if(this.equals(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
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
    
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
		getThis().removeDebitTransferFromList();
		getThis().addDebitTransferFromList(newState);
		getThis().getDebitTransfer().setState(newState);
		
	}
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
		return FalseValue.getTheFalseValue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
