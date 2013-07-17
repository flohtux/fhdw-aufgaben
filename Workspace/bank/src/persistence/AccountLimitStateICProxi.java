package persistence;



public abstract class AccountLimitStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountLimitState{
    
    public AccountLimitStateICProxi(long objectId) {
        super(objectId);
    }
    public AccountLimitStateICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAccountLimitState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAccountLimitState)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentAccountLimitState getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney transactionValue) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).checkLimit(transactionValue);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountLimitState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
