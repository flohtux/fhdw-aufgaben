package persistence;

import model.UserException;

import model.visitor.*;

public class LimitProxi extends LimitTypeProxi implements PersistentLimit{
    
    public LimitProxi(long objectId) {
        super(objectId);
    }
    public LimitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theLimitFacade
            .getLimit(this.getId());
    }
    
    public long getClassId() {
        return 128;
    }
    
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentLimit)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentLimit)this.getTheObject()).setMoney(newValue);
    }
    public PersistentLimit getThis() throws PersistenceException {
        return ((PersistentLimit)this.getTheObject()).getThis();
    }
    
    public void accept(LimitTypeVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).updateObservers(event);
    }
    public void checkLimit(final PersistentMoney money) 
				throws model.LimitViolatedException, PersistenceException{
        ((PersistentLimit)this.getTheObject()).checkLimit(money);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentLimit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
