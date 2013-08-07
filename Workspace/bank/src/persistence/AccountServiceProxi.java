package persistence;

import model.UserException;

import model.visitor.*;

public class AccountServiceProxi extends ServiceProxi implements PersistentAccountService{
    
    public AccountServiceProxi(long objectId) {
        super(objectId);
    }
    public AccountServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountServiceFacade
            .getAccountService(this.getId());
    }
    
    public long getClassId() {
        return -130;
    }
    
    public PersistentAccount getAccount() throws PersistenceException {
        return ((PersistentAccountService)this.getTheObject()).getAccount();
    }
    public void setAccount(PersistentAccount newValue) throws PersistenceException {
        ((PersistentAccountService)this.getTheObject()).setAccount(newValue);
    }
    public PersistentAccountService getThis() throws PersistenceException {
        return ((PersistentAccountService)this.getTheObject()).getThis();
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountService(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountService(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountService(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).deregister(observee);
    }
    public PersistentServer getAccess() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).getAccess();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).register(observee);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).updateObservers(event);
    }
    public void changeMoney(final PersistentTransfer trans, final common.Fraction newAmount) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeMoney(trans, newAmount);
    }
    public String changePassword(final String newPassword1, final String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void changeReceiverAccount(final PersistentTransfer trans, final long receiverAccNumber) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeReceiverAccount(trans, receiverAccNumber);
    }
    public void changeReceiverBank(final PersistentTransfer trans, final long receiverBankNumber) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeReceiverBank(trans, receiverBankNumber);
    }
    public void changeSubject(final PersistentTransfer trans, final String subject) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).changeSubject(trans, subject);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createTransfer() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).createTransfer();
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).disconnected();
    }
    public void executeTransfer(final PersistentDebitTransfer debitTransfer) 
				throws model.NoPermissionToExecuteDebitTransferException, model.InvalidBankNumberException, model.LimitViolatedException, model.InvalidAccountNumberException, PersistenceException{
        ((PersistentAccountService)this.getTheObject()).executeTransfer(debitTransfer);
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentAccountService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountService)this.getTheObject()).initializeOnInstantiation();
    }

    
}
