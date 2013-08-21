package persistence;

import model.UserException;

import model.visitor.*;

public class DebitGrantProxi extends PersistentProxi implements PersistentDebitGrant{
    
    public DebitGrantProxi(long objectId) {
        super(objectId);
    }
    public DebitGrantProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitGrantFacade
            .getDebitGrant(this.getId());
    }
    
    public long getClassId() {
        return 191;
    }
    
    public PersistentAccount getPermittedAccount() throws PersistenceException {
        return ((PersistentDebitGrant)this.getTheObject()).getPermittedAccount();
    }
    public void setPermittedAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentDebitGrant)this.getTheObject()).setPermittedAccount(newValue);
    }
    public PersistentLimitType getLimits() throws PersistenceException {
        return ((PersistentDebitGrant)this.getTheObject()).getLimits();
    }
    public void setLimits(PersistentLimitType newValue) throws PersistenceException {
        ((PersistentDebitGrant)this.getTheObject()).setLimits(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitGrant)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitGrant)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitGrant getThis() throws PersistenceException {
        return ((PersistentDebitGrant)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrant(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitGrant(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitGrant(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitGrant(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitGrant(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitGrant)this.getTheObject()).initializeOnInstantiation();
    }

    
}
