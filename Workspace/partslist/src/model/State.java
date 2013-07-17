
package model;

import persistence.*;


/* Additional import section end */

public abstract class State extends PersistentObject implements PersistentState{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentState getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStateFacade.getClass(objectId);
        return (PersistentState)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot master = (AbstractPersistentRoot)this.getMaster();
            if (master != null) {
                result.put("master", master.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    master.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && master.hasEssentialFields())master.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract State provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentState This;
    
    public State(PersistentState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStateFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentState getThis() throws PersistenceException ;
    
    
    
    public PersistentComponent getMaster() 
				throws PersistenceException{
        PersistentComponent result = null;
		try {
			if (result == null) result = (PersistentComponent)ConnectionHandler.getTheConnectionHandler().theComponentFacade
							.inverseGetCurrentState(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentState)This);
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
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
