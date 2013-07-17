package persistence;



public abstract class LimitStateICProxi extends AccountLimitStateICProxi implements PersistentLimitState{
    
    public LimitStateICProxi(long objectId) {
        super(objectId);
    }
    public LimitStateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public PersistentAmount getBalance() throws PersistenceException {
        return ((PersistentLimitState)this.getTheObject()).getBalance();
    }
    public void setBalance(PersistentAmount newValue) throws PersistenceException {
        ((PersistentLimitState)this.getTheObject()).setBalance(newValue);
    }
    public abstract PersistentLimitState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).checkLimit(transactionValue);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLimitState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
