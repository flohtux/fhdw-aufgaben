
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FeeWrapperProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentFeeWrapper;
import persistence.PersistentInternalFee;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentTransactionFee;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class FeeWrapper extends PersistentObject implements PersistentFeeWrapper{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentFeeWrapper getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.getClass(objectId);
        return (PersistentFeeWrapper)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentFeeWrapper createFeeWrapper(PersistentTransactionFee fee,PersistentInternalFee internalFee) throws PersistenceException{
        return createFeeWrapper(fee,internalFee,false);
    }
    
    public static PersistentFeeWrapper createFeeWrapper(PersistentTransactionFee fee,PersistentInternalFee internalFee,boolean delayed$Persistence) throws PersistenceException {
        PersistentFeeWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
                .newDelayedFeeWrapper();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
                .newFeeWrapper(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fee", fee);
        final$$Fields.put("internalFee", internalFee);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFeeWrapper createFeeWrapper(PersistentTransactionFee fee,PersistentInternalFee internalFee,boolean delayed$Persistence,PersistentFeeWrapper This) throws PersistenceException {
        PersistentFeeWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
                .newDelayedFeeWrapper();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
                .newFeeWrapper(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fee", fee);
        final$$Fields.put("internalFee", internalFee);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot fee = (AbstractPersistentRoot)this.getFee();
            if (fee != null) {
                result.put("fee", fee.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    fee.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fee.hasEssentialFields())fee.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot internalFee = (AbstractPersistentRoot)this.getInternalFee();
            if (internalFee != null) {
                result.put("internalFee", internalFee.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    internalFee.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && internalFee.hasEssentialFields())internalFee.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FeeWrapper provideCopy() throws PersistenceException{
        FeeWrapper result = this;
        result = new FeeWrapper(this.fee, 
                                this.internalFee, 
                                this.subService, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentTransactionFee fee;
    protected PersistentInternalFee internalFee;
    protected SubjInterface subService;
    protected PersistentFeeWrapper This;
    
    public FeeWrapper(PersistentTransactionFee fee,PersistentInternalFee internalFee,SubjInterface subService,PersistentFeeWrapper This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fee = fee;
        this.internalFee = internalFee;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 242;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 242) ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade
            .newFeeWrapper(this.getId());
        super.store();
        if(this.getFee() != null){
            this.getFee().store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.feeSet(this.getId(), getFee());
        }
        if(this.getInternalFee() != null){
            this.getInternalFee().store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.internalFeeSet(this.getId(), getInternalFee());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentTransactionFee getFee() throws PersistenceException {
        return this.fee;
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fee = (PersistentTransactionFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.feeSet(this.getId(), newValue);
        }
    }
    public PersistentInternalFee getInternalFee() throws PersistenceException {
        return this.internalFee;
    }
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.internalFee)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.internalFee = (PersistentInternalFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.internalFeeSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentFeeWrapper newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentFeeWrapper)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFeeWrapperFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentFeeWrapper getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFeeWrapper result = new FeeWrapperProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFeeWrapper)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleFeeWrapper(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFeeWrapper(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFeeWrapper(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFeeWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFeeWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFeeWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFeeWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFeeWrapper(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFee() != null) return 1;
        if (this.getInternalFee() != null) return 1;
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
        this.setThis((PersistentFeeWrapper)This);
		if(this.equals(This)){
			this.setFee((PersistentTransactionFee)final$$Fields.get("fee"));
			this.setInternalFee((PersistentInternalFee)final$$Fields.get("internalFee"));
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
