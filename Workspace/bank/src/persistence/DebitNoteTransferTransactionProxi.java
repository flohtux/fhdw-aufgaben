package persistence;

import model.UserException;

public abstract class DebitNoteTransferTransactionProxi extends PersistentProxi implements PersistentDebitNoteTransferTransaction{
    
    public DebitNoteTransferTransactionProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferTransactionProxi(PersistentInCacheProxi object) {
        super(object);
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
    public void execute() 
				throws model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentDebitNoteTransferTransaction)this.getTheObject()).execute();
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
