package persistence;

import model.UserException;

public abstract class DebitNoteTransferTransactionProxi extends PersistentProxi implements PersistentDebitNoteTransferTransaction{
    
    public DebitNoteTransferTransactionProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferTransactionProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return ((PersistentDebitNoteTransferTransaction)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).setTimestamp(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitNoteTransferTransaction)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitNoteTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).deregister(observee);
    }
    public void execute() 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).execute();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void executeImplementation() 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).executeImplementation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
