package persistence;

import model.UserException;

import model.visitor.*;

public class CompensationRequestedStateICProxi extends DebitTransferStateICProxi implements PersistentCompensationRequestedState{
    
    public CompensationRequestedStateICProxi(long objectId) {
        super(objectId);
    }
    public CompensationRequestedStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensationRequestedStateFacade
            .getCompensationRequestedState(this.getId());
    }
    
    public long getClassId() {
        return 283;
    }
    
    public PersistentCompensationRequestedState getThis() throws PersistenceException {
        return ((PersistentCompensationRequestedState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensationRequestedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensationRequestedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensationRequestedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensationRequestedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentCompensationRequestedState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).updateObservers(event);
    }
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
        return ((PersistentCompensationRequestedState)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isCompensationRequest() 
				throws PersistenceException{
        return ((PersistentCompensationRequestedState)this.getTheObject()).isCompensationRequest();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentCompensationRequestedState)this.getTheObject()).isExecutable();
    }
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
        return ((PersistentCompensationRequestedState)this.getTheObject()).isTransaction();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentCompensationRequestedState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
