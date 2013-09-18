
package model;

import java.sql.Timestamp;
import java.util.Date;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferExceptionVisitor;
import model.visitor.DebitTransferReturnExceptionVisitor;
import model.visitor.DebitTransferReturnVisitor;
import model.visitor.DebitTransferStateReturnVisitor;
import model.visitor.DebitTransferTransactionExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnVisitor;
import model.visitor.DebitTransferTransactionVisitor;
import model.visitor.DebitTransferVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import model.visitor.TriggerValueExceptionVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentExecutedState;
import persistence.PersistentMoney;
import persistence.PersistentNoTrigger;
import persistence.PersistentNotExecutableState;
import persistence.PersistentNotExecutedState;
import persistence.PersistentNotSuccessfulState;
import persistence.PersistentStornoState;
import persistence.PersistentSuccessfulState;
import persistence.PersistentTemplateState;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerValue;
import persistence.SubjInterface;
import persistence.TDObserver;
import persistence.TransferProxi;

import common.Fraction;


/* Additional import section end */

public class Transfer extends model.DebitTransfer implements PersistentTransfer{
    
    
    public static PersistentTransfer createTransfer() throws PersistenceException{
        return createTransfer(false);
    }
    
    public static PersistentTransfer createTransfer(boolean delayed$Persistence) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentTransfer createTransfer(boolean delayed$Persistence,PersistentTransfer This) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,-1);
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
    
    public Transfer provideCopy() throws PersistenceException{
        Transfer result = this;
        result = new Transfer(this.timestamp, 
                              this.subject, 
                              this.sender, 
                              this.state, 
                              this.subService, 
                              this.This, 
                              this.receiverAccountNumber, 
                              this.receiverBankNumber, 
                              this.money, 
                              this.invokerTrigger, 
                              this.previousDebitTransfer, 
                              this.stornoState, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Transfer(java.sql.Timestamp timestamp,String subject,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,long receiverAccountNumber,long receiverBankNumber,PersistentMoney money,PersistentTriggerValue invokerTrigger,PersistentDebitTransfer previousDebitTransfer,PersistentStornoState stornoState,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(String)subject,(PersistentAccount)sender,(PersistentDebitTransferState)state,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,(long)receiverAccountNumber,(long)receiverBankNumber,(PersistentMoney)money,(PersistentTriggerValue)invokerTrigger,(PersistentDebitTransfer)previousDebitTransfer,(PersistentStornoState)stornoState,id);        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 122) ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .newTransfer(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,this.getId());
        super.store();
        
    }
    
    public PersistentTransfer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransfer result = new TransferProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentTransfer)this.This;
    }
    
    public void accept(DebitTransferVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getState() != null) return 1;
        if (this.getInvokerTrigger() != null) return 1;
        if (this.getPreviousDebitTransfer() != null) return 1;
        if (this.getNextDebitTransferTransactionstriggers().getLength() > 0) return 1;
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
        this.setThis((PersistentTransfer)This);
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
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException{
        return getThis().getMoney();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setMoney(Money.createMoney(Amount.createAmount(Fraction.parse("0/1")), Euro.getTheEuro()));
        getThis().setReceiverAccountNumber(0);
        getThis().setReceiverBankNumber(0);
        System.err.println("niti 0");
        getThis().setState(NotExecutedState.createNotExecutedState());
        getThis().setStornoState(NoRequestState.getTheNoRequestState());
        getThis().setInvokerTrigger(NoTrigger.createNoTrigger());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
		PersistentTransfer copy = Transfer.createTransfer();
		PersistentMoney copyMoney = Money.createMoney(Amount.createAmount(getThis().getMoney().getAmount().getBalance()), getThis().getMoney().getCurrency());
		copy.setMoney(copyMoney);
		copy.setReceiverAccountNumber(getThis().getReceiverAccountNumber());
		copy.setReceiverBankNumber(getThis().getReceiverBankNumber());
		copy.setSender(getThis().getSender());
		copy.setSubject(getThis().getSubject());
		PersistentDebitTransferState copyState = 
		getThis().getState().accept(new DebitTransferStateReturnVisitor<PersistentDebitTransferState>() {
			@Override
			public PersistentDebitTransferState handleExecutedState(
					PersistentExecutedState executedState)
					throws PersistenceException {
				return ExecutedState.createExecutedState();
			}

			@Override
			public PersistentDebitTransferState handleNotSuccessfulState(
					PersistentNotSuccessfulState notSuccessfulState)
					throws PersistenceException {
				return NotSuccessfulState.createNotSuccessfulState();
			}

			@Override
			public PersistentDebitTransferState handleSuccessfulState(
					PersistentSuccessfulState successfulState)
					throws PersistenceException {
				return SuccessfulState.createSuccessfulState();
			}

			@Override
			public PersistentDebitTransferState handleNotExecutedState(
					PersistentNotExecutedState notExecutedState)
					throws PersistenceException {
				return NotExecutedState.createNotExecutedState();
			}

			@Override
			public PersistentDebitTransferState handleTemplateState(
					PersistentTemplateState templateState)
					throws PersistenceException {
				return TemplateState.createTemplateState();
			}

			@Override
			public PersistentDebitTransferState handleNotExecutableState(
					PersistentNotExecutableState notExecutableState)
					throws PersistenceException {
				return NotExecutableState.createNotExecutableState();
			}
		});
		copy.setState(copyState);
		copy.setStornoState(getThis().getStornoState());
		copy.setTimestamp(getThis().getTimestamp());
		PersistentTriggerValue copyTrigger = getThis().getInvokerTrigger().copy();
		copy.setInvokerTrigger(copyTrigger);
		return copy;
	}
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException{
    	if(getThis().getPreviousDebitTransfer() != null) {
	    	getThis().getPreviousDebitTransfer().getInvokerTrigger().accept(new TriggerValueExceptionVisitor<TriggerCyclicException>() {
				@Override
				public void handleNoTrigger(PersistentNoTrigger noTrigger)
						throws PersistenceException, TriggerCyclicException {
					System.out.println("no Trigger");
				}
				@Override
				public void handleTrigger(PersistentTrigger trigger)
						throws PersistenceException, TriggerCyclicException {
					System.out.println("trigger okay");
					if(getThis().contains(trigger).isTrue()) {
						throw new TriggerCyclicException();
					}
				}
			});
    	}
    	if (!getThis().getState().isExecutable().isTrue()) {
    		throw new NoPermissionToExecuteDebitTransferException();
    	}
    	Timestamp tstamp = new Timestamp(new Date().getTime());
    	getThis().setTimestamp(tstamp);
    	getThis().getSender().getBank().sendTransfer(getThis());
		return getThis();
	}

    /* Start of protected part that is not overridden by persistence generator */
 
    /* End of protected part that is not overridden by persistence generator */
    
}
