package persistence;

import model.UserException;

import model.visitor.*;

public class BankICProxi extends PersistentInCacheProxiOptimistic implements PersistentBank{
    
    public BankICProxi(long objectId) {
        super(objectId);
    }
    public BankICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankFacade
            .getBank(this.getId());
    }
    
    public long getClassId() {
        return -149;
    }
    
    public long getBankNumber() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getBankNumber();
    }
    public void setBankNumber(long newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setBankNumber(newValue);
    }
    public String getName() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setName(newValue);
    }
    public long getLastAccountNumber() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getLastAccountNumber();
    }
    public void setLastAccountNumber(long newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setLastAccountNumber(newValue);
    }
    public PersistentTransactionFee getFee() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getFee();
    }
    public void setFee(PersistentTransactionFee newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setFee(newValue);
    }
    public PersistentInternalFee getInternalFee() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getInternalFee();
    }
    public void setInternalFee(PersistentInternalFee newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setInternalFee(newValue);
    }
    public PersistentAccount getOwnAccount() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getOwnAccount();
    }
    public void setOwnAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setOwnAccount(newValue);
    }
    public Bank_AccountsProxi getAccounts() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getAccounts();
    }
    public PersistentAdministrator getAdministrator() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getAdministrator();
    }
    public void setAdministrator(PersistentAdministrator newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setAdministrator(newValue);
    }
    public Bank_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getCurrentAccounts();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBank)this.getTheObject()).setSubService(newValue);
    }
    public PersistentBank getThis() throws PersistenceException {
        return ((PersistentBank)this.getTheObject()).getThis();
    }
    
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBank(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBank(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBank(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBank(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBank(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBank(this);
    }
    
    
    public void changeName(final String name) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).changeName(name);
    }
    public void changeName(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).changeName(name, invoker);
    }
    public void createAccount(final String currencyType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).createAccount(currencyType, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).deregister(observee);
    }
    public PersistentBankService getBankServices() 
				throws PersistenceException{
        return ((PersistentBank)this.getTheObject()).getBankServices();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).updateObservers(event);
    }
    public void changeNameImplementation(final String name) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).changeNameImplementation(name);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String currencyType) 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).createAccount(currencyType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBank)this.getTheObject()).initializeOnInstantiation();
    }
    public void receiveTransfer(final PersistentDebitNoteTransfer debitNoteTransfer) 
				throws model.TransactionDeniedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentBank)this.getTheObject()).receiveTransfer(debitNoteTransfer);
    }
    public void sendTransfer(final PersistentAccount from, final PersistentDebitNoteTransfer debitNoteTransfer) 
				throws model.TransactionDeniedException, model.InvalidBankNumberException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentBank)this.getTheObject()).sendTransfer(from, debitNoteTransfer);
    }

    
}
