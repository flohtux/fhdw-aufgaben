package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentBankService extends PersistentService {
    
    public PersistentBank getBank() throws PersistenceException ;
    public void setBank(PersistentBank newValue) throws PersistenceException ;
    public PersistentBankService getThis() throws PersistenceException ;
    
    public void accept(ServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public AccountSearchList transAcc_Path_In_CloseAccount() 
				throws model.UserException, PersistenceException;
    public void changeInteralFee(final PersistentInternalFee fee, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException;
    public void changeMaxLimit(final PersistentLimitAccount limit, final common.Fraction amount) 
				throws model.MaxLimitLowerThenMinLimitException, PersistenceException;
    public void changeMinLimit(final PersistentLimitAccount limit, final common.Fraction amount) 
				throws model.MinLimitHigherMaxLimitException, PersistenceException;
    public void changeTransactionFeeToFixFee(final PersistentTransactionFee dummy, final common.Fraction fix, final String fixCurrency) 
				throws model.NoValidFeeValueException, PersistenceException;
    public void changeTransactionFeeToMixedFee(final PersistentTransactionFee dummy, final common.Fraction fix, final String fixCurrency, final common.Fraction limit, final String limitCurrency, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, model.NoValidFeeValueException, PersistenceException;
    public void changeTransactionFeeToProcentualFee(final PersistentTransactionFee dummy, final common.Fraction procentual) 
				throws model.NoValidPercentValueException, PersistenceException;
    public void closeAccount(final PersistentAccount acc) 
				throws model.CloseAccountNoPossibleException, PersistenceException;
    public void closeAccount(final PersistentAccount acc, final PersistentAccount transAcc) 
				throws model.ExecuteException, model.CloseAccountNoPossibleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String currencyType) 
				throws PersistenceException;
    public void findAccount(final long accountNumber) 
				throws model.UserException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void resetMaxLimit(final PersistentLimitAccount limit) 
				throws PersistenceException;
    public void resetMinLimit(final PersistentLimitAccount limit) 
				throws PersistenceException;

}

