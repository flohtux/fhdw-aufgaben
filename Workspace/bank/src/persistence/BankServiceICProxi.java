package persistence;

import model.UserException;

import model.visitor.*;

public class BankServiceICProxi extends ServiceICProxi implements PersistentBankService{
    
    public BankServiceICProxi(long objectId) {
        super(objectId);
    }
    public BankServiceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBankServiceFacade
            .getBankService(this.getId());
    }
    
    public long getClassId() {
        return -119;
    }
    
    public PersistentBank getBank() throws PersistenceException {
        return ((PersistentBankService)this.getTheObject()).getBank();
    }
    public void setBank(PersistentBank newValue) throws PersistenceException {
        ((PersistentBankService)this.getTheObject()).setBank(newValue);
    }
    public PersistentBankService getThis() throws PersistenceException {
        return ((PersistentBankService)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBankService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBankService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBankService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBankService(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).deregister(observee);
    }
    public PersistentServer getAccess() 
				throws PersistenceException{
        return ((PersistentBankService)this.getTheObject()).getAccess();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).register(observee);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).updateObservers(event);
    }
    public void changeMaxLimit(final PersistentAccount acc, final common.Fraction amount) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeMaxLimit(acc, amount);
    }
    public void changeMinLimit(final PersistentAccount acc, final common.Fraction amount) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeMinLimit(acc, amount);
    }
    public String changePassword(final String newPassword1, final String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentBankService)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void closeAccount(final PersistentAccount acc) 
				throws model.CloseAccountNoPossibleException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).closeAccount(acc);
    }
    public void closeAccount(final PersistentAccount acc, final PersistentAccount transAcc) 
				throws model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, model.NoPermissionToExecuteDebitNoteTransferException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).closeAccount(acc, transAcc);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String currencyType) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).createAccount(currencyType);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentBankService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).initializeOnInstantiation();
    }

    
}
