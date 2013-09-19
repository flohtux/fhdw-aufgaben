package persistence;

import model.UserException;

public abstract class DebitTransferICProxi extends DebitTransferTransactionICProxi implements PersistentDebitTransfer{
    
    public DebitTransferICProxi(long objectId) {
        super(objectId);
    }
    public DebitTransferICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public long getReceiverAccountNumber() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getReceiverAccountNumber();
    }
    public void setReceiverAccountNumber(long newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setReceiverAccountNumber(newValue);
    }
    public long getReceiverBankNumber() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getReceiverBankNumber();
    }
    public void setReceiverBankNumber(long newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setReceiverBankNumber(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setMoney(newValue);
    }
    public PersistentTriggerValue getInvokerTrigger() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getInvokerTrigger();
    }
    public void setInvokerTrigger(PersistentTriggerValue newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setInvokerTrigger(newValue);
    }
    public DebitTransfer_NextDebitTransferTransactionstriggersProxi getNextDebitTransferTransactionstriggers() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getNextDebitTransferTransactionstriggers();
    }
    public PersistentDebitTransfer getPreviousDebitTransfer() throws PersistenceException {
        return ((PersistentDebitTransfer)this.getTheObject()).getPreviousDebitTransfer();
    }
    public void setPreviousDebitTransfer(PersistentDebitTransfer newValue) throws PersistenceException {
        ((PersistentDebitTransfer)this.getTheObject()).setPreviousDebitTransfer(newValue);
    }
    public abstract PersistentDebitTransfer getThis() throws PersistenceException ;
    
    
    
    public void changeCurrency(final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeCurrency(currency);
    }
    public void changeMoney(final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeMoney(newAmount);
    }
    public void changeReceiverAccount(final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeReceiverAccount(receiverAccountNumber);
    }
    public void changeReceiverBank(final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeReceiverBank(receiverBankNumber);
    }
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).changeState(newState);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction execute() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).execute();
    }
    public void execute(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).execute(invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).updateObservers(event);
    }
    public void changeCurrencyImplementation(final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeCurrencyImplementation(currency);
    }
    public void changeMoneyImplementation(final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeMoneyImplementation(newAmount);
    }
    public void changeReceiverAccountImplementation(final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeReceiverAccountImplementation(receiverAccountNumber);
    }
    public void changeReceiverBankImplementation(final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).changeReceiverBankImplementation(receiverBankNumber);
    }
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).changeStateImplementation(newState);
    }
    public PersistentBooleanValue contains(final PersistentTrigger trigger) 
				throws PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).contains(trigger);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).copy();
    }
    public PersistentDebitTransferTransaction executeImplementation() 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).executeImplementation();
    }
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException{
        return ((PersistentDebitTransfer)this.getTheObject()).fetchRealMoney();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebitTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
