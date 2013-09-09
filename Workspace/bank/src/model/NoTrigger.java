
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NoTrigger extends model.TriggerValue implements PersistentNoTrigger{
    
    
    public static PersistentNoTrigger createNoTrigger() throws PersistenceException{
        return createNoTrigger(false);
    }
    
    public static PersistentNoTrigger createNoTrigger(boolean delayed$Persistence) throws PersistenceException {
        PersistentNoTrigger result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
                .newDelayedNoTrigger();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
                .newNoTrigger(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentNoTrigger createNoTrigger(boolean delayed$Persistence,PersistentNoTrigger This) throws PersistenceException {
        PersistentNoTrigger result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
                .newDelayedNoTrigger();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
                .newNoTrigger(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public NoTrigger provideCopy() throws PersistenceException{
        NoTrigger result = this;
        result = new NoTrigger(this.subService, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NoTrigger(SubjInterface subService,PersistentTriggerValue This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentTriggerValue)This,id);        
    }
    
    static public long getTypeId() {
        return 246;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 246) ConnectionHandler.getTheConnectionHandler().theNoTriggerFacade
            .newNoTrigger(this.getId());
        super.store();
        
    }
    
    public PersistentNoTrigger getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNoTrigger result = new NoTriggerProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNoTrigger)this.This;
    }
    
    public void accept(TriggerValueVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(TriggerValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(TriggerValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(TriggerValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoTrigger(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoTrigger(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoTrigger(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoTrigger(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNoTrigger)This);
		if(this.equals(This)){
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public PersistentTriggerValue copy() 
				throws PersistenceException{
        return NoTrigger.createNoTrigger();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
