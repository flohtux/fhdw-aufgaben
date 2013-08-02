
package model.visitor;

import persistence.*;

public interface UserExceptionReturnVisitor<R> {
    
    public R handleCycleException(model.CycleException cycleException) throws PersistenceException;
    public R handlePasswordException(model.PasswordException passwordException) throws PersistenceException;
    public R handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException;
    public R handleTransactionDeniedException(model.TransactionDeniedException transactionDeniedException) throws PersistenceException;
    public R handleRestrictionException(model.RestrictionException restrictionException) throws PersistenceException;
    public R handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException;
    
}
