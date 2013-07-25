package persistence;

import model.UserException;

import model.visitor.*;

public class SuccessfullStornoStateProxi extends StornoStateProxi implements PersistentSuccessfullStornoState{
    
    public SuccessfullStornoStateProxi(long objectId) {
        super(objectId);
    }
    public SuccessfullStornoStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSuccessfullStornoStateFacade
            .getSuccessfullStornoState(this.getId());
    }
    
    public long getClassId() {
        return 123;
    }
    
    public PersistentSuccessfullStornoState getThis() throws PersistenceException {
        return ((PersistentSuccessfullStornoState)this.getTheObject()).getThis();
    }
    
    public void accept(StornoStateVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullStornoState(this);
    }
    public <R> R accept(StornoStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullStornoState(this);
    }
    public <E extends UserException>  void accept(StornoStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullStornoState(this);
    }
    public <R, E extends UserException> R accept(StornoStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullStornoState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullStornoState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullStornoState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullStornoState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullStornoState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullStornoState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullStornoState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullStornoState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullStornoState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransfer getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentSuccessfullStornoState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSuccessfullStornoState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
