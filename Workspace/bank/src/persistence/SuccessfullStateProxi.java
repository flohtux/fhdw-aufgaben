package persistence;

import model.UserException;

import model.visitor.*;

public class SuccessfullStateProxi extends DebitNoteTransferStateProxi implements PersistentSuccessfullState{
    
    public SuccessfullStateProxi(long objectId) {
        super(objectId);
    }
    public SuccessfullStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSuccessfullStateFacade
            .getSuccessfullState(this.getId());
    }
    
    public long getClassId() {
        return 113;
    }
    
    public PersistentSuccessfullState getThis() throws PersistenceException {
        return ((PersistentSuccessfullState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitNoteTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullState(this);
    }
    public <R> R accept(DebitNoteTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullState(this);
    }
    public <E extends UserException>  void accept(DebitNoteTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(DebitNoteTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSuccessfullState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSuccessfullState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSuccessfullState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSuccessfullState(this);
    }
    
    
    public void deregister(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitNoteTransferState getDebitNoteTransfer() 
				throws PersistenceException{
        return ((PersistentSuccessfullState)this.getTheObject()).getDebitNoteTransfer();
    }
    public void initialize(Anything This, java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).register(observee);
    }
    public void updateObservers(model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(Anything copy) 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSuccessfullState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
