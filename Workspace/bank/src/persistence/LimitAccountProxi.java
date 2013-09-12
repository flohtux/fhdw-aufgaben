package persistence;

import model.UserException;

import model.visitor.*;

public class LimitAccountProxi extends PersistentProxi implements PersistentLimitAccount{
    
    public LimitAccountProxi(long objectId) {
        super(objectId);
    }
    public LimitAccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLimitAccountFacade
            .getLimitAccount(this.getId());
    }
    
    public long getClassId() {
        return 127;
    }
    
    public PersistentLimitType getMinLimit() throws PersistenceException {
        return ((PersistentLimitAccount)this.getTheObject()).getMinLimit();
    }
    public void setMinLimit(PersistentLimitType newValue) throws PersistenceException {
        ((PersistentLimitAccount)this.getTheObject()).setMinLimit(newValue);
    }
    public PersistentLimitType getMaxLimit() throws PersistenceException {
        return ((PersistentLimitAccount)this.getTheObject()).getMaxLimit();
    }
    public void setMaxLimit(PersistentLimitType newValue) throws PersistenceException {
        ((PersistentLimitAccount)this.getTheObject()).setMaxLimit(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentLimitAccount)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentLimitAccount)this.getTheObject()).setSubService(newValue);
    }
    public PersistentLimitAccount getThis() throws PersistenceException {
        return ((PersistentLimitAccount)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimitAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLimitAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimitAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimitAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimitAccount(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).deregister(observee);
    }
    public PersistentAccount getAccount() 
				throws PersistenceException{
        return ((PersistentLimitAccount)this.getTheObject()).getAccount();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).updateObservers(event);
    }
    public void changeMaxLimit(final PersistentMoney money) 
				throws model.MaxLimitLowerThenMinLimitException, PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).changeMaxLimit(money);
    }
    public void changeMinLimit(final PersistentMoney money) 
				throws model.MinLimitHigherMaxLimitException, PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).changeMinLimit(money);
    }
    public void checkLimit(final PersistentMoney money) 
				throws model.LimitViolatedException, PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).checkLimit(money);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLimitAccount)this.getTheObject()).initializeOnInstantiation();
    }

    
}
