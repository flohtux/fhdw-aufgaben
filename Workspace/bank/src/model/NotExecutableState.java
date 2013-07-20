
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NotExecutableState extends model.DebitNoteTransferState implements PersistentNotExecutableState{
    
    private static PersistentNotExecutableState theNotExecutableState = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentNotExecutableState getTheNotExecutableState() throws PersistenceException{
        if (theNotExecutableState == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        NotExecutableStateProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theNotExecutableStateFacade.getTheNotExecutableState();
                            theNotExecutableState = proxi;
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
                PersistentNotExecutableState getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theNotExecutableState;
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
        return theNotExecutableState;
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
    
    public NotExecutableState provideCopy() throws PersistenceException{
        NotExecutableState result = this;
        result = new NotExecutableState(this.state, 
                                        this.stornoState, 
                                        this.subService, 
                                        this.This, 
                                        this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NotExecutableState(PersistentDebitNoteTransferState state,PersistentStornoState stornoState,SubjInterface subService,PersistentDebitNoteTransferState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentDebitNoteTransferState)state,(PersistentStornoState)stornoState,(SubjInterface)subService,(PersistentDebitNoteTransferState)This,id);        
    }
    
    static public long getTypeId() {
        return 144;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNotExecutableState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNotExecutableState result = new NotExecutableStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNotExecutableState)this.This;
    }
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutableState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutableState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutableState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutableState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutableState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutableState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutableState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutableState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutableState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutableState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutableState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutableState(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getState() != null) return 1;
        if (this.getStornoState() != null) return 1;
        if (this.getDebitNoteTransfer() != null) return 1;
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
        this.setThis((PersistentNotExecutableState)This);
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
