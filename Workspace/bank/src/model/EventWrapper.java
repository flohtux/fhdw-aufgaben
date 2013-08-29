
package model;

import persistence.*;
import model.meta.DebitTransferChangeCurrencyCurrencyMssg;
import model.meta.DebitTransferChangeMoneyFractionMssg;
import model.meta.DebitTransferChangeReceiverAccountIntegerMssg;
import model.meta.DebitTransferChangeReceiverBankIntegerMssg;
import model.meta.DebitTransferTransactionChangeStateDebitTransferStateMssg;
import model.meta.DebitTransferTransactionExecuteMssg;
import model.meta.DebitTransferTransactionMssgsVisitor;
import model.visitor.*;


/* Additional import section end */

public class EventWrapper extends PersistentObject implements PersistentEventWrapper{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentEventWrapper getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade.getClass(objectId);
        return (PersistentEventWrapper)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentEventWrapper createEventWrapper() throws PersistenceException{
        return createEventWrapper(false);
    }
    
    public static PersistentEventWrapper createEventWrapper(boolean delayed$Persistence) throws PersistenceException {
        PersistentEventWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade
                .newDelayedEventWrapper();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade
                .newEventWrapper(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentEventWrapper createEventWrapper(boolean delayed$Persistence,PersistentEventWrapper This) throws PersistenceException {
        PersistentEventWrapper result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade
                .newDelayedEventWrapper();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade
                .newEventWrapper(-1);
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
    
    public EventWrapper provideCopy() throws PersistenceException{
        EventWrapper result = this;
        result = new EventWrapper(this.subService, 
                                  this.This, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected SubjInterface subService;
    protected PersistentEventWrapper This;
    
    public EventWrapper(SubjInterface subService,PersistentEventWrapper This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.subService = subService;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 227;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 227) ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade
            .newEventWrapper(this.getId());
        super.store();
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.equals(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentEventWrapper newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentEventWrapper)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theEventWrapperFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentEventWrapper getThis() throws PersistenceException {
        if(this.This == null){
            PersistentEventWrapper result = new EventWrapperProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentEventWrapper)this.This;
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleEventWrapper(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEventWrapper(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEventWrapper(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEventWrapper(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEventWrapper(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEventWrapper(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEventWrapper(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEventWrapper(this);
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
    public PersistentAccountService getAccountService() 
				throws PersistenceException{
        PersistentAccountService result = null;
		try {
			if (result == null) result = (PersistentAccountService)ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
							.inverseGetEventhandle(this.getId(), this.getClassId()).iterator().next();
		} catch (java.util.NoSuchElementException nsee){}
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentEventWrapper)This);
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
    public void reactOnEvent(final model.meta.DebitTransferTransactionMssgs ev) 
				throws PersistenceException{
        ev.accept(new DebitTransferTransactionMssgsVisitor() {
			@Override
			public void handleDebitTransferChangeReceiverBankIntegerMssg(DebitTransferChangeReceiverBankIntegerMssg event) throws PersistenceException {}
			@Override
			public void handleDebitTransferChangeReceiverAccountIntegerMssg(DebitTransferChangeReceiverAccountIntegerMssg event) throws PersistenceException {}
			@Override
			public void handleDebitTransferChangeMoneyFractionMssg(DebitTransferChangeMoneyFractionMssg event) throws PersistenceException {}
			@Override
			public void handleDebitTransferChangeCurrencyCurrencyMssg(DebitTransferChangeCurrencyCurrencyMssg event) throws PersistenceException {}
			@Override
			public void handleDebitTransferTransactionExecuteMssg(DebitTransferTransactionExecuteMssg event) throws PersistenceException {
				PersistentDebitTransferTransaction result;
				try {
					result = event.getResult();
					
				} catch (ExecuteException e) {
					return;
				}
				getThis().getAccountService().getSuccessful().add(result);
			}
			@Override
			public void handleDebitTransferTransactionChangeStateDebitTransferStateMssg(DebitTransferTransactionChangeStateDebitTransferStateMssg event)
					throws PersistenceException {
				final PersistentDebitTransferTransaction object = event.getResult().getDebitTransferStateNew().getDebitTransfer();
				event.getResult().getDebitTransferStateOld().accept(new DebitTransferStateVisitor() {
					@Override
					public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException {
						getThis().getAccountService().getTemplate().remove(object);
					}
					@Override
					public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException {
						getThis().getAccountService().getSuccessful().remove(object);
					}
					@Override
					public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException {
					}
					@Override
					public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException {
						getThis().getAccountService().getNotExecuted().remove(object);
					}
					@Override
					public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException {
					}
					@Override
					public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException {
					}
				});
				event.getResult().getDebitTransferStateNew().accept(new DebitTransferStateVisitor() {
					@Override
					public void handleTemplateState(PersistentTemplateState templateState) throws PersistenceException {
						getThis().getAccountService().getTemplate().add(object);
					}
					@Override
					public void handleSuccessfulState(PersistentSuccessfulState successfulState) throws PersistenceException {
						getThis().getAccountService().getSuccessful().add(object);
					}
					@Override
					public void handleNotSuccessfulState(PersistentNotSuccessfulState notSuccessfulState) throws PersistenceException {
					}
					@Override
					public void handleNotExecutedState(PersistentNotExecutedState notExecutedState) throws PersistenceException {
						getThis().getAccountService().getNotExecuted().add(object);
					}
					@Override
					public void handleNotExecutableState(PersistentNotExecutableState notExecutableState) throws PersistenceException {
					}
					@Override
					public void handleExecutedState(PersistentExecutedState executedState) throws PersistenceException {
					}
				});
			}
		});
        getThis().getAccountService().signalChanged(true);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
