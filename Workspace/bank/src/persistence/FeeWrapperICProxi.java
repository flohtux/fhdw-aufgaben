package persistence;

import model.UserException;

import model.visitor.*;

public class FeeWrapperICProxi extends PersistentInCacheProxiOptimistic implements PersistentFeeWrapper{
    
    public FeeWrapperICProxi(long objectId) {
        super(objectId);
    }
    public FeeWrapperICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
            .getFeeWrapper(this.getId());
    }
    
    public long getClassId() {
        return 242;
    }
    
    public PersistentTransactionFee getFee() throws PersistenceException {
        return ((PersistentFeeWrapper)this.getTheObject()).getFee();
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        ((PersistentFeeWrapper)this.getTheObject()).setFee(newValue);
    }
    public PersistentInternalFee getInternalFee() throws PersistenceException {
        return ((PersistentFeeWrapper)this.getTheObject()).getInternalFee();
    }
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException {
        ((PersistentFeeWrapper)this.getTheObject()).setInternalFee(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentFeeWrapper)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentFeeWrapper)this.getTheObject()).setSubService(newValue);
    }
    public PersistentFeeWrapper getThis() throws PersistenceException {
        return ((PersistentFeeWrapper)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleFeeWrapper(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFeeWrapper(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFeeWrapper(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFeeWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFeeWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFeeWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFeeWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFeeWrapper(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFeeWrapper)this.getTheObject()).initializeOnInstantiation();
    }

    
}
