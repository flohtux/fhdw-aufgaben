
package model;

import model.visitor.DebitTransferStateVisitor;
import model.visitor.DebitTransferTransactionReturnVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentBooleanValue;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentExecutedState;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransaction;
import persistence.PersistentTransfer;
import persistence.SubjInterface;
import persistence.TDObserver;


/* Additional import section end */

public abstract class DebitTransferState extends PersistentObject implements PersistentDebitTransferState{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentDebitTransferState getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theDebitTransferStateFacade.getClass(objectId);
        return (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot debitTransfer = (AbstractPersistentRoot)this.getDebitTransfer();
            if (debitTransfer != null) {
                result.put("debitTransfer", debitTransfer.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    debitTransfer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && debitTransfer.hasEssentialFields())debitTransfer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitTransferState provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected SubjInterface subService;
    protected PersistentDebitTransferState This;
    
    public DebitTransferState(SubjInterface subService,PersistentDebitTransferState This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
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
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferStateFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferStateFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theDebitTransferStateFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentDebitTransferState newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentDebitTransferState)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferStateFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitTransferState getThis() throws PersistenceException ;
    
    
    
    public PersistentDebitTransferTransaction getDebitTransfer() 
				throws PersistenceException{
        PersistentDebitTransferTransaction result = null;
		try {
			if (result == null) result = (PersistentDebitTransferTransaction)ConnectionHandler.getTheConnectionHandler().theDebitTransferTransactionFacade
							.inverseGetState(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitTransferState)This);
		if(this.equals(This)){
		}
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
    
    public void addDebitTransferFromList(final PersistentDebitTransferState state) 
				throws PersistenceException{
    	if(!getThis().isTransaction().isTrue()) {
	    	state.accept(new DebitTransferStateVisitor() {
				@Override
				public void handleTemplateState(PersistentTemplateState templateState)
						throws PersistenceException {
					getThis().getDebitTransfer().getSender().getAccountService().getTemplate().add(getThis().getDebitTransfer());
					
				}
				@Override
				public void handleSuccessfulState(PersistentSuccessfulState successfulState)
						throws PersistenceException {
					getThis().getDebitTransfer().getSender().getAccountService().getSuccessful().add(getThis().getDebitTransfer());
				}
				@Override
				public void handleNotSuccessfulState(
						PersistentNotSuccessfulState notSuccessfulState)
						throws PersistenceException {
					getThis().getDebitTransfer().getSender().getAccountService().getSuccessful().add(getThis().getDebitTransfer());
				}
				@Override
				public void handleNotExecutedState(
						PersistentNotExecutedState notExecutedState)
						throws PersistenceException {
					getThis().getDebitTransfer().getSender().getAccountService().getNotExecuted().add(getThis().getDebitTransfer());
				}
				@Override
				public void handleNotExecutableState(
						PersistentNotExecutableState notExecutableState)
						throws PersistenceException {}
				@Override
				public void handleExecutedState(PersistentExecutedState executedState)
						throws PersistenceException {}
			});
    	}
		
	}
    public PersistentBooleanValue isTransaction() 
				throws PersistenceException{
    	return getThis().getDebitTransfer().accept(new DebitTransferTransactionReturnVisitor<PersistentBooleanValue>() {
			@Override
			public PersistentBooleanValue handleTransfer(PersistentTransfer transfer)
					throws PersistenceException {
				return FalseValue.getTheFalseValue();
			}
			@Override
			public PersistentBooleanValue handleDebit(PersistentDebit debit)
					throws PersistenceException {
				return FalseValue.getTheFalseValue();
			}
			@Override
			public PersistentBooleanValue handleTransaction(
					PersistentTransaction transaction)
					throws PersistenceException {
				return TrueValue.getTheTrueValue();
			}
		});
    }
    public void removeDebitTransferFromList() 
				throws PersistenceException{
	    	getThis().accept(new DebitTransferStateVisitor() {
	    		@Override
	    		public void handleTemplateState(PersistentTemplateState templateState)
	    				throws PersistenceException {
	    			getThis().getDebitTransfer().getSender().getAccountService().getTemplate().remove(getThis().getDebitTransfer());
	    		}
	    		@Override
	    		public void handleSuccessfulState(PersistentSuccessfulState successfulState)
	    				throws PersistenceException {
	    			getThis().getDebitTransfer().getSender().getAccountService().getSuccessful().remove(getThis().getDebitTransfer());
	    		}
	    		@Override
	    		public void handleNotSuccessfulState(
	    				PersistentNotSuccessfulState notSuccessfulState)
	    				throws PersistenceException {}
	    		@Override
	    		public void handleNotExecutedState(
	    				PersistentNotExecutedState notExecutedState)
	    				throws PersistenceException {
	    			getThis().getDebitTransfer().getSender().getAccountService().getNotExecuted().remove(getThis().getDebitTransfer());
	    		}
	    			
	    		@Override
	    		public void handleNotExecutableState(
	    				PersistentNotExecutableState notExecutableState)
	    				throws PersistenceException {}
	    		@Override
	    		public void handleExecutedState(PersistentExecutedState executedState)
	    				throws PersistenceException {}
	    	});
    }

    /* Start of protected part that is not overridden by persistence generator */
       
    /* End of protected part that is not overridden by persistence generator */
    
}
