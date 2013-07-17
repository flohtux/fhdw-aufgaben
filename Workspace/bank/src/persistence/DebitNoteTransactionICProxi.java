package persistence;



public abstract class DebitNoteTransactionICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitNoteTransaction{
    
    public DebitNoteTransactionICProxi(long objectId) {
        super(objectId);
    }
    public DebitNoteTransactionICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public long getBankNumber() throws PersistenceException {
        return ((PersistentDebitNoteTransaction)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws PersistenceException {
        ((PersistentDebitNoteTransaction)this.getTheObject()).setBankNumber(newValue);
    }
    public long getAccountNumber() throws PersistenceException {
        return ((PersistentDebitNoteTransaction)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws PersistenceException {
        ((PersistentDebitNoteTransaction)this.getTheObject()).setAccountNumber(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentDebitNoteTransaction)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitNoteTransaction)this.getTheObject()).setMoney(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitNoteTransaction)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitNoteTransaction)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentDebitNoteTransaction getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitNoteTransaction)this.getTheObject()).initializeOnInstantiation();
    }

    
}
