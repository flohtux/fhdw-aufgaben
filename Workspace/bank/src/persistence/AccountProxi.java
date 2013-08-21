package persistence;

import model.UserException;

import model.visitor.*;

public class AccountProxi extends PersistentProxi implements PersistentAccount{
    
    public AccountProxi(long objectId) {
        super(objectId);
    }
    public AccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .getAccount(this.getId());
    }
    
    public long getClassId() {
        return 133;
    }
    
    public long getAccountNumber() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getAccountNumber();
    }
    public void setAccountNumber(long newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setAccountNumber(newValue);
    }
    public PersistentMoney getMoney() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getMoney();
    }
    public void setMoney(PersistentMoney newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setMoney(newValue);
    }
    public PersistentLimitAccount getLimit() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getLimit();
    }
    public void setLimit(PersistentLimitAccount newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setLimit(newValue);
    }
    public Account_GrantedDebitGrantsProxi getGrantedDebitGrants() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getGrantedDebitGrants();
    }
    public Account_ReceivedDebitGrantsProxi getReceivedDebitGrants() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getReceivedDebitGrants();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setSubService(newValue);
    }
    public PersistentAccount getThis() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).deregister(observee);
    }
    public PersistentAccountService getAccountService() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getAccountService();
    }
    public PersistentBank getBank() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getBank();
    }
    public PersistentAccountDebitTransferTransactions getDebitTransferTransactions() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getDebitTransferTransactions();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).updateObservers(event);
    }
    public void changeCurrency(final PersistentTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeCurrency(trans, currency);
    }
    public void changeMoney(final PersistentTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeMoney(trans, newAmount);
    }
    public void changeReceiverAccount(final PersistentTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverAccount(trans, receiverAccountNumber);
    }
    public void changeReceiverBank(final PersistentTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).createDebitGrant(receiver, limit);
    }
    public PersistentDebit createDebit() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createDebit();
    }
    public PersistentTransfer createTransfer() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createTransfer();
    }
    public void debitTransferTransactions_update(final model.meta.DebitTransferTransactionMssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).debitTransferTransactions_update(event);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnInstantiation();
    }

    
}
