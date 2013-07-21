
package model;

import persistence.*;


/* Additional import section end */

public abstract class DebitNoteTransferState extends PersistentObject implements PersistentDebitNoteTransferState{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitNoteTransferState getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.getClass(objectId);
        return (PersistentDebitNoteTransferState)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot state = (AbstractPersistentRoot)this.getState();
            if (state != null) {
                result.put("state", state.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    state.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && state.hasEssentialFields())state.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot stornoState = (AbstractPersistentRoot)this.getStornoState();
            if (stornoState != null) {
                result.put("stornoState", stornoState.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    stornoState.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && stornoState.hasEssentialFields())stornoState.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot debitNoteTransfer = (AbstractPersistentRoot)this.getDebitNoteTransfer();
            if (debitNoteTransfer != null) {
                result.put("debitNoteTransfer", debitNoteTransfer.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitNoteTransfer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitNoteTransfer.hasEssentialFields())debitNoteTransfer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitNoteTransferState provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentDebitNoteTransferState state;
    protected PersistentStornoState stornoState;
    protected SubjInterface subService;
    protected PersistentDebitNoteTransferState This;
    
    public DebitNoteTransferState(PersistentDebitNoteTransferState state,PersistentStornoState stornoState,SubjInterface subService,PersistentDebitNoteTransferState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.state = state;
        this.stornoState = stornoState;
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 150;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getState() != null){
            this.getState().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.stateSet(this.getId(), getState());
        }
        if(this.getStornoState() != null){
            this.getStornoState().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.stornoStateSet(this.getId(), getStornoState());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public PersistentDebitNoteTransferState getState() throws PersistenceException {
        return this.state;
    }
    public void setState(PersistentDebitNoteTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.state)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.state = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.stateSet(this.getId(), newValue);
        }
    }
    public PersistentStornoState getStornoState() throws PersistenceException {
        return this.stornoState;
    }
    public void setStornoState(PersistentStornoState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.stornoState)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.stornoState = (PersistentStornoState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.stornoStateSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitNoteTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitNoteTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitNoteTransferState getThis() throws PersistenceException ;
    
    
    
    public PersistentDebitNoteTransferState getDebitNoteTransfer() 
				throws PersistenceException{
        PersistentDebitNoteTransferState result = null;
		try {
			if (result == null) result = (PersistentDebitNoteTransferState)ConnectionHandler.getTheConnectionHandler().theDebitNoteTransferStateFacade
							.inverseGetState(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitNoteTransferState)This);
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