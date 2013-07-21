package persistence;



public abstract class DebitNoteTransferProxi extends DebitNoteTransferTransactionProxi implements PersistentDebitNoteTransfer{
    
    public DebitNoteTransferProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransferProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public PersistentAccount getSender() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getSender();
    }
    public void setSender(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setSender(newValue);
    }
    public PersistentAccount getReceiver() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getReceiver();
    }
    public void setReceiver(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setReceiver(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentDebitNoteTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitNoteTransfer)this.getTheObject()).setMoney(newValue);
    }
    public abstract PersistentDebitNoteTransfer getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransfer)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
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
