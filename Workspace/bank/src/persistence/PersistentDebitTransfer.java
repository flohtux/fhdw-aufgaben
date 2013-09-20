package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentDebitTransfer extends PersistentDebitTransferTransaction {
    
    public long getReceiverAccountNumber() throws PersistenceException ;
    public void setReceiverAccountNumber(long newValue) throws PersistenceException ;
    public long getReceiverBankNumber() throws PersistenceException ;
    public void setReceiverBankNumber(long newValue) throws PersistenceException ;
    public PersistentMoney getMoney() throws PersistenceException ;
    public void setMoney(PersistentMoney newValue) throws PersistenceException ;
    public PersistentTriggerValue getInvokerTrigger() throws PersistenceException ;
    public void setInvokerTrigger(PersistentTriggerValue newValue) throws PersistenceException ;
    public DebitTransfer_NextDebitTransferTransactionstriggersProxi getNextDebitTransferTransactionstriggers() throws PersistenceException ;
    public PersistentDebitTransfer getPreviousDebitTransfer() throws PersistenceException ;
    public void setPreviousDebitTransfer(PersistentDebitTransfer newValue) throws PersistenceException ;
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    public void accept(DebitTransferVisitor visitor) throws PersistenceException;
    public <R> R accept(DebitTransferReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(DebitTransferExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(DebitTransferReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void changeCurrency(final PersistentCurrency currency) 
				throws PersistenceException;
    public void changeMoney(final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccount(final long receiverAccountNumber) 
				throws PersistenceException;
    public void changeReceiverBank(final long receiverBankNumber) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void changeCurrencyImplementation(final PersistentCurrency currency) 
				throws PersistenceException;
    public void changeMoneyImplementation(final common.Fraction newAmount) 
				throws PersistenceException;
    public void changeReceiverAccountImplementation(final long receiverAccountNumber) 
				throws PersistenceException;
    public void changeReceiverBankImplementation(final long receiverBankNumber) 
				throws PersistenceException;
    public PersistentBooleanValue contains(final PersistentTrigger trigger) 
				throws PersistenceException;
    /**
     * Returns a deep copy of this debit, transfer or transaction
     * with all attributes being cloned objects with same values.
     */
    public PersistentDebitTransfer copyDebitTransfer() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    /**
     * Returns the value of this transaction with correct sign (+/-).
     * E.g. debits will be shown as negative!
     * @return money that the receiver gets -> with correct sign (+/-)
     */
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    /**
     * Returns a new transfer that would undo this debit or transfer.
     * @throws model.AccountSearchException if a closed account is involved.
     */
    public PersistentTransfer mirror() 
				throws model.AccountSearchException, PersistenceException;

}

