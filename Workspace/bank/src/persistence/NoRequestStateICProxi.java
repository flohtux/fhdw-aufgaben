package persistence;

import model.UserException;

import model.visitor.*;

public class NoRequestStateICProxi extends StornoStateICProxi implements PersistentNoRequestState{
    
    public NoRequestStateICProxi(long objectId) {
        super(objectId);
    }
    public NoRequestStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoRequestStateFacade
            .getNoRequestState(this.getId());
    }
    
    public long getClassId() {
        return 104;
    }
    
    public PersistentNoRequestState getThis() throws PersistenceException {
        return ((PersistentNoRequestState)this.getTheObject()).getThis();
    }
    
    public void accept(StornoStateVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoRequestState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoRequestState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoRequestState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoRequestState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).deregister(observee);
    }
    public PersistentCompensation getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentNoRequestState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoRequestState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
