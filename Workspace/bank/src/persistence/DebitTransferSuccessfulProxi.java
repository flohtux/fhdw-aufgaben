package persistence;

import model.UserException;

import model.visitor.*;

public class DebitTransferSuccessfulProxi extends PersistentProxi implements PersistentDebitTransferSuccessful{
    
    public DebitTransferSuccessfulProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferSuccessfulProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
            .getDebitTransferSuccessful(this.getId());
    }
    
    public long getClassId() {
        return 197;
    }
    
    public DebitTransferSuccessful_SuccessfulsProxi getSuccessfuls() throws PersistenceException {
        return ((PersistentDebitTransferSuccessful)this.getTheObject()).getSuccessfuls();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferSuccessful)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferSuccessful)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitTransferSuccessful getThis() throws PersistenceException {
        return ((PersistentDebitTransferSuccessful)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferSuccessful(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferSuccessful)this.getTheObject()).initializeOnInstantiation();
    }

    
}
