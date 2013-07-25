package persistence;

import model.UserException;

import model.visitor.*;

public class NotSuccessfullStateProxi extends DebitNoteTransferStateProxi implements PersistentNotSuccessfullState{
    
    public NotSuccessfullStateProxi(long objectId) {
        super(objectId);
    }
    public NotSuccessfullStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNotSuccessfullStateFacade
            .getNotSuccessfullState(this.getId());
    }
    
    public long getClassId() {
        return 142;
    }
    
    public PersistentNotSuccessfullState getThis() throws PersistenceException {
        return ((PersistentNotSuccessfullState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotSuccessfullState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotSuccessfullState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotSuccessfullState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransfer getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentNotSuccessfullState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotSuccessfullState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
