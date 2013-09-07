
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.LimitTypeExceptionVisitor;
import model.visitor.LimitTypeReturnExceptionVisitor;
import model.visitor.LimitTypeReturnVisitor;
import model.visitor.LimitTypeVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.LimitProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentLimit;
import persistence.PersistentLimitType;
import persistence.PersistentMoney;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class Limit extends model.LimitType implements PersistentLimit{
    
    
    public static PersistentLimit createLimit(PersistentMoney money) throws PersistenceException{
        return createLimit(money,false);
    }
    
    public static PersistentLimit createLimit(PersistentMoney money,boolean delayed$Persistence) throws PersistenceException {
        PersistentLimit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLimitFacade
                .newDelayedLimit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLimitFacade
                .newLimit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("money", money);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentLimit createLimit(PersistentMoney money,boolean delayed$Persistence,PersistentLimit This) throws PersistenceException {
        PersistentLimit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theLimitFacade
                .newDelayedLimit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theLimitFacade
                .newLimit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("money", money);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot money = (AbstractPersistentRoot)this.getMoney();
            if (money != null) {
                result.put("money", money.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    money.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && money.hasEssentialFields())money.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Limit provideCopy() throws PersistenceException{
        Limit result = this;
        result = new Limit(this.subService, 
                           this.This, 
                           this.money, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMoney money;
    
    public Limit(SubjInterface subService,PersistentLimitType This,PersistentMoney money,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentLimitType)This,id);
        this.money = money;        
    }
    
    static public long getTypeId() {
        return 128;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 128) ConnectionHandler.getTheConnectionHandler().theLimitFacade
            .newLimit(this.getId());
        super.store();
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theLimitFacade.moneySet(this.getId(), getMoney());
        }
        
    }
    
    public PersistentMoney getMoney() throws PersistenceException {
        return this.money;
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.money)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.money = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitFacade.moneySet(this.getId(), newValue);
        }
    }
    public PersistentLimit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentLimit result = new LimitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentLimit)this.This;
    }
    
    public void accept(LimitTypeVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(LimitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(LimitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(LimitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleLimit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleLimit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleLimit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleLimit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMoney() != null && this.getMoney().getTheObject().getLeafInfo() != 0) return 1;
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
        this.setThis((PersistentLimit)This);
		if(this.equals(This)){
			this.setMoney((PersistentMoney)final$$Fields.get("money"));
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
