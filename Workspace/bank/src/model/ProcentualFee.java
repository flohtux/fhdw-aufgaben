
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import model.visitor.TransactionFeeExceptionVisitor;
import model.visitor.TransactionFeeReturnExceptionVisitor;
import model.visitor.TransactionFeeReturnVisitor;
import model.visitor.TransactionFeeVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentPercent;
import persistence.PersistentProcentualFee;
import persistence.PersistentProxi;
import persistence.PersistentTransactionFee;
import persistence.ProcentualFeeProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class ProcentualFee extends model.TransactionFee implements PersistentProcentualFee{
    
    
    public static PersistentProcentualFee createProcentualFee(PersistentPercent percent) throws PersistenceException{
        return createProcentualFee(percent,false);
    }
    
    public static PersistentProcentualFee createProcentualFee(PersistentPercent percent,boolean delayed$Persistence) throws PersistenceException {
        PersistentProcentualFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade
                .newDelayedProcentualFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade
                .newProcentualFee(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("percent", percent);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentProcentualFee createProcentualFee(PersistentPercent percent,boolean delayed$Persistence,PersistentProcentualFee This) throws PersistenceException {
        PersistentProcentualFee result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade
                .newDelayedProcentualFee();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade
                .newProcentualFee(-1);
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
    
    public ProcentualFee provideCopy() throws PersistenceException{
        ProcentualFee result = this;
        result = new ProcentualFee(this.subService, 
                                   this.This, 
                                   this.percent, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentPercent percent;
    
    public ProcentualFee(SubjInterface subService,PersistentTransactionFee This,PersistentPercent percent,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentTransactionFee)This,id);
        this.percent = percent;        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 120) ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade
            .newProcentualFee(this.getId());
        super.store();
        if(this.getPercent() != null){
            this.getPercent().store();
            ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade.percentSet(this.getId(), getPercent());
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
            ConnectionHandler.getTheConnectionHandler().theProcentualFeeFacade.percentSet(this.getId(), newValue);
        }
    }
    public PersistentProcentualFee getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProcentualFee result = new ProcentualFeeProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentProcentualFee)this.This;
    }
    
    public void accept(TransactionFeeVisitor visitor) throws PersistenceException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(TransactionFeeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(TransactionFeeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(TransactionFeeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProcentualFee(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProcentualFee(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProcentualFee(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProcentualFee(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProcentualFee(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProcentualFee(this);
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
        this.setThis((PersistentProcentualFee)This);
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
