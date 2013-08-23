
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class FixTransactionFee extends model.TransactionFee implements PersistentFixTransactionFee{
    
    
    public static PersistentFixTransactionFee createFixTransactionFee(PersistentMoney value) throws PersistenceException{
        return createFixTransactionFee(value,false);
    }
    
    public static PersistentFixTransactionFee createFixTransactionFee(PersistentMoney value,boolean delayed$Persistence) throws PersistenceException {
        PersistentFixTransactionFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
                .newDelayedFixTransactionFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
                .newFixTransactionFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentFixTransactionFee createFixTransactionFee(PersistentMoney value,boolean delayed$Persistence,PersistentFixTransactionFee This) throws PersistenceException {
        PersistentFixTransactionFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
                .newDelayedFixTransactionFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
                .newFixTransactionFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("value", value);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot value = (AbstractPersistentRoot)this.getValue();
            if (value != null) {
                result.put("value", value.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    value.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && value.hasEssentialFields())value.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public FixTransactionFee provideCopy() throws PersistenceException{
        FixTransactionFee result = this;
        result = new FixTransactionFee(this.subService, 
                                       this.This, 
                                       this.value, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMoney value;
    
    public FixTransactionFee(SubjInterface subService,PersistentTransactionFee This,PersistentMoney value,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentTransactionFee)This,id);
        this.value = value;        
    }
    
    static public long getTypeId() {
        return 108;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 108) ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade
            .newFixTransactionFee(this.getId());
        super.store();
        if(this.getValue() != null){
            this.getValue().store();
            ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade.valueSet(this.getId(), getValue());
        }
        
    }
    
    public PersistentMoney getValue() throws PersistenceException {
        return this.value;
    }
    public void setValue(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.value)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.value = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theFixTransactionFeeFacade.valueSet(this.getId(), newValue);
        }
    }
    public PersistentFixTransactionFee getThis() throws PersistenceException {
        if(this.This == null){
            PersistentFixTransactionFee result = new FixTransactionFeeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentFixTransactionFee)this.This;
    }
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFixTransactionFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFixTransactionFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFixTransactionFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFixTransactionFee(this);
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
        this.setThis((PersistentFixTransactionFee)This);
		if(this.equals(This)){
			this.setValue((PersistentMoney)final$$Fields.get("value"));
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
