
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Subj extends PersistentObject implements PersistentSubj{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentSubj getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theSubjFacade.getClass(objectId);
        return (PersistentSubj)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentSubj createSubj() throws PersistenceException{
        return createSubj(false);
    }
    
    public static PersistentSubj createSubj(boolean delayed$Persistence) throws PersistenceException {
        PersistentSubj result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSubjFacade
                .newDelayedSubj();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSubjFacade
                .newSubj(-1);
        }
        return result;
    }
    
    public static PersistentSubj createSubj(boolean delayed$Persistence,PersistentSubj This) throws PersistenceException {
        PersistentSubj result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theSubjFacade
                .newDelayedSubj();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theSubjFacade
                .newSubj(-1);
        }
        return result;
    }
    
    public Subj provideCopy() throws PersistenceException{
        Subj result = this;
        result = new Subj(this.This, 
                          this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Subj_ObserveeProxi observee;
    protected PersistentSubj This;
    
    public Subj(PersistentSubj This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observee = new Subj_ObserveeProxi(this);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 129) ConnectionHandler.getTheConnectionHandler().theSubjFacade
            .newSubj(this.getId());
        super.store();
        this.getObservee().store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theSubjFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Subj_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentSubj newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentSubj)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theSubjFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentSubj getThis() throws PersistenceException {
        if(this.This == null){
            PersistentSubj result = new SubjProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentSubj)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        java.util.Iterator<ObsInterface> observers = getThis().getObservee().iterator();
		while (observers.hasNext()){
			ObsInterface current = observers.next();
			if (current.equals(observee))observers.remove();
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        getThis().getObservee().add(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        java.util.Iterator<ObsInterface> observers = getThis().getObservee().iterator();
		while (observers.hasNext()){
			ObsInterface current = observers.next();
			current.update(event);
		}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
