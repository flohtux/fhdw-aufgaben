package persistence;

import model.UserException;

import model.visitor.*;

public class DebitProxi extends DebitTransferProxi implements PersistentDebit{
    
    public DebitProxi(long objectId) {
        super(objectId);
    }
    public DebitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDebitFacade
            .getDebit(this.getId());
    }
    
    public long getClassId() {
        return 177;
    }
    
    public PersistentDebit getThis() throws PersistenceException {
        return ((PersistentDebit)this.getTheObject()).getThis();
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
    
    
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber);
    }
    public void changeState(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeState(newState);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).deregister(observee);
    }
    public void execute() 
				throws model.ExecuteException, PersistenceException{
        ((PersistentDebit)this.getTheObject()).execute();
    }
    public void execute(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).execute(invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).updateObservers(event);
    }
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeCurrency(trans, currency);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeMoney(trans, newAmount);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeReceiverAccount(trans, receiverAccountNumber);
    }
    public void changeReceiverBankImplementation(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeReceiverBankImplementation(trans, receiverBankNumber);
    }
    public void changeStateImplementation(final PersistentDebitTransferState newState) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).changeStateImplementation(newState);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentDebitTransferTransaction copy() 
				throws PersistenceException{
        return ((PersistentDebit)this.getTheObject()).copy();
    }
    public void executeImplementation() 
				throws model.ExecuteException, PersistenceException{
        ((PersistentDebit)this.getTheObject()).executeImplementation();
    }
    public PersistentMoney fetchRealMoney() 
				throws PersistenceException{
        return ((PersistentDebit)this.getTheObject()).fetchRealMoney();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
