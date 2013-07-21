package persistence;

import model.UserException;

import model.visitor.*;

public class InternalFeeICProxi extends PersistentInCacheProxiOptimistic implements PersistentInternalFee{
    
    public InternalFeeICProxi(long objectId) {
        super(objectId);
    }
    public InternalFeeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
            .getInternalFee(this.getId());
    }
    
    public long getClassId() {
        return 109;
    }
    
    public PersistentPercent getPercent() throws PersistenceException {
        return ((PersistentInternalFee)this.getTheObject()).getPercent();
    }
    public void setPercent(PersistentPercent newValue) throws PersistenceException {
        ((PersistentInternalFee)this.getTheObject()).setPercent(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentInternalFee)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentInternalFee)this.getTheObject()).setSubService(newValue);
    }
    public PersistentInternalFee getThis() throws PersistenceException {
        return ((PersistentInternalFee)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleInternalFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInternalFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInternalFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInternalFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleInternalFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInternalFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInternalFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInternalFee(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentInternalFee)this.getTheObject()).initializeOnInstantiation();
    }

    
}
