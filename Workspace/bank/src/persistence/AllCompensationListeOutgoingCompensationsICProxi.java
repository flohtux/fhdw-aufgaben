package persistence;

import model.UserException;

import model.visitor.*;

public class AllCompensationListeOutgoingCompensationsICProxi extends PersistentInCacheProxiOptimistic implements PersistentAllCompensationListeOutgoingCompensations{
    
    public AllCompensationListeOutgoingCompensationsICProxi(long objectId) {
        super(objectId);
    }
    public AllCompensationListeOutgoingCompensationsICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade
            .getAllCompensationListeOutgoingCompensations(this.getId());
    }
    
    public long getClassId() {
        return 269;
    }
    
    public PersistentAllCompensationListe getObserver() throws PersistenceException {
        return ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).getObserver();
    }
    public void setObserver(PersistentAllCompensationListe newValue) throws PersistenceException {
        ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).setObserver(newValue);
    }
    public PersistentCompensationListe getObservee() throws PersistenceException {
        return ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).getObservee();
    }
    public void setObservee(PersistentCompensationListe newValue) throws PersistenceException {
        ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).setObservee(newValue);
    }
    public PersistentAllCompensationListeOutgoingCompensations getThis() throws PersistenceException {
        return ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <E extends UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    public <R, E extends UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAllCompensationListeOutgoingCompensations(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAllCompensationListeOutgoingCompensations)this.getTheObject()).update(event);
    }

    
}
