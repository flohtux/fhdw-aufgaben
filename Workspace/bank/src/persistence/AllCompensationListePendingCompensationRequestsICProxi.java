package persistence;

import model.UserException;

import model.visitor.*;

public class AllCompensationListePendingCompensationRequestsICProxi extends PersistentInCacheProxiOptimistic implements PersistentAllCompensationListePendingCompensationRequests{
    
    public AllCompensationListePendingCompensationRequestsICProxi(long objectId) {
        super(objectId);
    }
    public AllCompensationListePendingCompensationRequestsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade
            .getAllCompensationListePendingCompensationRequests(this.getId());
    }
    
    public long getClassId() {
        return 270;
    }
    
    public PersistentAllCompensationListe getObserver() throws PersistenceException {
        return ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAllCompensationListe newValue) throws PersistenceException {
        ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).setObserver(newValue);
    }
    public PersistentCompensationRequestListe getObservee() throws PersistenceException {
        return ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentCompensationRequestListe newValue) throws PersistenceException {
        ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAllCompensationListePendingCompensationRequests getThis() throws PersistenceException {
        return ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListePendingCompensationRequests(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAllCompensationListePendingCompensationRequests)this.getTheObject()).update(event);
    }

    
}
