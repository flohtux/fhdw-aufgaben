package persistence;

import model.UserException;

import model.visitor.*;

public class MoneyProxi extends PersistentProxi implements PersistentMoney{
    
    public MoneyProxi(long objectId) {
        super(objectId);
    }
    public MoneyProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMoneyFacade
            .getMoney(this.getId());
    }
    
    public long getClassId() {
        return 148;
    }
    
    public PersistentAmount getAmount() throws PersistenceException {
        return ((PersistentMoney)this.getTheObject()).getAmount();
    }
    public void setAmount(PersistentAmount newValue) throws PersistenceException {
        ((PersistentMoney)this.getTheObject()).setAmount(newValue);
    }
    public PersistentCurrency getCurrency() throws PersistenceException {
        return ((PersistentMoney)this.getTheObject()).getCurrency();
    }
    public void setCurrency(PersistentCurrency newValue) throws PersistenceException {
        ((PersistentMoney)this.getTheObject()).setCurrency(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentMoney)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentMoney)this.getTheObject()).setSubService(newValue);
    }
    public PersistentMoney getThis() throws PersistenceException {
        return ((PersistentMoney)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMoney(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoney(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoney(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoney(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMoney(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMoney(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMoney(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMoney(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMoney)this.getTheObject()).initializeOnInstantiation();
    }

    
}
