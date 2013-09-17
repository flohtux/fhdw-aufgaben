package persistence;

import model.UserException;

import model.visitor.*;

public class BankOwnAccountPxICProxi extends PersistentInCacheProxiOptimistic implements PersistentBankOwnAccountPx{
    
    public BankOwnAccountPxICProxi(long objectId) {
        super(objectId);
    }
    public BankOwnAccountPxICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankOwnAccountPxFacade
            .getBankOwnAccountPx(this.getId());
    }
    
    public long getClassId() {
        return 262;
    }
    
    public PersistentAccount getAccount() throws PersistenceException {
        return ((PersistentBankOwnAccountPx)this.getTheObject()).getAccount();
    }
    public void setAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentBankOwnAccountPx)this.getTheObject()).setAccount(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBankOwnAccountPx)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBankOwnAccountPx)this.getTheObject()).setSubService(newValue);
    }
    public PersistentBankOwnAccountPx getThis() throws PersistenceException {
        return ((PersistentBankOwnAccountPx)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankOwnAccountPx(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankOwnAccountPx(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankOwnAccountPx(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankOwnAccountPx(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankOwnAccountPx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankOwnAccountPx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankOwnAccountPx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankOwnAccountPx(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBankOwnAccountPx)this.getTheObject()).initializeOnInstantiation();
    }

    
}
