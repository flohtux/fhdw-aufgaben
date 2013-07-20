package persistence;

import model.UserException;

import model.visitor.*;

public class BankCreatorProxi extends PersistentProxi implements PersistentBankCreator{
    
    public BankCreatorProxi(long objectId) {
        super(objectId);
    }
    public BankCreatorProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankCreatorFacade
            .getBankCreator(this.getId());
    }
    
    public long getClassId() {
        return 152;
    }
    
    public long getLastBankNumber() throws PersistenceException {
        return ((PersistentBankCreator)this.getTheObject()).getLastBankNumber();
    }
    public void setLastBankNumber(long newValue) throws PersistenceException {
        ((PersistentBankCreator)this.getTheObject()).setLastBankNumber(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBankCreator)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBankCreator)this.getTheObject()).setSubService(newValue);
    }
    public PersistentBankCreator getThis() throws PersistenceException {
        return ((PersistentBankCreator)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankCreator(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankCreator(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankCreator(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankCreator(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankCreator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankCreator(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankCreator(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankCreator(this);
    }
    
    
    public void createBank(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).createBank(name, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentBank createBank(final String name) 
				throws PersistenceException{
        return ((PersistentBankCreator)this.getTheObject()).createBank(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBankCreator)this.getTheObject()).initializeOnInstantiation();
    }

    
}
