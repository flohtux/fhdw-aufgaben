package persistence;



public abstract class TransactionFeeProxi extends PersistentProxi implements PersistentTransactionFee{
    
    public TransactionFeeProxi(long objectId) {
        super(objectId);
    }
    public TransactionFeeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentTransactionFee)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentTransactionFee)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentTransactionFee getThis() throws PersistenceException ;
    
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).deregister(observee);
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransactionFee)this.getTheObject()).initializeOnInstantiation();
    }

    
}
