
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class DebitTransferDoubleState extends PersistentObject implements PersistentDebitTransferDoubleState{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferDoubleState getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.getClass(objectId);
        return (PersistentDebitTransferDoubleState)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentDebitTransferDoubleState createDebitTransferDoubleState(PersistentDebitTransferState debitTransferStateOld,PersistentDebitTransferState debitTransferStateNew) throws PersistenceException{
        return createDebitTransferDoubleState(debitTransferStateOld,debitTransferStateNew,false);
    }
    
    public static PersistentDebitTransferDoubleState createDebitTransferDoubleState(PersistentDebitTransferState debitTransferStateOld,PersistentDebitTransferState debitTransferStateNew,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebitTransferDoubleState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
                .newDelayedDebitTransferDoubleState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
                .newDebitTransferDoubleState(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("debitTransferStateOld", debitTransferStateOld);
        final$$Fields.put("debitTransferStateNew", debitTransferStateNew);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebitTransferDoubleState createDebitTransferDoubleState(PersistentDebitTransferState debitTransferStateOld,PersistentDebitTransferState debitTransferStateNew,boolean delayed$Persistence,PersistentDebitTransferDoubleState This) throws PersistenceException {
        PersistentDebitTransferDoubleState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
                .newDelayedDebitTransferDoubleState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
                .newDebitTransferDoubleState(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("debitTransferStateOld", debitTransferStateOld);
        final$$Fields.put("debitTransferStateNew", debitTransferStateNew);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot debitTransferStateOld = (AbstractPersistentRoot)this.getDebitTransferStateOld();
            if (debitTransferStateOld != null) {
                result.put("debitTransferStateOld", debitTransferStateOld.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitTransferStateOld.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitTransferStateOld.hasEssentialFields())debitTransferStateOld.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot debitTransferStateNew = (AbstractPersistentRoot)this.getDebitTransferStateNew();
            if (debitTransferStateNew != null) {
                result.put("debitTransferStateNew", debitTransferStateNew.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitTransferStateNew.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitTransferStateNew.hasEssentialFields())debitTransferStateNew.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public DebitTransferDoubleState provideCopy() throws PersistenceException{
        DebitTransferDoubleState result = this;
        result = new DebitTransferDoubleState(this.debitTransferStateOld, 
                                              this.debitTransferStateNew, 
                                              this.subService, 
                                              this.This, 
                                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDebitTransferState debitTransferStateOld;
    protected PersistentDebitTransferState debitTransferStateNew;
    protected SubjInterface subService;
    protected PersistentDebitTransferDoubleState This;
    
    public DebitTransferDoubleState(PersistentDebitTransferState debitTransferStateOld,PersistentDebitTransferState debitTransferStateNew,SubjInterface subService,PersistentDebitTransferDoubleState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.debitTransferStateOld = debitTransferStateOld;
        this.debitTransferStateNew = debitTransferStateNew;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 228;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 228) ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade
            .newDebitTransferDoubleState(this.getId());
        super.store();
        if(this.getDebitTransferStateOld() != null){
            this.getDebitTransferStateOld().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.debitTransferStateOldSet(this.getId(), getDebitTransferStateOld());
        }
        if(this.getDebitTransferStateNew() != null){
            this.getDebitTransferStateNew().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.debitTransferStateNewSet(this.getId(), getDebitTransferStateNew());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentDebitTransferState getDebitTransferStateOld() throws PersistenceException {
        return this.debitTransferStateOld;
    }
    public void setDebitTransferStateOld(PersistentDebitTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransferStateOld)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransferStateOld = (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.debitTransferStateOldSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferState getDebitTransferStateNew() throws PersistenceException {
        return this.debitTransferStateNew;
    }
    public void setDebitTransferStateNew(PersistentDebitTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.debitTransferStateNew)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.debitTransferStateNew = (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.debitTransferStateNewSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferDoubleState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferDoubleState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferDoubleStateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentDebitTransferDoubleState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebitTransferDoubleState result = new DebitTransferDoubleStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebitTransferDoubleState)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebitTransferDoubleState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebitTransferDoubleState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebitTransferDoubleState(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getDebitTransferStateOld() != null) return 1;
        if (this.getDebitTransferStateNew() != null) return 1;
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
        this.setThis((PersistentDebitTransferDoubleState)This);
		if(this.equals(This)){
			this.setDebitTransferStateOld((PersistentDebitTransferState)final$$Fields.get("debitTransferStateOld"));
			this.setDebitTransferStateNew((PersistentDebitTransferState)final$$Fields.get("debitTransferStateNew"));
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
