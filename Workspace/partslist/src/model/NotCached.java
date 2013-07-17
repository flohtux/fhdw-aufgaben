
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class NotCached extends model.State implements PersistentNotCached{
    
    
    public static PersistentNotCached createNotCached() throws PersistenceException{
        return createNotCached(false);
    }
    
    public static PersistentNotCached createNotCached(boolean delayed$Persistence) throws PersistenceException {
        PersistentNotCached result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
                .newDelayedNotCached();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
                .newNotCached(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentNotCached createNotCached(boolean delayed$Persistence,PersistentNotCached This) throws PersistenceException {
        PersistentNotCached result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
                .newDelayedNotCached();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
                .newNotCached(-1);
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
    
    public NotCached provideCopy() throws PersistenceException{
        NotCached result = this;
        result = new NotCached(this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public NotCached(PersistentState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentState)This,id);        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 113) ConnectionHandler.getTheConnectionHandler().theNotCachedFacade
            .newNotCached(this.getId());
        super.store();
        
    }
    
    public PersistentNotCached getThis() throws PersistenceException {
        if(this.This == null){
            PersistentNotCached result = new NotCachedProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentNotCached)this.This;
    }
    
    public void accept(StateVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotCached(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMaster() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentNotCached)This);
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
    
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
		PersistentMateriallist calcList = getThis().getMaster().createMateriallist();
		getThis().getMaster().setCurrentState(Cached.createCached(calcList));
		return calcList;
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
