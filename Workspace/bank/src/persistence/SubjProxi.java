package persistence;

import model.UserException;

import model.visitor.*;

public class SubjProxi extends PersistentProxi implements PersistentSubj{
    
    public SubjProxi(long objectId) {
        super(objectId);
    }
    public SubjProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSubjFacade
            .getSubj(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public Subj_ObserveeProxi getObservee() throws PersistenceException {
        return ((PersistentSubj)this.getTheObject()).getObservee();
    }
    public PersistentSubj getThis() throws PersistenceException {
        return ((PersistentSubj)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleSubj(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubj(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubj(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubj(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSubj(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSubj(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSubj(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSubj(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSubj)this.getTheObject()).deregister(observee);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentSubj)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentSubj)this.getTheObject()).updateObservers(event);
    }

    
}
