
package model;

import persistence.*;


/* Additional import section end */

public abstract class Component extends PersistentObject implements PersistentComponent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentComponent getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theComponentFacade.getClass(objectId);
        return (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            AbstractPersistentRoot currentState = (AbstractPersistentRoot)this.getCurrentState();
            if (currentState != null) {
                result.put("currentState", currentState.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    currentState.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && currentState.hasEssentialFields())currentState.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("partOf", this.getPartOf().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ComponentSearchList getComponentByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theComponentFacade
            .getComponentByName(name);
    }
    
    public abstract Component provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentState currentState;
    protected PersistentComponent This;
    
    public Component(String name,PersistentState currentState,PersistentComponent This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.currentState = currentState;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 117;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getCurrentState() != null){
            this.getCurrentState().store();
            ConnectionHandler.getTheConnectionHandler().theComponentFacade.currentStateSet(this.getId(), getCurrentState());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theComponentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theComponentFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public PersistentState getCurrentState() throws PersistenceException {
        return this.currentState;
    }
    public void setCurrentState(PersistentState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.currentState)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.currentState = (PersistentState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theComponentFacade.currentStateSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentComponent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentComponent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theComponentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentComponent getThis() throws PersistenceException ;
    
    
    
    public QPartSearchList getPartOf() 
				throws PersistenceException{
        QPartSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theQPartFacade
							.inverseGetComponent(this.getId(), this.getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentComponent)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{

    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentMateriallist fetchMateriallist() 
				throws PersistenceException{
    	return getThis().getCurrentState().fetchMateriallist();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
