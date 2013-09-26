package persistence;

import model.UserException;

import model.visitor.*;

public class NoPayedFeesProxi extends DebitTransferPayedFeesProxi implements PersistentNoPayedFees{
    
    public NoPayedFeesProxi(long objectId) {
        super(objectId);
    }
    public NoPayedFeesProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNoPayedFeesFacade
            .getNoPayedFees(this.getId());
    }
    
    public long getClassId() {
        return 287;
    }
    
    public PersistentNoPayedFees getThis() throws PersistenceException {
        return ((PersistentNoPayedFees)this.getTheObject()).getThis();
    }
    
    public void accept(DebitTransferPayedFeesVisitor visitor) throws PersistenceException {
        visitor.handleNoPayedFees(this);
    }
    public <R> R accept(DebitTransferPayedFeesReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoPayedFees(this);
    }
    public <E extends UserException>  void accept(DebitTransferPayedFeesExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoPayedFees(this);
    }
    public <R, E extends UserException> R accept(DebitTransferPayedFeesReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoPayedFees(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoPayedFees(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoPayedFees(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoPayedFees(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoPayedFees(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoPayedFees(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoPayedFees(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoPayedFees(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoPayedFees(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoPayedFees)this.getTheObject()).initializeOnInstantiation();
    }

    
}
