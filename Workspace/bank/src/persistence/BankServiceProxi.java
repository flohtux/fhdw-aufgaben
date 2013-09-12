package persistence;

import model.UserException;

import model.visitor.*;

public class BankServiceProxi extends ServiceProxi implements PersistentBankService{
    
    public BankServiceProxi(long objectId) {
        super(objectId);
    }
    public BankServiceProxi(PersistentInCacheProxi object) {
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
    public AccountSearchList transAcc_Path_In_CloseAccount() 
				throws model.UserException, PersistenceException{
        return ((PersistentBankService)this.getTheObject()).transAcc_Path_In_CloseAccount();
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).updateObservers(event);
    }
    public void changeInteralFee(final PersistentInternalFee fee, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeInteralFee(fee, procentual);
    }
    public void changeMaxLimit(final PersistentLimitAccount limit, final common.Fraction amount) 
				throws model.MaxLimitLowerThenMinLimitException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeMaxLimit(limit, amount);
    }
    public void changeMinLimit(final PersistentLimitAccount limit, final common.Fraction amount) 
				throws model.MinLimitHigherMaxLimitException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeMinLimit(limit, amount);
    }
    public String changePassword(final String newPassword1, final String newPassword2) 
				throws model.PasswordException, PersistenceException{
        return ((PersistentBankService)this.getTheObject()).changePassword(newPassword1, newPassword2);
    }
    public void changeTransactionFeeToFixFee(final PersistentTransactionFee dummy, final common.Fraction fix, final String fixCurrency) 
				throws model.NoValidFeeValueException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeTransactionFeeToFixFee(dummy, fix, fixCurrency);
    }
    public void changeTransactionFeeToMixedFee(final PersistentTransactionFee dummy, final common.Fraction fix, final String fixCurrency, final common.Fraction limit, final String limitCurrency, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, model.NoValidFeeValueException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeTransactionFeeToMixedFee(dummy, fix, fixCurrency, limit, limitCurrency, procentual);
    }
    public void changeTransactionFeeToProcentualFee(final PersistentTransactionFee dummy, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).changeTransactionFeeToProcentualFee(dummy, procentual);
    }
    public void closeAccount(final PersistentAccount acc) 
				throws model.CloseAccountNoPossibleException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).closeAccount(acc);
    }
    public void closeAccount(final PersistentAccount acc, final PersistentAccount transAcc) 
				throws model.ExecuteException, model.CloseAccountNoPossibleException, PersistenceException{
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
    public void findAccount(final long accountNumber) 
				throws model.UserException, PersistenceException{
        ((PersistentBankService)this.getTheObject()).findAccount(accountNumber);
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
    public void resetMaxLimit(final PersistentLimitAccount limit) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).resetMaxLimit(limit);
    }
    public void resetMinLimit(final PersistentLimitAccount limit) 
				throws PersistenceException{
        ((PersistentBankService)this.getTheObject()).resetMinLimit(limit);
    }

    
}
