package persistence;

import model.UserException;

import model.visitor.*;

public class TransferProxi extends DebitTransferProxi implements PersistentTransfer{
    
    public TransferProxi(long objectId) {
        super(objectId);
    }
    public TransferProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .getTransfer(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public PersistentTransfer getThis() throws PersistenceException {
        return ((PersistentTransfer)this.getTheObject()).getThis();
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
    public void accept(DebitTransferNoValueVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(DebitTransferNoValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends UserException>  void accept(DebitTransferNoValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends UserException> R accept(DebitTransferNoValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    
    
    public void changeCurrency(final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeCurrency(currency);
    }
    public void changeMoney(final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeMoney(newAmount);
    }
    public void changeReceiverAccount(final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeReceiverAccount(receiverAccountNumber);
    }
    public void changeReceiverBank(final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeReceiverBank(receiverBankNumber);
    }
    public PersistentDebitTransferDoubleState changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).changeState(newState);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).deregister(observee);
    }
    public PersistentDebitTransferTransaction execute(final PersistentAccount hasToPayFees) 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).execute(hasToPayFees);
    }
    public void execute(final PersistentAccount hasToPayFees, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).execute(hasToPayFees, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).updateObservers(event);
    }
    public void changeCurrencyImplementation(final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeCurrencyImplementation(currency);
    }
    public void changeMoneyImplementation(final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeMoneyImplementation(newAmount);
    }
    public void changeReceiverAccountImplementation(final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeReceiverAccountImplementation(receiverAccountNumber);
    }
    public void changeReceiverBankImplementation(final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).changeReceiverBankImplementation(receiverBankNumber);
    }
    public PersistentDebitTransferDoubleState changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).changeStateImplementation(newState);
    }
    public PersistentBooleanValue contains(final PersistentTrigger trigger) 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).contains(trigger);
    }
    public PersistentDebitTransfer copyDebitTransfer() 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).copyDebitTransfer();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).copy();
    }
    public PersistentDebitTransfer createNewObject() 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).createNewObject();
    }
    public PersistentDebitTransferTransaction executeImplementation(final PersistentAccount hasToPayFees) 
				throws model.ExecuteException, PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).executeImplementation(hasToPayFees);
    }
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).fetchRealMoney();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTransfer)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentTransfer mirror() 
				throws model.AccountSearchException, PersistenceException{
        return ((PersistentTransfer)this.getTheObject()).mirror();
    }

    
}
