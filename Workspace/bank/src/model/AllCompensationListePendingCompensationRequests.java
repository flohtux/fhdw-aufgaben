
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AllCompensationListePendingCompensationRequests extends PersistentObject implements PersistentAllCompensationListePendingCompensationRequests{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAllCompensationListePendingCompensationRequests getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.getClass(objectId);
        return (PersistentAllCompensationListePendingCompensationRequests)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAllCompensationListePendingCompensationRequests createAllCompensationListePendingCompensationRequests() throws PersistenceException{
        return createAllCompensationListePendingCompensationRequests(false);
    }
    
    public static PersistentAllCompensationListePendingCompensationRequests createAllCompensationListePendingCompensationRequests(boolean delayed$Persistence) throws PersistenceException {
        PersistentAllCompensationListePendingCompensationRequests result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade
                .newDelayedAllCompensationListePendingCompensationRequests();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade
                .newAllCompensationListePendingCompensationRequests(-1);
        }
        while (!(result instanceof AllCompensationListePendingCompensationRequests)) result = (PersistentAllCompensationListePendingCompensationRequests)result.getTheObject();
        ((AllCompensationListePendingCompensationRequests)result).setThis(result);
        return result;
    }
    
    public AllCompensationListePendingCompensationRequests provideCopy() throws PersistenceException{
        AllCompensationListePendingCompensationRequests result = this;
        result = new AllCompensationListePendingCompensationRequests(this.observer, 
                                                                     this.observee, 
                                                                     this.This, 
                                                                     this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAllCompensationListe observer;
    protected PersistentCompensationRequestListe observee;
    protected PersistentAllCompensationListePendingCompensationRequests This;
    
    public AllCompensationListePendingCompensationRequests(PersistentAllCompensationListe observer,PersistentCompensationRequestListe observee,PersistentAllCompensationListePendingCompensationRequests This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 270;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 270) ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade
            .newAllCompensationListePendingCompensationRequests(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentAllCompensationListe getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(PersistentAllCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAllCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationRequestListe getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentCompensationRequestListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentCompensationRequestListe oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentCompensationRequestListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAllCompensationListePendingCompensationRequests newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAllCompensationListePendingCompensationRequests)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListePendingCompensationRequestsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAllCompensationListePendingCompensationRequests getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAllCompensationListePendingCompensationRequests result = new AllCompensationListePendingCompensationRequestsProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAllCompensationListePendingCompensationRequests)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().pendingCompensationRequests_update((model.meta.CompensationRequestListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
