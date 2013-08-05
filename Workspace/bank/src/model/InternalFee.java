
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class InternalFee extends PersistentObject implements PersistentInternalFee{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentInternalFee getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.getClass(objectId);
        return (PersistentInternalFee)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentInternalFee createInternalFee(PersistentPercent percent) throws PersistenceException{
        return createInternalFee(percent,false);
    }
    
    public static PersistentInternalFee createInternalFee(PersistentPercent percent,boolean delayed$Persistence) throws PersistenceException {
        PersistentInternalFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
                .newDelayedInternalFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
                .newInternalFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("percent", percent);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentInternalFee createInternalFee(PersistentPercent percent,boolean delayed$Persistence,PersistentInternalFee This) throws PersistenceException {
        PersistentInternalFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
                .newDelayedInternalFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
                .newInternalFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("percent", percent);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot percent = (AbstractPersistentRoot)this.getPercent();
            if (percent != null) {
                result.put("percent", percent.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    percent.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && percent.hasEssentialFields())percent.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public InternalFee provideCopy() throws PersistenceException{
        InternalFee result = this;
        result = new InternalFee(this.percent, 
                                 this.subService, 
                                 this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentPercent percent;
    protected SubjInterface subService;
    protected PersistentInternalFee This;
    
    public InternalFee(PersistentPercent percent,SubjInterface subService,PersistentInternalFee This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.percent = percent;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 109;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 109) ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade
            .newInternalFee(this.getId());
        super.store();
        if(this.getPercent() != null){
            this.getPercent().store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.percentSet(this.getId(), getPercent());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentPercent getPercent() throws PersistenceException {
        return this.percent;
    }
    public void setPercent(PersistentPercent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.percent)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.percent = (PersistentPercent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.percentSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentInternalFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentInternalFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theInternalFeeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentInternalFee getThis() throws PersistenceException {
        if(this.This == null){
            PersistentInternalFee result = new InternalFeeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentInternalFee)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getPercent() != null) return 1;
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
        this.setThis((PersistentInternalFee)This);
		if(this.equals(This)){
			this.setPercent((PersistentPercent)final$$Fields.get("percent"));
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
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
