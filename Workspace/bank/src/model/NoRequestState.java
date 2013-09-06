
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.StornoStateExceptionVisitor;
import model.visitor.StornoStateReturnExceptionVisitor;
import model.visitor.StornoStateReturnVisitor;
import model.visitor.StornoStateVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.NoRequestStateProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentNoRequestState;
import persistence.PersistentStornoState;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class NoRequestState extends model.StornoState implements PersistentNoRequestState{
    
    private static PersistentNoRequestState theNoRequestState = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentNoRequestState getTheNoRequestState() throws PersistenceException{
        if (theNoRequestState == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        NoRequestStateProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theNoRequestStateFacade.getTheNoRequestState();
                            theNoRequestState = proxi;
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
                PersistentNoRequestState getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theNoRequestState;
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
        return theNoRequestState;
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
    
    public NoRequestState provideCopy() throws PersistenceException{
        NoRequestState result = this;
        result = new NoRequestState(this.subService, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoRequestState(SubjInterface subService,PersistentStornoState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentStornoState)This,id);        
    }
    
    static public long getTypeId() {
        return 104;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentNoRequestState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoRequestState result = new NoRequestStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNoRequestState)this.This;
    }
    
    public void accept(StornoStateVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
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
        this.setThis((PersistentNoRequestState)This);
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
