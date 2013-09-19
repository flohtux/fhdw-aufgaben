
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AllCompensationListeOutgoingCompensations extends PersistentObject implements PersistentAllCompensationListeOutgoingCompensations{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentAllCompensationListeOutgoingCompensations getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.getClass(objectId);
        return (PersistentAllCompensationListeOutgoingCompensations)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentAllCompensationListeOutgoingCompensations createAllCompensationListeOutgoingCompensations() throws PersistenceException{
        return createAllCompensationListeOutgoingCompensations(false);
    }
    
    public static PersistentAllCompensationListeOutgoingCompensations createAllCompensationListeOutgoingCompensations(boolean delayed$Persistence) throws PersistenceException {
        PersistentAllCompensationListeOutgoingCompensations result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade
                .newDelayedAllCompensationListeOutgoingCompensations();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade
                .newAllCompensationListeOutgoingCompensations(-1);
        }
        while (!(result instanceof AllCompensationListeOutgoingCompensations)) result = (PersistentAllCompensationListeOutgoingCompensations)result.getTheObject();
        ((AllCompensationListeOutgoingCompensations)result).setThis(result);
        return result;
    }
    
    public AllCompensationListeOutgoingCompensations provideCopy() throws PersistenceException{
        AllCompensationListeOutgoingCompensations result = this;
        result = new AllCompensationListeOutgoingCompensations(this.observer, 
                                                               this.observee, 
                                                               this.This, 
                                                               this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAllCompensationListe observer;
    protected PersistentCompensationListe observee;
    protected PersistentAllCompensationListeOutgoingCompensations This;
    
    public AllCompensationListeOutgoingCompensations(PersistentAllCompensationListe observer,PersistentCompensationListe observee,PersistentAllCompensationListeOutgoingCompensations This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 269;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 269) ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade
            .newAllCompensationListeOutgoingCompensations(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.observerSet(this.getId(), newValue);
        }
    }
    public PersistentCompensationListe getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(PersistentCompensationListe newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.observee)) return;
        PersistentCompensationListe oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentCompensationListe)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAllCompensationListeOutgoingCompensations newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAllCompensationListeOutgoingCompensations)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAllCompensationListeOutgoingCompensationsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAllCompensationListeOutgoingCompensations getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAllCompensationListeOutgoingCompensations result = new AllCompensationListeOutgoingCompensationsProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentAllCompensationListeOutgoingCompensations)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().outgoingCompensations_update((model.meta.CompensationListeMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
