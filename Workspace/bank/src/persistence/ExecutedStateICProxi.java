package persistence;

import model.UserException;

import model.visitor.*;

public class ExecutedStateICProxi extends DebitTransferStateICProxi implements PersistentExecutedState{
    
    public ExecutedStateICProxi(long objectId) {
        super(objectId);
    }
    public ExecutedStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
            .getExecutedState(this.getId());
    }
    
    public long getClassId() {
        return 110;
    }
    
    public PersistentExecutedState getThis() throws PersistenceException {
        return ((PersistentExecutedState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentExecutedState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).updateObservers(event);
    }
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
        return ((PersistentExecutedState)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isCompensationRequest() 
				throws PersistenceException{
        return ((PersistentExecutedState)this.getTheObject()).isCompensationRequest();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentExecutedState)this.getTheObject()).isExecutable();
    }
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
        return ((PersistentExecutedState)this.getTheObject()).isTransaction();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentExecutedState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
