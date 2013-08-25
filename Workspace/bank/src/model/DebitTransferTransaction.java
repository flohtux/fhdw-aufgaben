
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
    protected SubjInterface subService;
    protected PersistentDebitTransferTransaction This;
    
    public DebitTransferTransaction(java.sql.Timestamp timestamp,SubjInterface subService,PersistentDebitTransferTransaction This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.timestamp = timestamp;
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
    
    
    
    public void execute() 
				throws model.ExecuteException, PersistenceException{
        model.meta.DebitTransferTransactionExecuteMssg event = new model.meta.DebitTransferTransactionExecuteMssg(getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
