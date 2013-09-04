package persistence;

import model.UserException;

import model.visitor.*;

public class DebitTransferDoubleStateICProxi extends PersistentInCacheProxiOptimistic implements PersistentDebitTransferDoubleState{
    
    public DebitTransferDoubleStateICProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferDoubleStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
            .getDebitTransferDoubleState(this.getId());
    }
    
    public long getClassId() {
        return 228;
    }
    
    public PersistentDebitTransferState getDebitTransferStateOld() throws PersistenceException {
        return ((PersistentDebitTransferDoubleState)this.getTheObject()).getDebitTransferStateOld();
    }
    public void setDebitTransferStateOld(PersistentDebitTransferState newValue) throws PersistenceException {
        ((PersistentDebitTransferDoubleState)this.getTheObject()).setDebitTransferStateOld(newValue);
    }
    public PersistentDebitTransferState getDebitTransferStateNew() throws PersistenceException {
        return ((PersistentDebitTransferDoubleState)this.getTheObject()).getDebitTransferStateNew();
    }
    public void setDebitTransferStateNew(PersistentDebitTransferState newValue) throws PersistenceException {
        ((PersistentDebitTransferDoubleState)this.getTheObject()).setDebitTransferStateNew(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentDebitTransferDoubleState)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentDebitTransferDoubleState)this.getTheObject()).setSubService(newValue);
    }
    public PersistentDebitTransferDoubleState getThis() throws PersistenceException {
        return ((PersistentDebitTransferDoubleState)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferDoubleState(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransferDoubleState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
