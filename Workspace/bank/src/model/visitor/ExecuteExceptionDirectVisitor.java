
package model.visitor;

import model.*;
import persistence.*;

public abstract class ExecuteExceptionDirectVisitor implements ExecuteExceptionVisitor {
    
    public abstract void handleDebitException(model.DebitException debitException) throws PersistenceException;
    
    public void handleLimitViolatedException(model.LimitViolatedException limitViolatedException) throws PersistenceException{
        this.handleDebitException(limitViolatedException);
    }
    public void handleDebitNotGrantedException(model.DebitNotGrantedException debitNotGrantedException) throws PersistenceException{
        this.handleDebitException(debitNotGrantedException);
    }
    public abstract void handleNoPermissionToExecuteDebitTransferException(model.NoPermissionToExecuteDebitTransferException noPermissionToExecuteDebitTransferException) throws PersistenceException;
    
    public abstract void handleAccountSearchException(model.AccountSearchException accountSearchException) throws PersistenceException;
    
    public void handleInvalidBankNumberException(model.InvalidBankNumberException invalidBankNumberException) throws PersistenceException{
        this.handleAccountSearchException(invalidBankNumberException);
    }
    public void handleInvalidAccountNumberException(model.InvalidAccountNumberException invalidAccountNumberException) throws PersistenceException{
        this.handleAccountSearchException(invalidAccountNumberException);
    }
    public abstract void handleTriggerCyclicException(model.TriggerCyclicException triggerCyclicException) throws PersistenceException;
    
    
}
