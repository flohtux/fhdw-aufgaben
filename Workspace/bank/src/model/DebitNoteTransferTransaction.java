
package model;

import persistence.*;


/* Additional import section end */

public abstract class DebitNoteTransferTransaction extends PersistentObject implements PersistentDebitNoteTransferTransaction{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitNoteTransferTransaction getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.getClass(objectId);
        return (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(objectId, classId);
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
    
    public abstract DebitNoteTransferTransaction provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected java.sql.Timestamp timestamp;
    protected SubjInterface subService;
    protected PersistentDebitNoteTransferTransaction This;
    
    public DebitNoteTransferTransaction(java.sql.Timestamp timestamp,SubjInterface subService,PersistentDebitNoteTransferTransaction This,long id) throws persistence.PersistenceException {
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
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return this.timestamp;
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.timestampSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitNoteTransferTransaction newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitNoteTransferTransaction)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferTransactionFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitNoteTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public void execute() 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException{
        model.meta.DebitNoteTransferTransactionExecuteMssg event = new model.meta.DebitNoteTransferTransactionExecuteMssg(getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitNoteTransferTransaction)This);
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
