
package model;

import java.sql.Timestamp;
import java.util.Date;

import model.visitor.DebitTransferNoValueExceptionVisitor;
import model.visitor.DebitTransferNoValueReturnVisitor;
import model.visitor.DebitTransferReturnExceptionVisitor;
import model.visitor.TriggerValueExceptionVisitor;
import model.visitor.TriggerValueReturnVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.DebitTransferNoValue;
import persistence.DebitTransfer_NextDebitTransferTransactionstriggersProxi;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentBank;
import persistence.PersistentBooleanValue;
import persistence.PersistentCurrency;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentMoney;
import persistence.PersistentNoDebitTransfer;
import persistence.PersistentNoTrigger;
import persistence.PersistentProxi;
import persistence.PersistentTransfer;
import persistence.PersistentTrigger;
import persistence.PersistentTriggerValue;
import persistence.SubjInterface;
import persistence.TDObserver;

import common.Fraction;


/* Additional import section end */

public abstract class DebitTransfer extends model.DebitTransferTransaction implements PersistentDebitTransfer{
    
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("receiverAccountNumber", new Long(this.getReceiverAccountNumber()).toString());
            result.put("receiverBankNumber", new Long(this.getReceiverBankNumber()).toString());
            AbstractPersistentRoot receiver = (AbstractPersistentRoot)this.getReceiver();
            if (receiver != null) {
                result.put("receiver", receiver.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    receiver.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && receiver.hasEssentialFields())receiver.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot money = (AbstractPersistentRoot)this.getMoney();
            if (money != null) {
                result.put("money", money.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    money.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && money.hasEssentialFields())money.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot invokerTrigger = (AbstractPersistentRoot)this.getInvokerTrigger();
            if (invokerTrigger != null) {
                result.put("invokerTrigger", invokerTrigger.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    invokerTrigger.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && invokerTrigger.hasEssentialFields())invokerTrigger.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("nextDebitTransferTransactionstriggers", this.getNextDebitTransferTransactionstriggers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
            AbstractPersistentRoot previousDebitTransfer = (AbstractPersistentRoot)this.getPreviousDebitTransfer();
            if (previousDebitTransfer != null) {
                result.put("previousDebitTransfer", previousDebitTransfer.createProxiInformation(false, essentialLevel == 0));
                if(depth > 1) {
                    previousDebitTransfer.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && previousDebitTransfer.hasEssentialFields())previousDebitTransfer.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public abstract DebitTransfer provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long receiverAccountNumber;
    protected long receiverBankNumber;
    protected PersistentAccount receiver;
    protected PersistentMoney money;
    protected PersistentTriggerValue invokerTrigger;
    protected DebitTransfer_NextDebitTransferTransactionstriggersProxi nextDebitTransferTransactionstriggers;
    protected DebitTransferNoValue previousDebitTransfer;
    
    public DebitTransfer(java.sql.Timestamp timestamp,String subject,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,long receiverAccountNumber,long receiverBankNumber,PersistentAccount receiver,PersistentMoney money,PersistentTriggerValue invokerTrigger,DebitTransferNoValue previousDebitTransfer,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(String)subject,(PersistentAccount)sender,(PersistentDebitTransferState)state,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,id);
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverBankNumber = receiverBankNumber;
        this.receiver = receiver;
        this.money = money;
        this.invokerTrigger = invokerTrigger;
        this.nextDebitTransferTransactionstriggers = new DebitTransfer_NextDebitTransferTransactionstriggersProxi(this);
        this.previousDebitTransfer = previousDebitTransfer;        
    }
    
    static public long getTypeId() {
        return 176;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getReceiver() != null){
            this.getReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverSet(this.getId(), getReceiver());
        }
        if(this.getMoney() != null){
            this.getMoney().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.moneySet(this.getId(), getMoney());
        }
        if(this.getInvokerTrigger() != null){
            this.getInvokerTrigger().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.invokerTriggerSet(this.getId(), getInvokerTrigger());
        }
        this.getNextDebitTransferTransactionstriggers().store();
        if(this.getPreviousDebitTransfer() != null){
            this.getPreviousDebitTransfer().store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.previousDebitTransferSet(this.getId(), getPreviousDebitTransfer());
        }
        
    }
    
    public long getReceiverAccountNumber() throws PersistenceException {
        return this.receiverAccountNumber;
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverAccountNumberSet(this.getId(), newValue);
        this.receiverAccountNumber = newValue;
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return this.receiverBankNumber;
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverBankNumberSet(this.getId(), newValue);
        this.receiverBankNumber = newValue;
    }
    public PersistentAccount getReceiver() throws PersistenceException {
        return this.receiver;
    }
    public void setReceiver(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.receiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.receiver = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.receiverSet(this.getId(), newValue);
        }
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return this.money;
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.money)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.money = (PersistentMoney)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.moneySet(this.getId(), newValue);
        }
    }
    public PersistentTriggerValue getInvokerTrigger() throws PersistenceException {
        return this.invokerTrigger;
    }
    public void setInvokerTrigger(PersistentTriggerValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.invokerTrigger)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invokerTrigger = (PersistentTriggerValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.invokerTriggerSet(this.getId(), newValue);
        }
    }
    public DebitTransfer_NextDebitTransferTransactionstriggersProxi getNextDebitTransferTransactionstriggers() throws PersistenceException {
        return this.nextDebitTransferTransactionstriggers;
    }
    public DebitTransferNoValue getPreviousDebitTransfer() throws PersistenceException {
        return this.previousDebitTransfer;
    }
    public void setPreviousDebitTransfer(DebitTransferNoValue newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.previousDebitTransfer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.previousDebitTransfer = (DebitTransferNoValue)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDebitTransferFacade.previousDebitTransferSet(this.getId(), newValue);
        }
    }
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    
    
    public void changeCurrency(final PersistentCurrency currency) 
				throws PersistenceException{
        model.meta.DebitTransferChangeCurrencyCurrencyMssg event = new model.meta.DebitTransferChangeCurrencyCurrencyMssg(currency, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeMoney(final common.Fraction newAmount) 
				throws PersistenceException{
        model.meta.DebitTransferChangeMoneyFractionMssg event = new model.meta.DebitTransferChangeMoneyFractionMssg(newAmount, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeReceiverAccount(final long receiverAccountNumber) 
				throws PersistenceException{
        model.meta.DebitTransferChangeReceiverAccountIntegerMssg event = new model.meta.DebitTransferChangeReceiverAccountIntegerMssg(receiverAccountNumber, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void changeReceiverBank(final long receiverBankNumber) 
				throws PersistenceException{
        model.meta.DebitTransferChangeReceiverBankIntegerMssg event = new model.meta.DebitTransferChangeReceiverBankIntegerMssg(receiverBankNumber, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebitTransfer)This);
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
    
    /* Start of protected part that is not overridden by persistence generator */
    
    public void changeCurrencyImplementation(final PersistentCurrency currency) 
				throws PersistenceException{
		getThis().getMoney().setCurrency(currency);
	}
    public void changeReceiverAccountImplementation(final long receiverAccountNumber) 
				throws PersistenceException{
		getThis().setReceiverAccountNumber(receiverAccountNumber);
	}
    public void changeReceiverBankImplementation(final long receiverBankNumber) 
				throws PersistenceException{
		getThis().setReceiverBankNumber(receiverBankNumber);
	}
    public void changeMoneyImplementation(Fraction newAmount) throws PersistenceException {
    	getThis().getMoney().getAmount().setBalance(newAmount);
    }
    
    public PersistentBooleanValue contains(final PersistentTrigger trigger)
			throws PersistenceException {
    	final PersistentBooleanValue result;
    	
    	PersistentTrigger realThisTrigger = getThis().getInvokerTrigger().accept(new TriggerValueReturnVisitor<PersistentTrigger>(){
			public PersistentTrigger handleNoTrigger(PersistentNoTrigger noTrigger) throws PersistenceException {
				return null;
			}
			public PersistentTrigger handleTrigger(PersistentTrigger trigger) throws PersistenceException {
				return trigger;
			}});
    	
    	if(realThisTrigger != null && realThisTrigger.equals(trigger)) {
    		return TrueValue.getTheTrueValue();
    	}else {
    		result = FalseValue.getTheFalseValue();
    	}
    	return getThis().getPreviousDebitTransfer().accept(new DebitTransferNoValueReturnVisitor<PersistentBooleanValue>() {
			@Override
			public PersistentBooleanValue handleTransfer(
					PersistentTransfer transfer) throws PersistenceException {
				return result.or(transfer.contains(trigger));
			}

			@Override
			public PersistentBooleanValue handleDebit(PersistentDebit debit)
					throws PersistenceException {
				return result.or(debit.contains(trigger));
			}

			@Override
			public PersistentBooleanValue handleNoDebitTransfer(
					PersistentNoDebitTransfer noDebitTransfer)
					throws PersistenceException {
				return result;
			}
		});
	}
    
    @Override
    public PersistentTransfer mirror() throws AccountSearchException, PersistenceException {
    	PersistentDebitTransfer copy = getThis().copyDebitTransfer();
    	PersistentTransfer result = copy.accept(new DebitTransferReturnExceptionVisitor<PersistentTransfer, AccountSearchException>() {
			public PersistentTransfer handleTransfer(PersistentTransfer transfer) throws PersistenceException, AccountSearchException {
		    	transfer.setReceiverAccountNumber(getThis().getSender().getAccountNumber());
		    	transfer.setReceiverBankNumber(getThis().getSender().getBank().getBankNumber());
		    	PersistentBank b = getThis().getSender().getBank().getAdministrator().searchBankByBankNumber(getThis().getReceiverBankNumber());
		    	PersistentAccount a = b.searchAccountByAccNumber(getThis().getReceiverAccountNumber());
		    	transfer.setSender(a);
				return transfer;
			}
			public PersistentTransfer handleDebit(PersistentDebit debit) throws PersistenceException {
				return debit.copyToTransfer();
			}
		});
    	return result;
    }
    @Override
    public PersistentDebitTransferTransaction executeImplementation(PersistentAccount hasToPayFees) 
			throws model.ExecuteException, PersistenceException{
		if (!getThis().getState().isExecutable().isTrue()) {
			throw new NoPermissionToExecuteDebitTransferException();
		}
		Timestamp tstamp = new Timestamp(new Date().getTime());
		getThis().setTimestamp(tstamp);
		getThis().getSender().getBank().sendTransfer(getThis(), hasToPayFees);
		return getThis();
    }
    
    public PersistentDebitTransfer copyDebitTransfer() 
				throws PersistenceException{
		PersistentDebitTransfer copy = getThis().createNewObject();
		PersistentMoney copyMoney = Money.createMoney(Amount.createAmount(new Fraction(getThis().getMoney().getAmount().getBalance())), getThis().getMoney()
				.getCurrency());
		copy.setMoney(copyMoney);
		copy.setReceiverAccountNumber(getThis().getReceiverAccountNumber());
		copy.setReceiverBankNumber(getThis().getReceiverBankNumber());
		copy.setSender(getThis().getSender());
		copy.setState(getThis().getState().copy());
		copy.setSubject(getThis().getSubject());
		copy.setInvokerTrigger(getThis().getInvokerTrigger());
		copy.setTimestamp(getThis().getTimestamp());
		return copy;
	}
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
		return getThis().copyDebitTransfer();
	}

 
    /* End of protected part that is not overridden by persistence generator */
    
}
