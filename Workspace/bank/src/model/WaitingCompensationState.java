
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class WaitingCompensationState extends model.CompensationState implements PersistentWaitingCompensationState{
    
    private static PersistentWaitingCompensationState theWaitingCompensationState = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentWaitingCompensationState getTheWaitingCompensationState() throws PersistenceException{
        if (theWaitingCompensationState == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        WaitingCompensationStateProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theWaitingCompensationStateFacade.getTheWaitingCompensationState();
                            theWaitingCompensationState = proxi;
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
                PersistentWaitingCompensationState getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theWaitingCompensationState;
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
        return theWaitingCompensationState;
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
    
    public WaitingCompensationState provideCopy() throws PersistenceException{
        WaitingCompensationState result = this;
        result = new WaitingCompensationState(this.subService, 
                                              this.This, 
                                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public WaitingCompensationState(SubjInterface subService,PersistentCompensationState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentCompensationState)This,id);        
    }
    
    static public long getTypeId() {
        return 278;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentWaitingCompensationState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentWaitingCompensationState result = new WaitingCompensationStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentWaitingCompensationState)this.This;
    }
    
    public void accept(CompensationStateVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(CompensationStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(CompensationStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(CompensationStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWaitingCompensationState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWaitingCompensationState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWaitingCompensationState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWaitingCompensationState(this);
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
        this.setThis((PersistentWaitingCompensationState)This);
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
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
