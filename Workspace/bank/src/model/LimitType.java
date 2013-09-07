
package model;

import model.visitor.LimitTypeExceptionVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentLimit;
import persistence.PersistentLimitType;
import persistence.PersistentMoney;
import persistence.PersistentNoLimit;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public abstract class LimitType extends PersistentObject implements PersistentLimitType{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentLimitType getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theLimitTypeFacade.getClass(objectId);
        return (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
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
    
    public abstract LimitType provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected SubjInterface subService;
    protected PersistentLimitType This;
    
    public LimitType(SubjInterface subService,PersistentLimitType This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 140;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theLimitTypeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theLimitTypeFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theLimitTypeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentLimitType newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentLimitType)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theLimitTypeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentLimitType getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentLimitType)This);
		if(this.equals(This)){
		}
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
    
    public void checkMaxLimit(final PersistentMoney money) 
				throws model.LimitViolatedException, PersistenceException{
    	getThis().accept(new LimitTypeExceptionVisitor<LimitViolatedException>() {

			@Override
			public void handleNoLimit(PersistentNoLimit noLimit) throws PersistenceException, LimitViolatedException {
				return;
			}

			@Override
			public void handleLimit(PersistentLimit limit) throws PersistenceException, LimitViolatedException {
				if (limit.getMoney().greaterOrEqual(money).isTrue()) {
					return;
				} else {
					throw new LimitViolatedException();
				}
			}
		});
    	
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
