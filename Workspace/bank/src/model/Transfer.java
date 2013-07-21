
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Transfer extends model.DebitNoteTransfer implements PersistentTransfer{
    
    private static PersistentTransfer theTransfer = null;
    public static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static PersistentTransfer getTheTransfer() throws PersistenceException{
        if (theTransfer == null || reset$For$Test){
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void run(){
                    try {
                        TransferProxi proxi = null;
                        synchronized ($$lock){
                            proxi = ConnectionHandler.getTheConnectionHandler().theTransferFacade.getTheTransfer();
                            theTransfer = proxi;
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
                PersistentTransfer getResult() throws PersistenceException{
                    if(exception != null) throw exception;
                    return theTransfer;
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
        return theTransfer;
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
    
    public Transfer provideCopy() throws PersistenceException{
        Transfer result = this;
        result = new Transfer(this.subService, 
                              this.This, 
                              this.sender, 
                              this.receiver, 
                              this.money, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Transfer(SubjInterface subService,PersistentDebitNoteTransferTransaction This,PersistentAccount sender,PersistentAccount receiver,PersistentMoney money,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentDebitNoteTransferTransaction)This,(PersistentAccount)sender,(PersistentAccount)receiver,(PersistentMoney)money,id);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public PersistentTransfer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransfer result = new TransferProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTransfer)this.This;
    }
    
    public void accept(DebitNoteTransferVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitNoteTransferReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitNoteTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitNoteTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSender() != null) return 1;
        if (this.getReceiver() != null) return 1;
        if (this.getMoney() != null) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransfer)This);
		if(this.equals(This)){
		}
    }
    public synchronized void register(ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(Anything copy) 
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
    
    public void execute() 
				throws PersistenceException{
		// TODO Auto-generated method stub
		
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
