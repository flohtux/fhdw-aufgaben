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
    
    
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeCurrency(trans, currency, invoker);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeMoney(trans, newAmount, invoker);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverAccount(trans, receiverAccountNumber, invoker);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber, invoker);
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
        ((PersistentAccount)this.getTheObject()).createDebitGrant(receiver, limit);
    }
    public void createDebitGrant(final PersistentAccount receiver, final PersistentLimitType limit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).createDebitGrant(receiver, limit, invoker);
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
    public PersistentDebitGrantListe getGrantedDebitGrant() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getGrantedDebitGrant();
    }
    public PersistentDebitGrantListe getReceivedDebitGrant() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getReceivedDebitGrant();
    }
    public PersistentTriggerListe getTriggerListe() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).getTriggerListe();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).register(observee);
    }
    public void remove(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).remove(acc, list);
    }
    public void setGrantedDebitGrant(final PersistentDebitGrantListe grantedDebitGrant) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).setGrantedDebitGrant(grantedDebitGrant);
    }
    public void setReceivedDebitGrant(final PersistentDebitGrantListe receivedDebitGrant) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).setReceivedDebitGrant(receivedDebitGrant);
    }
    public void setTriggerListe(final PersistentTriggerListe triggerListe) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).setTriggerListe(triggerListe);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).updateObservers(event);
    }
    public void addToTransactionTemplate(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).addToTransactionTemplate(transaction, debitTransfer);
    }
    public void addToTransaction(final PersistentTransaction transaction, final DebitTransferSearchList debitTransfer) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).addToTransaction(transaction, debitTransfer);
    }
    public void changeCurrency(final PersistentDebitTransfer trans, final PersistentCurrency currency) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeCurrency(trans, currency);
    }
    public void changeMoney(final PersistentDebitTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeMoney(trans, newAmount);
    }
    public void changeReceiverAccount(final PersistentDebitTransfer trans, final long receiverAccountNumber) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverAccount(trans, receiverAccountNumber);
    }
    public void changeReceiverBank(final PersistentDebitTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDebitGrantImplementation(final PersistentAccount receiver, final PersistentLimitType limit) 
				throws model.GrantAlreadyGivenException, PersistenceException{
        ((PersistentAccount)this.getTheObject()).createDebitGrantImplementation(receiver, limit);
    }
    public PersistentDebit createDebit() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createDebit();
    }
    public PersistentDebitTransferTransaction createTemplate(final String type) 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createTemplate(type);
    }
    public PersistentTransaction createTransaction() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createTransaction();
    }
    public PersistentTransfer createTransfer() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createTransfer();
    }
    public PersistentTrigger createTrigger(final String name, final PersistentDebitTransferTransaction dtt) 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).createTrigger(name, dtt);
    }
    public void debitTransferTransactions_update(final model.meta.DebitTransferTransactionMssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).debitTransferTransactions_update(event);
    }
    public void grantedDebitGrant_update(final model.meta.DebitGrantListeMssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).grantedDebitGrant_update(event);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnInstantiation();
    }
    public void receivedDebitGrant_update(final model.meta.DebitGrantListeMssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).receivedDebitGrant_update(event);
    }
    public void removeImplementation(final PersistentAccountPx acc, final PersistentDebitGrantListe list) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).removeImplementation(acc, list);
    }
    public void triggerListe_update(final model.meta.TriggerListeMssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).triggerListe_update(event);
    }

    
}
