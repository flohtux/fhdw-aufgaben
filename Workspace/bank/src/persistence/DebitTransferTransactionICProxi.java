package persistence;

import model.UserException;

public abstract class DebitTransferTransactionICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitTransferTransaction{
    
    public DebitTransferTransactionICProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferTransactionICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public java.sql.Timestamp getTimestamp() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getTimestamp();
    }
    public void setTimestamp(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setTimestamp(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferTransaction)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferTransaction)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitTransferTransaction getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).deregister(observee);
    }
    public void execute() 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).execute();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void executeImplementation() 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).executeImplementation();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferTransaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
