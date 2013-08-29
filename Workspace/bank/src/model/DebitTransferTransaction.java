
package model;

import persistence.*;


/* Additional import section end */

public abstract class DebitTransferTransaction extends PersistentObject implements PersistentDebitTransferTransaction{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferTransaction getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.getClass(objectId);
        return (PersistentDebitTransferTransaction)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("timestamp", this.getTimestamp());
            AbstractPersistentRoot sender = (AbstractPersistentRoot)this.getSender();
            if (sender != null) {
                result.put("sender", sender.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    sender.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && sender.hasEssentialFields())sender.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                result.put("state", state.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    state.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && state.hasEssentialFields())state.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitTransferTransaction provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected java.sql.Timestamp timestamp;
    protected PersistentAccount sender;
    protected PersistentDebitTransferState state;
    protected SubjInterface subService;
    protected PersistentDebitTransferTransaction This;
    
    public DebitTransferTransaction(java.sql.Timestamp timestamp,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.timestamp = timestamp;
        this.sender = sender;
        this.state = state;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 147;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getSender() != null){
            this.getSender().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.senderSet(this.getId(), getSender());
        }
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.stateSet(this.getId(), getState());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return this.timestamp;
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.timestampSet(this.getId(), newValue);
        this.timestamp = newValue;
    }
    public PersistentAccount getSender() throws PersistenceException {
        return this.sender;
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.sender)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.sender = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.senderSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferState getState() throws PersistenceException {
        return this.state;
    }
    public void setState(PersistentDebitTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.stateSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferTransaction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferTransaction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        model.meta.DebitTransferTransactionChangeStateDebitTransferStateMssg event = new model.meta.DebitTransferTransactionChangeStateDebitTransferStateMssg(newState, getThis());
		event.execute();
		getThis().updateObservers(event);
		return event.getResult();
    }
    public PersistentDebitTransferTransaction execute() 
				throws model.ExecuteException, PersistenceException{
        model.meta.DebitTransferTransactionExecuteMssg event = new model.meta.DebitTransferTransactionExecuteMssg(getThis());
		event.execute();
		getThis().updateObservers(event);
		return event.getResult();
    }
    public void execute(final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentExecuteCommand command = model.meta.ExecuteCommand.createExecuteCommand(now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitTransferTransaction)This);
		if(this.equals(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
    	PersistentDebitTransferDoubleState result = DebitTransferDoubleState.createDebitTransferDoubleState(getThis().getState(), newState);
		getThis().setState(newState);	
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
