package persistence;

import model.UserException;

import model.visitor.*;

public class BankPxProxi extends PersistentProxi implements PersistentBankPx{
    
    public BankPxProxi(long objectId) {
        super(objectId);
    }
    public BankPxProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankPxFacade
            .getBankPx(this.getId());
    }
    
    public long getClassId() {
        return 241;
    }
    
    public PersistentBank getBank() throws PersistenceException {
        return ((PersistentBankPx)this.getTheObject()).getBank();
    }
    public void setBank(PersistentBank newValue) throws PersistenceException {
        ((PersistentBankPx)this.getTheObject()).setBank(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBankPx)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBankPx)this.getTheObject()).setSubService(newValue);
    }
    public PersistentBankPx getThis() throws PersistenceException {
        return ((PersistentBankPx)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankPx(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankPx(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankPx(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankPx(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankPx(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankPx(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankPx(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankPx(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBankPx)this.getTheObject()).initializeOnInstantiation();
    }

    
}
