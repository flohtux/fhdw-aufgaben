package model;

import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.DebitTransferExceptionVisitor;
import model.visitor.DebitTransferNoValueExceptionVisitor;
import model.visitor.DebitTransferNoValueReturnExceptionVisitor;
import model.visitor.DebitTransferNoValueReturnVisitor;
import model.visitor.DebitTransferNoValueVisitor;
import model.visitor.DebitTransferReturnExceptionVisitor;
import model.visitor.DebitTransferReturnVisitor;
import model.visitor.DebitTransferTransactionExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnExceptionVisitor;
import model.visitor.DebitTransferTransactionReturnVisitor;
import model.visitor.DebitTransferTransactionVisitor;
import model.visitor.DebitTransferVisitor;
import model.visitor.SubjInterfaceExceptionVisitor;
import model.visitor.SubjInterfaceReturnExceptionVisitor;
import model.visitor.SubjInterfaceReturnVisitor;
import model.visitor.SubjInterfaceVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.DebitProxi;
import persistence.DebitTransferNoValue;
import persistence.ObsInterface;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentDebit;
import persistence.PersistentDebitTransfer;
import persistence.PersistentDebitTransferState;
import persistence.PersistentDebitTransferTransaction;
import persistence.PersistentMoney;
import persistence.PersistentTransfer;
import persistence.PersistentTriggerValue;
import persistence.SubjInterface;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class Debit extends model.DebitTransfer implements PersistentDebit{
    
    
    public static PersistentDebit createDebit() throws PersistenceException{
        return createDebit(false);
    }
    
    public static PersistentDebit createDebit(boolean delayed$Persistence) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentDebit createDebit(boolean delayed$Persistence,PersistentDebit This) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,-1);
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
    
    public Debit provideCopy() throws PersistenceException{
        Debit result = this;
        result = new Debit(this.timestamp, 
                           this.subject, 
                           this.sender, 
                           this.state, 
                           this.subService, 
                           this.This, 
                           this.receiverAccountNumber, 
                           this.receiverBankNumber, 
                           this.receiver, 
                           this.money, 
                           this.invokerTrigger, 
                           this.previousDebitTransfer, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Debit(java.sql.Timestamp timestamp,String subject,PersistentAccount sender,PersistentDebitTransferState state,SubjInterface subService,PersistentDebitTransferTransaction This,long receiverAccountNumber,long receiverBankNumber,PersistentAccount receiver,PersistentMoney money,PersistentTriggerValue invokerTrigger,DebitTransferNoValue previousDebitTransfer,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((java.sql.Timestamp)timestamp,(String)subject,(PersistentAccount)sender,(PersistentDebitTransferState)state,(SubjInterface)subService,(PersistentDebitTransferTransaction)This,(long)receiverAccountNumber,(long)receiverBankNumber,(PersistentAccount)receiver,(PersistentMoney)money,(PersistentTriggerValue)invokerTrigger,(DebitTransferNoValue)previousDebitTransfer,id);        
    }
    
    static public long getTypeId() {
        return 177;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 177) ConnectionHandler.getTheConnectionHandler().theDebitFacade
            .newDebit(new java.sql.Timestamp(System.currentTimeMillis()),"",0,0,this.getId());
        super.store();
        
    }
    
    public PersistentDebit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebit result = new DebitProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentDebit)this.This;
    }
    
    public void accept(DebitTransferVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(DebitTransferTransactionVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(DebitTransferTransactionReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends UserException>  void accept(DebitTransferTransactionExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends UserException> R accept(DebitTransferTransactionReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(DebitTransferNoValueVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
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
        this.setThis((PersistentDebit)This);
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
    
    public PersistentTransfer copyToTransfer() 
				throws PersistenceException{
		PersistentTransfer result = Transfer.createTransfer();
		result.setInvokerTrigger(getThis().getInvokerTrigger());
		PersistentMoney copyMoney = Money.createMoney(Amount.createAmount(new Fraction(getThis().getMoney().getAmount().getBalance())), getThis().getMoney()
				.getCurrency());
		result.setMoney(copyMoney);
		result.setPreviousDebitTransfer(getThis().getPreviousDebitTransfer());
		result.setReceiverAccountNumber(getThis().getReceiverAccountNumber());
		result.setSender(getThis().getSender());
		result.setReceiverBankNumber(getThis().getReceiverBankNumber());
		result.setState(getThis().getState().copy());
		result.setSubject(getThis().getSubject());
		result.setTimestamp(getThis().getTimestamp());
		return result;
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException{
		return getThis().getMoney().multiply(Fraction.MinusOne);
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		getThis().setMoney(Money.createMoney(Amount.createAmount(Fraction.parse("0/1")), Euro.getTheEuro()));
		getThis().setReceiverAccountNumber(0);
		getThis().setReceiverBankNumber(0);
		getThis().setState(NotExecutedState.createNotExecutedState());
		getThis().setInvokerTrigger(NoTrigger.createNoTrigger());
		getThis().setPreviousDebitTransfer(NoDebitTransfer.createNoDebitTransfer());
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    
    
    // Start of section that contains overridden operations only.
    
    public PersistentDebitTransfer createNewObject() 
				throws PersistenceException{
		return Debit.createDebit();
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
