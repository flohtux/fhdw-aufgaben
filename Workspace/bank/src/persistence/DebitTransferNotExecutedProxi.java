package persistence;

import model.UserException;

import model.visitor.*;

public class DebitTransferNotExecutedProxi extends PersistentProxi implements PersistentDebitTransferNotExecuted{
    
    public DebitTransferNotExecutedProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferNotExecutedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitTransferNotExecutedFacade
            .getDebitTransferNotExecuted(this.getId());
    }
    
    public long getClassId() {
        return 200;
    }
    
    public DebitTransferNotExecuted_NotExecutedsProxi getNotExecuteds() throws PersistenceException {
        return ((PersistentDebitTransferNotExecuted)this.getTheObject()).getNotExecuteds();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferNotExecuted)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitTransferNotExecuted getThis() throws PersistenceException {
        return ((PersistentDebitTransferNotExecuted)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferNotExecuted(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferNotExecuted(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferNotExecuted(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferNotExecuted(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferNotExecuted(this);
    }
    
    
    public void add(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).add(debitTransferTransaction);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).register(observee);
    }
    public void remove(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).remove(debitTransferTransaction);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).updateObservers(event);
    }
    public void addImplementation(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).addImplementation(debitTransferTransaction);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeImplementation(final PersistentDebitTransferTransaction debitTransferTransaction) 
				throws PersistenceException{
        ((PersistentDebitTransferNotExecuted)this.getTheObject()).removeImplementation(debitTransferTransaction);
    }

    
}
