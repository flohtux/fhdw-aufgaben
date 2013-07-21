package persistence;



public abstract class DebitNoteTransferICProxi extends DebitNoteTransferTransactionICProxi implements PersistentDebitNoteTransfer{
    
    public DebitNoteTransferICProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public long getReceiverAccountNumber() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public PersistentAccount getSender() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getSender();
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setSender(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setMoney(newValue);
    }
    public abstract PersistentDebitNoteTransfer getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void execute() 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).execute();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
