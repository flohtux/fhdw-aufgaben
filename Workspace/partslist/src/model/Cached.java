
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Cached extends model.State implements PersistentCached{
    
    
    public static PersistentCached createCached(PersistentMateriallist cachedList) throws PersistenceException{
        return createCached(cachedList,false);
    }
    
    public static PersistentCached createCached(PersistentMateriallist cachedList,boolean delayed$Persistence) throws PersistenceException {
        PersistentCached result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCachedFacade
                .newDelayedCached();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCachedFacade
                .newCached(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("cachedList", cachedList);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentCached createCached(PersistentMateriallist cachedList,boolean delayed$Persistence,PersistentCached This) throws PersistenceException {
        PersistentCached result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCachedFacade
                .newDelayedCached();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCachedFacade
                .newCached(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("cachedList", cachedList);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot cachedList = (AbstractPersistentRoot)this.getCachedList();
            if (cachedList != null) {
                result.put("cachedList", cachedList.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    cachedList.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && cachedList.hasEssentialFields())cachedList.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Cached provideCopy() throws PersistenceException{
        Cached result = this;
        result = new Cached(this.This, 
                            this.cachedList, 
                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentMateriallist cachedList;
    
    public Cached(PersistentState This,PersistentMateriallist cachedList,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentState)This,id);
        this.cachedList = cachedList;        
    }
    
    static public long getTypeId() {
        return 107;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 107) ConnectionHandler.getTheConnectionHandler().theCachedFacade
            .newCached(this.getId());
        super.store();
        if(this.getCachedList() != null){
            this.getCachedList().store();
            ConnectionHandler.getTheConnectionHandler().theCachedFacade.cachedListSet(this.getId(), getCachedList());
        }
        
    }
    
    public PersistentMateriallist getCachedList() throws PersistenceException {
        return this.cachedList;
    }
    public void setCachedList(PersistentMateriallist newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.cachedList)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.cachedList = (PersistentMateriallist)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theCachedFacade.cachedListSet(this.getId(), newValue);
        }
    }
    public PersistentCached getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCached result = new CachedProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentCached)this.This;
    }
    
    public void accept(StateVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(StateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(StateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(StateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCached(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCached(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCached(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCached(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getMaster() != null) return 1;
        if (this.getCachedList() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentCached)This);
		if(this.equals(This)){
			this.setCachedList((PersistentMateriallist)final$$Fields.get("cachedList"));
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
		return getThis().getCachedList();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
