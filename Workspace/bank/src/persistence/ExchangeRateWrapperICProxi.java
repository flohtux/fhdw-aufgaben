package persistence;

import model.UserException;

import model.visitor.*;

public class ExchangeRateWrapperICProxi extends PersistentInCacheProxiOptimistic implements PersistentExchangeRateWrapper{
    
    public ExchangeRateWrapperICProxi(long objectId) {
        super(objectId);
    }
    public ExchangeRateWrapperICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theExchangeRateWrapperFacade
            .getExchangeRateWrapper(this.getId());
    }
    
    public long getClassId() {
        return 273;
    }
    
    public PersistentAmount getAmount() throws PersistenceException {
        return ((PersistentExchangeRateWrapper)this.getTheObject()).getAmount();
    }
    public void setAmount(PersistentAmount newValue) throws PersistenceException {
        ((PersistentExchangeRateWrapper)this.getTheObject()).setAmount(newValue);
    }
    public PersistentCurrency getCurrency() throws PersistenceException {
        return ((PersistentExchangeRateWrapper)this.getTheObject()).getCurrency();
    }
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException {
        ((PersistentExchangeRateWrapper)this.getTheObject()).setCurrency(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentExchangeRateWrapper)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentExchangeRateWrapper)this.getTheObject()).setSubService(newValue);
    }
    public PersistentExchangeRateWrapper getThis() throws PersistenceException {
        return ((PersistentExchangeRateWrapper)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleExchangeRateWrapper(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExchangeRateWrapper(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExchangeRateWrapper(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExchangeRateWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExchangeRateWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExchangeRateWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExchangeRateWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExchangeRateWrapper(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentExchangeRateWrapper)this.getTheObject()).initializeOnInstantiation();
    }

    
}
