
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitTransferSuccessful extends PersistentObject implements PersistentDebitTransferSuccessful{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferSuccessful getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade.getClass(objectId);
        return (PersistentDebitTransferSuccessful)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitTransferSuccessful createDebitTransferSuccessful() throws PersistenceException{
        return createDebitTransferSuccessful(false);
    }
    
    public static PersistentDebitTransferSuccessful createDebitTransferSuccessful(boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitTransferSuccessful result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
                .newDelayedDebitTransferSuccessful();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
                .newDebitTransferSuccessful(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitTransferSuccessful createDebitTransferSuccessful(boolean delayed$Persistence,PersistentDebitTransferSuccessful This) throws PersistenceException {
        PersistentDebitTransferSuccessful result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
                .newDelayedDebitTransferSuccessful();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
                .newDebitTransferSuccessful(-1);
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
            result.put("successfuls", this.getSuccessfuls().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitTransferSuccessful provideCopy() throws PersistenceException{
        DebitTransferSuccessful result = this;
        result = new DebitTransferSuccessful(this.subService, 
                                             this.This, 
                                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected DebitTransferSuccessful_SuccessfulsProxi successfuls;
    protected SubjInterface subService;
    protected PersistentDebitTransferSuccessful This;
    
    public DebitTransferSuccessful(SubjInterface subService,PersistentDebitTransferSuccessful This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.successfuls = new DebitTransferSuccessful_SuccessfulsProxi(this);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 197;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 197) ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade
            .newDebitTransferSuccessful(this.getId());
        super.store();
        this.getSuccessfuls().store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public DebitTransferSuccessful_SuccessfulsProxi getSuccessfuls() throws PersistenceException {
        return this.successfuls;
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferSuccessful newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferSuccessful)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferSuccessfulFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferSuccessful getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitTransferSuccessful result = new DebitTransferSuccessfulProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitTransferSuccessful)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferSuccessful(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferSuccessful(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferSuccessful(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getSuccessfuls().getLength() > 0) return 1;
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
        this.setThis((PersistentDebitTransferSuccessful)This);
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
