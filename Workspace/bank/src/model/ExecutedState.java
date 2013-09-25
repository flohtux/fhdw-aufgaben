
package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferStateExceptionVisitor;
import model.visitor.DebitTransferStateReturnExceptionVisitor;
import model.visitor.DebitTransferStateReturnVisitor;
import model.visitor.DebitTransferStateVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ExecutedStateProxi;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebitTransferState;
import persistence.PersistentExecutedState;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public class ExecutedState extends model.DebitTransferState implements PersistentExecutedState{
    
    
    public static PersistentExecutedState createExecutedState() throws PersistenceException{
        return createExecutedState(false);
    }
    
    public static PersistentExecutedState createExecutedState(boolean delayed$Persistence) throws PersistenceException {
        PersistentExecutedState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
                .newDelayedExecutedState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
                .newExecutedState(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentExecutedState createExecutedState(boolean delayed$Persistence,PersistentExecutedState This) throws PersistenceException {
        PersistentExecutedState result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
                .newDelayedExecutedState();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
                .newExecutedState(-1);
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
    
    public ExecutedState provideCopy() throws PersistenceException{
        ExecutedState result = this;
        result = new ExecutedState(this.subService, 
                                   this.This, 
                                   this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public ExecutedState(SubjInterface subService,PersistentDebitTransferState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentDebitTransferState)This,id);        
    }
    
    static public long getTypeId() {
        return 110;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 110) ConnectionHandler.getTheConnectionHandler().theExecutedStateFacade
            .newExecutedState(this.getId());
        super.store();
        
    }
    
    public PersistentExecutedState getThis() throws PersistenceException {
        if(this.This == null){
            PersistentExecutedState result = new ExecutedStateProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentExecutedState)this.This;
    }
    
    public void accept(DebitTransferStateVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(DebitTransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(DebitTransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(DebitTransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleExecutedState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleExecutedState(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleExecutedState(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleExecutedState(this);
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
        this.setThis((PersistentExecutedState)This);
		if(this.equals(This)){
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
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
		getThis().removeDebitTransferFromList();
		getThis().getDebitTransfer().setState(newState);
		
	}
    public PersistentDebitTransferState copy() 
				throws PersistenceException{
		return ExecutedState.createExecutedState();
	}
    public PersistentBooleanValue isExecutable() 
				throws PersistenceException{
		return FalseValue.getTheFalseValue();
	}

	@Override
	public PersistentBooleanValue isCompensated() throws PersistenceException {
		return FalseValue.getTheFalseValue();
	}

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
