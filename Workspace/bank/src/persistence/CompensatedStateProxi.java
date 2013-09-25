package persistence;

import model.UserException;

import model.visitor.*;

public class CompensatedStateProxi extends DebitTransferStateProxi implements PersistentCompensatedState{
    
    public CompensatedStateProxi(long objectId) {
        super(objectId);
    }
    public CompensatedStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompensatedStateFacade
            .getCompensatedState(this.getId());
    }
    
    public long getClassId() {
        return 282;
    }
    
    public PersistentCompensatedState getThis() throws PersistenceException {
        return ((PersistentCompensatedState)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleCompensatedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensatedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensatedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensatedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCompensatedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensatedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensatedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensatedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompensatedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompensatedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompensatedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompensatedState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        return ((PersistentCompensatedState)this.getTheObject()).getDebitTransfer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).updateObservers(event);
    }
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).addDebitTransferFromList(state);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).changeState(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
        return ((PersistentCompensatedState)this.getTheObject()).copy();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentBooleanValue isCompensationRequest() 
				throws PersistenceException{
        return ((PersistentCompensatedState)this.getTheObject()).isCompensationRequest();
    }
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
        return ((PersistentCompensatedState)this.getTheObject()).isExecutable();
    }
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
        return ((PersistentCompensatedState)this.getTheObject()).isTransaction();
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
        ((PersistentCompensatedState)this.getTheObject()).removeDebitTransferFromList();
    }

    
}
