package persistence;

import model.UserException;

import model.visitor.*;

public class NotExecutedStateProxi extends DebitTransferStateProxi implements PersistentNotExecutedState{
    
    public NotExecutedStateProxi(long objectId) {
        super(objectId);
    }
    public NotExecutedStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNotExecutedStateFacade
            .getNotExecutedState(this.getId());
    }
    
    public long getClassId() {
        return 210;
    }
    
    public PersistentNotExecutedState getThis() throws PersistenceException {
        return ((PersistentNotExecutedState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotExecutedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentNotExecutedState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).updateObservers(event);
    }
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
        return ((PersistentNotExecutedState)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isCompensated() 
				throws PersistenceException{
        return ((PersistentNotExecutedState)this.getTheObject()).isCompensated();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentNotExecutedState)this.getTheObject()).isExecutable();
    }
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
        return ((PersistentNotExecutedState)this.getTheObject()).isTransaction();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentNotExecutedState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
