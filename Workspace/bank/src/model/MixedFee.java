
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class MixedFee extends model.TransactionFee implements PersistentMixedFee{
    
    
    public static PersistentMixedFee createMixedFee(PersistentFixTransactionFee fix,PersistentProcentualFee procentual,PersistentMoney limit) throws PersistenceException{
        return createMixedFee(fix,procentual,limit,false);
    }
    
    public static PersistentMixedFee createMixedFee(PersistentFixTransactionFee fix,PersistentProcentualFee procentual,PersistentMoney limit,boolean delayed$Persistence) throws PersistenceException {
        PersistentMixedFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
                .newDelayedMixedFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
                .newMixedFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fix", fix);
        final$$Fields.put("procentual", procentual);
        final$$Fields.put("limit", limit);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentMixedFee createMixedFee(PersistentFixTransactionFee fix,PersistentProcentualFee procentual,PersistentMoney limit,boolean delayed$Persistence,PersistentMixedFee This) throws PersistenceException {
        PersistentMixedFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
                .newDelayedMixedFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
                .newMixedFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fix", fix);
        final$$Fields.put("procentual", procentual);
        final$$Fields.put("limit", limit);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot fix = (AbstractPersistentRoot)this.getFix();
            if (fix != null) {
                result.put("fix", fix.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    fix.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fix.hasEssentialFields())fix.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot procentual = (AbstractPersistentRoot)this.getProcentual();
            if (procentual != null) {
                result.put("procentual", procentual.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    procentual.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && procentual.hasEssentialFields())procentual.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot limit = (AbstractPersistentRoot)this.getLimit();
            if (limit != null) {
                result.put("limit", limit.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    limit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && limit.hasEssentialFields())limit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public MixedFee provideCopy() throws PersistenceException{
        MixedFee result = this;
        result = new MixedFee(this.subService, 
                              this.This, 
                              this.fix, 
                              this.procentual, 
                              this.limit, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentFixTransactionFee fix;
    protected PersistentProcentualFee procentual;
    protected PersistentMoney limit;
    
    public MixedFee(SubjInterface subService,PersistentTransactionFee This,PersistentFixTransactionFee fix,PersistentProcentualFee procentual,PersistentMoney limit,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentTransactionFee)This,id);
        this.fix = fix;
        this.procentual = procentual;
        this.limit = limit;        
    }
    
    static public long getTypeId() {
        return 129;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 129) ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade
            .newMixedFee(this.getId());
        super.store();
        if(this.getFix() != null){
            this.getFix().store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.fixSet(this.getId(), getFix());
        }
        if(this.getProcentual() != null){
            this.getProcentual().store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.procentualSet(this.getId(), getProcentual());
        }
        if(this.getLimit() != null){
            this.getLimit().store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.limitSet(this.getId(), getLimit());
        }
        
    }
    
    public PersistentFixTransactionFee getFix() throws PersistenceException {
        return this.fix;
    }
    public void setFix(PersistentFixTransactionFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.fix)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fix = (PersistentFixTransactionFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.fixSet(this.getId(), newValue);
        }
    }
    public PersistentProcentualFee getProcentual() throws PersistenceException {
        return this.procentual;
    }
    public void setProcentual(PersistentProcentualFee newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.procentual)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.procentual = (PersistentProcentualFee)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.procentualSet(this.getId(), newValue);
        }
    }
    public PersistentMoney getLimit() throws PersistenceException {
        return this.limit;
    }
    public void setLimit(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.limit)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.limit = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theMixedFeeFacade.limitSet(this.getId(), newValue);
        }
    }
    public PersistentMixedFee getThis() throws PersistenceException {
        if(this.This == null){
            PersistentMixedFee result = new MixedFeeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentMixedFee)this.This;
    }
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMixedFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMixedFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMixedFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMixedFee(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFix() != null) return 1;
        if (this.getProcentual() != null) return 1;
        if (this.getLimit() != null) return 1;
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
        this.setThis((PersistentMixedFee)This);
		if(this.equals(This)){
			this.setFix((PersistentFixTransactionFee)final$$Fields.get("fix"));
			this.setProcentual((PersistentProcentualFee)final$$Fields.get("procentual"));
			this.setLimit((PersistentMoney)final$$Fields.get("limit"));
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
